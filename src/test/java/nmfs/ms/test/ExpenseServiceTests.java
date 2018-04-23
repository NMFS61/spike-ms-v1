package nmfs.ms.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import config.BuildChoice;
import nmfs.ms.MicroservicesApplication;
import nmfs.ms.bpl.ExpenseControlBPL;
import nmfs.ms.dal.mongo.ExpenseDAO;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.expense.Payee;
import nmfs.ms.model.response.ErrorList;
import nmfs.ms.model.response.RestResponse;
import nmfs.ms.service.ExpenseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes=MicroservicesApplication.class)
public class ExpenseServiceTests {

    //@Autowired ones are mocked..
    @InjectMocks
    ExpenseService service;
    @Spy
    ExpenseDAO dao;
    @Mock
    ExpenseControlBPL expenseControls;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldInsertExpenseRecord(){

        Expense expense=getExpense(BuildChoice.VALID);

        // ** Make the Mockito prep
            List<ErrorList> list=new ArrayList<>();
            //notice different Mockito syntax for @Mock
            Mockito.when(expenseControls.doCompulsoryCheck(expense)).thenReturn(list);
            Mockito.when(expenseControls.doValidationCheck(expense)).thenReturn(list);
            //notice different Mockito syntax for @Spy
            Mockito.doReturn("").when(dao).insertOne(expense);

        //Do the test as it is

        RestResponse resp= service.insertOne(expense);
        assertThat(resp.getStatus(),is("OK"));
    }

    @Test
    public void shouldFailInsertingAnExpenseRecordInvalidValidation(){

        Expense expense=getExpense(BuildChoice.INVALID_VALIDATION);

        // ** Make the Mockito prep
        List<ErrorList> listValidations=new ArrayList<>();
        List<ErrorList> listCompulsaryChecks=new ArrayList<>();
        listValidations.add(ErrorList.builder().field("name").issue("is not valid").build());
        //notice different Mockito syntax for @Mock
        Mockito.when(expenseControls.doCompulsoryCheck(expense)).thenReturn(listCompulsaryChecks);
        Mockito.when(expenseControls.doValidationCheck(expense)).thenReturn(listValidations);
        //notice different Mockito syntax for @Spy
        Mockito.doReturn("").when(dao).insertOne(expense);

        //Do the test as it is

        RestResponse resp= service.insertOne(expense);
        assertThat(resp.getStatus(),is("FAIL"));
        assertTrue(resp.getErrorList().size()>0);
    }

    @Test
    public void shouldFailInsertingAnExpenseRecordInvalidCompulsary(){

        Expense expense=getExpense(BuildChoice.INVALID_VALIDATION);

        // ** Make the Mockito prep
        List<ErrorList> listValidations=new ArrayList<>();
        List<ErrorList> listCompulsaryChecks=new ArrayList<>();
        listCompulsaryChecks.add(ErrorList.builder().field("name").issue("can not be empty.").build());
        //notice different Mockito syntax for @Mock
        Mockito.when(expenseControls.doCompulsoryCheck(expense)).thenReturn(listCompulsaryChecks);
        Mockito.when(expenseControls.doValidationCheck(expense)).thenReturn(listValidations);
        //notice different Mockito syntax for @Spy
        Mockito.doReturn("").when(dao).insertOne(expense);

        //Do the test as it is

        RestResponse resp= service.insertOne(expense);
        assertThat(resp.getStatus(),is("FAIL"));
        assertTrue(resp.getErrorList().size()>0);
    }

    private Expense getExpense(BuildChoice choice)
    {
        Expense e=null;

        if (choice==BuildChoice.VALID) {
                e=Expense.builder().expenseType("Meal")
                    .amount("11.14")
                    .description("Coffee at costa")
                    .paidBy("B U")
                    .payee(Payee.builder().address("address").name("B U").id("1").build())
                    .receipt("Yes")
                    .vat(".2")
                    .Date(new Date())
                    .departmentsToApprove("")
                    .build();
        }
        if (choice==BuildChoice.INVALID_VALIDATION) {
                e=Expense.builder().expenseType("Meal")
                    .amount("11.14")
                    .description("Coffee at costa")
                    .paidBy("B U")
                    .payee(Payee.builder().address("address").name("B U").id("1").build())
                    .receipt("Yes")
                    .vat(".2")
                    .Date(new Date())
                    .departmentsToApprove("")
                    .build();
        }
        if (choice==BuildChoice.INVALID_COMPULSARY) {
            e=Expense.builder().expenseType("Meal")
                    .amount("11.14")
                    .description("Coffee at costa")
                    .paidBy("B U")
                    .payee(Payee.builder().address("address").name("B U").id("1").build())
                    .receipt("Yes")
                    .vat(".2")
                    .Date(new Date())
                    .departmentsToApprove("")
                    .build();
        }
        return e;
    }
}

package ExpenseTests;

import java.util.Date;

import nmfs.ms.bpl.ExpenseControlBPL;
import nmfs.ms.bpl.compulsory.ExpenseCompulsoryChecks;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.expense.Payee;
import nmfs.ms.service.ExpenseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@ContextConfiguration
@RunWith(SpringRunner.class)
public class ExpenseCompulsaryTests {

    Expense validExpense;
    Expense invalidExpense;

    @Autowired( required = true )
    ExpenseControlBPL expenseControls;

    @Before
    public void init(){
        invalidExpense= Expense.builder().build();

        validExpense= Expense.builder().expenseType("Meal")
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

    @Test
    public void shouldReturnZeroCompulsaryErrorsForValidExpense(){
        ExpenseControlBPL expenseControl=new ExpenseControlBPL();
        //nmfs.ms.bpl.compulsory.ExpenseCompulsoryChecks compulsoryChecks=new ExpenseCompulsoryChecks();
        assertThat(expenseControls.doCompulsoryCheck(validExpense).size(),is(0) );
    }

    @Test
    public void shouldReturnCompulsaryErrorsForInvalidExpense(){
        ExpenseControlBPL expenseControl=new ExpenseControlBPL();
        assertTrue(expenseControl.doCompulsoryCheck(invalidExpense).size()>0 );
    }
}

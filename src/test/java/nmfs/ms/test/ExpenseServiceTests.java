package nmfs.ms.test;

import java.util.Date;

import nmfs.ms.MicroservicesApplication;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.expense.Payee;
import nmfs.ms.model.response.RestResponse;
import nmfs.ms.service.ExpenseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
@SpringBootTest(classes=MicroservicesApplication.class)
//@SpringApplicationConfiguration
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@ComponentScan("nmfs.ms")
public class ExpenseServiceTests {

    @Test
    public void test1(){
        ExpenseService expenseService=new ExpenseService();
        Expense expense=Expense.builder()
                .expenseType("meal")
                .amount("11.11")
                .description("some desc")
                .payee(Payee.builder().address("4 London St").name("Bora").build())
                .paidBy("Bora")
                .receipt("Yes")
                .vat("0")
                .build();

        RestResponse rest=expenseService.insertOne(expense);
    }
    @Test
    public void shouldReturnResponseForInsertRequest() {
        ExpenseService service=new ExpenseService();
        Expense e1= Expense.builder().build();

        Expense e2= Expense.builder().expenseType("Meal")
                .amount("11.14")
                .description("Coffee at costa")
                .paidBy("B U")
                .payee(Payee.builder().address("address").name("B U").id("1").build())
                .receipt("Yes")
                .vat(".2")
                .Date(new Date())
                .departmentsToApprove("")
                .build();

        assertTrue(service.insertOne(e1) instanceof nmfs.ms.model.response.RestResponse);
      //  assertTrue(service.insertOne(e) instanceof nmfs.ms.model.response.RestResponse);

    }
}

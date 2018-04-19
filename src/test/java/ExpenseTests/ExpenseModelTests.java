package ExpenseTests;
import java.util.Date;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.expense.Payee;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


//@RunWith(MockitoJUnitRunner.class)
public class ExpenseModelTests {

    @Before
    public void init() {

    }

    @Test
    public void shouldPublishSuccessOutcome() {
     Date now=new Date();

     Expense expense= Expense.builder().expenseType("Meal")
            .amount("11.14")
            .description("Coffee at costa")
            .paidBy("B U")
            .payee(Payee.builder().address("address").name("B U").id("1").build())
            .receipt("Yes")
            .vat(".2")
            .Date(now)
            .departmentsToApprove("")
            .build();
            System.out.println(expense.toString());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        assertThat(dateFormat.format(now), is(dateFormat.format(expense.getDate())));
        assertThat("1",is("1"));

    }


}

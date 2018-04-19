package ExpenseTests;

import nmfs.ms.model.expense.Expense;
import nmfs.ms.service.ExpenseService;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ExpenseServiceTests {

    @Test
    public void shouldReturnResponseForInsertRequest() {
        ExpenseService service=new ExpenseService();
        Expense e= Expense.builder().build();

        assertTrue(service.insertOne(e) instanceof nmfs.ms.model.response.RestResponse);

    }
}

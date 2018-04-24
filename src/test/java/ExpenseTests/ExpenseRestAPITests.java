package ExpenseTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.expense.Payee;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class ExpenseRestAPITests {

    @Test
    public void test1() throws JsonProcessingException {
        // Rest template requires Rest Application to run.
        RestTemplate restTemplate = new RestTemplate();
        //String forObject = restTemplate.postForObject("http://localhost:9063/expense/insertOne", jsonInString, String.class);

        assertTrue(true);
    }
}

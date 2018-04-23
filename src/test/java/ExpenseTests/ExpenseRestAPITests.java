package ExpenseTests;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;

public class ExpenseRestAPITests {

    @Test
    public void test1(){
        RestTemplate restTemplate = new RestTemplate();
       // String forObject = restTemplate.postForObject("http://localhost:8080/expense/testInsert", payload, String.class);
       assertTrue(true);
    }
}

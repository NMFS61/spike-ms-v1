package nmfs.ms.service;
import nmfs.ms.dal.mongo.CustomerDAO;
import nmfs.ms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private CustomerDAO dao;
    public void testService(Customer c)
    {
        dao.insertOne(c);
    }

}

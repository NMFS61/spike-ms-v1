package nmfs.ms.dal.mongo;

import com.mongodb.WriteResult;
import nmfs.ms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class CustomerDAO {

    @Autowired
    private CustomerRepository repository;

//    @Autowired
//    MongoTemplate mongoTemplate;

    public void insertOne(Customer c) {

        repository.save(c);
    }

    public void deleteAll(){

        repository.deleteAll();
    }

    public void searchByName(String name) {

        Customer c=repository.findByFirstName(name);
    }

    public void searchBy1() {

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("Eric"));

    }
    public void searchBy2() {

        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^A"));


    }
    public void searchBy3() {

        Query query = new Query();
        query.addCriteria(Criteria.where("age").lt(50).gt(20));
      //  List<Customer> users = mongoTemplate.find(query, Customer.class);
    }

    public void searchBy4() {

        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "age"));
        //List<Customer> users = mongoTemplate.find(query, Customer.class);
    }

    public void searchBy5() {

        final Pageable pageableRequest = new PageRequest(0, 2);
        Query query = new Query();
        query.with(pageableRequest);
        //List<Customer> users = mongoTemplate.find(query, Customer.class);
    }

    public int updateDomain(String domain, boolean displayAds) {

//        Query query = new Query(Criteria.where("domain").is(domain));
//        Update update = new Update();
//        update.set("displayAds", displayAds);
//
//        WriteResult result = mongoTemplate.updateFirst(query, update, Customer.class);
//
//        if(result!=null)
//            return result.getN();
//        else
//            return 0;
        return 0;

    }
}


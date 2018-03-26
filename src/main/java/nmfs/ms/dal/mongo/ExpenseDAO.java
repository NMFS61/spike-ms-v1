package nmfs.ms.dal.mongo;

import nmfs.ms.model.Customer;
import nmfs.ms.model.expense.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseDAO {

    @Autowired
    private ExpenseRepository repository;


    public String insertOne(Expense expense) {

        repository.save(expense);
        return expense.getId();
    }

    public List<String> insertMultiple(List<Expense> list) {

        List<String> _listOfID=new ArrayList<String>();

        list.stream().forEach(expense ->
                       {
                           _listOfID.add(insertOne(expense));
                       });

        return _listOfID;
    }
    public void deleteAll(){

        repository.deleteAll();
    }


}


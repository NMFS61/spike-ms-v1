package nmfs.ms.service;
import nmfs.ms.bpl.ExpenseControlBPL;
import nmfs.ms.bpl.compulsory.ExpenseCompulsoryChecks;
import nmfs.ms.dal.mongo.CustomerDAO;
import nmfs.ms.dal.mongo.ExpenseDAO;
import nmfs.ms.model.Customer;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.response.ErrorList;
import nmfs.ms.model.response.RestResponse;
import nmfs.ms.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseDAO dao;

    @Autowired
    ExpenseControlBPL expenseControls;

    public RestResponse insertOne(Expense expense) {
        //entry()

        RestResponse resp=new RestResponse();
        List<ErrorList> list= ServiceUtils.combineErrorList(expenseControls.doCompulsoryCheck(expense),expenseControls.doValidationCheck(expense));
        if(list.size()>0) {
            resp.setStatus("FAIL");
            resp.setErrorList(list);
        }
        else{
            dao.insertOne(expense);
            resp.setStatus("OK");
        }

        //exit()
        return resp;
    }

    public void insertListofExpenses(List<Expense> list)
    {
        dao.insertMultiple(list);
    }

}

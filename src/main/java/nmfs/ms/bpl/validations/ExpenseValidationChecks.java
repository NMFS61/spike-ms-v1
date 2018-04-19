package nmfs.ms.bpl.validations;

import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.response.ErrorList;
import nmfs.ms.util.ServiceUtils;

import java.util.ArrayList;
import java.util.List;

public class ExpenseValidationChecks {

    public List<ErrorList> doValidationCheck(Expense expense)
    {
        List<ErrorList> list=new ArrayList<>();
        ServiceUtils.combineErrorList(list,validateAmount(expense.getAmount()));
        return list;
    }

    // List of Property Validations
    // amount
    private List<ErrorList> validateAmount(String val)
    {   List<ErrorList> list=new ArrayList<>();
        //TODO : implement the validation rules for the Amount here - temporary implementation returns true(valid).
       // example:
       // if(Integer.parseInt(val)>500){list.add(ErrorList.builder().field("Amount").issue("max amount can be 5000").build());}

        return list;
    }
}

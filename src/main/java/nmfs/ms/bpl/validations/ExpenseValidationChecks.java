package nmfs.ms.bpl.validations;

import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.response.ErrorList;

import java.util.ArrayList;
import java.util.List;

public class ExpenseValidationChecks {

    public List<ErrorList> doValidationCheck(Expense expense)
    {
        List<ErrorList> list=new ArrayList<>();

        return list;
    }


    private boolean isStringEmptyOrNull(String str)
    {
        boolean retVal=true;
        if(str != null && !str.isEmpty()) {retVal=false;}

        return retVal;
    }
}

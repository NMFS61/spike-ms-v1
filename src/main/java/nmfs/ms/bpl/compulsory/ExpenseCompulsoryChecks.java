package nmfs.ms.bpl.compulsory;

import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.response.ErrorList;

import java.util.ArrayList;
import java.util.List;

public class ExpenseCompulsoryChecks {

    public List<ErrorList> doCompulsoryCheck(Expense expense)
    {
        List<ErrorList> list=doConditionalCompulsoryCheck(expense); // first do the conditional compulsary checks

        // Then the other compulsary checks:

        if(isStringEmptyOrNull(expense.getAmount())) {
            list.add(ErrorList.builder().field("Amount").issue("can not be null").build());
        }


        return list;
    }

    public List<ErrorList> doConditionalCompulsoryCheck(Expense expense)
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

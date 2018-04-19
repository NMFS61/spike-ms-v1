package nmfs.ms.bpl.compulsory;

import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.response.ErrorList;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ExpenseCompulsoryChecks {

    public List<ErrorList> doCompulsoryCheck(Expense expense)
    {
        List<ErrorList> list=doConditionalCompulsoryCheck(expense); // first do the conditional compulsary checks

        // Then the other compulsary checks:

        if(StringUtils.isEmpty(expense.getAmount())) {
            list.add(ErrorList.builder().field("Amount").issue("can not be null").build());
        }

        return list;
    }

    public List<ErrorList> doConditionalCompulsoryCheck(Expense expense)
    {
        List<ErrorList> list=new ArrayList<>();

        return list;
    }

}

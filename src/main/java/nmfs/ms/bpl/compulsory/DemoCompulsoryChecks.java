package nmfs.ms.bpl.compulsory;

import nmfs.ms.model.expense.Expense;

import java.util.ArrayList;
import java.util.List;

public class DemoCompulsoryChecks {

    public List<String[]> doCompulsoryCheck(Expense expense)
    {
        List<String[]> list=doConditionalCompulsoryCheck(expense); // first do the conditional compulsary checks

        // Then the other compulsary checks:
        if(expense.getAmount().isEmpty()||expense.getAmount()==null) {list.add(new String[]{"Amount","can not be null"});}


        return list;
    }

    public List<String[]> doConditionalCompulsoryCheck(Expense expense)
    {
        List<String[]> list=new ArrayList<>();

        return list;
    }
}

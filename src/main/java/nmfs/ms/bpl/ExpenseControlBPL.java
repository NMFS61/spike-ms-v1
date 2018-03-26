package nmfs.ms.bpl;

import nmfs.ms.bpl.compulsory.ExpenseCompulsoryChecks;
import nmfs.ms.bpl.validations.ExpenseValidationChecks;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.response.ErrorList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpenseControlBPL {

    public List<ErrorList> doCompulsoryCheck(Expense expense) { return new ExpenseCompulsoryChecks().doCompulsoryCheck(expense); }
    public List<ErrorList> doValidationCheck(Expense expense) { return new ExpenseValidationChecks().doValidationCheck(expense);}
}

package nmfs.ms.bpl.compulsory;

import nmfs.ms.model.expense.Expense;
import org.springframework.stereotype.Component;

@Component
public class MainServiceBPL {

    public void compulsaryCheck(Object o) {

        if(o instanceof Expense){}

    }
}

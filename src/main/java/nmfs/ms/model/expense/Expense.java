package nmfs.ms.model.expense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection="expense")
public class Expense {

    @Id
    private String id;
    private java.util.Date Date;
    private Payee payee;
    private String description;
    private String expenseType;
    private String paidBy;
    private String amount;
    private String receipt;
    private String vat;
    private String departmentsToApprove;
   // private byte[] attachment;

}

package nmfs.ms.dal.mongo;

import java.util.List;

import nmfs.ms.model.Customer;
import nmfs.ms.model.expense.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {


}

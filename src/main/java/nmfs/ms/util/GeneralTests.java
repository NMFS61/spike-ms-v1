package nmfs.ms.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.expense.Payee;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;

import java.util.ArrayList;
import java.util.Date;

public class GeneralTests {

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("1. (C)reate an expense ");
        System.out.println(createAnExpenseJsonString());
        System.out.println("2. (C)reate multiple expenses ");
        System.out.println(createMultipleExpenseJsonString());

    }

    public static String createAnExpenseJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Expense expense= Expense.builder().expenseType("Meal")
                .amount("11.14")
                .description("Coffee at costa")
                .paidBy("B U")
                .payee(Payee.builder().address("address").name("B U").id("1").build())
                .receipt("Yes")
                .vat(".2")
                .Date(new Date())
                .departmentsToApprove("")
                .build();
        String expenseAsJsonString = mapper.writeValueAsString(expense);
       return expenseAsJsonString;
    }

    public static String createMultipleExpenseJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Expense expense1= Expense.builder().expenseType("Meal")
                .amount("11.14")
                .description("Coffee at costa")
                .paidBy("B U")
                .payee(Payee.builder().address("address").name("B U").id("1").build())
                .receipt("Yes")
                .vat(".2")
                .Date(new Date())
                .departmentsToApprove("")
                .build();
        Expense expense2= Expense.builder().expenseType("Meal")
                .amount("11.15")
                .description("Food")
                .paidBy("B U")
                .payee(Payee.builder().address("address").name("B U").id("1").build())
                .receipt("Yes")
                .vat(".2")
                .Date(new Date())
                .departmentsToApprove("")
                .build();
        ArrayList<Expense> list=new ArrayList<>();
        list.add(expense1);
        list.add(expense2);
        String expenseAsJsonString = mapper.writeValueAsString(list);
        return expenseAsJsonString;
    }
}

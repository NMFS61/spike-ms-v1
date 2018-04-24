package nmfs.ms.rest;

import nmfs.ms.model.expense.Expense;
import nmfs.ms.model.expense.Payee;
import nmfs.ms.model.response.ErrorList;
import nmfs.ms.model.response.RestResponse;
import nmfs.ms.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    // **********************  TEMPORARY INTERFACEs ******************************************
// **********************  REAL INTERFACEs ******************************************

	// Health check for MicroService
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<String> healthCheck() {

        return new ResponseEntity<String>("Up and Running", HttpStatus.OK);
    }

     // INSERT ONE record Interface
	 @RequestMapping(value = "/insertOne", method = RequestMethod.POST)
	 public ResponseEntity<RestResponse> insertOne(@RequestBody Expense expense) {
        System.out.println("*** Amount : "+expense.getAmount());
		return new ResponseEntity<RestResponse>(expenseService.insertOne(expense), HttpStatus.OK);
		}

	// INSERT MULTIPLE record Interface
	@RequestMapping(value = "/insertMultiple", method = RequestMethod.POST)
	public ResponseEntity<List<RestResponse>> insertMultiple(@RequestBody List<Expense> list) {
        List<RestResponse> listResults=new ArrayList<>();
        System.out.println(list.size());
	    list.stream().forEach(expense ->
                {
                    listResults.add(expenseService.insertOne(expense));
                    System.out.println("*** Amount : "+expense.getAmount());
                });

		return new ResponseEntity<List<RestResponse>>(listResults, HttpStatus.OK);
	    }

}

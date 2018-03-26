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
	@RequestMapping(value = "/testInsert", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> testInsert() {

		Expense expense=Expense.builder()
				.expenseType("meal")
				.amount("11.11")
				.description("some desc")
				.payee(Payee.builder().address("4 London St").name("Bora").build())
				.paidBy("Bora")
				.receipt("Yes")
				.vat("0")
				.build();

		RestResponse rest=expenseService.insertOne(expense);
		return new ResponseEntity<RestResponse>(rest, HttpStatus.OK);
	}
	@RequestMapping(value = "/testInsertMulti", method = RequestMethod.GET)
	public ResponseEntity<String> testInsertMulti() {

		List<Expense> list=new ArrayList<Expense>();


		expenseService.insertListofExpenses(list);
		return new ResponseEntity<String>("Up and Running", HttpStatus.OK);
	}
	@RequestMapping(value = "/testResponse", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> testResponse() {


		RestResponse response=RestResponse.builder().status(Boolean.TRUE.toString()).build();
		String[] str=new String[2];

		List<ErrorList> list=new ArrayList<>();
		list.add(ErrorList.builder().field("name").issue("can not be null").build());
		list.add(ErrorList.builder().field("last name").issue("can not be null").build());

		response.setErrorList(list);
//        RestResponse response=RestResponse.builder()
//				.status(Boolean.TRUE)
//				.errorList(errors).build();
		return new ResponseEntity<RestResponse>(response, HttpStatus.OK);
	}
// **********************  REAL INTERFACEs ******************************************

	// Health check for MicroService
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<String> post(@RequestParam("data")String payload) {

        return new ResponseEntity<String>("Up and Running", HttpStatus.OK);
    }
     // INSERT ONE record Interface
	 @RequestMapping(value = "/insertOne", method = RequestMethod.POST)
	 public ResponseEntity<RestResponse> insertOne(@RequestBody Expense expense) {

		return new ResponseEntity<RestResponse>(expenseService.insertOne(expense), HttpStatus.OK);
		}

	// INSERT MULTIPLE record Interface
	@RequestMapping(value = "/insertMultiple", method = RequestMethod.POST)
	public ResponseEntity<String> insertMultiple(@RequestBody List<Expense> list) {

		return new ResponseEntity<String>("Up and Running", HttpStatus.OK);
	    }

}

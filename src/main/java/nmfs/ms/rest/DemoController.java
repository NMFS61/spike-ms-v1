package nmfs.ms.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nmfs.ms.model.Person;

@RestController
@RequestMapping(value="/demo")
public class DemoController {

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	    public ResponseEntity<String> post(@RequestParam("data")String payload) {
	    
		  return new ResponseEntity<String>("Up and Running", HttpStatus.OK);
	    }
	 @RequestMapping(value = "/insertOne", method = RequestMethod.POST)
	 public ResponseEntity<String> insertOne() {
		    
			  return new ResponseEntity<String>("Up and Running", HttpStatus.OK);
		    }
	 
	 @RequestMapping(value = "/mirror", method = RequestMethod.POST)
	 public Person mirror(@RequestBody Person p) {
		      //p.setAge(38);
		      return Person.builder().lastName("Nic")
		                 .name("Kid")
		                 .age(33)
		                 .build();
		                
			 // return p;
		    }
}

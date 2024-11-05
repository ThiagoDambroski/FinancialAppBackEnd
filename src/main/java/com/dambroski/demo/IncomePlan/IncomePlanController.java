package com.dambroski.demo.IncomePlan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.demo.account.Account;

@RestController
@RequestMapping("incomePlan")
public class IncomePlanController {
	
	@Autowired
	IncomePlanService service;
	
	
	@GetMapping("/getAll")
	public List<IncomePlan> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post/{accountId}")
	public IncomePlan post(@RequestBody IncomePlan incomePlan,@PathVariable("accountId") Long accountId) {
		
		return service.post(incomePlan,accountId);
	}
	
	
	@PutMapping("/put/{incomePlanId}")
	public IncomePlan put(@RequestBody IncomePlan incomePlan,@PathVariable("incomePlanId") Long incomePlanId) {
		
		return service.put(incomePlan,incomePlanId);
	}
	
	@DeleteMapping("/delete/{incomePlanId}")
	public void delete(@PathVariable("incomePlanId") Long incomePlanId) {
		service.delete(incomePlanId);
	}
}

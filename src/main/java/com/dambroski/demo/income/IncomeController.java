package com.dambroski.demo.income;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/income")
public class IncomeController {
	
	@Autowired
	IncomeService service;

	
	@GetMapping("/getAll")
	public List<Income> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/postFromAccount/{accountId}")
	public Income postFromAccount(@RequestBody Income income, @PathVariable("accountId") Long accountId) {
		return service.postFromAccount(income,accountId);
		
	}
	
	@PostMapping("/postFromPlan/{incomePlanId}")
	public Income postFromPlanIncome(@RequestBody Income income, @PathVariable("incomePlanId") Long incomePlanId) {
		return service.postFromPlanIncome(income,incomePlanId);
	}
	
	
	@PutMapping("/put/{incomeId}")
	public Income putIncome(@RequestBody Income income, @PathVariable("incomeId") Long incomeId) {
		return service.put(income,incomeId);
	}
	
}


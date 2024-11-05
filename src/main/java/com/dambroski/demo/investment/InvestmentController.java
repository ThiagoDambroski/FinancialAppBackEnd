package com.dambroski.demo.investment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

	@Autowired
	InvestmentService service;
	
	
	@GetMapping("/getAll")
	public List<Investment> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post/{accountId}")
	public Investment post(@RequestBody Investment investment, @PathVariable("accountId") Long accountId) {
		
		return service.post(investment,accountId);
	}
	
	@PutMapping("/put/{investmentId}")
	public Investment put(@RequestBody Investment investment, @PathVariable("investmentId") Long investmentId) {
		
		return service.put(investment,investmentId);
		
	}
	
	@DeleteMapping("/delete/{investmentId]}")
	public void delete(@PathVariable("investmentId")Long investmentId) {
		
		service.delete(investmentId);
		
	}
}

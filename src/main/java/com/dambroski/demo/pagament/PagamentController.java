package com.dambroski.demo.pagament;

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
@RequestMapping("/pagaments")
public class PagamentController {
	
	@Autowired
	PagamentService service;
	
	
	@GetMapping("/getAll")
	public List<Pagament> getAllPagaments(){
		return service.getAll();
	}
	
	@PostMapping("/postFromAccount/{accountId}")
	public Pagament postFromAccount(@RequestBody Pagament pagament, @PathVariable("accountId") Long accountId) {
		
		return service.postFromAccount(pagament,accountId);
	}
	
	@PostMapping("/postFromPlan/{pagamentPlanId}")
	public Pagament postFromPlan(@RequestBody Pagament pagament, @PathVariable("pagamentPlanId") Long pagamentPlanId) {
		
		return service.postFromPlan(pagament,pagamentPlanId);
	}
	
	@PutMapping("/put/{pagamentId}")
	public Pagament put(@RequestBody Pagament pagament, @PathVariable("pagamentId") Long pagamentId) {
		
		return service.put(pagament,pagamentId);
	}
	
	
	
	
	
}

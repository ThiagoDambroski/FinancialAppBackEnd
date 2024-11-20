package com.dambroski.demo.PagamentPlan;

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
@RequestMapping("pagamentPlan")
public class PagamentPlanController {

	@Autowired
	PagamentPlanService service;
	
	@GetMapping("/getAll")
	public List<PagamentPlan> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post/{accountId}")
	public PagamentPlan post(@RequestBody PagamentPlan pagamentPlan,@PathVariable("accountId") Long accountId) {
		return service.post(pagamentPlan,accountId);
	}
	
	@PutMapping("/put/{pagamentPlanId}")
	public PagamentPlan put(@RequestBody PagamentPlan pagamentPlan,@PathVariable("pagamentPlanId")Long pagamentPlanId) {
		return service.put(pagamentPlan,pagamentPlanId);
	}
	
}

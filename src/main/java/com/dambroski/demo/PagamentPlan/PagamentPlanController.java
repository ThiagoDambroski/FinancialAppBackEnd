package com.dambroski.demo.PagamentPlan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

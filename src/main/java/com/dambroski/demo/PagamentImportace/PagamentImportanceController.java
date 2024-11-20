package com.dambroski.demo.PagamentImportace;

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

@RestController
@RequestMapping("/pagamentImportance")
public class PagamentImportanceController {

	@Autowired
	PagamentImportanceService service;
	
	
	@GetMapping("/getAll")
	public List<PagamentImportance> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post")
	public PagamentImportance post(@RequestBody PagamentImportance pagamentImportance) {
		return service.post(pagamentImportance);
	}
	
	@PutMapping("/put/{pagamentImportanceId}")
	public PagamentImportance put(@RequestBody PagamentImportance pagamentImportance,@PathVariable("pagamentImportanceId") Long pagamentImportanceId) {
		return service.put(pagamentImportance,pagamentImportanceId);
	}
	
	@PatchMapping("/patch/addToPagament/{pagamentImportanceId}/{pagamentId}")
	public PagamentImportance patchAddToPagament(@PathVariable("pagamentImportanceId") Long pagamentImportanceId,@PathVariable("pagamentId") Long pagamentId) {
		return service.patchAddToPagament(pagamentImportanceId,pagamentId);
	}
	
	@PatchMapping("/patch/addToPagamentPlan/{pagamentImportanceId}/{pagamentPlanId}")
	public PagamentImportance addToPagamentPlan(@PathVariable("pagamentImportanceId") Long pagamentImportanceId,@PathVariable("pagamentPlanId") Long pagamentPlanId) {
		return service.patchAddToPagamentPlan(pagamentImportanceId,pagamentPlanId);
	}
	
	
	@DeleteMapping("/delete/{pagamentImportanceId}")
	public void delete(@PathVariable("pagamentImportanceId") Long pagamentImportanceId) {
		service.delete(pagamentImportanceId);
	}
}

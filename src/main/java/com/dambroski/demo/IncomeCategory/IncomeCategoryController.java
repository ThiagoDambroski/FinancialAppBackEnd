package com.dambroski.demo.IncomeCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incomeCategory")
public class IncomeCategoryController {
	
	@Autowired
	IncomeCategoryService service;
	
	
	@GetMapping("/getAll")
	public List<IncomeCategory> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post")
	public IncomeCategory post(@RequestBody IncomeCategory incomeCategory) {
		return service.post(incomeCategory);
	}
	
	@PatchMapping("/patch/name/{incomeCategoryId}")
	public IncomeCategory patchName(@RequestBody IncomeCategory incomeCategory,@PathVariable("incomeCategoryId") Long IncomeCategoryId) {
		return service.patchName(incomeCategory,IncomeCategoryId);
	}
	
	
	@DeleteMapping("delete/{incomeCategoryId}")
	public void delete(@PathVariable("incomeCategoryId") Long incomeCategoryId) {
		 service.delete(incomeCategoryId);
	}
	
}

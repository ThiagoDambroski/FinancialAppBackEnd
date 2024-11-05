package com.dambroski.demo.pagamentCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentCategory")
public class PagamentCategoryController {
	
	@Autowired
	PagamentCategoryService service;
	
	@GetMapping("/getAll")
	public List<PagamentCategory> getAll(){
		return service.getAll();
	}
	
}

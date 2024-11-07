package com.dambroski.demo.pagamentCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/post")
	public PagamentCategory post(@RequestBody PagamentCategory pagamentCategory) {
		return service.post(pagamentCategory);
	}
	
	@PatchMapping("/patch/name/{pagamentCategoryId")
	public PagamentCategory patchName(@RequestBody PagamentCategory pagamentCategory, @PathVariable("pagamentCategoryId") Long pagamentCategoryId ) {
		return service.patchName(pagamentCategory,pagamentCategoryId);
	}
 }

package com.dambroski.demo.PagamentImportace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

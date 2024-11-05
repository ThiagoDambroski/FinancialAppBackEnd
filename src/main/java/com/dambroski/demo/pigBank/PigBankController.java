package com.dambroski.demo.pigBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pigbank")
public class PigBankController {
	
	@Autowired
	PigBankService service;
	
	@GetMapping("/getAll")
	public List<PigBank> getAll(){
		return service.getAll();
	}

}

package com.dambroski.demo.account;

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
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	
	@GetMapping("/getAll")
	public List<Account> getAll(){
		return service.getAll();
	}
	
	
	@PostMapping("/post/{userId}")
	public Account post(@RequestBody Account account, @PathVariable("userId") Long userId) {
		return service.post(account,userId);
	}
	
	
	@PatchMapping("/patch/name/{accountId}")
	public Account patchName(@RequestBody String newName, @PathVariable("accountId")Long accountId) {
		return service.patchName(newName,accountId);
	}
	
	
	
	
	@DeleteMapping("/delete/{accountId}")
	public void delete(@PathVariable("accountId")Long accountId) {
		service.delete(accountId);
		
	}

}

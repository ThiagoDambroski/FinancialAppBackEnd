package com.dambroski.demo.pigBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PigBankServiceImpl implements PigBankService{
	
	@Autowired
	PigBankRepository repo;

	@Override
	public List<PigBank> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}

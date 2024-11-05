package com.dambroski.demo.PagamentImportace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentImportanceServiceImpl  implements PagamentImportanceService{
	
	@Autowired
	PagamentImportanceRepository repo;

	@Override
	public List<PagamentImportance> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}

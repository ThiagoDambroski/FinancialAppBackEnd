package com.dambroski.demo.pagamentCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service

public class PagamentCategoryServiceImpl implements PagamentCategoryService{
	
	@Autowired
	PagamentCategoryRepository repo;

	@Override
	public List<PagamentCategory> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}

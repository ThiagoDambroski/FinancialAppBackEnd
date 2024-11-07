package com.dambroski.demo.pagamentCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.pagament.Pagament;

import erros.PagamentCategoryNotFoundException;

@Service

public class PagamentCategoryServiceImpl implements PagamentCategoryService{
	
	@Autowired
	PagamentCategoryRepository repo;

	@Override
	public List<PagamentCategory> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public PagamentCategory post(PagamentCategory pagamentCategory) {
		
		List<Pagament> emptyPagamentList = new ArrayList<>();
		
		pagamentCategory.setPagaments(emptyPagamentList);
		
		return repo.save(pagamentCategory);
	}

	@Override
	public PagamentCategory patchName(PagamentCategory pagamentCategory, Long pagamentCategoryId) {
		PagamentCategory oldPagamentCategory = repo.findById(pagamentCategoryId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Category not found"));
		
		if(Objects.nonNull(pagamentCategory.getCategoryName()) && pagamentCategory.getCategoryName().length() > 0) {
			oldPagamentCategory.setCategoryName(pagamentCategory.getCategoryName());
		}
		
		
		return repo.save(oldPagamentCategory);
	}
	

}

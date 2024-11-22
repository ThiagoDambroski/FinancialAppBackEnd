package com.dambroski.demo.pagamentCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.PagamentPlan.PagamentPlanRepository;
import com.dambroski.demo.erros.CategoryNotInPagamentException;
import com.dambroski.demo.erros.PagamentCategoryNotFoundException;
import com.dambroski.demo.erros.PagamentNotFoundException;
import com.dambroski.demo.pagament.Pagament;
import com.dambroski.demo.pagament.PagamentRepository;

@Service

public class PagamentCategoryServiceImpl implements PagamentCategoryService{
	
	@Autowired
	PagamentCategoryRepository repo;
	
	@Autowired
	PagamentRepository pagamentRepository;
	
	@Autowired
	PagamentPlanRepository pagamentPlanRepository;

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

	@Override
	public PagamentCategory patchAddToPagament(Long pagamentCategoryId, Long pagamentId) {
		PagamentCategory pagamentCategory = repo.findById(pagamentCategoryId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Cateogory not found"));
		
		Pagament pagament = pagamentRepository.findById(pagamentId)
				.orElseThrow(() -> new PagamentNotFoundException("Pagament not found"));
		
		List<Pagament> pagaments = pagamentCategory.getPagaments();
		if(!pagaments.contains(pagament)) {
			pagaments.add(pagament);
		}
		
		pagamentCategory.setPagaments(pagaments);
		
		return repo.save(pagamentCategory);
	}
	
	@Override
	public PagamentCategory removeFromPagament(Long pagamentCategoryId, Long pagamentId) {
		PagamentCategory pagamentCategory = repo.findById(pagamentCategoryId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Cateogory not found"));
		
		Pagament pagament = pagamentRepository.findById(pagamentId)
				.orElseThrow(() -> new PagamentNotFoundException("Pagament not found"));
		
		List<Pagament> listPagament = pagamentCategory.getPagaments();
		
		if(!listPagament.contains(pagament)) {
			throw new CategoryNotInPagamentException("Category not in pagament");
		}
		listPagament.remove(pagament);
		
		pagamentCategory.setPagaments(listPagament);
		
		return repo.save(pagamentCategory);
	}

	
	@Override
	public PagamentCategory patchAddToPagamentPlan(Long pagamentCategoryId, Long pagamentPlanId) {
		PagamentCategory pagamentCategory = repo.findById(pagamentCategoryId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Category not found"));
		
		PagamentPlan pagamentPlan = pagamentPlanRepository.findById(pagamentPlanId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Category not found"));
		
		List<PagamentPlan> pagamentsPlan = pagamentCategory.getPagamentsPlan();
		if(!pagamentsPlan.contains(pagamentPlan)) {
			pagamentsPlan.add(pagamentPlan);
		}
		
		pagamentCategory.setPagamentsPlan(pagamentsPlan);
		
		return repo.save(pagamentCategory);
	}
	@Override
	public PagamentCategory removeFromPagamentPlan(Long pagamentCategoryId, Long pagamentPlanId) {
		
		PagamentCategory pagamentCategory = repo.findById(pagamentCategoryId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Category not found"));
		
		PagamentPlan pagamentPlan = pagamentPlanRepository.findById(pagamentPlanId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Category not found"));
		
		List<PagamentPlan> pagamentsPlan = pagamentCategory.getPagamentsPlan();
		
		if(!pagamentsPlan.contains(pagamentPlan)) {
			///Todo
		}
		
		return null;
	}

	@Override
	public void delete(Long pagamentCategoryId) {
		PagamentCategory pagamentCategory = repo.findById(pagamentCategoryId)
				.orElseThrow(() -> new PagamentCategoryNotFoundException("Pagament Category Not Found"));
		
		repo.delete(pagamentCategory);
	}

	

	
	

}

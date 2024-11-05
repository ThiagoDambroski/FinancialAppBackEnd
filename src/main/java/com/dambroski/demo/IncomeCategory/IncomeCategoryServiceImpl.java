package com.dambroski.demo.IncomeCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.IncomePlan.IncomePlan;
import com.dambroski.demo.income.Income;

import erros.IncomeCategoryNotFoundException;

@Service
public class IncomeCategoryServiceImpl implements IncomeCategoryService{
	
	@Autowired
	IncomeCategoryRepository repository;
	

	@Override
	public List<IncomeCategory> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public IncomeCategory post(IncomeCategory incomeCategory) {

		List<Income> emptyListIncome = new ArrayList<>();
		incomeCategory.setIncomes(emptyListIncome);
		List<IncomePlan> emptyListIncomePlan = new ArrayList<>();
		incomeCategory.setIncomesplans(emptyListIncomePlan);
		
		
		
		return repository.save(incomeCategory);
	}


	@Override
	public IncomeCategory patchName(IncomeCategory incomeCategory, Long incomeCategoryId) {
		IncomeCategory oldIncomeCategory = repository.findById(incomeCategoryId)
				.orElseThrow(() -> new IncomeCategoryNotFoundException("Income Category not found"));
		
		if(Objects.nonNull(incomeCategory.getName()) && incomeCategory.getName().length() > 0) {
			oldIncomeCategory.setName(incomeCategory.getName());
		}
		
		return repository.save(oldIncomeCategory);
	}


	@Override
	public void delete(Long incomeCategoryId) {
		IncomeCategory incomeCategory = repository.findById(incomeCategoryId)
				.orElseThrow(() -> new IncomeCategoryNotFoundException("Income Category not found"));
		
		repository.delete(incomeCategory);
		
	}

}

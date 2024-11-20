package com.dambroski.demo.IncomeCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.IncomePlan.IncomePlan;
import com.dambroski.demo.IncomePlan.IncomePlanRepository;
import com.dambroski.demo.erros.CategoryNotInIncomeException;
import com.dambroski.demo.erros.IncomeCategoryNotFoundException;
import com.dambroski.demo.erros.IncomeNotFoundException;
import com.dambroski.demo.erros.IncomePlanNotFoundException;
import com.dambroski.demo.income.Income;
import com.dambroski.demo.income.IncomeRepository;

@Service
public class IncomeCategoryServiceImpl implements IncomeCategoryService{
	
	@Autowired
	IncomeCategoryRepository repository;
	
	@Autowired
	IncomeRepository incomeRepo;
	
	@Autowired
	IncomePlanRepository incomePlanRepo;

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
	public IncomeCategory patchAddToIncome(Long incomeCategoryId, Long incomeId) {
		IncomeCategory incomeCategory = repository.findById(incomeCategoryId)
				.orElseThrow(() -> new IncomeCategoryNotFoundException("Income Category Not Found"));
		
		Income income = incomeRepo.findById(incomeId)
				.orElseThrow(() -> new IncomeNotFoundException("Income Not found "));
		
		List<Income> incomeList = incomeCategory.getIncomes();
		
		if(!incomeList.contains(income)) {
			incomeList.add(income);
		}
		
		incomeCategory.setIncomes(incomeList);
		
		return repository.save(incomeCategory);
	}
	
	
	@Override
	public IncomeCategory patchRemoveFromIncome(Long incomeCategoryId, Long incomeId) {
		
		IncomeCategory incomeCategory = repository.findById(incomeCategoryId)
				.orElseThrow(() -> new IncomeCategoryNotFoundException("Income Category Not Found"));
		
		Income income = incomeRepo.findById(incomeId)
				.orElseThrow(() -> new IncomeNotFoundException("Income Not found "));
		
		List<Income> incomeList = incomeCategory.getIncomes();
		
		if(!incomeList.contains(income)) {
			throw new CategoryNotInIncomeException("income category, not in income");
		}
		incomeList.remove(income);
		
		incomeCategory.setIncomes(incomeList);
		
		return repository.save(incomeCategory);
	}
	
	
	@Override
	public IncomeCategory patchAddToIncomePlan(Long incomeCategoryId, Long incomePlanId) {
		IncomeCategory incomeCategory = repository.findById(incomeCategoryId)
				.orElseThrow(() -> new IncomeCategoryNotFoundException("Income Category Not Found"));
		
		IncomePlan incomePlan = incomePlanRepo.findById(incomePlanId)
				.orElseThrow(() -> new IncomePlanNotFoundException("income plan not found"));
		
		List<IncomePlan> listIncomeCategory = incomeCategory.getIncomesplans();
		
		if(!listIncomeCategory.contains(incomePlan)) {
			listIncomeCategory.add(incomePlan);
		}
		
		
		return repository.save(incomeCategory);
	}
 
	
	

	@Override
	public void delete(Long incomeCategoryId) {
		IncomeCategory incomeCategory = repository.findById(incomeCategoryId)
				.orElseThrow(() -> new IncomeCategoryNotFoundException("Income Category not found"));
		
		repository.delete(incomeCategory);
		
	}


	


	

	

}

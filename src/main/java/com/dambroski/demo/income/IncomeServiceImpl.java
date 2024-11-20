package com.dambroski.demo.income;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.IncomeCategory.IncomeCategory;
import com.dambroski.demo.IncomePlan.IncomePlan;
import com.dambroski.demo.IncomePlan.IncomePlanRepository;
import com.dambroski.demo.account.Account;
import com.dambroski.demo.account.AccountRepository;
import com.dambroski.demo.erros.AccountNotFoundException;
import com.dambroski.demo.erros.IncomeNotFoundException;
import com.dambroski.demo.erros.IncomePlanNotFoundException;

@Service
public class IncomeServiceImpl implements IncomeService{
	
	@Autowired
	IncomeRepository repo;
	
	
	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	IncomePlanRepository incomeRepo;

	@Override
	public List<Income> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Income postFromAccount(Income income, Long accountId) {
			Account account = accountRepo.findById(accountId)
					.orElseThrow(() -> new AccountNotFoundException("Account not found"));
			
			income.setAccount(account);
			
			if(Objects.nonNull(income.getCategorys())) {
				List<IncomeCategory> emptyCategoryList = new ArrayList<>();
				income.setCategorys(emptyCategoryList);
			}
			
			income.setIncomePlanAssociation(null);
			
			account.setCurrentValue(account.getCurrentValue() + income.getValue() );
			
			accountRepo.save(account);
			
		
		
		return repo.save(income);
	}

	@Override
	public Income postFromPlanIncome(Income income, Long incomePlanId) {
		IncomePlan incomePlan = incomeRepo.findById(incomePlanId)
				.orElseThrow(() -> new IncomePlanNotFoundException("Income Plan not found"));
		
		income.setIncomePlanAssociation(incomePlan);
		income.setAccount(incomePlan.getAccount());
		
		if(Objects.nonNull(income.getCategorys())) {
			List<IncomeCategory> emptyCategoryList = new ArrayList<>();
			income.setCategorys(emptyCategoryList);
		}
		
		income.setValue(incomePlan.getValue());
		
		Account account = incomePlan.getAccount();
		
		account.setCurrentValue(account.getCurrentValue() + income.getValue() );
		
		accountRepo.save(account);
		
		
		return repo.save(income);
	}

	@Override
	public Income put(Income income, Long incomeId) {
		Income oldIncome = repo.findById(incomeId)
				.orElseThrow(() -> new IncomeNotFoundException("Income not Found"));
		
		
		if(Objects.nonNull(income.getDescription()) && income.getDescription().length() > 0) {
			oldIncome.setDescription(income.getDescription());
			
		}
		
		if(Objects.nonNull(income.getCategorys())) {
			oldIncome.setCategorys(income.getCategorys());
		}
		
		if(Objects.nonNull(income.getDate())) {
			oldIncome.setDate(income.getDate());
		}
		
		
		return repo.save(oldIncome);
	}

	

}

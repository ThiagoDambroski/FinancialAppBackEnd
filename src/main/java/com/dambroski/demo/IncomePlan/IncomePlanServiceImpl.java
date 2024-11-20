package com.dambroski.demo.IncomePlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.IncomeCategory.IncomeCategory;
import com.dambroski.demo.account.Account;
import com.dambroski.demo.account.AccountRepository;
import com.dambroski.demo.erros.AccountNotFoundException;
import com.dambroski.demo.erros.IncomeNotFoundException;
import com.dambroski.demo.erros.IncomePlanNotFoundException;
import com.dambroski.demo.income.Income;

@Service
public class IncomePlanServiceImpl implements IncomePlanService{
	
	@Autowired
	IncomePlanRepository repository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<IncomePlan> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public IncomePlan post(IncomePlan incomePlan, Long accountId) {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Found"));
		
		incomePlan.setAccount(account);
		
		List<Income> listEmptyIncome = new ArrayList<>();
		incomePlan.setIncomeHistory(listEmptyIncome);
		
		List<IncomeCategory> listEmptyIncomeCategory = new ArrayList<>();
		incomePlan.setCategorys(listEmptyIncomeCategory);
		
		
		return repository.save(incomePlan);
	}

	@Override
	public IncomePlan put(IncomePlan incomePlan, Long incomePlanId) {
		
		IncomePlan oldIncomePlan = repository.findById(incomePlanId)
				.orElseThrow(() -> new IncomePlanNotFoundException("Income Plan Not Found"));
		
		if(Objects.nonNull(incomePlan.getName()) && incomePlan.getName().length() > 0 ) {
			oldIncomePlan.setName(incomePlan.getName());
		}
		
		if(Objects.nonNull(incomePlan.getValue())) {
			oldIncomePlan.setValue(incomePlan.getValue());
		}
		
		if(Objects.nonNull(incomePlan.getPayday()) && (incomePlan.getPayday() > 0 && incomePlan.getPayday() < 31 )) {
			oldIncomePlan.setPayday(incomePlan.getPayday());
		}
		
		if(Objects.nonNull(incomePlan.getIncomeCycle())) {
			oldIncomePlan.setIncomeCycle(incomePlan.getIncomeCycle());
		}
		
		return repository.save(oldIncomePlan);
	}

	@Override
	public void delete(Long incomePlanId) {
		IncomePlan incomePlan = repository.findById(incomePlanId)
				.orElseThrow(() -> new IncomePlanNotFoundException("Income Plan Not Found"));
		repository.delete(incomePlan);
	}

	
}

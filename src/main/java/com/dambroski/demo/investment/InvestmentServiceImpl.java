package com.dambroski.demo.investment;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.account.Account;
import com.dambroski.demo.account.AccountRepository;

import erros.AccountNotFoundException;
import erros.InvestmentNotFoundException;

@Service
public class InvestmentServiceImpl implements InvestmentService {
	
	@Autowired
	InvestmentRepository repo;
	
	@Autowired
	AccountRepository accountRepo;

	@Override
	public List<Investment> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Investment post(Investment investment, Long accountId) {
		Account account = accountRepo.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account not found "));
		
		investment.setAccouunt(account);
		investment.setBegginOfInvestment(new Date());
		
		
		return repo.save(investment);
	}

	@Override
	public Investment put(Investment investment, Long investmentId) {
		Investment oldInvestment = repo.findById(investmentId)
				.orElseThrow(() -> new InvestmentNotFoundException("Investment not Found"));
		
		if(Objects.nonNull(investment.getName()) && investment.getName().length() > 0) {
			oldInvestment.setName(investment.getName());
		}
		
		if(Objects.nonNull(investment.getBegginOfInvestment())) {
			oldInvestment.setBegginOfInvestment(investment.getBegginOfInvestment());
		}
		
		if(Objects.nonNull(investment.isRemoveble())) {
			oldInvestment.setRemoveble(investment.isRemoveble());
		}
		
		
		return repo.save(oldInvestment);
	}

	@Override
	public void delete(Long investmentId) {
		Investment investment = repo.findById(investmentId)
				.orElseThrow(() -> new InvestmentNotFoundException("Investment not Found"));
		
		repo.delete(investment);
		
		
	}
	
	

}

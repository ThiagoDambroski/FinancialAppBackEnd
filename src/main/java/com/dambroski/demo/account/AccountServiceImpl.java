package com.dambroski.demo.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.IncomePlan.IncomePlan;
import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.erros.AccountNotFoundException;
import com.dambroski.demo.erros.UserNotFoundException;
import com.dambroski.demo.income.Income;
import com.dambroski.demo.investment.Investment;
import com.dambroski.demo.pagament.Pagament;
import com.dambroski.demo.pigBank.PigBank;
import com.dambroski.demo.user.User;
import com.dambroski.demo.user.UserRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository repo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Account post(Account account, Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found") );
		
		account.setUser(user);
		if(Objects.nonNull(account.getCurrentValue()))	{
			account.setCurrentValue(0);
		}
		
		List<Income> emptyIncomeList = new ArrayList<>();
		account.setIncomes(emptyIncomeList);
		
		List<Investment> emptyInvestmentList = new ArrayList<>();
		account.setInvestments(emptyInvestmentList);
		
		List<Pagament> emptyPagamentList = new ArrayList<>();
		account.setPagaments(emptyPagamentList);
		
		List<PagamentPlan> emptyPagamentPlanList = new ArrayList<>();
		account.setPagamentsPlan(emptyPagamentPlanList);
		
		List<PigBank> emptyPigBankList = new ArrayList<>();
		account.setPigBank(emptyPigBankList);
		
		List<IncomePlan> emptyPlanIncomesList = new ArrayList<>();
		account.setPlanIncomes(emptyPlanIncomesList);
		
		
		return repo.save(account);
	}

	@Override
	public Account patchName(String newName, Long accountId) {
		Account account = repo.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account not found"));
		
		if(Objects.nonNull(newName) && newName.length() > 0 ) {
			account.setName(newName);
		}
		
		
		return repo.save(account);
	}

	@Override
	public void delete(Long accountId) {
		Account account = repo.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account not found"));
		
		repo.delete(account);
		
	}


}

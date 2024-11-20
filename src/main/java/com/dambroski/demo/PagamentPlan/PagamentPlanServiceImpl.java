package com.dambroski.demo.PagamentPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.account.Account;
import com.dambroski.demo.account.AccountRepository;
import com.dambroski.demo.erros.AccountNotFoundException;
import com.dambroski.demo.erros.PagamentPlanNotFoundException;
import com.dambroski.demo.pagament.Pagament;
import com.dambroski.demo.pagamentCategory.PagamentCategory;


@Service
public class PagamentPlanServiceImpl implements PagamentPlanService{
	
	@Autowired
	PagamentPlanRepository repo;
	
	@Autowired
	AccountRepository accountRepo;

	@Override
	public List<PagamentPlan> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public PagamentPlan post(PagamentPlan pagamentPlan, Long accountId) {
		Account account = accountRepo.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account not found exception"));
		
		pagamentPlan.setAccount(account);
		
		List<PagamentCategory> emptyPagamentCategoryList = new ArrayList<>();
		
		pagamentPlan.setCategorys(emptyPagamentCategoryList);
		
		List<Pagament> emptyPagamentList = new ArrayList<>();
		
		pagamentPlan.setPagamentsHistory(emptyPagamentList);
		
		
		return repo.save(pagamentPlan);
	}

	@Override
	public PagamentPlan put(PagamentPlan pagamentPlan, Long pagamentPlanId) {
		PagamentPlan oldPagamentPlan = repo.findById(pagamentPlanId)
				.orElseThrow(() -> new PagamentPlanNotFoundException("Pagament Plan Not Found"));
		
		
		if(Objects.nonNull(pagamentPlan.getPagamentPlanName()) && pagamentPlan.getPagamentPlanName().length() > 0) {
			oldPagamentPlan.setPagamentPlanName(pagamentPlan.getPagamentPlanName());
		}
		
		if(Objects.nonNull(pagamentPlan.getDayOfPagamentInMonth()) && pagamentPlan.getDayOfPagamentInMonth() > 0) {
			oldPagamentPlan.setDayOfPagamentInMonth(pagamentPlan.getDayOfPagamentInMonth());
		}
		if(Objects.nonNull(pagamentPlan.getPagamentEveryHowManyDays())) {
			oldPagamentPlan.setPagamentEveryHowManyDays(pagamentPlan.getPagamentEveryHowManyDays());
		}
		
		
		return repo.save(oldPagamentPlan);
	}

}

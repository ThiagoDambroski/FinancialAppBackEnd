package com.dambroski.demo.pagament;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.PagamentPlan.PagamentPlanRepository;
import com.dambroski.demo.account.Account;
import com.dambroski.demo.account.AccountRepository;
import com.dambroski.demo.erros.PagamentNotFoundException;
import com.dambroski.demo.erros.PagamentPlanNotFoundException;
import com.dambroski.demo.pagamentCategory.PagamentCategory;


@Service
public class PagamentServiceImpl implements PagamentService{
	
	@Autowired
	PagamentRepository repository;
	
	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	PagamentPlanRepository pagamentPlanRepo;

	@Override
	public List<Pagament> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Pagament postFromAccount(Pagament pagament, Long accountId) {
		Account account = accountRepo.findById(accountId)
				.orElseThrow(() -> new PagamentNotFoundException("Pagament not found"));
		
		pagament.setAccount(account);
		
		
		List<PagamentCategory> emptyListCategorys = new ArrayList<>();
		pagament.setCategorys(emptyListCategorys);
		
		pagament.setPlan(null);
		
		return repository.save(pagament);
	}

	@Override
	public Pagament postFromPlan(Pagament pagament, Long pagamentPlanId) {
		PagamentPlan pagamentPlan = pagamentPlanRepo.findById(pagamentPlanId)
				.orElseThrow(() -> new PagamentPlanNotFoundException("PagamentPlanNotFoundException"));
		
		pagament.setPlan(pagamentPlan);
		pagament.setAccount(pagamentPlan.getAccount());
		
		List<PagamentCategory> emptyListCategorys = new ArrayList<>();
		pagament.setCategorys(emptyListCategorys);
		
		
		
		return repository.save(pagament);
	}

	@Override
	public Pagament put(Pagament pagament, Long pagamentId) {
		Pagament oldPagament = repository.findById(pagamentId)
				.orElseThrow(() -> new PagamentNotFoundException("Pagament Not Found exception"));
		
		if(Objects.nonNull(pagament.getName()) && pagament.getName().length() > 0) {
			oldPagament.setName(pagament.getName());
		}
		
		if(Objects.nonNull(pagament.getPagamentDate())) {
			oldPagament.setPagamentDate(pagament.getPagamentDate());
		}
		
		oldPagament.setCategorys(pagament.getCategorys());
		
		
		
		return repository.save(pagament);
	}

}

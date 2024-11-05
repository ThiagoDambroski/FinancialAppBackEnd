package com.dambroski.demo.PagamentPlan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PagamentPlanServiceImpl implements PagamentPlanService{
	
	@Autowired
	PagamentPlanRepository repo;

	@Override
	public List<PagamentPlan> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}

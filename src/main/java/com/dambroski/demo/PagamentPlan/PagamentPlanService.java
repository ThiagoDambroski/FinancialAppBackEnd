package com.dambroski.demo.PagamentPlan;

import java.util.List;

public interface PagamentPlanService {

	List<PagamentPlan> getAll();

	PagamentPlan post(PagamentPlan pagamentPlan, Long accountId);

	PagamentPlan put(PagamentPlan pagamentPlan, Long pagamentPlanId);

}

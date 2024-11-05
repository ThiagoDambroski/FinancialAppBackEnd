package com.dambroski.demo.pagament;

import java.util.List;

public interface PagamentService {

	List<Pagament> getAll();

	Pagament postFromAccount(Pagament pagament, Long accountId);

	Pagament postFromPlan(Pagament pagament, Long pagamentPlanId);

	Pagament put(Pagament pagament, Long pagamentId);

}

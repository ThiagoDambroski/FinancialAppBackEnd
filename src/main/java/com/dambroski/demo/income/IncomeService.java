package com.dambroski.demo.income;

import java.util.List;

public interface IncomeService {

	List<Income> getAll();

	Income postFromAccount(Income income, Long accountId);

	Income postFromPlanIncome(Income income, Long incomePlanId);

	Income put(Income income, Long incomeId);

}

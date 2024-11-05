package com.dambroski.demo.IncomeCategory;

import java.util.List;

public interface IncomeCategoryService {

	List<IncomeCategory> getAll();

	IncomeCategory post(IncomeCategory incomeCategory);

	IncomeCategory patchName(IncomeCategory incomeCategory, Long incomeCategoryId);

	void delete(Long incomeCategoryId);

}
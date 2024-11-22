package com.dambroski.demo.pagamentCategory;

import java.util.List;

public interface PagamentCategoryService {

	List<PagamentCategory> getAll();

	PagamentCategory post(PagamentCategory pagamentCategory);

	PagamentCategory patchName(PagamentCategory pagamentCategory, Long pagamentCategoryId);

	PagamentCategory patchAddToPagament(Long pagamentCategoryId,Long pagamentId);

	void delete(Long pagamentCategoryId);

	PagamentCategory patchAddToPagamentPlan(Long pagamentCategoryId, Long pagamentPlanId);

	PagamentCategory removeFromPagament(Long pagamentCategoryId, Long pagamentId);

	PagamentCategory removeFromPagamentPlan(Long pagamentCategoryId, Long pagamentPlanId);
}

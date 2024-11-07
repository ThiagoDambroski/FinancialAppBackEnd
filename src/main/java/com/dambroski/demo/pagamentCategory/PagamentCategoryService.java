package com.dambroski.demo.pagamentCategory;

import java.util.List;

public interface PagamentCategoryService {

	List<PagamentCategory> getAll();

	PagamentCategory post(PagamentCategory pagamentCategory);

	PagamentCategory patchName(PagamentCategory pagamentCategory, Long pagamentCategoryId);
}

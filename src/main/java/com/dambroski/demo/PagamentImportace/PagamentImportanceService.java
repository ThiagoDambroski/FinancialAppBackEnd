package com.dambroski.demo.PagamentImportace;

import java.util.List;

public interface PagamentImportanceService {

	List<PagamentImportance> getAll();

	PagamentImportance post(PagamentImportance pagamentImportance);

	PagamentImportance put(PagamentImportance pagamentImportance, Long pagamentImportanceId);

	PagamentImportance patchAddToPagament(Long pagamentImportanceId, Long pagamentId);

	void delete(Long pagamentImportanceId);

	PagamentImportance patchAddToPagamentPlan(Long pagamentImportanceId, Long pagamentPlanId);

}

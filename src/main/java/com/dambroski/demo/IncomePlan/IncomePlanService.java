package com.dambroski.demo.IncomePlan;

import java.util.List;

public interface IncomePlanService {

	List<IncomePlan> getAll();

	IncomePlan post(IncomePlan incomePlan, Long accountId);

	IncomePlan put(IncomePlan incomePlan, Long incomePlanId);

	void delete(Long incomePlanId);

}

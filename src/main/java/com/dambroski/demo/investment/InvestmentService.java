package com.dambroski.demo.investment;

import java.util.List;

public interface InvestmentService {

	List<Investment> getAll();

	Investment post(Investment investment, Long accountId);

	Investment put(Investment investment, Long investmentId);

	void delete(Long investmentId);

}

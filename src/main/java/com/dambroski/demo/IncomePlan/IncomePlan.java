package com.dambroski.demo.IncomePlan;

import java.util.List;

import com.dambroski.demo.IncomeCategory.IncomeCategory;
import com.dambroski.demo.account.Account;
import com.dambroski.demo.income.Income;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long incomePlanId;
	
	private String name;
	
	private double value;
	
	private int payday;
	
	private IncomePlanTimes incomeCycle;
	
	@OneToMany(mappedBy = "incomePlanAssociation")
	private List<Income> incomeHistory;
	
	@OneToMany(mappedBy = "incomesplans")
	private List<IncomeCategory> categorys;
	
	@OneToMany(mappedBy = "planIncomes")
	private Account account;

}

package com.dambroski.demo.account;

import java.util.List;

import com.dambroski.demo.IncomePlan.IncomePlan;
import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.income.Income;
import com.dambroski.demo.investment.Investment;
import com.dambroski.demo.pagament.Pagament;
import com.dambroski.demo.pigBank.PigBank;
import com.dambroski.demo.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long accountId;
	
	private String name;
	
	private double currentValue;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id" , referencedColumnName = "userId")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pagament_id" , referencedColumnName = "pagamentId")
	private List<Pagament> pagaments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pagament_plan_id" , referencedColumnName = "pagamentPlanId")
	private List<PagamentPlan> pagamentsPlan;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "income_id" , referencedColumnName = "incomeId")
	private List<Income> incomes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "income_plan_id" , referencedColumnName = "incomePlanId")
	private List<IncomePlan> planIncomes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "investment_id" , referencedColumnName = "investmentId")
	private List<Investment> investments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pig_bank_id" , referencedColumnName = "pigBankId")
	private List<PigBank> pigBank;
	
	
	

}

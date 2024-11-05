package com.dambroski.demo.IncomeCategory;

import java.util.List;

import com.dambroski.demo.IncomePlan.IncomePlan;
import com.dambroski.demo.income.Income;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long incomeCategoryId;
	
	private String name;
	
	@ManyToMany(mappedBy = "categorys")
	private List<Income> incomes;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "income_plan_id" , referencedColumnName = "incomePlanId")
	private List<IncomePlan> incomesplans;
}

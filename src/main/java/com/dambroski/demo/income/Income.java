package com.dambroski.demo.income;

import java.util.Date;
import java.util.List;

import com.dambroski.demo.IncomeCategory.IncomeCategory;
import com.dambroski.demo.IncomePlan.IncomePlan;
import com.dambroski.demo.account.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private  Long incomeID;
	
	private Date date;
	
	private double value;
	
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "income_income_category_map",joinColumns = @JoinColumn(
			name = "income_category_id", 
			referencedColumnName = "incomeCategoryId"),
	inverseJoinColumns = @JoinColumn(
					name = "income_id",
					referencedColumnName = "incomeId"))
	private List<IncomeCategory> categorys;
	
	@OneToMany(mappedBy = "incomes")
	private Account account;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "income_plan_id" , referencedColumnName = "incomePlanId")
	private IncomePlan incomePlanAssociation;
	
	

}

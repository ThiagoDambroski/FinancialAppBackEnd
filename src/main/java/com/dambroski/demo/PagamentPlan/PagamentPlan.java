package com.dambroski.demo.PagamentPlan;

import java.util.List;

import com.dambroski.demo.PagamentImportace.PagamentImportance;
import com.dambroski.demo.account.Account;
import com.dambroski.demo.pagament.Pagament;
import com.dambroski.demo.pagamentCategory.PagamentCategory;

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
public class PagamentPlan {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pagamentPlanId;
	
	private String pagamentPlanName;
	
	@OneToMany(mappedBy = "pagamentsPlan")
	private PagamentImportance importance;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pagament_plan_pagament_category_map",
			joinColumns = @JoinColumn(
				name="pagament_category_id",
				referencedColumnName = "pagamentCategoryId"
			),
			inverseJoinColumns =  @JoinColumn(
					name = "pagament_plan_id",
					referencedColumnName = "pagamentPlanId"
					))
	private List<PagamentCategory> categorys;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pagament_id" , referencedColumnName = "pagamentId")
	private List<Pagament> pagamentsHistory;
	
	private int dayOfPagamentInMonth;
	
	private int pagamentEveryHowManyDays;
	
	@OneToMany(mappedBy = "pagamentsPlan")
	private Account account;
	
	
	
	
	
	
}

package com.dambroski.demo.pagament;

import java.util.Date;
import java.util.List;

import com.dambroski.demo.PagamentImportace.PagamentImportance;
import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.account.Account;
import com.dambroski.demo.pagamentCategory.PagamentCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagament {
	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long pagamentId;
	
	private String name;
	
	private double value;
	
	private Date pagamentDate;
	
	@OneToMany(mappedBy = "pagaments")
	private PagamentImportance importance;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pagament_pagament_category_map",joinColumns = @JoinColumn(
			name = "pagament_category_id", 
			referencedColumnName = "pagamentCategoryId"),
	inverseJoinColumns = @JoinColumn(
					name = "pagament_id",
					referencedColumnName = "pagamentId"))
	private List<PagamentCategory> categorys;
	
	@OneToMany(mappedBy = "pagaments")
	private Account account;
	
	@OneToMany(mappedBy = "pagamentsHistory")
	private PagamentPlan plan;
	

}

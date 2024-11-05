package com.dambroski.demo.pigBank;

import java.util.Date;

import com.dambroski.demo.account.Account;

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
public class PigBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long pigBankId;
	
	private String name;
	
	private double currentAmount;
	
	private boolean onlyBreakable;
	
	private Date ExpectBreakDate;
	
	@OneToMany(mappedBy = "pigBank")
	private Account account;
	

}

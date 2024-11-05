package com.dambroski.demo.investment;

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
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long investmentId;
	
	private double value;
	
	private String name;
	
	private double interstRate;
	
	private boolean removeble;
	
	private Date begginOfInvestment;
	
	@OneToMany(mappedBy = "investments")
	private Account accouunt;
	
	
	
}

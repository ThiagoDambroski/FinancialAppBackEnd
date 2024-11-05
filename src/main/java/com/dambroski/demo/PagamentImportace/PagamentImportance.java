package com.dambroski.demo.PagamentImportace;

import java.util.List;

import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.pagament.Pagament;

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
public class PagamentImportance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pagamentImportanceId ; 
	
	private String name;
	
	private int value;
	
	private boolean unMissible;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pagament_id" , referencedColumnName = "pagamentId")
	private List<Pagament> pagaments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pagament_plan_id" , referencedColumnName = "pagamentPlanId")
	private List<PagamentPlan> pagamentsPlan;
	
	
}

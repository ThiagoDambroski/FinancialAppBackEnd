package com.dambroski.demo.pagamentCategory;

import java.util.List;

import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.pagament.Pagament;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PagamentCategoryId;
	
	private String categoryName;
	
	@ManyToMany(mappedBy = "categorys")
	private List<Pagament> pagaments;
	
	@ManyToMany(mappedBy = "categorys")
	private List<PagamentPlan> pagamentsPlan;
	
	

}

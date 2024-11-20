package com.dambroski.demo.PagamentImportace;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.demo.PagamentPlan.PagamentPlan;
import com.dambroski.demo.PagamentPlan.PagamentPlanRepository;
import com.dambroski.demo.erros.PagamentImportanceNotFoundException;
import com.dambroski.demo.erros.PagamentNotFoundException;
import com.dambroski.demo.erros.PagamentPlanNotFoundException;
import com.dambroski.demo.pagament.Pagament;
import com.dambroski.demo.pagament.PagamentRepository;

@Service
public class PagamentImportanceServiceImpl  implements PagamentImportanceService{
	
	@Autowired
	PagamentImportanceRepository repo;
	
	@Autowired
	PagamentRepository pagamentRepository;
	
	@Autowired
	PagamentPlanRepository pagamentPlanRepository;

	@Override
	public List<PagamentImportance> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public PagamentImportance post(PagamentImportance pagamentImportance) {
		
		List<Pagament> emptyPagamentList = new ArrayList<>();
		pagamentImportance.setPagaments(emptyPagamentList);
		List<PagamentPlan> emptyPagamentPlanList = new ArrayList<>();
		pagamentImportance.setPagamentsPlan(emptyPagamentPlanList);
		
		return repo.save(pagamentImportance);
	}

	@Override
	public PagamentImportance put(PagamentImportance pagamentImportance, Long pagamentImportanceId) {
		PagamentImportance oldImportance = repo.findById(pagamentImportanceId)
				.orElseThrow(() -> new PagamentImportanceNotFoundException("pagament importance not found "));
		
		if(Objects.nonNull(pagamentImportance.getName()) && pagamentImportance.getName().length() > 0) {
				oldImportance.setName(pagamentImportance.getName());
		}
		if(Objects.nonNull(pagamentImportance.getValue())) {
			oldImportance.setValue(pagamentImportance.getValue());
		}
		
		oldImportance.setUnMissible(pagamentImportance.isUnMissible());
		
		return repo.save(oldImportance);
	}

	@Override
	public PagamentImportance patchAddToPagament(Long pagamentImportanceId, Long pagamentId) {
		PagamentImportance pagamentImportance = repo.findById(pagamentImportanceId)
				.orElseThrow(() -> new PagamentImportanceNotFoundException("Pagament Importance Not Found"));
		
		Pagament pagament = pagamentRepository.findById(pagamentId)
				.orElseThrow(() -> new PagamentNotFoundException("Pagament Not Found"));
		
		List<Pagament> listPagament = pagamentImportance.getPagaments();
		
		if(!listPagament.contains(pagament)) {
			listPagament.add(pagament);
		}
		
		pagamentImportance.setPagaments(listPagament);
		
		return repo.save(pagamentImportance);
	}
	
	@Override
	public PagamentImportance patchAddToPagamentPlan(Long pagamentImportanceId, Long pagamentPlanId) {
		PagamentImportance pagamentImportance = repo.findById(pagamentImportanceId)
				.orElseThrow(() -> new PagamentImportanceNotFoundException("pagament importance not found"));
		
		PagamentPlan pagamentPlan = pagamentPlanRepository.findById(pagamentPlanId)
				.orElseThrow(() -> new PagamentPlanNotFoundException("pagament plan not found"));
		
		
		List<PagamentPlan> listPagamentPlan = pagamentImportance.getPagamentsPlan();
		
		if(!listPagamentPlan.contains(pagamentPlan)) {
			listPagamentPlan.add(pagamentPlan);
		}
		
		pagamentImportance.setPagamentsPlan(listPagamentPlan);
		
		
		return repo.save(pagamentImportance);
	}
	

	@Override
	public void delete(Long pagamentImportanceId) {
		PagamentImportance pagamentImportance = repo.findById(pagamentImportanceId)
				.orElseThrow(() -> new PagamentImportanceNotFoundException("Pagament Importance Not Found"));
		
		repo.delete(pagamentImportance);
		
	}

	
	

}

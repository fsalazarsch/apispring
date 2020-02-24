package com.lealtad360.panelscotiacms.entity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lealtad360.panelscotiacms.entity.dao.IBeneficioDao;
import com.lealtad360.panelscotiacms.entity.models.Beneficio;

@Service
public class BeneficioServiceImpl implements IBeneficioService{
	
	@Autowired
	private IBeneficioDao beneficioDao;
	
	@Override
	public Beneficio get(long id) {
		return beneficioDao.findById(id).get();
	}

	@Override
	public List<Beneficio> getAll() {
		return (List<Beneficio>) beneficioDao.findAll();
	}

	@Override
	public void post(Beneficio beneficio) {
		beneficioDao.save(beneficio);
		
	}

	@Override
	public void put(Beneficio beneficio, long id) {
		beneficioDao.findById(id).ifPresent((x)->{
			beneficio.setId(id);
			beneficioDao.save(beneficio);
		} );
		
	}

	@Override
	public void delete(long id) {
		beneficioDao.deleteById(id);
		
	}

	@Override
	public List<Beneficio> getBybeneficiomarca(long ali, String categ) {
		
	    List<Beneficio> filteredList = new ArrayList<>();
	    List<Beneficio> originalList = (List<Beneficio>) beneficioDao.findAll();
		
	    for (Beneficio beneficio : originalList) {
	    	if(beneficio.getAlianza_id() == ali)
	    		if ( beneficio.getNombre_categoria().equals(categ))
	    			filteredList.add(beneficio);
	    	
	    }
		
		
		//aux.stream().filter(arg0)
		return filteredList;
	}

	@Override
	public void cambiarEstado(long id, long estado) {
		/*
		beneficioDao.findById(id)
		.ifPresent((x)->{
			
			beneficioDao.save(beneficio);
		} );*/
		
		
	}

}

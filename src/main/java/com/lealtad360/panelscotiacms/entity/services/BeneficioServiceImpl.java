package com.lealtad360.panelscotiacms.entity.services;

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

}

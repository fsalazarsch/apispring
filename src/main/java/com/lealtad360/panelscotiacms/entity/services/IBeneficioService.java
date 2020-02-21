package com.lealtad360.panelscotiacms.entity.services;

import java.util.List;

import com.lealtad360.panelscotiacms.entity.models.Beneficio;

public interface IBeneficioService {

	public Beneficio get(long id);
	public List<Beneficio> getAll();
	public void post(Beneficio beneficio);
	public void put(Beneficio beneficio, long id);
	public void delete(long id);
	
}

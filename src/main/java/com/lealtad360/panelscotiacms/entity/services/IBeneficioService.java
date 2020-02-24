package com.lealtad360.panelscotiacms.entity.services;

import java.util.HashMap;
import java.util.List;

import com.lealtad360.panelscotiacms.entity.models.Beneficio;

public interface IBeneficioService {

	public Beneficio get(long id);
	public List<Beneficio> getAll();
	public List<Beneficio> getBybeneficiomarca(long ali, String categ);
	public HashMap<String, Integer> monitor();
	public void cambiarEstado(long id, long estado);
	public void post(Beneficio beneficio);
	public void put(Beneficio beneficio, long id);
	public void delete(long id);
	
}

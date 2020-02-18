package com.lealtad360.panelscotiacms.entity.services;

import java.util.List;

import com.lealtad360.panelscotiacms.entity.models.Marca;


public interface IMarcaService {
	public Marca get(long id);
	public List<Marca> getAll();
	public void post(Marca marca);
	public void put(Marca marca, long id);
	public void delete(long id);
	
	
}

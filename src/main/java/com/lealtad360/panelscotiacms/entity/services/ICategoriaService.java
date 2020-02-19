package com.lealtad360.panelscotiacms.entity.services;

import java.util.List;

import com.lealtad360.panelscotiacms.entity.models.Categoria;


public interface ICategoriaService {

	public Categoria get(long id);
	public List<Categoria> getAll();
	public void post(Categoria categoria);
	public void put(Categoria categoria, long id);
	public void delete(long id);
}

package com.lealtad360.panelscotiacms.entity.services;

import java.util.List;

import com.lealtad360.panelscotiacms.entity.models.Alianza;


public interface IAlianzaService {

	public Alianza get(long id);
	public List<Alianza> getAll();
	public void post(Alianza alianza);
	public void put(Alianza alianza, long id);
	public void delete(long id);
}

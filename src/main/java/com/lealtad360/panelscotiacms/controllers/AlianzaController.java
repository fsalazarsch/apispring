package com.lealtad360.panelscotiacms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lealtad360.panelscotiacms.entity.models.Alianza;
import com.lealtad360.panelscotiacms.entity.services.IAlianzaService;

public class AlianzaController {

	@Autowired
	IAlianzaService alianzaservice;

	@GetMapping("/empresa")
	public List<Alianza> getAllAlianzas() {
		return alianzaservice.getAll();
	}
	
	@GetMapping("/empresa/{id}")
	public Alianza getOne(@PathVariable(value = "id") long id ) {
		return alianzaservice.get(id);
	}
	
	@PostMapping("/empresa")
	public void add(Alianza alianza) {
		alianzaservice.post(alianza);
	}
	
	@PutMapping("/empresa")
	public void update(Alianza alianza, long id) {
		alianzaservice.put(alianza, id);
	}
	
	@DeleteMapping
	public void delete(long id) {
		alianzaservice.delete(id);
	}
}

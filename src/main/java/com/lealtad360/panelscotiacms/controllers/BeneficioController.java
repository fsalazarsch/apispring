package com.lealtad360.panelscotiacms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lealtad360.panelscotiacms.entity.models.Beneficio;
import com.lealtad360.panelscotiacms.entity.services.IBeneficioService;

@RestController
public class BeneficioController {

	@Autowired
	IBeneficioService beneficioservice;

	@GetMapping("/beneficio")
	public List<Beneficio> getAllAlianzas() {
		return beneficioservice.getAll();
	}
	
	@GetMapping("/beneficio/{id}")
	public Beneficio getOne(@PathVariable(value = "id") long id ) {
		return beneficioservice.get(id);
	}
	
	@PostMapping("/beneficio")
	public void add(Beneficio beneficio) {
		beneficioservice.post(beneficio);
	}
	
	@PutMapping("/beneficio")
	public void update(Beneficio beneficio, long id) {
		beneficioservice.put(beneficio, id);
	}
	
	@DeleteMapping("/beneficio/{id}")
	public void delete(long id) {
		beneficioservice.delete(id);
	}
}
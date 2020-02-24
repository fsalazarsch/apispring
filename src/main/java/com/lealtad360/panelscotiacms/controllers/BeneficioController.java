package com.lealtad360.panelscotiacms.controllers;

import java.util.HashMap;
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

	@GetMapping("/beneficio/{ali}/{categ}")
	public List<Beneficio> getBybeneficiomarca(@PathVariable(value = "ali") long ali, @PathVariable(value = "categ") String categ ) {
		return beneficioservice.getBybeneficiomarca( ali, categ);
	}
	
	@GetMapping("/monitor")
	public HashMap<String, Integer> monitor(){		
		return beneficioservice.monitor();
	}
	
	/*Reemplazar por el put mapping*/
	@GetMapping("/beneficio_estado/{id}/{estado}")
	public void cambiarEstado(@PathVariable(value = "id") long id, @PathVariable(value = "estado") long estado ){
		beneficioservice.cambiarEstado(id, estado);
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
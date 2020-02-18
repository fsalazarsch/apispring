package com.lealtad360.panelscotiacms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lealtad360.panelscotiacms.entity.models.Marca;
import com.lealtad360.panelscotiacms.entity.services.IMarcaService;

@RestController
public class MarcaController{

	@Autowired
	IMarcaService marcaService;
	
	@GetMapping("/marcas")
	public List<Marca> getAllMarcas() {
		return marcaService.getAll();
	}
	
	@GetMapping("/marcas/{id}")
	public Marca getOne(@PathVariable(value = "id") long id ) {
		return marcaService.get(id);
	}
	
	@PostMapping("/marcas")
	public void add(Marca marca) {
		marcaService.post(marca);
	}
	
	@PutMapping("/marcas")
	public void update(Marca marca, long id) {
		marcaService.put(marca, id);
	}
	
	@DeleteMapping
	public void delete(long id) {
		marcaService.delete(id);
	}
}

package com.lealtad360.panelscotiacms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lealtad360.panelscotiacms.entity.models.Categoria;
import com.lealtad360.panelscotiacms.entity.services.ICategoriaService;

@RestController
public class CategoriaController{

	@Autowired
	ICategoriaService categoriaservice;
	
	@GetMapping("/categorias")
	public List<Categoria> getAllCategorias() {
		return categoriaservice.getAll();
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria getOne(@PathVariable(value = "id") long id ) {
		return categoriaservice.get(id);
	}
	
	@PostMapping("/categorias")
	public void add(Categoria Categoria) {
		categoriaservice.post(Categoria);
	}
	
	@PutMapping("/categorias")
	public void update(Categoria Categoria, long id) {
		categoriaservice.put(Categoria, id);
	}
	
	@DeleteMapping
	public void delete(long id) {
		categoriaservice.delete(id);
	}
}

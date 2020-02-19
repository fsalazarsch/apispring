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
	ICategoriaService categoriaService;
	
	@GetMapping("/Categorias")
	public List<Categoria> getAllCategorias() {
		return categoriaService.getAll();
	}
	
	@GetMapping("/Categorias/{id}")
	public Categoria getOne(@PathVariable(value = "id") long id ) {
		return categoriaService.get(id);
	}
	
	@PostMapping("/Categorias")
	public void add(Categoria Categoria) {
		categoriaService.post(Categoria);
	}
	
	@PutMapping("/Categorias")
	public void update(Categoria Categoria, long id) {
		categoriaService.put(Categoria, id);
	}
	
	@DeleteMapping
	public void delete(long id) {
		categoriaService.delete(id);
	}
}

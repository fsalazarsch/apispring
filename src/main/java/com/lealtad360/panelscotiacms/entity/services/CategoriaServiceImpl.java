package com.lealtad360.panelscotiacms.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lealtad360.panelscotiacms.entity.dao.ICategoriaDao;
import com.lealtad360.panelscotiacms.entity.models.Categoria;

public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao categoriadao;
	
	@Override
	public Categoria get(long id) {
		return categoriadao.findById(id).get();
	}

	@Override
	public List<Categoria> getAll() {
		return (List<Categoria>) categoriadao.findAll();
	}

	@Override
	public void post(Categoria categoria) {
		categoriadao.save(categoria);
		
	}

	@Override
	public void put(Categoria categoria, long id) {
		categoriadao.findById(id).ifPresent((x)->{
			categoria.setId(id);
			categoriadao.save(categoria);
		});
		
	}

	@Override
	public void delete(long id) {
		categoriadao.deleteById(id);
		
	}

}

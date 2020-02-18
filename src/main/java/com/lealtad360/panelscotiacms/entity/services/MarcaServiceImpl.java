package com.lealtad360.panelscotiacms.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.lealtad360.panelscotiacms.entity.dao.IMarcaDao;
import com.lealtad360.panelscotiacms.entity.models.Marca;

@Service
public class MarcaServiceImpl implements IMarcaService {
	
	@Autowired
	private IMarcaDao marcaDao;

	
	@Override
	public Marca get(long id) {
		return marcaDao.findById(id).get();
	}

	@Override
	public List<Marca> getAll() {
		return  (List<Marca>) marcaDao.findAll();
	}

	@Override
	public void post(Marca marca) {
		marcaDao.save(marca);
	}

	@Override
	public void put(Marca marca, long id) {
		 marcaDao.findById(id).ifPresent((x)->{
			marca.setId(id);
			 marcaDao.save(marca);
			
			});
		
	}

	@Override
	public void delete(long id) {
		marcaDao.deleteById(id);
	}

}

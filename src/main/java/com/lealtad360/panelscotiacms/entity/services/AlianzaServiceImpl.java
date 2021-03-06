package com.lealtad360.panelscotiacms.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lealtad360.panelscotiacms.entity.dao.IAlianzaDao;
import com.lealtad360.panelscotiacms.entity.models.Alianza;

@Service
public class AlianzaServiceImpl implements IAlianzaService {
	
	@Autowired
	private IAlianzaDao alianzaDao;
	
	@Override
	public Alianza get(long id) {
		return alianzaDao.findById(id).get();
	}

	@Override
	public List<Alianza> getAll() {
		return  (List <Alianza>) alianzaDao.findAll();
	}

	@Override
	public void post(Alianza alianza) {
		alianzaDao.save(alianza);
		
	}

	@Override
	public void put(Alianza alianza, long id) {
		alianzaDao.findById(id).ifPresent((x)-> {
			alianza.setId(id);
			alianzaDao.save(alianza);
		});
		
	}

	@Override
	public void delete(long id) {
		if(id != 6)
			alianzaDao.deleteById(id);
		
	}

}

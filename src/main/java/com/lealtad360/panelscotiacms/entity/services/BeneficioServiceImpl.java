package com.lealtad360.panelscotiacms.entity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lealtad360.panelscotiacms.entity.dao.IAlianzaDao;
import com.lealtad360.panelscotiacms.entity.dao.IBeneficioDao;
import com.lealtad360.panelscotiacms.entity.dao.ICategoriaDao;
import com.lealtad360.panelscotiacms.entity.models.Alianza;
import com.lealtad360.panelscotiacms.entity.models.Beneficio;
import com.lealtad360.panelscotiacms.entity.models.Categoria;

@Service
public class BeneficioServiceImpl implements IBeneficioService{
	
	@Autowired
	private IBeneficioDao beneficioDao;
	private IAlianzaDao alianzadao;
	private ICategoriaDao categoriadao;
	
	@Override
	public Beneficio get(long id) {
		return beneficioDao.findById(id).get();
	}

	@Override
	public List<Beneficio> getAll() {
		return (List<Beneficio>) beneficioDao.findAll();
	}

	@Override
	public void post(Beneficio beneficio) {
		beneficioDao.save(beneficio);
		
	}

	@Override
	public void put(Beneficio beneficio, long id) {
		beneficioDao.findById(id).ifPresent((x)->{
			beneficio.setId(id);
			beneficioDao.save(beneficio);
		} );
		
	}

	@Override
	public void delete(long id) {
		beneficioDao.deleteById(id);
		
	}

	@Override
	public List<Beneficio> getBybeneficiomarca(long ali, String categ) {
		
	    List<Beneficio> filteredList = new ArrayList<>();
	    List<Beneficio> originalList = (List<Beneficio>) beneficioDao.findAll();
		
	    for (Beneficio beneficio : originalList) {
	    	if(beneficio.getAlianza_id() == ali)
	    		if ( beneficio.getNombre_categoria().equals(categ) || beneficio.getCategoria_id().toString().equals(categ) )
	    			filteredList.add(beneficio);
	    	
	    }
		
		
		//aux.stream().filter(arg0)
		return filteredList;
	}

	@Override
	public void cambiarEstado(long id, long estado) {
		
		Beneficio b = beneficioDao.findById(id).get();
		b.setEstado(estado);
		
		
	}


	
	@Override
	public HashMap<String, Integer> monitor() {
	//public void monitor() {
		System.out.print("asdasdas");

		HashMap<String, Integer> filteredList = new HashMap< String, Integer>();
	    
		List<Alianza> a = new ArrayList<Alianza>();
		a = (List<Alianza>) alianzadao.findAll();
		List<Categoria> c = (List<Categoria>) categoriadao.findAll();
		
		
		for( Alianza alianza : a ) {
			for (Categoria categoria : c) {
		    	filteredList.put("imagen", (int) alianza.getId());
		    	
		    	int count = getBybeneficiomarca((long) alianza.getId(), categoria.getNombreCategoria()).size();
		    	
		    	filteredList.put( categoria.getNombreCategoria(), count );

			}
		}
		return filteredList;
	}
	
	

}

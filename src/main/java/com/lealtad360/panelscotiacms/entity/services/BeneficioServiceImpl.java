package com.lealtad360.panelscotiacms.entity.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
	@Autowired
	private IAlianzaDao alianzadao;
	@Autowired
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
	public List<Beneficio> getBybeneficiomarca(long ali, String categ, boolean monitor) {
		
	    List<Beneficio> filteredList = new ArrayList<>();
	    List<Beneficio> originalList = (List<Beneficio>) beneficioDao.findAll();
		
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");  
	    Date date = new Date();  
	    
	    for (Beneficio beneficio : originalList) {
	    	if(beneficio.getAlianza_id() == ali)
	    		if ( beneficio.getNombre_categoria().equals(categ) || beneficio.getCategoria_id().toString().equals(categ)){
	    			if (monitor == true) {
	    				if ( (beneficio.getEstado() == 1) && (beneficio.getFechaPeriodo().startsWith(formatter.format(date))))
	    					filteredList.add(beneficio);
	    			}
	    			else
	    				filteredList.add(beneficio);
	    		}
	    	
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
	public List<Map<String, Integer>> monitor() {
	//public void monitor() {
		System.out.print("asdasdas");

		//List filteredList = new ArrayList();
		List<Map<String, Integer>> filteredList = new ArrayList<>();

		
		List<Alianza> a = (List<Alianza>) alianzadao.findAll();
		
		List<Categoria> c = (List<Categoria>) categoriadao.findAll();
		
		int i = 0;
		for( Alianza alianza : a ) {
			HashMap<String, Integer> aux = new HashMap< String, Integer>();

			for (Categoria categoria : c) {
		    	aux.put("imagen", (int) alianza.getId());
		    	
		    	int count = getBybeneficiomarca((long) alianza.getId(), categoria.getNombreCategoria(), true).size();
		    	
		    	aux.put( categoria.getNombreCategoria(), count );

			}
			filteredList.add(i, aux);
			i += 1;
		}
		return  filteredList;
	}
	
	

}

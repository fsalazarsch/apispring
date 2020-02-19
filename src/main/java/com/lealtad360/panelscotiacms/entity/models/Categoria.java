package com.lealtad360.panelscotiacms.entity.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Categoria implements Serializable{
public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String nombreCategoria;
	private String dateCreateAt;
	private String dateUpdateAt;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public String getDateCreateAt() {
		return dateCreateAt;
	}
	public void setDateCreateAt(String dateCreateAt) {
		this.dateCreateAt = dateCreateAt;
	}
	public String getDateUpdateAt() {
		return dateUpdateAt;
	}
	public void setDateUpdateAt(String dateUpdateAt) {
		this.dateUpdateAt = dateUpdateAt;
	}

	public Categoria() {}
}

package com.lealtad360.panelscotiacms.entity.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name= "Alinzas")
public class Alianza implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String nombreAlianza;
	
	private String link;
	private String dateCreateAt;
	private String dateUpdateAt;
	
	private String imagen;
	private String color;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreAlianza() {
		return nombreAlianza;
	}
	public void setNombreAlianza(String nombreAlianza) {
		this.nombreAlianza = nombreAlianza;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Alianza() {}
	
}

package com.lealtad360.panelscotiacms.entity.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "beneficios")
public class Beneficio implements Serializable{
public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private long alianzaId;
	@NotEmpty
	private long categoriaId;
	@NotEmpty
	private long marcaId;
	private long cantidadBeneficios;
	private String dateCreateAt;
	private String dateUpdateAt;
	private String cuotas;
	private long descuento;
	private String fechaPeriodo;
	private long estado;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "alianzaId", insertable= false, updatable = false)
	private Alianza alianza;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "categoriaId", insertable= false, updatable = false)
	private Categoria categoria;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "marcaId", insertable= false, updatable = false)
	private Marca marca;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getCatidadBeneficios() {
		return cantidadBeneficios;
	}
	public void setCatidadBeneficios(long catidadBeneficios) {
		this.cantidadBeneficios = catidadBeneficios;
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
	public String getCuotas() {
		if (cuotas == null)
			return "";
		return cuotas;
	}
	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}
	public long getDescuento() {
		return descuento;
	}
	public void setDescuento(long descuento) {
		this.descuento = descuento;
	}
	public String getFechaPeriodo() {
		return fechaPeriodo;
	}
	public void setFechaPeriodo(String fechaPeriodo) {
		this.fechaPeriodo = fechaPeriodo;
	}
	public long getEstado() {
		return estado;
	}
	public void setEstado(long estado) {
		this.estado = estado;
	}
	
	public Beneficio() {}


	public String getNombre_alianza() {
		return alianza.getNombreAlianza();
	}

	public Long getAlianza_id() {
		return alianza.getId();
	}
	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}

	public String getNombre_categoria() {
		return categoria.getNombreCategoria();
	}

	public Long getCategoria_id() {
		return categoria.getId();
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre_marca() {
		return marca.getNombreMarca();
	}

	public Long getMarca_id() {
		return marca.getId();
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}

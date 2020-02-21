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
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAlianzaid() {
		return alianzaId;
	}
	public void setAlianzaid(long alianza) {
		this.alianzaId = alianza;
	}
	public long getCategoria() {
		return categoriaId;
	}
	public void setCategoria(long categoria) {
		this.categoriaId = categoria;
	}
	public long getMarca() {
		return marcaId;
	}
	public void setMarca(long marca) {
		this.marcaId = marca;
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

	@Override
	public String toString() {
		return "Beneficio [id=" + id + ", alianzaId=" + alianzaId + ", categoriaId=" + categoriaId + ", marcaId="
				+ marcaId + ", cantidadBeneficios=" + cantidadBeneficios + ", dateCreateAt=" + dateCreateAt
				+ ", dateUpdateAt=" + dateUpdateAt + ", cuotas=" + cuotas + ", descuento=" + descuento
				+ ", fechaPeriodo=" + fechaPeriodo + ", estado=" + estado + ", alianza=" + alianza + "]";
	}
	public Alianza getAlianza() {
		return alianza;
	}
	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}
    
	/*"nombre_alianza": "CMR Falabella",
    "nombre_categoria": "Viajes",
    "id": "1",
    "cantidad_beneficios": "1",
    "alianza_id": "1",
    "categoria_id": "1",
    "dateCrfecha_periodoeate_at": "2019-05-10 22:00:04",
    "dateUpdate_at": "2020-02-07 00:00:00",
    "cuotas": "",
    "descuento": "0",
    "": "2020-01-20",
    "marca_id": "1",
    "estado": "1"*/
}

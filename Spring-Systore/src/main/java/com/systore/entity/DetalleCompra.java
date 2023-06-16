package com.systore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detallecompra")
public class DetalleCompra {

	@EmbeddedId
	private DetalleCompraPK id;
	
	@ManyToOne
    @JoinColumn(name = "cod_com",insertable = false,updatable = false,referencedColumnName ="cod_com")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "cod_pro",insertable = false,updatable = false,referencedColumnName ="cod_pro")
    private Producto producto;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "cantidad")
    private Integer cantidad;

	public DetalleCompraPK getId() {
		return id;
	}

	public void setId(DetalleCompraPK id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}

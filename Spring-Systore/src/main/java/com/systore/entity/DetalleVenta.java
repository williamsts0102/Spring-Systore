package com.systore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalleventa")
public class DetalleVenta {

	@EmbeddedId
	private DetalleVentaPK id;
	
	@ManyToOne
    @JoinColumn(name = "cod_ven",insertable = false,updatable = false,referencedColumnName ="cod_ven")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "cod_pro",insertable = false,updatable = false,referencedColumnName ="cod_pro")
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

	public DetalleVentaPK getId() {
		return id;
	}

	public void setId(DetalleVentaPK id) {
		this.id = id;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
    
}

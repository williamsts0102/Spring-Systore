package com.systore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Venta")
public class Venta {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ven")
    private Integer codigo;

    @Column(name = "fec_ven")
    private LocalDate fechaVenta;

    @OneToMany(mappedBy = "venta")
    @JsonIgnore
    private List<DetalleVenta> listaDetallesVenta;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public List<DetalleVenta> getListaDetallesVenta() {
		return listaDetallesVenta;
	}

	public void setListaDetallesVenta(List<DetalleVenta> listaDetallesVenta) {
		this.listaDetallesVenta = listaDetallesVenta;
	}

}

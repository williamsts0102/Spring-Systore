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
@Table(name = "Compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_com")
    private Integer codigo;

    @Column(name = "fec_bol")
    private LocalDate fechaBoleta;

    @OneToMany(mappedBy = "compra")
    @JsonIgnore
    private List<DetalleCompra> listaDetallesCompra;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFechaBoleta() {
		return fechaBoleta;
	}

	public void setFechaBoleta(LocalDate fechaBoleta) {
		this.fechaBoleta = fechaBoleta;
	}

	public List<DetalleCompra> getListaDetallesCompra() {
		return listaDetallesCompra;
	}

	public void setListaDetallesCompra(List<DetalleCompra> listaDetallesCompra) {
		this.listaDetallesCompra = listaDetallesCompra;
	}
    
}

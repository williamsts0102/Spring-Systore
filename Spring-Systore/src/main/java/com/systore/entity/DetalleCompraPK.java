package com.systore.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleCompraPK implements Serializable{

	private Integer cod_com;
	private Integer cod_pro;
	private Integer cod_prov;
	
	public Integer getCod_com() {
		return cod_com;
	}
	public void setCod_com(Integer cod_com) {
		this.cod_com = cod_com;
	}
	public Integer getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(Integer cod_pro) {
		this.cod_pro = cod_pro;
	}
	public Integer getCod_prov() {
		return cod_prov;
	}
	public void setCod_prov(Integer cod_prov) {
		this.cod_prov = cod_prov;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cod_com, cod_pro, cod_prov);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleCompraPK other = (DetalleCompraPK) obj;
		return Objects.equals(cod_com, other.cod_com) && Objects.equals(cod_pro, other.cod_pro)
				&& Objects.equals(cod_prov, other.cod_prov);
	}
	
}

package com.systore.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleVentaPK implements Serializable {

	private Integer cod_ven;
	private Integer cod_pro;
	
	public Integer getCod_ven() {
		return cod_ven;
	}
	public void setCod_ven(Integer cod_ven) {
		this.cod_ven = cod_ven;
	}
	public Integer getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(Integer cod_pro) {
		this.cod_pro = cod_pro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cod_pro, cod_ven);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleVentaPK other = (DetalleVentaPK) obj;
		return Objects.equals(cod_pro, other.cod_pro) && Objects.equals(cod_ven, other.cod_ven);
	}
	
}

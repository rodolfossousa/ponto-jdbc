package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class TipoPonto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipoPonto;
	
	public TipoPonto() {
		
	}

	public TipoPonto(Integer id, String tipoPonto) {
		this.id = id;
		this.tipoPonto = tipoPonto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(String tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoPonto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPonto other = (TipoPonto) obj;
		return Objects.equals(id, other.id) && Objects.equals(tipoPonto, other.tipoPonto);
	}

	@Override
	public String toString() {
		return "TipoPonto [id=" + id + ", tipoPonto=" + tipoPonto + "]";
	}

}

package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class TipoInsercao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String tipoInsercao;

	public TipoInsercao() {

	}

	public TipoInsercao(Integer id, String tipoInsercao) {
		this.id = id;
		this.tipoInsercao = tipoInsercao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoInsercao() {
		return tipoInsercao;
	}

	public void setTipoInsercao(String tipoInsercao) {
		this.tipoInsercao = tipoInsercao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoInsercao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoInsercao other = (TipoInsercao) obj;
		return Objects.equals(tipoInsercao, other.tipoInsercao) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TipoInsercao [id=" + id + ", TipoInsercao=" + tipoInsercao + "]";
	}

	
}

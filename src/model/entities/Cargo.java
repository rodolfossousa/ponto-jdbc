package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String cargo;
	
	public Cargo() {
		
	}

	public Cargo(Integer id, String cargo) {
		this.id = id;
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", cargo=" + cargo + "]";
	}

	
}

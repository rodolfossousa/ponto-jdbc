package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String endereco;
	private Cargo cargo;
	private Date horarioCadastro;
	
	public Usuario () {
		
	}

	public Usuario(Integer id, String nome, String endereco, Cargo cargo, Date horarioCadastro) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cargo = cargo;
		this.horarioCadastro = horarioCadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getHorarioCadastro() {
		return horarioCadastro;
	}

	public void setHorarioCadastro(Date horarioCadastro) {
		this.horarioCadastro = horarioCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cargo=" + cargo
				+ ", horarioCadastro=" + horarioCadastro + "]";
	}
	
}

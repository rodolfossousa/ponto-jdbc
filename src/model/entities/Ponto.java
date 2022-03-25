package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Ponto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date horario;
	
	private TipoInsercao tipoInsercao;
	private TipoPonto tipoPonto;
	private Usuario usuario;
	
	public Ponto () {
		
	}

	public Ponto(Integer id, Date horario, TipoInsercao tipoInsercao, TipoPonto tipoPonto, Usuario usuario) {
		this.id = id;
		this.horario = horario;
		this.tipoInsercao = tipoInsercao;
		this.tipoPonto = tipoPonto;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public TipoInsercao getTipoInsercao() {
		return tipoInsercao;
	}

	public void setTipoInsercao(TipoInsercao tipoInsercao) {
		this.tipoInsercao = tipoInsercao;
	}

	public TipoPonto getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(TipoPonto tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Ponto other = (Ponto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ponto [id=" + id + ", horario=" + horario + ", tipoInsercao=" + tipoInsercao + ", tipoPonto="
				+ tipoPonto + ", usuario=" + usuario + "]";
	}
	
	

}

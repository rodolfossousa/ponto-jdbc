package model.dao;

import java.util.List;

import model.entities.Cargo;
import model.entities.Usuario;

public interface UsuarioDao {

	void insert(Usuario obj);
	void update(Usuario obj);
	void deleteById(Integer id);
	Usuario fyndById(Integer id);
	List<Usuario> findAll();
	List<Usuario> findByCargo(Cargo cargo);
}

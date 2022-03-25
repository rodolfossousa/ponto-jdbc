package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.UsuarioDao;
import model.entities.Cargo;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {

	private Connection conn;
	
	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario fyndById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT USUR.*,CARG.CARGO AS NOME_CARGO "
					+ "FROM USUR INNER JOIN CARG "
					+ "ON USUR.CARGO = CARG.ID "
					+ "WHERE USUR.ID = ?"					
					);
			
			st.setInt(1, id);			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Cargo cargo = instanciaCargo(rs);
				Usuario obj = instanciaUsuario(rs, cargo);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByCargo(Cargo cargo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT USUR.*,CARG.CARGO AS NOME_CARGO "
					+ "FROM USUR INNER JOIN CARG "
					+ "ON USUR.CARGO = CARG.ID "
					+ "WHERE CARG.CARGO = ?"					
					);
			
			st.setString(1, cargo.getCargo());			
			rs = st.executeQuery();
			
			List<Usuario> list = new ArrayList<>();
			Map<Integer, Cargo> map = new HashMap<>();
			
			while(rs.next()) {
				
				Cargo carg = map.get(rs.getInt("CARGO"));
				
				if(carg == null) {
					carg = instanciaCargo(rs);
					map.put(rs.getInt("CARGO"), carg);
				}

				Usuario obj = instanciaUsuario(rs, carg);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	private Cargo instanciaCargo(ResultSet rs) throws SQLException {
		Cargo obj = new Cargo();
		obj.setId(rs.getInt("CARGO"));
		obj.setCargo(rs.getString("NOME_CARGO"));
		return obj;
	}
	
	private Usuario instanciaUsuario(ResultSet rs, Cargo cargo) throws SQLException {
		Usuario obj = new Usuario();
		obj.setId(rs.getInt("ID"));
		obj.setNome(rs.getString("NOME"));
		obj.setEndereco(rs.getString("ENDERECO"));
		obj.setCargo(cargo);
		obj.setHorarioCadastro(rs.getDate("HORARIO_CADASTRO"));
		return obj;
	}

}

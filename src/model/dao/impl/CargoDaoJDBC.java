package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CargoDao;
import model.entities.Cargo;

public class CargoDaoJDBC implements CargoDao {

	private Connection conn;
	
	public CargoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Cargo obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO CARG "
					+ "(CARGO) "
					+ "VALUES "
					+ "(?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getCargo());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Cargo obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE CARG "
					+ "SET CARGO = ? "
					+ "WHERE Id = ?");
			
			st.setString(1, obj.getCargo());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM CARG WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Cargo fyndById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+ "FROM CARG "
					+ "WHERE ID = ?"					
					);
			
			st.setInt(1, id);			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Cargo obj = instanciaCargo(rs);
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
	public List<Cargo> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+ "FROM CARG"				
					);
					
			rs = st.executeQuery();
			
			List<Cargo> list = new ArrayList<>();
			
			while(rs.next()) {
				Cargo obj = instanciaCargo(rs);
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
		obj.setId(rs.getInt("ID"));
		obj.setCargo(rs.getString("CARGO"));
		return obj;
	}

	}



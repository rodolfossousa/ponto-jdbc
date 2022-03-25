package application;

import java.util.List;

import model.dao.CargoDao;
import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Cargo;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) {
		
		CargoDao cargoDao = DaoFactory.createCargoDao();
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		
		System.out.println("=== TEST 1: Cargo findById ===");
		Cargo cargo = cargoDao.fyndById(3);
		
		System.out.println(cargo);
		
		System.out.println();
		System.out.println("=== TEST 2: Cargo findAll ===");
		List<Cargo> cargos = cargoDao.findAll();
		
		cargos.forEach(System.out::println);
		
		System.out.println();
		System.out.println("=== TEST 3: Cargo insert ===");
		Cargo cargo2 = new Cargo(null, "ANALISTA FINANCEIRO");
		cargoDao.insert(cargo2);
		cargos = cargoDao.findAll();
		
		cargos.forEach(System.out::println);
		
		System.out.println();
		System.out.println("=== TEST 4: Cargo update ===");
		cargo2 = cargoDao.fyndById(cargo2.getId());
		cargo2.setCargo("RECEPCIONISTA");
		cargoDao.update(cargo2);
		cargos = cargoDao.findAll();
		
		cargos.forEach(System.out::println);
		
		System.out.println();
		System.out.println("=== TEST 5: Cargo delete ===");
		cargoDao.deleteById(cargo2.getId());
		cargos = cargoDao.findAll();
		
		cargos.forEach(System.out::println);
		
		System.out.println();
		System.out.println("=== TEST 6: Usuario findById ===");
		Usuario usuario = usuarioDao.fyndById(1);
		
		System.out.println(usuario);
		
		System.out.println();
		System.out.println("=== TEST 7: Usuario findByCargo ===");
		List<Usuario> usuarios = usuarioDao.findByCargo(usuario.getCargo());
		usuarios.forEach(System.out::println);		
		
	}

}

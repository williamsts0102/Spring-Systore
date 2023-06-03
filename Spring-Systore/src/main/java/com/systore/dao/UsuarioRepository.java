package com.systore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.systore.entity.Enlace;
import com.systore.entity.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	//select * from tb_usuario where login='aaa' and password='bb'
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String login);
	
	@Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
	public List<Enlace> traerEnlacesDelUsuario(int codRol);
	
}

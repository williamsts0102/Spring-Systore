package com.systore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systore.dao.UsuarioRepository;
import com.systore.entity.Enlace;
import com.systore.entity.Usuario;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repo;

	public Usuario validarSesion(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	
	public List<Enlace> enlacesDelUsuario(int codRol){
		return repo.traerEnlacesDelUsuario(codRol);
	}
}

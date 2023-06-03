package com.systore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.systore.entity.Enlace;
import com.systore.entity.Usuario;
import com.systore.services.UsuarioServices;

@SessionAttributes({"datosUsuario","ENLACES"})
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	/*inyeccion al servicio*/
	@Autowired
	private UsuarioServices servicio;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/intranet")
	/**/
	public String intranet(Authentication auth, Model model) {
		/*Con esto sacamos el id ingresado*/
		String vLogin = auth.getName();
		//Invocar al metodo validarSesion
		Usuario bean = servicio.validarSesion(vLogin);
		//Invocar al metodo enlacesDelUsuario
		List<Enlace> lista = servicio.enlacesDelUsuario(bean.getRol().getCodigo());
		//Asignar valor a los atributos de tipo sesión
		model.addAttribute("datosUsuario",bean.getApellido()+""+bean.getNombre());
		model.addAttribute("ENLACES",lista);
		return "intranet";
	}
}
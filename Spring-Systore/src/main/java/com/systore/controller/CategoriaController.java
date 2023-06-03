package com.systore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.systore.entity.Categoria;
import com.systore.entity.Tienda;
import com.systore.services.CategoriaServices;
import com.systore.services.TiendaServices;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
    private CategoriaServices categoriaService;
	
	@Autowired
    private TiendaServices tiendaService;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		//crear atributos
		model.addAttribute("categorias", categoriaService.listarTodos());
		model.addAttribute("tiendas",tiendaService.listarTodos());
		
		return "categoria";
	}
	
	//ruta (URL) para buscar por código
	@RequestMapping("/buscar")
	@ResponseBody //genera JSON
	public Categoria buscarPorCodigo(@RequestParam("codigo") Integer cod) {
		return categoriaService.buscarPorID(cod);
	
	}
	
	//ruta (URL) para eliminar por código
	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigo") Integer cod,
				 						RedirectAttributes redirect) {
		categoriaService.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Categoria eliminado");
		return "redirect:/categoria/lista";
	}
	
	//ruta (URL) para grabar
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						 @RequestParam("nombre") String nom,
						 @RequestParam("tienda") Integer codTienda,
						 RedirectAttributes redirect) {
		try {
			//crear objeto de la entidad Medicamento
			Categoria c=new Categoria();
			//setear atributos del objeto "m"
			c.setNombre(nom);
			//crear objeto de la entidad TipoMedicamento
			Tienda t=new Tienda();
			//setear codigo
			t.setCodigo(codTienda);
			//enviar objeto "tm" al objeto "m"
			c.setTienda(t);
			
			if(cod==0) {			
				categoriaService.registrar(c);
				//atributo
				redirect.addFlashAttribute("MENSAJE","Categoria registrado");
			}
			else {
				c.setCodigo(cod);
				categoriaService.actualizar(c);
				//atributo
				redirect.addFlashAttribute("MENSAJE","Categoria actualizado");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		return "redirect:/categoria/lista";
	}	
}

package com.systore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.systore.entity.Categoria;
import com.systore.entity.Producto;
import com.systore.entity.Tienda;
import com.systore.services.CategoriaServices;
import com.systore.services.ProductoServices;
import com.systore.services.TiendaServices;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoServices productoService;

    @Autowired
    private TiendaServices tiendaService;

    @Autowired
    private CategoriaServices categoriaService;

    @RequestMapping("/lista")
    public String index(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("tiendas", tiendaService.listarTodos());
        /*
        model.addAttribute("categorias", categoriaService.listarTodos());
        */
        return "producto";
    }

    @RequestMapping("/grabar")
    public String grabar(@RequestParam("codigo") Integer cod,
                         @RequestParam("nombre") String nom,
                         @RequestParam("descripcion") String des,
                         @RequestParam("precioVenta") double pre,
                         @RequestParam("stock") int sto,
                         @RequestParam("tienda") int codTienda,
                         @RequestParam("categoria") int codCategoria,
                         RedirectAttributes redirect) {
        try {
            Producto producto = new Producto();
            producto.setNombre(nom);
            producto.setDescripcion(des);
            producto.setPrecioVenta(pre);
            producto.setStock(sto);

            Tienda tienda = new Tienda();
            tienda.setCodigo(codTienda);
            producto.setTienda(tienda);

            Categoria categoria = new Categoria();
            categoria.setCodigo(codCategoria);
            producto.setCategoria(categoria);

            if (cod == 0) {
                productoService.registrar(producto);
                redirect.addFlashAttribute("MENSAJE", "Producto registrado");
            } else {
                producto.setCodigo(cod);
                productoService.actualizar(producto);
                redirect.addFlashAttribute("MENSAJE", "Producto actualizado");
            }
        } catch (Exception e) {
            redirect.addFlashAttribute("MENSAJE", "Error en el registro");
            e.printStackTrace();
        }
        return "redirect:/producto/lista";
    }

    @RequestMapping("/buscar")
    @ResponseBody
    public Producto buscarPorCodigo(@RequestParam("codigo") Integer cod) {
        return productoService.buscarPorID(cod);
    }

    @RequestMapping("/eliminar")
    public String eliminarPorCodigo(@RequestParam("codigo") Integer cod,
                                    RedirectAttributes redirect) {
        productoService.eliminarPorID(cod);
        redirect.addFlashAttribute("MENSAJE", "Producto eliminado");
        return "redirect:/producto/lista";
    }

    @RequestMapping("/listarPorTienda")
    @ResponseBody
    public List<Categoria> listarPorTienda(@RequestParam("codigo") Integer cod) {
        return categoriaService.listarPorTienda(cod);
    }

    /*
    @RequestMapping("/listarPorCategoria")
    @ResponseBody
    public List<Ti> listarPorCategoria(@RequestParam("codigo") Integer cod) {
        return productoService.listarPorCategoria(cod);
    }
    */
}


package com.systore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systore.dao.ProductoRepository;
import com.systore.entity.Producto;

@Service
public class ProductoServices {
    @Autowired
    private ProductoRepository repo;

    public void registrar(Producto p) {
        repo.save(p);
    }

    public void actualizar(Producto p) {
        repo.save(p);
    }

    public void eliminarPorID(Integer cod) {
        repo.deleteById(cod);
    }

    public Producto buscarPorID(Integer cod) {
        return repo.findById(cod).orElse(null);
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }

    public List<Producto> listarProductosPorStock(int stock) {
        return repo.listarProductosPorStock(stock);
    }
}


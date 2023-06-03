package com.systore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systore.dao.CategoriaRepository;
import com.systore.entity.Categoria;

@Service
public class CategoriaServices {
    @Autowired
    private CategoriaRepository repo;

    public void registrar(Categoria c) {
        repo.save(c);
    }

    public void actualizar(Categoria c) {
        repo.save(c);
    }

    public void eliminarPorID(Integer cod) {
        repo.deleteById(cod);
    }

    public Categoria buscarPorID(Integer cod) {
        return repo.findById(cod).orElse(null);
    }
    
    public List<Categoria> listarTodos() {
        return repo.findAll();
    }

    public List<Categoria> listarPorTienda(Integer codTienda) {
        return repo.findAllByTienda(codTienda);
    }
}


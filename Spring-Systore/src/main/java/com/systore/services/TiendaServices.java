package com.systore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systore.dao.TiendaRepository;
import com.systore.entity.Tienda;

@Service
public class TiendaServices {
    @Autowired
    private TiendaRepository repo;

    public List<Tienda> listarTodos() {
        return repo.findAll();
    }
}


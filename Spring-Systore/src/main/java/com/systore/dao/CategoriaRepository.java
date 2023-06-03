package com.systore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.systore.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Método para retornar todas las categorías de una tienda según su código
    @Query("SELECT c FROM Categoria c WHERE c.tienda.codigo = ?1")
    public List<Categoria> findAllByTienda(Integer codTienda);
}


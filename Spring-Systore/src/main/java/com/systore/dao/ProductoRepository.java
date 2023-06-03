package com.systore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.systore.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Método para retornar todos los productos donde su stock sea mayor a un parámetro
    @Query("SELECT p FROM Producto p WHERE p.stock > ?1")
    public List<Producto> listarProductosPorStock(int stock);
}


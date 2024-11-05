package com.sergiov.apirest.repository;

import com.sergiov.apirest.model.Categoria;

import java.util.List;

public interface CategoriaRepository {


    List<Categoria> obtenerCategorias();
    Categoria obtenerCategoriaPorId(int id);

    boolean insertarCategoria(Categoria c);


}

package com.sergiov.apirest.repository;

import com.sergiov.apirest.model.Libro;

import java.util.List;

public interface LibroRepository {

    List<Libro> obtenerLibros();
    Libro obtenerLibroPorId(int id);

    boolean insertarLibro(Libro l);

    boolean actualizarLibro(Libro l);

    boolean eliminarLibro(int id);
}

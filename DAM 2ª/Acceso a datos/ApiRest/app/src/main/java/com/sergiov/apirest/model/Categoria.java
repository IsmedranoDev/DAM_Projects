package com.sergiov.apirest.model;



public class Categoria {

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    private Integer id;


    private String nombre;


    public int getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre ;
    }





}

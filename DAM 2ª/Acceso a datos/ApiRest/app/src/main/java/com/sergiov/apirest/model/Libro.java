package com.sergiov.apirest.model;



public class Libro {

    private Integer id;

    private String titulo;

    private String autor;

    private String fecha;

    private Categoria categoria;


    public Libro(Integer id, String titulo, String autor, String fecha, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", fecha=" + fecha + ", categoria="
                + categoria + "]";
    }



}

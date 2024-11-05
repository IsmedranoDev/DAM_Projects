/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Crea un objeto de tipo Administración, que hereda de Candidato
 * @author israelmedrano
 */
public class Administracion extends Candidato {
    
    String nivelInformaticaTexto;
    String nivelInformaticaHojaCalculo;
    String nivelInformaticaInternet;

    public Administracion(String nombre, String apellidos, String dni, String fechaNacimiento, String direccion, int cp, String localidad, int telefono, String rutaCv, String estudiosFinalizados, String observaciones, String fechaAlta, String usuarioRegistrador, String nivelInformaticaTexto, String nivelInformaticaHojaCalculo, String nivelInformaticaInternet) {
        super(nombre, apellidos, dni, fechaNacimiento, direccion, cp, localidad, telefono, rutaCv, estudiosFinalizados, observaciones, fechaAlta, usuarioRegistrador);
        this.nivelInformaticaTexto=nivelInformaticaTexto;
        this.nivelInformaticaHojaCalculo=nivelInformaticaHojaCalculo;
        this.nivelInformaticaInternet=nivelInformaticaInternet;
     
    }

    public String getNivelInformaticaTexto() {
        return nivelInformaticaTexto;
    }

    public void setNivelInformaticaTexto(String nivelInformaticaTexto) {
        this.nivelInformaticaTexto = nivelInformaticaTexto;
    }

    public String getNivelInformaticaHojaCalculo() {
        return nivelInformaticaHojaCalculo;
    }

    public void setNivelInformaticaHojaCalculo(String nivelInformaticaHojaCalculo) {
        this.nivelInformaticaHojaCalculo = nivelInformaticaHojaCalculo;
    }

    public String getNivelInformaticaInternet() {
        return nivelInformaticaInternet;
    }

    public void setNivelInformaticaInternet(String nivelInformaticaInternet) {
        this.nivelInformaticaInternet = nivelInformaticaInternet;
    }

    @Override
    public String toString() {
        return "Administracion{" + "nivelInformaticaTexto=" + nivelInformaticaTexto + ", nivelInformaticaHojaCalculo=" + nivelInformaticaHojaCalculo + ", nivelInformaticaInternet=" + nivelInformaticaInternet + '}';
    }
    
    
    
}

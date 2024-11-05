/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Crea un objeto de tipo Almacen, que herada de la clase candidato.
 * @author israelmedrano
 */
public class Almacen extends Candidato{
    
    String carnetConducir;
    String carnetCarretilla;
    String carnetCamion;

    public Almacen(String nombre, String apellidos, String dni, String fechaNacimiento, String direccion, int cp, String localidad, int telefono, String rutaCv, String estudiosFinalizados, String observaciones, String fechaAlta, String usuarioRegistrador, String carnetConducir, String carnetCarretilla, String carnetCamion) {
        super(nombre, apellidos, dni, fechaNacimiento, direccion, cp, localidad, telefono, rutaCv, estudiosFinalizados, observaciones, fechaAlta, usuarioRegistrador);
        this.carnetConducir=carnetConducir;
        this.carnetCarretilla=carnetCarretilla;
        this.carnetCamion=carnetCamion;
        
    }

    public String getCarnetConducir() {
        return carnetConducir;
    }

    public void setCarnetConducir(String carnetConducir) {
        this.carnetConducir = carnetConducir;
    }

    public String getCarnetCarretilla() {
        return carnetCarretilla;
    }

    public void setCarnetCarretilla(String carnetCarretilla) {
        this.carnetCarretilla = carnetCarretilla;
    }

    public String getCarnetCamion() {
        return carnetCamion;
    }

    public void setCarnetCamion(String carnetCamion) {
        this.carnetCamion = carnetCamion;
    }

    @Override
    public String toString() {
        return "Almacen{" + "carnetConducir=" + carnetConducir + ", carnetCarretilla=" + carnetCarretilla + ", carnetCamion=" + carnetCamion + '}';
    }
    
    
    
}

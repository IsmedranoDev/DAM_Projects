/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Crea un objeto candidato, con los campos básicos
 * @author israelmedrano
 */
public class Candidato {
    
    String nombre;
    String apellidos;
    String dni;
    String fechaNacimiento;
    String direccion;
    int cp;
    String localidad;
    int telefono;
    String rutaCv;
    String estudiosFinalizados;
    String observaciones;
    String fechaAlta;
    String usuarioRegistrador;

    public Candidato(String nombre, String apellidos, String dni, String fechaNacimiento, String direccion, int cp, String localidad, int telefono, String rutaCv, String estudiosFinalizados, String observaciones, String fechaAlta, String usuarioRegistrador) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.cp = cp;
        this.localidad = localidad;
        this.telefono = telefono;
        this.rutaCv = rutaCv;
        this.estudiosFinalizados = estudiosFinalizados;
        this.observaciones = observaciones;
        this.fechaAlta = fechaAlta;
        this.usuarioRegistrador = usuarioRegistrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRutaCv() {
        return rutaCv;
    }

    public void setRutaCv(String rutaCv) {
        this.rutaCv = rutaCv;
    }

    public String getEstudiosFinalizados() {
        return estudiosFinalizados;
    }

    public void setEstudiosFinalizados(String estudiosFinalizados) {
        this.estudiosFinalizados = estudiosFinalizados;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getUsuarioRegistrador() {
        return usuarioRegistrador;
    }

    public void setUsuarioRegistrador(String usuarioRegistrador) {
        this.usuarioRegistrador = usuarioRegistrador;
    }

    @Override
    public String toString() {
        return "Candidato{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", cp=" + cp + ", localidad=" + localidad + ", telefono=" + telefono + ", rutaCv=" + rutaCv + ", estudiosFinalizados=" + estudiosFinalizados + ", observaciones=" + observaciones + ", fechaAlta=" + fechaAlta + ", usuarioRegistrador=" + usuarioRegistrador + '}';
    }
    
   
    
    
}

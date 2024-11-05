/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *Clase para establecer la conexión con la base de datos
 * y realizar las consultas correspondientes
 * @author israelmedrano
 */
public class Conexion {
    
    
    static String url= "jdbc:mysql://145.14.151.1:3306/u812167471_candidatos";
    static String userName = "u812167471_usercandidatos";
    static String pass = "5n&BKAL9";
    
    
    //Objeto de la clase connection
    static Connection conn;
    
    
    
    /**
     * Método donde se establecen los parámetros de la conexión
     * con la base de datos sqlite
     */
    
    public static Connection conectar()  {
        try {
            conn = DriverManager.getConnection(url,userName,pass);
        
        }catch (SQLException ex){
           
            JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos\n"+ ex.getMessage());
        } 
        
        return null;
        
    }
    
    /**
     * Método para cerrar la conexión a la base de datos
     */
    public static void cerrarConexion(){
        try{
            conn.close();
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "No se ha podido cerrar la conexión a la base de datos\n"+ex.getMessage());
        }
    }
    
    
    
    /**
     * Consulta para comprobar el logado de usuarios
     * @param user
     * @param pass
     * @return
     */
    public static boolean acceder(String user, String pass){
        
        String SSQL="SELECT usuario, contrasenya FROM usuarios WHERE usuario =? AND contrasenya =?";
        
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = conn.prepareStatement(SSQL);
            pst.setString(1, user);
            pst.setString(2,pass);
            rs = pst.executeQuery();
            
            return rs.next();
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return false;
    }
    
    
  /**
   * Recupera el nombre de usuario para que conste quien registra el candidato
   * @return . El nombre del usuario que ha accedido a la BD
   */
    
    public static String recuperaUsuario(){
         String nombreUsuario = null;

    try (Connection connection = DriverManager.getConnection(url, userName, pass);
         Statement statement = connection.createStatement()) {
        // Obtener el nombre del usuario actual
        String sql = "SELECT CURRENT_USER() AS usuario";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                nombreUsuario = resultSet.getString("usuario");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return nombreUsuario;
}
    
    
    
    /**
     * Inserción de los candidatos en la BD
     * @param a. Es el parámetro creado con toda la información del candidato recogida en los formularios
     * @return 
     */
    
    public static boolean registraAdministracion(Administracion a){
        
        String consultaInsert = "INSERT into candidatoadministracion (nombre, apellidos, dni, fechaNacimiento, direccion, cp, localidad, telefono, rutaCv, nivelEstudios, observaciones, fechaAlta, registrador, nivelInformaticaTexto, nivelInformaticaHojaCalculo, nivelInformaticaInternet) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        boolean registrado;
        
        try{
            PreparedStatement pst = conn.prepareStatement(consultaInsert);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellidos());
            pst.setString(3, a.getDni());
            pst.setString(4, a.getFechaNacimiento());
            pst.setString(5, a.getDireccion());
            pst.setInt(6, a.getCp());
            pst.setString(7, a.getLocalidad());
            pst.setInt(8, a.getTelefono());
            pst.setString(9, a.getRutaCv());
            pst.setString(10, a.getEstudiosFinalizados());
            pst.setString(11, a.getObservaciones());
            pst.setString(12, a.getFechaAlta());
            pst.setString(13, a.getUsuarioRegistrador());
            pst.setString(14, a.getNivelInformaticaTexto());
            pst.setString(15, a.getNivelInformaticaHojaCalculo());
            pst.setString(16, a.getNivelInformaticaInternet());
            
            pst.execute();
            pst.close();
            
            registrado = true;
        } catch (SQLException ex){
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
            registrado = false;
        }
        return registrado;
    }
    
    
   /**
     * Inserción de los candidatos en la BD
     * @param a. Es el parámetro creado con toda la información del candidato recogida en los formularios
     * @return 
     */
    
        public static boolean registraAlmacen(Almacen a){
        
        String consultaInsert = "INSERT into candidatoalmacen (nombre, apellidos, dni, fechaNacimiento, direccion, cp, localidad, telefono, rutaCv, nivelEstudios, observaciones, fechaAlta, registrador, carnetConducir, carnetCarretilla, carnetCamion) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        boolean registrado;
        
        try{
            PreparedStatement pst = conn.prepareStatement(consultaInsert);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellidos());
            pst.setString(3, a.getDni());
            pst.setString(4, a.getFechaNacimiento());
            pst.setString(5, a.getDireccion());
            pst.setInt(6, a.getCp());
            pst.setString(7, a.getLocalidad());
            pst.setInt(8, a.getTelefono());
            pst.setString(9, a.getRutaCv());
            pst.setString(10, a.getEstudiosFinalizados());
            pst.setString(11, a.getObservaciones());
            pst.setString(12, a.getFechaAlta());
            pst.setString(13, a.getUsuarioRegistrador());
            pst.setString(14, a.getCarnetConducir());
            pst.setString(15, a.getCarnetCarretilla());
            pst.setString(16, a.getCarnetCamion());
            pst.execute();
            pst.close();
            
            registrado = true;
        } catch (SQLException ex){
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
            registrado = false;
        }
        return registrado;
    }
        
    /**
     * Comprobamos que los números de DNI son verdaderos
     * @param dni
     * @return 
     */
        public static boolean compruebaDniAdministracion(String dni){
            
            if(dni.length()!=9){
                return false;
            }
            
            for(int i=0; i<8; i++){
                if(!Character.isDigit(dni.charAt(i))){
                    return false;
                }
            }
            
            char letra = dni.charAt(8);
            if(!Character.isLetter(letra)){
                return false;
            }
            
            return true;
            
        }
        
        /**
         * Comprueba que el DNI introducido es correcto
         * @param dni
         * @return 
         */
        public static boolean compruebaDniAlmacen(String dni){
            
           if(dni.length()!=9){
                return false;
            }
            
            for(int i=0; i<8; i++){
                if(!Character.isDigit(dni.charAt(i))){
                    return false;
                }
            }
            
            char letra = dni.charAt(8);
            if(!Character.isLetter(letra)){
                return false;
            }
            
            return true;  
            
        }
        /**
         * Realizo una sobrecarga de métodos para registrar en un archivo TXT toda la información que he recogido en los formularios.
         * @param persona . Se trata del parámetro creado en los formularios que contiene toda la información recogida y necesaria.
         */
        
        public static void guardarTxt(Administracion persona){
            
          try{BufferedWriter escritor = new BufferedWriter(new FileWriter("historicoAdministracion.txt", true));
           
            escritor.newLine();escritor.write("Nombre y apellidos = "+persona.getNombre());
            escritor.newLine();escritor.write("Dni = "+persona.getDni());
            escritor.newLine();escritor.write("Fecha de nacimiento  = "+persona.getFechaNacimiento());
            escritor.newLine();escritor.write("Dirección = "+persona.getDireccion());
            escritor.newLine();escritor.write("Cp = "+persona.getCp());
            escritor.newLine();escritor.write("Localidad = "+persona.getLocalidad());
            escritor.newLine();escritor.write("Teléfono = "+persona.getTelefono());
            escritor.newLine();escritor.write("Estudios finalizados = "+persona.getEstudiosFinalizados());
            escritor.newLine();escritor.write("Nivel en competencias informáticas");
            escritor.newLine();escritor.write("     Tratamiento de texto: "+persona.getNivelInformaticaTexto());
            escritor.newLine();escritor.write("     Hojas de cálculo: "+ persona.getNivelInformaticaHojaCalculo());
            escritor.newLine();escritor.write("     Internet: "+ persona.getNivelInformaticaInternet());
            escritor.newLine();escritor.write("Observaciones = "+persona.getObservaciones());
            escritor.newLine();escritor.write("Fecha de alta= "+Comprueba.obtenerFecha());
            escritor.newLine();escritor.write("Registrado por= "+Conexion.recuperaUsuario());
            escritor.close();
            
            System.out.println(persona.getNombre());
            System.out.println(persona.getDni());
            
     
            JOptionPane.showMessageDialog(null, "Datos escritos en txt correctamente");
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al escribir el txt");
                e.printStackTrace();
         
            }
        }
        
       /**
         * Realizo una sobrecarga de métodos para registrar en un archivo TXT toda la información que he recogido en los formularios.
         * @param persona . Se trata del parámetro creado en los formularios que contiene toda la información recogida y necesaria.
         */
        
          public static void guardarTxt(Almacen persona){
            
            try{BufferedWriter escritor = new BufferedWriter(new FileWriter("historicoAlmacen.txt", true));
           
            escritor.newLine();escritor.write("Nombre y apellidos = "+persona.getNombre());
            escritor.newLine();escritor.write("Dni = "+persona.getDni());
            escritor.newLine();escritor.write("Fecha de nacimiento  = "+persona.getFechaNacimiento());
            escritor.newLine();escritor.write("Dirección = "+persona.getDireccion());
            escritor.newLine();escritor.write("Cp = "+persona.getCp());
            escritor.newLine();escritor.write("Localidad = "+persona.getLocalidad());
            escritor.newLine();escritor.write("Teléfono = "+persona.getTelefono());
            escritor.newLine();escritor.write("Estudios finalizados = "+persona.getEstudiosFinalizados());
            escritor.newLine();escritor.write("Carnets de conducir");
            escritor.newLine();escritor.write("     Carnet de conducir: "+persona.getCarnetConducir());
            escritor.newLine();escritor.write("     Carnet de carretilla: "+ persona.getCarnetCarretilla());
            escritor.newLine();escritor.write("     Carnet de camión: "+ persona.getCarnetCamion());
            escritor.newLine();escritor.write("Observaciones = "+persona.getObservaciones());
            escritor.newLine();escritor.write("Fecha de alta= "+Comprueba.obtenerFecha());
            escritor.newLine();escritor.write("Registrado por= "+Conexion.recuperaUsuario());
            escritor.close();
            
            System.out.println(persona.getCarnetConducir());
            
            
     
            JOptionPane.showMessageDialog(null, "Datos escritos en txt correctamente");
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al escribir el txt");
                e.printStackTrace();
         
            }
        }
   
}

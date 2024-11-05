/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Clase para gestionar los archivos del programa.
 * @author israelmedrano
 */
public class Fichero {
    
    private File fichero;
    
    public Fichero(){
        

    }
    
    public File getFichero(){
        return fichero;
    }
    
    public void setFicher(File fichero){
        
       this.fichero=fichero;
    }
    
    //Creo el archivo donde se guardarán los datos
    private static final String archivodatos = "archivodatos.txt";
    
    public void escribir(String datos){
        
        /**
         * Código para escribir los datos en un fichero TXT.
         */
        
        try(FileWriter fw = new FileWriter(archivodatos);
                BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(datos);
            JOptionPane.showMessageDialog(null, "Archivo escrito correctamente");
            
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo");
        }
    }
}

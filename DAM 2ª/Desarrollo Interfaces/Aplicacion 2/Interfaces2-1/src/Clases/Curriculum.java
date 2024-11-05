/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.File;

/**
 * Crea un objeto de tipo File para trabajar con archivos.
 * @author israelmedrano
 */
public class Curriculum {
    
    private File archivo;
    
    public Curriculum(File archivo){
        this.archivo = archivo;
        
    }
    
    public File getAttribute(){
        return archivo;
    }
    
    public void setAttribute(File archivo){
        this.archivo=archivo;
    }
    
    
    
}

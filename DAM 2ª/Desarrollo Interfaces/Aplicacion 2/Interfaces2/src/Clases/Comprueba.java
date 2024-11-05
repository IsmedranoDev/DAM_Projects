/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Comprueba que el campo no se encuentra vacío. 
 * @author israelmedrano
 */
public class Comprueba {
    
    public static boolean vacio(JTextField campo){
        
        return"".equals(campo.getText().trim());
    }
    
    
    /**
     * Lanza una alerta si el campo se encuentra vacío 
     * @param padre
     * @param campo 
     */
    public static void alertaVacio(Component padre, JTextField campo){
        JOptionPane.showMessageDialog(padre,"El campo "+ campo.getName()+ " no puede estar vacío", "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
        campo.setBackground(Color.red);
    }
    
    /**
     * Comprueba que se ha seleccionado alguna opción del JComboBox.
     * @param select
     * @return 
     */
    public static boolean select (JComboBox select) {
        return select.getSelectedIndex() != 0;
    }
    
    /**
     * Lanza una alerta si no hay ningún campo seleccionado en el JComboBox
     * @param padre
     * @param select 
     */
    public static void alertaSelect (Component padre, JComboBox select) {
        JOptionPane.showMessageDialog(padre, "Debe seleccionar un elemento del campo " +select.getName(), "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
        
    }
/**
 * Comprueba que el selector de fecha no está vacío.
 * @param fecha
 * @return 
 */
    public static boolean select(JDateChooser fecha) {
        return fecha.getDate()!=null; 
    }
    
    /**
     * Lanza una alerta para seleccionar una fecha
     * @param padre
     * @param dateChooser 
     */
   public static void alertaSelect(Component padre, JDateChooser dateChooser) {
    JOptionPane.showMessageDialog(padre, "Debe seleccionar una fecha del campo " + dateChooser.getName(), "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
}
  
/**
 * Comprueba que un al menos un boton se encuentra seleccionado en un grupo de botones
 * @param grupo
 * @return 
 */
   public static boolean select(ButtonGroup grupo){
       for (Enumeration<AbstractButton> buttons = grupo.getElements(); buttons.hasMoreElements();) {
        if (buttons.nextElement().isSelected()) {
            return true;
        }
    }
    return false;
   }
/**
 * Lanza una alerta si no existe ninguna opción seleccionada en un grupo de botones
 * @param padre
 * @param grupo 
 */
   public static void alertaSelect(Component padre, ButtonGroup grupo){
       JOptionPane.showMessageDialog(padre, "Debe seleccionar al menos, uno de los niveles");
   }
      /**
       * Captura la información que se encuentra en los campos seleccionados dentro de un ButtonGroup
       * @param grupo
       * @return devuelve el texto del botón en forma de String.
       */ 
    public static String botonSeleccionado(ButtonGroup grupo){
      String textoSeleccionado=null;
      
          Enumeration<AbstractButton> buttons = grupo.getElements();
while (buttons.hasMoreElements()) {
    AbstractButton button = buttons.nextElement();
    if (button.isSelected()) {
        textoSeleccionado = button.getText();
        break;
    }  
    }
    return textoSeleccionado;
    }
    
    /**
     * Comprueba si se ha seleccionado o no un JCheckBox
     * @param seleccion
     * @return SI o NO dependiendo de la selección.
     */
    public static String SiNo(JCheckBox seleccion){
        if(seleccion.isSelected()){
            return "SI";
        }else{
            return "NO";
        }
    }
    
    /**
     * Método para recuperar la fecha actual.
     * @return La fecha actual con el formato "dd/Mm/YY"
     */
    public static String obtenerFecha(){
          LocalDate fechaHoy = LocalDate.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
    return fechaHoy.format(formato);
    }
    
}

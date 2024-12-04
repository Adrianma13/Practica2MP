/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

/**
 *
 * @author usuario
 */
public class ClienteTarifaPlana extends Cliente {
    private String nacionalidad;
    private float tarifa=20;
    private float minutoshablados;
    private final float pexceso = (float) 0.15;

    public static void setTarifa(int i, float f) {
       
    }

    public static String getLimite() {
        
        return null;
        
    }

    public static String getTarifa() {
        
        return null;
        
    }
    public ClienteTarifaPlana(String nif, String nombre, Fecha fnac,Fecha fechaAlta, float tarifa, String nacionalidad) {
        super(nif,nombre,fnac,fechaAlta);
        this.tarifa=tarifa;
        this.nacionalidad=nacionalidad;
    }
    public ClienteTarifaPlana(String nif, String nombre, Fecha fnac, float tarifa, String nacionalidad) {
        super(nif,nombre,fnac);
        this.tarifa=tarifa;
        this.nacionalidad=nacionalidad;
    }

    public void setNombre(String pepe) {
        
    
        
    }

    public void setNacionalidad(String india) {
 
    }

    public void setMinutos(int i) {

    }

    public void ver() {
      
    }
    
}

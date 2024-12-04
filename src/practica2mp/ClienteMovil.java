/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

/**
 *
 * @author usuario
 */
public class ClienteMovil extends Cliente{
private float preciom;
private float minutoshablados;
private Fecha Permanencia;
   

  
    public ClienteMovil(String nif, String nombre, Fecha fnac, Fecha fAlta, Fecha f30,float preciom, float minutoshablados) {
        super(nif,nombre,fnac,fAlta);
        this.preciom = preciom;
        this.minutoshablados = minutoshablados;
        this.Permanencia = fAlta;  
    }

 
    public ClienteMovil(String nif, String nombre, Fecha fnac, float preciom, float minutoshablados) {
        super(nif,nombre,fnac);
         this.preciom = preciom;
        this.minutoshablados = minutoshablados;
        
    }

  

    public void setFPermanencia(Fecha f1) {
      Permanencia=(Fecha) f1.clone();
    }

    public Fecha getFPermanencia() {
      
    return Permanencia;
      
    }

    public void ver() {
        
    }

   
    
}

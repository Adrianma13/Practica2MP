/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

/**
 *
 * @author usuario
 */
public class Cliente {
    private final String nif; //dni del cliente (letra incluida) (NO puede cambiar)
    private final int codCliente; //codigo único (y fijo) generado por la aplicación
    private String nombre; //nombre completo del cliente (SI se puede modificar)
    private final Fecha fechaNac; //fecha nacimiento del cliente (NO se puede cambiar)
    private  Fecha fechaAlta; //fecha de alta del cliente (SI se puede modificar)
    private static Fecha fechadefecto = new Fecha(01, 01, 2018);
    private int contador=1;
    public static Fecha getFechaPorDefecto() {
        return fechadefecto;
    }

   public Cliente(Cliente c1) {
        codCliente = contador;
        nif = c1.nif;      
        nombre = c1.nombre;
        fechaNac = (Fecha) c1.fechaNac.clone();
        fechaAlta = (Fecha) c1.fechaAlta.clone();
        contador++;
    }
      public Cliente(String NIF, String nom, Fecha fNac, Fecha fAlta) {
        codCliente = contador;
        nif = NIF;
        nombre = nom;
        fechaNac = (Fecha) fNac.clone();
        fechaAlta = (Fecha) fAlta.clone();
        contador++;
    } //constructor

    public Cliente(String NIF, String nom, Fecha fNac) {
        nif = NIF;
        nombre = nom;
        fechaNac = fNac;
        codCliente = contador;
        fechaAlta = (Fecha) fechadefecto.clone();
        contador++;
    } //constructor


    public String getNif() {
        return nif;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNac() {
        return (Fecha) fechaNac.clone();
    }

    public Fecha getFechaAlta() {
        return (Fecha) fechaAlta.clone();
    }

 
    @Override
    public String toString() {
        String s;

        s = "DNI: " + nif + "  Nombre: " + nombre + "   Fecha Nacimiento: " + fechaNac + "     FechaAlta: " + fechaAlta +"      ID: "+codCliente;

        return s;

    } //devuelve una cadena con la información del clienteF

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
     public Object clone() {
//return new Fecha(this);
        Object obj = null;
        obj = new Cliente(nif,nombre,fechaNac,fechaAlta); //se llama al clone() de la clase base (Object)
//que hace copia binaria de los atributos
        return obj;
    }

   public void setFechaAlta(Fecha fnac1) {
        fechaAlta=(Fecha) fnac1.clone();
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
 public static void setFechaPorDefecto(Fecha nuevafechadefecto) { 
        fechadefecto=new Fecha((Fecha) nuevafechadefecto.diaSig().clone());
        
    }

   
    public void ver() {
        System.out.println( toString());
    }
    
    
}

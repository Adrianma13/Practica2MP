/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

/**
 *
 * @author usuario
 */

public class Cliente implements Cloneable, Proceso {
	
	private final String nif; //dni del cliente (letra incluida) (NO puede cambiar)
	private final int codCliente; //codigo único (y fijo) generado por la aplicación
	private String nombre; //nombre completo del cliente (SI se puede modificar)
	private final Fecha fechaNac; //fecha nacimiento del cliente (NO se puede cambiar)
	private final Fecha fechaAlta; //fecha de alta del cliente (SI se puede modificar)
	private static Fecha fechaPorDefecto=new Fecha(01,01,2018);
	private static int codC=1;
	public Cliente (String NIF, String nom, Fecha fNac, Fecha fAlta) {
		nif=NIF;
		nombre=nom;
		fechaNac=fNac;
		fechaAlta=new Fecha(fAlta);
		codCliente=codC;
		codC++;
	} //constructor
	public Cliente (String NIF, String nom, Fecha fNac) {
		nif=NIF;
		nombre=nom;
		fechaNac=fNac;
		fechaAlta=getFechaPorDefecto();
		codCliente=codC;
		codC++;
	} //constructor
	
	public Cliente (Cliente c) {
		nif=c.nif;
		nombre=c.nombre;
		fechaNac=c.getFechaNac();
		fechaAlta=c.getFechaAlta();
		codCliente=codC;
		codC++;
	}
	
	public String toString() {
		String cad=nif+" "+fechaNac+": "+nombre+" (" + codCliente+" - "+fechaAlta+")";
		return cad;
	} //devuelve una cadena con la información del cliente
	
	public static Fecha getFechaPorDefecto() {
		Fecha f=new Fecha(fechaPorDefecto);
		return f;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Fecha getFechaNac() {
		Fecha f=new Fecha(fechaNac);
		return f;
	}
	
	public Fecha getFechaAlta() {
		Fecha f=new Fecha(fechaAlta);
		return f;
	}
	
	public String getNif() {
		return nif;
	}
	
	public int getCodCliente() {
		return codCliente;
	}
	
	public void setFechaAlta(Fecha f) {
		fechaAlta.setFecha(f.getDia(), f.getMes(), f.getAnio());
	}
	
	public static void setFechaPorDefecto(Fecha f) {
		fechaPorDefecto.setFecha(f.getDia(), f.getMes(), f.getAnio());
	}
	
	public void ver() {
		System.out.println(this);
		//(nif+" "+fechaNac+": "+nombre+" (" + codCliente+" - "+fechaAlta+")");
	}
	public boolean equals(Object obj) {
		boolean igual=false;
		if(obj.getClass()==this.getClass())
			if(((Cliente)obj).nif.equals(this.nif))
				igual=true;
		return igual;
	}
	
	public Object clone() {
		Cliente c=new Cliente(this);
		return c;
	}
}


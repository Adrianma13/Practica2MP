/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

/**
 *
 * @Adria 
 */
public class ClienteTarifaPlana extends Cliente {
	private String nacionalidad;
	private float minutosHablados;
	private final float precioexc=0.15f;
	private static float precioTarifa=20f;
	private static float minutos=300f;
	
	public ClienteTarifaPlana(String NIF, String nom, Fecha fNac, Fecha fAlta, float minhab, String nac) {
		super(NIF, nom, fNac, fAlta);
		nacionalidad=nac;
		minutosHablados=minhab;
	}
	
	public ClienteTarifaPlana(String NIF, String nom, Fecha fNac,float minhab, String nac) {
		super(NIF, nom, fNac);
		nacionalidad=nac;
		minutosHablados=minhab;
	}
	
	public ClienteTarifaPlana(ClienteTarifaPlana c) {
		super(c.getNif(),c.getNombre(),c.getFechaNac(),c.getFechaAlta());
		nacionalidad=c.nacionalidad;
		minutosHablados=c.minutosHablados;
	}
	
	public float factura() {
		float factura;
		if(minutosHablados<=minutos)
			factura=precioTarifa;
		else
		{
			float min;
			min=minutosHablados-minutos;
			factura=precioTarifa+(min*precioexc);
		}
		return factura;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nac) {
		nacionalidad=nac;
	}
	
	public float getMinutos() {
		return minutosHablados;
	}
	
	public void setMinutos(float min) {
		minutosHablados=min; 
	}
	
	public static float getTarifa() {
		return precioTarifa;
	}
	
	public static void setTarifa(float min, float prec) {
		minutos=min;
		precioTarifa=prec;
	}
	
	public static float getLimite() {
		return minutos;
	}
	
	
	public boolean equals(Object obj) {
		boolean igual=false;
		if(super.equals(obj)&&obj.getClass()==this.getClass())
				igual=true;
		return igual;
	}
	
	public String toString() {
		String cad=super.toString()+" "+nacionalidad+" ["+minutos+ " por "+precioTarifa + "] "+minutosHablados+ " --> "+factura();
		return cad;
	}
	
	public Object clone() {
		ClienteTarifaPlana c= new ClienteTarifaPlana(this);
		return c;
	}
}
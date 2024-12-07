/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

/**
 *
 * @author usuario
 */
public class ClienteMovil extends Cliente {
	private float minutosHablados;
	private float precio;
	private final Fecha permanencia;
	
	public ClienteMovil(String NIF, String nom, Fecha fNac, Fecha fAlta, Fecha perm, float minhab, float prec) {
		super(NIF,nom,fNac,fAlta);
		permanencia=perm;
		minutosHablados=minhab;
		precio=prec;
	}

	public ClienteMovil(String NIF, String nom, Fecha fNac, float minhab, float prec) {
		super(NIF,nom,fNac);
		permanencia=getFechaPorDefecto();
		permanencia.setFecha(permanencia.getDia(), permanencia.getMes(), permanencia.getAnio()+1);
		minutosHablados=minhab;
		precio=prec;
	}
	
	public ClienteMovil(ClienteMovil c) {
		super(c.getNif(),c.getNombre(),c.getFechaNac(),c.getFechaAlta());
		permanencia=c.getFPermanencia();
		minutosHablados=c.minutosHablados;
		precio=c.precio;
	}
	
	public Fecha getFPermanencia() {
		Fecha f=new Fecha(permanencia);
		return f;
	}
	
	public void setFPermanencia(Fecha f) {
		permanencia.setFecha(permanencia.getDia(), permanencia.getMes(), permanencia.getAnio());
	}
	
	public float getPrecioMinuto() {
		return precio;
	}
	
	public void setPrecioMinuto(float prec) {
		precio=prec;
	}
	
	public float factura() {
		float fac=minutosHablados*precio;
		return fac;
	}
	
	public boolean equals(Object obj) {
		boolean igual=false;
		if(super.equals(obj)&&obj.getClass()==this.getClass())
				igual=true;
		return igual;
	}
	
	public String toString() {
		String cad=super.toString()+" "+permanencia+" "+minutosHablados+ " x "+precio + " --> "+factura();
		return cad;
	}
	
	public Object clone() {
		ClienteMovil c= new ClienteMovil(this);
		return c;
	}
}

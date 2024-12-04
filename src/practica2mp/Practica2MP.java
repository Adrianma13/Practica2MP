/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica2mp;

/**
 *
 * @author usuario
 */
public class Practica2MP {

    /**
     * @param args the command line arguments
     */
    /*   public static void main(String[] args) {
      Fecha fnac=new Fecha(24, 5, 2001);
      Fecha falta=new Fecha(18, 10, 2017);
      Cliente c=new Cliente("79118121F", "Adrian Machuca", fnac , falta);
        Cliente c2=new Cliente(c);
        c2.ver();
             
    }*/
 /*
     public static void main(String[] args) {
      
        Fecha f1 = new Fecha(29, 2, 2001), f2 = new Fecha(f1), f3 = new Fecha(29, 2, 2004);
        final Fecha f4 = new Fecha(05, 12, 2003); //es constante la referencia f4
        System.out.println("Fechas: " + f1.toString() + ", " + f2 + ", " + f3 + ", " + f4);
        f1 = new Fecha(31, 12, 2016); //31/12/2016
        f4.setFecha(28, 2, 2008); //pero no es constante el objeto al que apunta
        System.out.println(f1 + " " + f2.toString() + " " + f3 + " " + f4 + " " + f1);
        f1 = new Fecha(f4.getDia() - 10, f4.getMes(), f4.getAnio() - 7); //f1=18/02/2001
        f3 = Fecha.pedirFecha(); // pide una fecha por teclado
        if (f3.bisiesto() && Fecha.mayor(f2, f1)) {
            System.out.println("El " + f3.getAnio() + " fue bisiesto, " + f1 + ", " + f3);
        }
        System.out.print("Fin\n");
    }
    
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        final Fecha f1 = new Fecha(29, 2, 2001), f2 = new Fecha(f1), f3 = (Fecha) f1.clone();
        Fecha fnac1 = new Fecha(7, 3, 1980), fnac2 = fnac1.diaSig(),
                fnac3 = new Fecha(27, 06, 1995), aux;
        System.out.print("Fechas: " + f1.toString() + ", " + f2 + ", " + f3 + "\n");
        System.out.println(f2.diaSig() + " " + (f2.getDia() - 2) + " " + f2 + " " + f2.getAnio());
        if (!f3.bisiesto() && f1.equals(f2)) {
            System.out.println(f3.getAnio() + " no fue bisiesto. " + f1 + " igual a " + f3);
        }
        f3.setFecha(5, 12, 2001);
        if (!f1.equals(f3) && Fecha.mayor(f1, f2) == false && Fecha.mayor(f3, f1)) {
            System.out.println(f3 + " mayor que " + f1 + ". " + f1 + " no es mayor que " + f2);
        }
        f1.setFecha(1, 1, 2001);
        f2.setFecha(2, 2, 2002);
        f3.setFecha(3, 3, 2003);
        System.out.print("Fecha alta por defecto: " + Cliente.getFechaPorDefecto() + "\n");
        Cliente c1 = new Cliente("793X", "Ana Pi", new Fecha(2, 2, 1972), f3), c2 = new Cliente(c1);
        Cliente c3 = new Cliente("953H", "Susana", new Fecha(7, 2, 1984)), c4 = (Cliente) c3.clone();
        c1.setFechaAlta(fnac1);
        c1.setNombre("Luis");
        c3.setFechaAlta(fnac3);
        c3.setNombre("Juan");
        aux = c1.getFechaNac();
        aux.setFecha(5, 5, 2005);
        aux = c1.getFechaAlta();
        aux.setFecha(7, 7, 2020);
        
        c1.ver();
        c2.ver();
        c3.ver();
        c4.ver();
        if (c2.equals(c1) && c3.equals(c4)) {
            System.out.println("asidufhaliuf");
            Cliente.setFechaPorDefecto(f3.diaSig());
        }
        System.out.print("Fecha alta por defecto: " + Cliente.getFechaPorDefecto() + "\n");
        Cliente[] c = new Cliente[6]; //array de 6 elementos de tipo Cliente
        c[0] = new ClienteMovil("547B", "Bo Derek", fnac1, f3, f3, 50.50f, 0.03f);//
        c[1] = new ClienteMovil("107J", "Messi", fnac2, 35.00f, 0.02f);
        ClienteMovil cm = (ClienteMovil) c[1].clone();
        c[2] = cm;
        cm.setNombre(c1.getNombre());
        cm.setFechaAlta(f1);
        cm.setFPermanencia(f1);
        f1.setFecha(4, 4, 2004);
        aux = cm.getFPermanencia();
        aux.setFecha(20, 20, 2020);
        c[3] = new ClienteTarifaPlana("805W", "Iker", fnac2, f1, 375.09f, "Española");
        c[4] = new ClienteTarifaPlana("953H", "Paz", fnac3, 290.00f, "Polaca");
        ClienteTarifaPlana ct = (ClienteTarifaPlana) c[3].clone();
        c[5] = ct;
        ct.setNombre("Pepe");
        ct.setNacionalidad("India");
        ct.setMinutos(500);
        cm.ver();
        ct.ver();
        ClienteTarifaPlana.setTarifa(350, 22.50f); //cambia la Tarifa Plana a 350 min x 22.50
        System.out.print("Tarifa Plana: " + ClienteTarifaPlana.getLimite() + " minutos por "
                + ClienteTarifaPlana.getTarifa() + " euros");
        for (int i = 0; i < 6; i++) {
            System.out.println(c[i].getNif() + ", " + c[i].getFechaAlta() + ", " + c[i]);
        }
        if (c[2].equals(c[1])) {
            System.out.println("c[2] y c[1] son iguales");
        }
        if (c[4].equals(c3) == false) {
            System.out.println("c[4] y c3 no son iguales (mismo dni pero distinto tipo)");
        }
    }
}

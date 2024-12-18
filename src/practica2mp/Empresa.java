/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

import java.util.Scanner;

/**
 *
 * @author Adria
 */
public class Empresa implements Cloneable {

    private Cliente clientes[];
    private static int nMaxCli = 10;
    private int nCli;
    
    
    /*
    public void mostrarClientesRecomendados() {
        int posicionTP = -1, posicionMovil = -1;
        float facturaTP = 0, facturaMovil = 0;
        for (int i = 0; i < nCli; i++) {
            if (clientes[i] instanceof ClienteMovil) {
                if (facturaMovil < ((ClienteMovil) clientes[i]).factura()) {
                    facturaMovil = ((ClienteMovil) clientes[i]).factura();
                    posicionMovil = i;
                }
            } else if (clientes[i] instanceof ClienteTarifaPlana) {
                if (facturaTP < ((ClienteTarifaPlana) clientes[i]).factura()) {
                    facturaTP = ((ClienteTarifaPlana) clientes[i]).factura();
                    posicionTP = i;
                }
            }
        }

        System.out.println("El cliente Movil con mejor Tarifa es: " + clientes[posicionMovil].toString());
        System.out.println("El cliente Tarifa con mejor Tarifa es: " + clientes[posicionTP].toString());
    }

    public void portarClientesTPUmbral(Empresa e1, Empresa e2, double umbral) {

        for (int i = 0; i < nCli; i++) {
            if (clientes[i] instanceof ClienteMovil) {
                if (umbral >= ((ClienteMovil) clientes[i]).factura()) {
                    e1.alta(new ClienteMovil((ClienteMovil) clientes[i]));
                }
            } else if (clientes[i] instanceof ClienteTarifaPlana) {
                if (umbral >= ((ClienteTarifaPlana) clientes[i]).factura()) {
                    e1.alta(new ClienteTarifaPlana((ClienteTarifaPlana) clientes[i]));
                }
            }
        }

    }

    public boolean equals(Empresa e1) {
        boolean encontrado = false;
        if (nCli == e1.getN()) {
            for (int i = 0; i < nCli; i++) {
                encontrado = false;
                if (clientes[i] instanceof ClienteMovil) {
                    for (int j = 0; j < e1.getN(); j++) {
                        if (e1.clientes[j] instanceof ClienteMovil) {
                            if (((ClienteMovil) clientes[i]).getNombre() == ((ClienteMovil) e1.clientes[j]).getNombre()) {
                                encontrado = true;
                                j = e1.getN();
                            }
                        }
                    }
                } else if (clientes[i] instanceof ClienteTarifaPlana) {
                    for (int j = 0; j < e1.getN(); j++) {
                        if (e1.clientes[j] instanceof ClienteTarifaPlana) {
                            if (((ClienteTarifaPlana) clientes[i]).getNombre() == ((ClienteTarifaPlana) e1.clientes[j]).getNombre()) {
                                encontrado = true;
                                j = e1.getN();
                            }
                        }
                    }
                }
                if (encontrado == false) {
                    i = nCli;
                }
            }
        }
        return encontrado;
    }
    
    
    public int descuento(Empresa e1,float dto,int año) {
        int contador=0;
        for (int i = 0; i < nCli; i++) {
            if (clientes[i] instanceof ClienteMovil) {
                System.out.println(((ClienteMovil) clientes[i]).getFechaAlta().getAnio());
                if( ((ClienteMovil) clientes[i]).getFechaAlta().getAnio()==año){
                ((ClienteMovil) clientes[i]).setPrecioMinuto(((ClienteMovil) clientes[i]).getPrecioMinuto() - dto);
                contador++;
                }
            }
        }
        return contador;
    }*/
    
    
    public Empresa() {
        nCli = 0;
        clientes = new Cliente[nMaxCli];
    }

    public Empresa(Empresa e) {
        nCli = e.nCli;
        clientes = new Cliente[e.nMaxCli];
    }

    public float factura() {
        float f = 0;
        for (int i = 0; i < nCli; i++) {
            if (clientes[i] instanceof ClienteMovil) {
                f += ((ClienteMovil) clientes[i]).factura();
            } else if (clientes[i] instanceof ClienteTarifaPlana) {
                f += ((ClienteTarifaPlana) clientes[i]).factura();
            }
        }
        return f;
    }

    public void alta() {
        Cliente c = null;
        String dni, nombre, nac;
        Fecha fNac, fAlta, fPer;
        int tipo;
        float min, prec;
        Scanner cin = new Scanner(System.in);
        cin.useDelimiter("\n");

        System.out.print("Dni: ");
        dni = cin.nextLine();
        int pos = existe(dni);
        if (pos == -1) {
            System.out.print("Nombre: ");
            nombre = cin.nextLine();

            System.out.print("Fecha de nacimiento: \n");
            fNac = Fecha.pedirFecha();

            System.out.print("Fecha de alta: \n");
            fAlta = Fecha.pedirFecha();

            System.out.print("Minutos que habla al mes: \n");
            min = Float.parseFloat(cin.nextLine());

            do {
                System.out.print("Indique tipo de cliente(1-Movil, 2-Tarifa Plana): ");
                tipo = Integer.parseInt(cin.nextLine());
                if (tipo != 2 && tipo != 1) {
                    System.out.print("\nError al introducir el tipo.");
                }
            } while (tipo != 2 && tipo != 1);

            if (tipo == 1) {
                System.out.print("Precio por minuto: ");
                prec = Float.parseFloat(cin.nextLine());

                System.out.print("Fecha fin permanencia: \n");
                fPer = Fecha.pedirFecha();

                c = new ClienteMovil(dni, nombre, fNac, fAlta, fPer, min, prec);

                if (nCli == nMaxCli) {
                    listaLlena();
                }
                clientes[nCli] = c;
                nCli++;
            }

            if (tipo == 2) {
                System.out.print("nacionalidad: ");
                nac = cin.nextLine();

                c = new ClienteTarifaPlana(dni, nombre, fNac, fAlta, min, nac);
                if (nCli == nMaxCli) {
                    listaLlena();
                }
                clientes[nCli] = c;
                nCli++;
            }

        } else {
            System.out.print("Ya existe un Cliente con ese dni: \n");
            clientes[pos].ver();
            System.out.print("\n");
        }
    }

    public void alta(Cliente c) {
        if (existe(c.getNif()) == -1) {
            if (nCli == nMaxCli) {
                listaLlena();
            }
            clientes[nCli] = c;
            nCli++;
        }
    }

    public int existe(String dni) {
        boolean existe = false;
        int pos = -1;
        int i = 0;
        while (i < nCli && !existe) {
            if (clientes[i].getNif().equals(dni)) {
                existe = true;
            } else {
                i++;
            }
        }
        if (existe) {
            pos = i;
        }
        return pos;
    }

    public void listaLlena() {
        Cliente aux[] = clientes;
        nMaxCli = nMaxCli * 2;
        clientes = new Cliente[nMaxCli];
        for (int i = 0; i < nCli; i++) {
            clientes[i] = aux[i];
        }
    }

    public void baja(String dni) {
        int pos = existe(dni);
        if (pos != -1) {
            for (int i = pos; i < nCli; i++) {
                clientes[i] = clientes[i + 1];
            }
            nCli--;
        }
    }

    public void baja() {
        Scanner cin = new Scanner(System.in);
        String dni, opc;

        System.out.print("\nIntroduzca nif cliente a dar de baja: ");
        dni = cin.nextLine();

        int pos = existe(dni);
        if (pos == -1) {
            System.out.print("\nEl cliente no existe");
        } else {
            System.out.print(clientes[pos].toString());
            do {
                System.out.print("\n¿Seguro que desea eliminarlo? (s/n): ");
                opc = cin.nextLine();
                if (!opc.equals("s") && !opc.equals("n")) {
                    System.out.print("\nError al introducir la opcion");
                }
            } while (!opc.equals("s") && !opc.equals("n"));

            if (opc.equals("s")) {
                System.out.print("El cliente " + clientes[pos].getNombre() + " con nif " + dni + " ha sido eliminado\n\n");
                baja(dni);
            } else {
                System.out.print("El cliente con nif " + dni + " no se elimina\n");
            }
        }
    }

    public String toString() {
        String cad = clientes[0].toString();
        for (int i = 0; i < nCli; i++) {
            cad += "\n" + clientes[i].toString();
        }
        cad += "\n";
        return cad;
    }

    public void descuento(int dto) {
        for (int i = 0; i < nCli; i++) {
            if (clientes[i] instanceof ClienteMovil) {
                ((ClienteMovil) clientes[i]).setPrecioMinuto(((ClienteMovil) clientes[i]).getPrecioMinuto() * dto / 100);
            }
        }
    }

    @Override
    public Empresa clone() {
        Empresa e = new Empresa(this);
        for (int i = 0; i < nCli; i++) {
            if (clientes[i] instanceof ClienteMovil) {
                e.clientes[i] = new ClienteMovil((ClienteMovil) clientes[i]);
            }
            if (clientes[i] instanceof ClienteTarifaPlana) {
                e.clientes[i] = new ClienteTarifaPlana((ClienteTarifaPlana) clientes[i]);
            }
        }
        return e;
    }

    public int getN() {
        return nCli;
    }

    public int nClienteMovil() {
        int contador = 0;
        for (int i = 0; i < nCli; i++) {
            if (clientes[i] instanceof ClienteMovil) {
                contador++;
            }
        }
        return contador;
    }



}

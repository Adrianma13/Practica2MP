/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2mp;

/**
 *
 * @author usuario
 */
public interface Proceso {

    @Override
    public abstract boolean equals(Object obj); //true sin son iguales

    void ver(); //muestra en pantalla el objeto
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto2;

/**
 *
 * @author usuario
 */
public class Main {

    public static void main(String[] args) {
        Taxi newTaxi = new Taxi("Filomeno");
        newTaxi.gestionarMotor();
        newTaxi.recogerPasajero();
        newTaxi.gestionarSeguros();
        newTaxi.gestionarMarcha();
        newTaxi.moverAbajo(5);
        newTaxi.moverDerecha(6);
        newTaxi.moverIzquierda(2);
        newTaxi.gestionarSeguros();
        newTaxi.gestionarMarcha();
        newTaxi.dejarPasajero();
        newTaxi.dejarPasajero(); //asdf
        newTaxi.gestionarSeguros();
        newTaxi.dejarPasajero();
        newTaxi.recogerPasajero();
        newTaxi.gestionarSeguros();
        newTaxi.moverArriba(1);
        newTaxi.gestionarMarcha();
        newTaxi.gestionarSeguros();
        newTaxi.dejarPasajero();
        
        
        
        
        
        

        //newTaxi.dejarPasajero();
        System.out.println(newTaxi.getNombreConductor() + " "
                + newTaxi.getnPasajeros()
                + " " + newTaxi.getCantidadDinero() + " "
                + newTaxi.getnMaximoPasajeros() + " "
                + newTaxi.getLocalizacionX() + " "
                + newTaxi.getLocalizacionY() + " "
                + newTaxi.isAireAcondicionadoActivado() + " "
                + newTaxi.isMotorEncendido() + " "
                + newTaxi.isWifiEncendido() + " "
                + newTaxi.isEnMarcha() +  " " 
                + newTaxi.getDistanciaRecorrida()+ " "
                + newTaxi.isSegurosActivados() + " "
                + newTaxi.calcularDistanciaAcopio());
        
                
        
        
        
                
        
                
        
    }

}

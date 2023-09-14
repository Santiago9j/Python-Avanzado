
package com.mycompany.reto2;

public abstract class Vehiculo {
    //Inserte acá los atributos
    private String nombreConductor;
    private int nPasajeros = 0; 
    private double cantidadDinero = 0.0;  
    private int nMaximoPasajeros = 1;
    private double localizacionX = 0.0;
    private double localizacionY = 0.0;
    private boolean aireAcondicionadoActivado = false;
    private boolean motorEncendido = false;
    private boolean wifiEncendido = false;
    private boolean enMarcha = false;

    //Inserte acá el método constructor
    public Vehiculo (String nombreConductor,int nMaximoPasajeros ){
        this.nombreConductor = nombreConductor;
        this.nMaximoPasajeros = nMaximoPasajeros; 
        
    }
    public Vehiculo (String nombreConductor){
        this.nombreConductor = nombreConductor; 
    }
    
    
    
    //Inserte acá los métodos (NO LOS GETTER Y SETTERS)
    public void dejarPasajero(){
        if (enMarcha == false){
            nPasajeros =  nPasajeros - 1;
        }
        
    }
    public double calcularDistanciaAcopio(){
        double g = (localizacionX *  localizacionX) + (localizacionY * localizacionY);
        double e = Math.sqrt(g);
        return e;
    }
    public void gestionarAireAcondicionado(){
        if (motorEncendido == true){
            if (aireAcondicionadoActivado == false){
                aireAcondicionadoActivado = true;
            } else {
                aireAcondicionadoActivado = false;
            }
        } else {
            aireAcondicionadoActivado = false;
        }
        
    }
    public void gestionarMotor(){
        if (motorEncendido == false){
            motorEncendido = true;
        } else {
            motorEncendido = false;
            aireAcondicionadoActivado = false;
            wifiEncendido = false;
            enMarcha = false;
        }
    }
    public void gestionarWifi(){
        if (motorEncendido == true){
            if (wifiEncendido == false){
                wifiEncendido = true;
            } else {
                wifiEncendido = false;
            }
        } else {
            wifiEncendido = false;
        }
    }

    public void moverDerecha(double d){
        if (enMarcha == true){
            localizacionX = localizacionX + d;
        }
    }
    public void moverIzquierda(double d){
        if (enMarcha == true){
            localizacionX = localizacionX - d;
        }
    }
    public void moverArriba(double d){
        if (enMarcha == true){
            localizacionY = localizacionY + d;
        }
    }
    public void moverAbajo(double d){
        if (enMarcha== true){
            localizacionY = localizacionY  - d;
        }
    }
    
    public abstract void gestionarMarcha();
    
    
    
    //Inserte acá los SETTERS Y GETTERS
    public void setnPasajeros(int nPasajeros){
        this.nPasajeros = nPasajeros;
    }
    public int getnPasajeros(){
        return nPasajeros;
    }
    public void setnMaximoPasajeros(int nMaximoPasajeros){
        this.nMaximoPasajeros = nMaximoPasajeros;
    }
    public int getnMaximoPasajeros(){
        return nMaximoPasajeros;
    }
    public boolean isEnMarcha(){
        return enMarcha;
    }
    public void setEnMarcha(boolean enMarcha){
        this.enMarcha = enMarcha; 
    }
    public double getCantidadDinero(){
        return cantidadDinero;
    }
    public void setCantidadDinero(double cantidadDinero){
        this.cantidadDinero = cantidadDinero;
    }
    public String getNombreConductor(){
        return nombreConductor;
    }
    public double getLocalizacionX(){
        return localizacionX;
    }
    public void setLocalizacionX(double d){
        this.localizacionX = this.localizacionX + d;
    }
    public void setLocalizacionY(double d){
        this.localizacionY = this.localizacionY + d;
    }    
    public double getLocalizacionY(){
        return localizacionY;
    }
    public boolean isAireAcondicionadoActivado(){
        return aireAcondicionadoActivado;
    }
    public boolean isMotorEncendido(){
        return motorEncendido;
    }
    public boolean isWifiEncendido(){
        return wifiEncendido;
    }
    public void setNombreConductor(String nombreConductor){
        this.nombreConductor = nombreConductor;
    }
    
    
}


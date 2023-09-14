
package com.mycompany.reto2;

public class Autobus extends Vehiculo{
    //              ^ (Autobus hereda de Vehiculo)
    //Inserte acá los atributos
    private boolean puertaAbierta = false;
    //Inserte acá el método constructor
    public Autobus(String nombreConductor,int nMaximoPasajeros){
        super(nombreConductor,nMaximoPasajeros);
    }
    
    //Inserte acá los métodos (NO LOS GETTER Y SETTERS)
    @Override
    public void dejarPasajero(){
        if (puertaAbierta == true){
            super.dejarPasajero();  
        }
    }
    public void recogerPasajero(int estrato){
        if (getnPasajeros() < getnMaximoPasajeros()){
            if (puertaAbierta == true){
                if (isEnMarcha() == false){
                    setCantidadDinero(getCantidadDinero() + this.calcularPasaje(estrato));
                    setnPasajeros(getnPasajeros()+1);
                }
            }
            
        }
    }
    public void gestionarPuerta(){
        if (puertaAbierta == false){
            if (isEnMarcha() == false ){
                puertaAbierta = true;
            } else {
                puertaAbierta = false;
            }
        } else {
            puertaAbierta = false;
        }
    }
    @Override
    public void gestionarMarcha(){
        if (isEnMarcha() == false){
            if (puertaAbierta == false){
                setEnMarcha(true);
            } else {
                setEnMarcha(false);
            }
        } else{
            setEnMarcha(false);
        }
    } 
    public double calcularPasaje(int estrato){
        double valor = 0.0;
        switch(estrato){
            case 0: valor = 1500; break;
            case 1: valor = 1500; break;
            case 2: valor = 1500; break;
            case 3: valor = 2600; break;
            case 4: valor = 2600; break;
            case 5: valor = 3000; break;
            case 6: valor = 3000; break;
        }
        return valor;
    } 
    
    
    
    //Inserte acá los SETTERS Y GETTERS
    public boolean isPuertaAbierta(){
        return puertaAbierta;
    }
    
    
    
}
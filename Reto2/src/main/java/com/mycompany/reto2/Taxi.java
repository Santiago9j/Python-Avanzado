package com.mycompany.reto2;

public class Taxi extends  Vehiculo{
    //           ^ (Taxi hereda de Vehiculo)
    //Inserte acá los atributos
    private double distanciaRecorrida = 0.0;
    private boolean segurosActivados = false;
    //Inserte acá el método constructor
    public Taxi(String nombreConductor){
        super(nombreConductor);
    }
    //Inserte acá los métodos (NO LOS GETTER Y SETTERS)
    
    public void reiniciarTaximetro(){
        this.distanciaRecorrida = 0;
        
    }
    public void presionarBotonPanico(){
        this.setEnMarcha(false);
        this.segurosActivados = false;
        this.setnPasajeros(0);  
        
    }
    @Override
    public void dejarPasajero(){
        //Hasta acá.
        //setCantidadDinero(getCantidadDinero() + this.calcularPasaje());
        if (!this.isSegurosActivados() && this.getnPasajeros()>0){
            
            this.setnPasajeros(this.getnPasajeros() - 1);
            setCantidadDinero(getCantidadDinero() + this.calcularPasaje());
            this.reiniciarTaximetro(); 
        }  
    } 
    public double calcularPasaje (){
        double valor;
        valor = 3000+(2300 * distanciaRecorrida);
        return valor;
    }
    public void recogerPasajero(){
        if (!this.isSegurosActivados() && this.getnPasajeros() == 0 && isEnMarcha() == false){
            this.setnPasajeros(this.getnPasajeros()+1);
            
        }     
    }
    @Override
    public void gestionarMarcha(){
        if (isEnMarcha() == false && segurosActivados == true){
            if (isMotorEncendido() == true){
                setEnMarcha(true);
            } else {
                setEnMarcha(false);
            }
        } else {
            setEnMarcha(false);
        }
    }
    @Override
    public void moverDerecha(double d){
        if (isEnMarcha() == true){
            setLocalizacionX(d);
            if (getnPasajeros()>0){
                distanciaRecorrida = distanciaRecorrida + d;
            }
            
        }
    }
    @Override
    public void moverIzquierda(double d){
        if (isEnMarcha() == true){
            setLocalizacionX(-d);
            if (getnPasajeros()>0){
                distanciaRecorrida = distanciaRecorrida + d;
            }
        }
    }
    @Override
    public  void moverArriba(double d){
        if (isEnMarcha() == true){
            setLocalizacionY(d);
            if (getnPasajeros()>0){
                distanciaRecorrida = distanciaRecorrida + d;
            }
            
            
        }
        
    }
    @Override
    public void moverAbajo(double d){
        if (isEnMarcha() == true){
            setLocalizacionY(-d);
            if (getnPasajeros()>0){
                distanciaRecorrida = distanciaRecorrida + d;
            }
             
        }
        
    }
    public void gestionarSeguros(){
         if (isEnMarcha() == false){
             if (segurosActivados == true){
                 segurosActivados = false;
             } else {
                 segurosActivados = true;
                  
             }
         }
    }
        
    //Inserte acá los SETTERS Y GETTERS
    public double getDistanciaRecorrida(){
        return  distanciaRecorrida;
    }
    public boolean isSegurosActivados(){
        return segurosActivados;
    }
    
    
}
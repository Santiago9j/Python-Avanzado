/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Torres
 */
public class Nacionalidad {
    private int id_nacionaliad;
    private String descripcion;

    public Nacionalidad() {
    }

    public Nacionalidad(int id_nacionaliad, String descripcion) {
        this.id_nacionaliad = id_nacionaliad;
        this.descripcion = descripcion;
    }

    public int getId_nacionaliad() {
        return id_nacionaliad;
    }

    public void setId_nacionaliad(int id_nacionaliad) {
        this.id_nacionaliad = id_nacionaliad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

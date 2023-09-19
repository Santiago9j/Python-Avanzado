/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Torres
 */
public class Eps {
    private int id_eps;
    private String descripcion;

    public Eps() {
    }

    public Eps(int id_eps, String descripcion) {
        this.id_eps = id_eps;
        this.descripcion = descripcion;
    }

    public int getId_eps() {
        return id_eps;
    }

    public void setId_eps(int id_eps) {
        this.id_eps = id_eps;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Torres
 */
public class Cargo {
    private int id_Cargo;
    private String descripcion;

    public Cargo() {
    }

    public Cargo(int id_Cargo, String descripcion) {
        this.id_Cargo = id_Cargo;
        this.descripcion = descripcion;
    }

    public int getId_Cargo() {
        return id_Cargo;
    }

    public void setId_Cargo(int id_Cargo) {
        this.id_Cargo = id_Cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Cargo{" + "id_Cargo=" + id_Cargo + ", descripcion=" + descripcion + '}';
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Torres
 */
public class Empleado {
    
    private int id;
    private String identificacion;
    private String primer_nombre;
    private String segundo_nombre = "";
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono = "";
    private String celular;
    private String direccion;
    private String fecha_nacimiento;
    private double salario;
    private String fecha_ingreso;
    private String genero = "";
    private String cargo;
    private String sucursal;
    private String nacionalidad;
    private String eps;
    private String tipo_documento;

    public Empleado() {
    }

    public Empleado(int id, String identificacion, String primer_nombre, String primer_apellido, String segundo_apellido, String celular, String direccion, String fecha_nacimiento, double salario, String fecha_ingreso, String cargo, String sucursal, String nacionalidad, String eps, String tipo_documento) {
        this.id = id;
        this.identificacion = identificacion;
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.celular = celular;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
        this.fecha_ingreso = fecha_ingreso;
        this.cargo = cargo;
        this.sucursal = sucursal;
        this.nacionalidad = nacionalidad;
        this.eps = eps;
        this.tipo_documento = tipo_documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", identificacion=" + identificacion + ", primer_nombre=" + primer_nombre + ", segundo_nombre=" + segundo_nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido + ", telefono=" + telefono + ", celular=" + celular + ", direccion=" + direccion + ", fecha_nacimiento=" + fecha_nacimiento + ", salario=" + salario + ", fecha_ingreso=" + fecha_ingreso + ", genero=" + genero + ", cargo=" + cargo + ", sucursal=" + sucursal + ", nacionalidad=" + nacionalidad + ", eps=" + eps + ", tipo_documento=" + tipo_documento + '}';
    }

    
    
    
    
    
}

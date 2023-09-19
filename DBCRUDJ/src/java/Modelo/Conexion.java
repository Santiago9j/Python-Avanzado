/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Torres
 */
public class Conexion {
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    // USUARIO Y CONTRASEÑA DEL USUARIO CREADO EN ORACLE
    String user = "DBCRUD";
    String pass = "1234";
    
    //VARIABLE IMPORTANTE PARA COMUNICARSE CON LA BASE DE DATOS
    Connection con; 
    Statement st; 
    ResultSet rs; 
    PreparedStatement ps; 
    
    //ID
    int idSigUser = 0;
    
    //CONECTARME CON LA BASE DE DATOS
    
    public void Conectar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Se conecto con la base de datos");
            } catch (SQLException ex) {
                System.out.println("No se conecto con la base de datos.");
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Sucedió un error al conectarnos con la base de datos.");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // LISTAR TODOS LOS EMPLEADOS QUE TENEMOS EN LA BASE DE DATOS.
    public ArrayList listar_empleados() throws SQLException {
        ArrayList<Empleado> lista = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT EMP.ID_EMPLEADO, EMP.IDENTIFICACION, EMP.PRIMER_NOMBRE, EMP.SEGUNDO_NOMBRE, EMP.PRIMER_APELLIDO, EMP.SEGUNDO_APELLIDO, EMP.TELEFONO_FIJO, EMP.CELULAR, EMP.DIRECCION, TO_CHAR(EMP.FECHA_NACIMIENTO, 'yyyy/MM/dd'), EMP.SALARIO,TO_CHAR(EMP.FECHA_INGRESO, 'yyyy/MM/dd'), EMP.GENERO, CA.DESCRIPCION, SU.NOMBRE, NAC.NOMBRE, EP.NOMBRE, TIDO.NOMBRE " +
"FROM EMPLEADO EMP INNER JOIN CARGO CA ON EMP.ID_CARGO = CA.ID_CARGO " +
"INNER JOIN SUCURSAL SU ON EMP.ID_SUCURSAL = SU.ID_SUCURSAL " +
"INNER JOIN NACIONALIDAD NAC ON EMP.ID_NACIONALIDAD = NAC.ID_NACIONALIDAD " +
"INNER JOIN EPS EP ON EMP.ID_EPS = EP.ID_EPS " +
"INNER JOIN TIPO_DOCUMENTO TIDO ON EMP.ID_TIPO_DOCUMENTO = TIDO.ID_TIPO_DOCUMENTO ORDER BY EMP.ID_EMPLEADO";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
            Empleado empleado = new Empleado();
                empleado.setId(rs.getInt(1));
                idSigUser = rs.getInt(1);
                empleado.setIdentificacion(rs.getString(2));
                empleado.setPrimer_nombre(rs.getString(3));
                empleado.setSegundo_nombre(rs.getString(4));
                empleado.setPrimer_apellido(rs.getString(5));
                empleado.setSegundo_apellido(rs.getString(6));
                empleado.setTelefono(rs.getString(7));
                empleado.setCelular(rs.getString(8));
                empleado.setDireccion(rs.getString(9));
                empleado.setFecha_nacimiento(rs.getString(10));
                empleado.setSalario(rs.getDouble(11));
                empleado.setFecha_ingreso(rs.getString(12));
                empleado.setGenero(rs.getString(13));
                empleado.setCargo(rs.getString(14));
                empleado.setSucursal(rs.getString(15));
                empleado.setNacionalidad(rs.getString(16));
                empleado.setEps(rs.getString(17));
                empleado.setTipo_documento(rs.getString(18));
                lista.add(empleado);
        }
        return lista;
    }
    
    
    // LISTAR TODOS LOS CARGOS QUE TENEMOS EN LA BASE DE DATOS.
    public ArrayList listar_cargos() throws SQLException {
        ArrayList<Cargo> cargos = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT * FROM CARGO";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId_Cargo(rs.getInt(1));
                cargo.setDescripcion(rs.getString(2));
                cargos.add(cargo);
        }
        return cargos;
    }
    
    // LISTAR TODAS LAS SUCURSALES QUE TENEMOS EN LA BASE DE DATOS.
    public ArrayList listar_sucursales() throws SQLException {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT * FROM SUCURSAL";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(rs.getInt(1));
                sucursal.setDescripcion(rs.getString(2));
                sucursales.add(sucursal);
        }
        return sucursales;
    }
    
    // LISTAR TODAS LAS NACIONALIDADES QUE TENEMOS EN LA BASE DE DATOS.
    public ArrayList listar_nacionalidades() throws SQLException {
        ArrayList<Nacionalidad> nacionalidades = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT * FROM NACIONALIDAD";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
                Nacionalidad nacionalidad = new Nacionalidad();
                nacionalidad.setId_nacionaliad(rs.getInt(1));
                nacionalidad.setDescripcion(rs.getString(2));
                nacionalidades.add(nacionalidad);
        }
        return nacionalidades;
    }
    
    // LISTAR TODAS LAS NACIONALIDADES QUE TENEMOS EN LA BASE DE DATOS.
    public ArrayList listar_eps() throws SQLException {
        ArrayList<Eps> epss = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT * FROM EPS";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
                Eps eps = new Eps();
                eps.setId_eps(rs.getInt(1));
                eps.setDescripcion(rs.getString(2));
                epss.add(eps);
        }
        return epss;
    }
    
    // LISTAR TODOS LOS TIPO DE DOCUMENTOS QUE TENEMOS EN LA BASE DE DATOS.
    public ArrayList listar_tipos_documentos() throws SQLException {
        ArrayList<Tipo_documento> tipos_documentos = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT * FROM TIPO_DOCUMENTO";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
                Tipo_documento td = new Tipo_documento();
                td.setId_tipo_documento(rs.getInt(1));
                td.setDescripcion(rs.getString(2));
                tipos_documentos.add(td);
        }
        return tipos_documentos;
    }
    
    
    //AGREGAR UN EMPLEADO
    public int agregar(EmpleadoInsertar p){
        int r = 0;
        String sql = "INSERT INTO EMPLEADO VALUES (?,?,?,?,?,?,?,?,?,TO_DATE(?,'yyyy/MM/dd'),?,TO_DATE(?,'yyyy/MM/dd'),?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getIdentificacion());
            ps.setString(3, p.getPrimer_nombre());
            ps.setString(4, p.getSegundo_nombre());
            ps.setString(5, p.getPrimer_apellido());
            ps.setString(6, p.getSegundo_apellido());
            ps.setString(7, p.getTelefono());
            ps.setString(8, p.getCelular());
            ps.setString(9, p.getDireccion());
            ps.setString(10, p.getFecha_nacimiento());
            ps.setDouble(11, p.getSalario());
            ps.setString(12, p.getFecha_ingreso());
            ps.setString(13, p.getGenero());
            ps.setInt(14, p.getCargo());
            ps.setInt(15, p.getSucursal());
            ps.setInt(16, p.getNacionalidad());
            ps.setInt(17, p.getEps());
            ps.setInt(18, p.getTipo_documento());
            r = ps.executeUpdate(); //Ejecuta la consulta.
            if (r==1){
                r=1;
            } else{
                r = 0;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Ha sucedido un error al insertar un articulo.");
        }
        return r;
    }
    
    //VERIFICAR SI UN EMPLEADO YA EXISTE EN LA DB POR ID O POR IDENTIFICACION.
    public int verificar_empleado(int id, String identificacion) throws SQLException {
        int res = 0;
        st = con.createStatement();
        String consulta = "SELECT * FROM EMPLEADO WHERE ID_EMPLEADO = "+id+" OR IDENTIFICACION = "+identificacion;
        rs = st.executeQuery(consulta);
        while (rs.next()) {
                res = 1;
        }
        return res;
    }
    
    // SELECCIONAR UN ARTICULO EN PARTICULAR
    
    public EmpleadoInsertar listarId(int id){
        String sql = "SELECT ID_EMPLEADO, IDENTIFICACION, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, TELEFONO_FIJO, CELULAR, DIRECCION, TO_CHAR(FECHA_NACIMIENTO, 'yyyy-MM-dd'), SALARIO,TO_CHAR(FECHA_INGRESO, 'yyyy-MM-dd'), GENERO, ID_CARGO, ID_SUCURSAL, ID_NACIONALIDAD, ID_EPS, ID_TIPO_DOCUMENTO FROM EMPLEADO WHERE ID_EMPLEADO="+id;
        EmpleadoInsertar empIns = new EmpleadoInsertar();
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                empIns.setId(rs.getInt(1));
                empIns.setIdentificacion(rs.getString(2));
                empIns.setPrimer_nombre(rs.getString(3));
                empIns.setSegundo_nombre(rs.getString(4));
                empIns.setPrimer_apellido(rs.getString(5));
                empIns.setSegundo_apellido(rs.getString(6));
                empIns.setTelefono(rs.getString(7));
                empIns.setCelular(rs.getString(8));
                empIns.setDireccion(rs.getString(9));
                empIns.setFecha_nacimiento(rs.getString(10));
                empIns.setSalario(rs.getDouble(11));
                empIns.setFecha_ingreso(rs.getString(12));
                empIns.setGenero(rs.getString(13));
                empIns.setCargo(rs.getInt(14));
                empIns.setSucursal(rs.getInt(15));
                empIns.setNacionalidad(rs.getInt(16));
                empIns.setEps(rs.getInt(17));
                empIns.setTipo_documento(rs.getInt(18));
                
            }
        } catch (Exception e){
            System.out.println("Error al buscar por id");
        }
        return empIns;
    }
    
    
    //MODIFICAR UN EMPLEADO
    
    public int actualizar (EmpleadoInsertar empleadoInsertar){
        int respuestAct;
        String sql = "UPDATE EMPLEADO SET IDENTIFICACION = ?, PRIMER_NOMBRE = ?, SEGUNDO_NOMBRE = ?, PRIMER_APELLIDO = ?, SEGUNDO_APELLIDO = ?, TELEFONO_FIJO = ?, CELULAR = ?, DIRECCION = ?, FECHA_NACIMIENTO = TO_DATE(?,'yyyy/MM/dd'), SALARIO = ?, FECHA_INGRESO = TO_DATE(?,'yyyy/MM/dd'), GENERO = ?, ID_CARGO = ?, ID_SUCURSAL = ?, ID_NACIONALIDAD = ?, ID_EPS = ?, ID_TIPO_DOCUMENTO = ? WHERE ID_EMPLEADO = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, empleadoInsertar.getIdentificacion());
            ps.setString(2, empleadoInsertar.getPrimer_nombre());
            ps.setString(3, empleadoInsertar.getSegundo_nombre());
            ps.setString(4, empleadoInsertar.getPrimer_apellido());
            ps.setString(5, empleadoInsertar.getSegundo_apellido());
            ps.setString(6, empleadoInsertar.getTelefono());
            ps.setString(7, empleadoInsertar.getCelular());
            ps.setString(8, empleadoInsertar.getDireccion());
            ps.setString(9, empleadoInsertar.getFecha_nacimiento());
            ps.setDouble(10, empleadoInsertar.getSalario());
            ps.setString(11, empleadoInsertar.getFecha_ingreso());
            ps.setString(12, empleadoInsertar.getGenero());
            ps.setInt(13, empleadoInsertar.getCargo());
            ps.setInt(14, empleadoInsertar.getSucursal());
            ps.setInt(15, empleadoInsertar.getNacionalidad());
            ps.setInt(16, empleadoInsertar.getEps());
            ps.setInt(17, empleadoInsertar.getTipo_documento());
            ps.setInt(18, empleadoInsertar.getId());
            System.out.println(empleadoInsertar.toString());
            ps.executeUpdate();
            respuestAct = 1;
            System.out.println("Todo salió bien.");
            
        }  catch(Exception e){
            System.out.println("Error al modificar el empleado.");
            respuestAct = 0;
        }
        return respuestAct;
    }
    
    //ELIMINAR UN EMPLEADO
    public int eliminar (int id){
        int res = 0;
        String sql = "DELETE FROM EMPLEADO WHERE ID_EMPLEADO="+id;
        try{
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            res = 1;
        }catch(Exception e){
            System.out.println("Error al eliminar el empleado de la BD.");
            System.out.println(e.toString());
            res = 0;
        }
        return res;
    }
    
    public ArrayList listar_usuarios_like(String buscartxt) throws SQLException {
        ArrayList<Empleado> lista = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT EMP.ID_EMPLEADO, EMP.IDENTIFICACION, EMP.PRIMER_NOMBRE, EMP.SEGUNDO_NOMBRE, EMP.PRIMER_APELLIDO, EMP.SEGUNDO_APELLIDO, EMP.TELEFONO_FIJO, EMP.CELULAR, EMP.DIRECCION, TO_CHAR(EMP.FECHA_NACIMIENTO, 'yyyy/MM/dd'), EMP.SALARIO,TO_CHAR(EMP.FECHA_INGRESO, 'yyyy/MM/dd'), EMP.GENERO, CA.DESCRIPCION, SU.NOMBRE, NAC.NOMBRE, EP.NOMBRE, TIDO.NOMBRE " +
"FROM EMPLEADO EMP INNER JOIN CARGO CA ON EMP.ID_CARGO = CA.ID_CARGO " +
"INNER JOIN SUCURSAL SU ON EMP.ID_SUCURSAL = SU.ID_SUCURSAL " +
"INNER JOIN NACIONALIDAD NAC ON EMP.ID_NACIONALIDAD = NAC.ID_NACIONALIDAD " +
"INNER JOIN EPS EP ON EMP.ID_EPS = EP.ID_EPS " +
"INNER JOIN TIPO_DOCUMENTO TIDO ON EMP.ID_TIPO_DOCUMENTO = TIDO.ID_TIPO_DOCUMENTO WHERE EMP.PRIMER_NOMBRE LIKE '%"+buscartxt+"%' OR EMP.IDENTIFICACION LIKE '%"+buscartxt+"%' ORDER BY EMP.ID_EMPLEADO";
        System.out.println("Antes de la consulta");
        rs = st.executeQuery(consulta);
        System.out.println("Después de la consulta.");
        while (rs.next()) {
            Empleado emp = new Empleado();
                emp.setId(rs.getInt(1));
                emp.setIdentificacion(rs.getString(2));
                emp.setPrimer_nombre(rs.getString(3));
                emp.setSegundo_nombre(rs.getString(4));
                emp.setPrimer_apellido(rs.getString(5));
                emp.setSegundo_apellido(rs.getString(6));
                emp.setTelefono(rs.getString(7));
                emp.setCelular(rs.getString(8));
                emp.setDireccion(rs.getString(9));
                emp.setFecha_nacimiento(rs.getString(10));
                emp.setSalario(rs.getDouble(11));
                emp.setFecha_ingreso(rs.getString(12));
                emp.setGenero(rs.getString(13));
                emp.setCargo(rs.getString(14));
                emp.setSucursal(rs.getString(15));
                emp.setNacionalidad(rs.getString(16));
                emp.setEps(rs.getString(17));
                emp.setTipo_documento(rs.getString(18));
                lista.add(emp);
        }
        return lista;
    }
    
    // NUMERO DE EMPLEADOS QUE HAY EN LA BD.
    public int cantidad_empleado() {
        int cantEmp = 0;
        try {
            st = con.createStatement();
            String consulta = "SELECT COUNT(ID_EMPLEADO) FROM EMPLEADO";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                    cantEmp = rs.getInt(1);
            }
        } catch (Exception e){
            System.out.println("Error "+e.toString());
        }
        return cantEmp;
    }
    
    public int obtenerSigId(){
        int resp = idSigUser + 1;
        return resp;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cargo;
import Modelo.Conexion;
import Modelo.Empleado;
import Modelo.EmpleadoInsertar;
import Modelo.Eps;
import Modelo.Nacionalidad;
import Modelo.Sucursal;
import Modelo.Tipo_documento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago Torres
 */
public class Controlador extends HttpServlet {
    Conexion dao = new Conexion();
    Empleado emp = new Empleado();
    EmpleadoInsertar empInser = new EmpleadoInsertar();
    int idElimGlobal = 0;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lo sentimos, ocurrió un error inesperado. Ingrese nuevamente a la página.</h1>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dao.Conectar();
        System.out.println("DO GET.");
        String accion = request.getParameter("accion");
        switch (accion){
            case "Listar":{
                try{
                    ArrayList<Empleado> datos = dao.listar_empleados();
                    int canTotEmpR = dao.cantidad_empleado();
                    request.setAttribute("cantTotEmp",canTotEmpR);
                    request.setAttribute("datos", datos);
                    request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
                    break;
                } catch (Exception e){
                    System.out.println("Error al listar los empleados.");
                }
            }case "Agregar un empleado":{
                try{
                    ArrayList<Cargo> cargos = dao.listar_cargos();
                    ArrayList<Sucursal> sucursales = dao.listar_sucursales();
                    ArrayList<Nacionalidad> nacionalidades = dao.listar_nacionalidades();
                    ArrayList<Eps> epss = dao.listar_eps();
                    ArrayList<Tipo_documento> tipos_documentos = dao.listar_tipos_documentos();
                    int idSigUser = dao.obtenerSigId();
                    request.setAttribute("dCargo", cargos);
                    request.setAttribute("dSucursal", sucursales);
                    request.setAttribute("dNacionalidad", nacionalidades);
                    request.setAttribute("dEps", epss);
                    request.setAttribute("dTipoDocumento", tipos_documentos);
                    request.setAttribute("dSigIdUsuario", idSigUser);
                    request.getRequestDispatcher("crearEmpleado.jsp").forward(request, response);
                    break;
                } catch (Exception e){
                    System.out.println("Error al listar los registros de la base de datosj.");
                }
            }case "Agregar":{
                String id = request.getParameter("tid");
                String identificacion = request.getParameter("tidentificacion");
                String primer_nombre = request.getParameter("tprimernombre");
                String segundo_nombre = request.getParameter("tsegundonombre");
                String primer_apellido = request.getParameter("tprimerapellido");
                String segundo_apellido = request.getParameter("tsegundoapellido");
                String telefono = request.getParameter("ttelefono");
                String celular = request.getParameter("tcelular");
                String direccion = request.getParameter("tdireccion");
                String fecha_nacimiento = request.getParameter("tfechanacimiento");
                String salario = request.getParameter("tsalario");
                String fecha_ingreso = request.getParameter("tfechaingreso");
                String genero = request.getParameter("tgenero");
                String cargo = request.getParameter("tcargo");
                String sucursal = request.getParameter("tsucursal");
                String nacionalidad = request.getParameter("tnacionalidad");
                String eps = request.getParameter("teps");
                String tipo_documento = request.getParameter("ttipodocumento");
                
                empInser.setId(Integer.parseInt(id));
                empInser.setIdentificacion(identificacion);
                empInser.setPrimer_nombre(primer_nombre);
                empInser.setSegundo_nombre(segundo_nombre);
                empInser.setPrimer_apellido(primer_apellido);
                empInser.setSegundo_apellido(segundo_apellido);
                empInser.setTelefono(telefono);
                empInser.setCelular(celular);
                empInser.setDireccion(direccion);
                empInser.setFecha_nacimiento(fecha_nacimiento);
                empInser.setSalario(Double.parseDouble(salario));
                empInser.setFecha_ingreso(fecha_ingreso); 
                empInser.setGenero(genero);
                empInser.setCargo(Integer.parseInt(cargo));
                empInser.setSucursal(Integer.parseInt(sucursal));
                empInser.setNacionalidad(Integer.parseInt(nacionalidad));
                empInser.setEps(Integer.parseInt(eps));
                empInser.setTipo_documento(Integer.parseInt(tipo_documento));
                try {
                    int respuesta = dao.verificar_empleado(Integer.parseInt(id), identificacion);
                    if (respuesta == 1){
                        request.setAttribute("msg", "errorInsertEmp");
                    } else{
                        if (respuesta == 0){
                            int respuestaDos = dao.agregar(empInser);
                            if (respuestaDos == 1){
                                request.setAttribute("msg", "agregarEmp");
                            } else{
                                request.setAttribute("msg", "errorAlInsertarBD");
                            }
                        }
                    }
                } catch (Exception e){
                    request.setAttribute("msg", "errorAlInsertarBD");
                }
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);  
                
                break;
            }case "Editar":{
                try{
                    String id = request.getParameter("idU");
                    empInser = dao.listarId(Integer.parseInt(id));
                    ArrayList<Cargo> cargos = dao.listar_cargos();
                    ArrayList<Sucursal> sucursales = dao.listar_sucursales();
                    ArrayList<Nacionalidad> nacionalidades = dao.listar_nacionalidades();
                    ArrayList<Eps> epss = dao.listar_eps();
                    ArrayList<Tipo_documento> tipos_documentos = dao.listar_tipos_documentos();
                    request.setAttribute("dCargo", cargos);
                    request.setAttribute("dSucursal", sucursales);
                    request.setAttribute("dNacionalidad", nacionalidades);
                    request.setAttribute("dEps", epss);
                    request.setAttribute("dTipoDocumento", tipos_documentos);
                    request.setAttribute("datosPerson", empInser);
                    request.getRequestDispatcher("editEmp.jsp").forward(request, response);
                    break;
                }  catch (Exception e){
                    System.out.println("Error al editar los campos.");
                }
            } case "Guardar Cambios":{
                String idEdit = request.getParameter("tid");
                String identificacionEdit = request.getParameter("tidentificacion");
                String primer_nombreEdit = request.getParameter("tprimernombre");
                String segundo_nombreEdit = request.getParameter("tsegundonombre");
                String primer_apellidoEdit = request.getParameter("tprimerapellido");
                String segundo_apellidoEdit = request.getParameter("tsegundoapellido");
                String telefonoEdit = request.getParameter("ttelefono");
                String celularEdit = request.getParameter("tcelular");
                String direccionEdit = request.getParameter("tdireccion");
                String fecha_nacimientoEdit = request.getParameter("tfechanacimiento");
                String salarioEdit = request.getParameter("tsalario");
                String fecha_ingresoEdit = request.getParameter("tfechaingreso");
                String generoEdit = request.getParameter("tgenero");
                String cargoEdit = request.getParameter("tcargo");
                String sucursalEdit = request.getParameter("tsucursal");
                String nacionalidadEdit = request.getParameter("tnacionalidad");
                String epsEdit = request.getParameter("teps");
                String tipo_documentoEdit = request.getParameter("ttipodocumento");
                
                empInser.setId(Integer.parseInt(idEdit));
                empInser.setIdentificacion(identificacionEdit);
                empInser.setPrimer_nombre(primer_nombreEdit);
                empInser.setSegundo_nombre(segundo_nombreEdit);
                empInser.setPrimer_apellido(primer_apellidoEdit);
                empInser.setSegundo_apellido(segundo_apellidoEdit);
                empInser.setTelefono(telefonoEdit);
                empInser.setCelular(celularEdit);
                empInser.setDireccion(direccionEdit);
                empInser.setFecha_nacimiento(fecha_nacimientoEdit);
                empInser.setSalario(Double.parseDouble(salarioEdit));
                empInser.setFecha_ingreso(fecha_ingresoEdit); 
                empInser.setGenero(generoEdit);
                empInser.setCargo(Integer.parseInt(cargoEdit));
                empInser.setSucursal(Integer.parseInt(sucursalEdit));
                empInser.setNacionalidad(Integer.parseInt(nacionalidadEdit));
                empInser.setEps(Integer.parseInt(epsEdit));
                empInser.setTipo_documento(Integer.parseInt(tipo_documentoEdit));
                try {
                    int respuestaDos = dao.actualizar(empInser);
                    if (respuestaDos == 1){
                        request.setAttribute("msg", "editEmp");
                    } else{
                        request.setAttribute("msg", "errorAlUpdateBD");
                    }
                } catch (Exception e){
                    request.setAttribute("msg", "errorAlUpdateBD");
                }
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);  
                break;
            }case "Eliminar":{
                String idElim = request.getParameter("idU");
                System.out.println("---> "+ idElim);
                idElimGlobal = Integer.parseInt(idElim);
                request.setAttribute("msg", "eliminarEmp");
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            } case "Buscar":{
                try{
                    String bus = request.getParameter("buscartxt");
                    ArrayList<EmpleadoInsertar> datos = dao.listar_usuarios_like(bus);
                    int canTotEmpR = dao.cantidad_empleado();
                    request.setAttribute("cantTotEmp",canTotEmpR);
                    request.setAttribute("datos", datos);
                    request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
                    //request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                    break;
                } catch (Exception e){
                    System.out.println("Error al buscar.");
                }
            }case "EliminarA":{
                int idElim = idElimGlobal;
                System.out.println("-->>>>> "+idElim);
                int res = dao.eliminar(idElim);
                if (res == 1){
                    request.setAttribute("msg", "eliminarEmpBD");
                } else{
                    request.setAttribute("msg", "errorAlDeleteBD");
                }
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            }default:{
                request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

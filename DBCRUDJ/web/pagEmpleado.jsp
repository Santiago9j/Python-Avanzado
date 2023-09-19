<%-- 
    Document   : pagEmpleado
    Created on : 9/12/2022, 10:37:21 AM
    Author     : Santiago Torres
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLEADOS</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="principal">
            <h1>GESTIONAR EMPLEADOS</h1>
            <div class="ensatoPP">
                <div class="general">
                    <form action="Controlador" method="GET">
                        <div class="buscarEstilos">
                            <input  class="jjUno" type="text" name="buscartxt" placeholder="Buscar registro por Primer Nombre o Identificación...">
                            <input class="jjDos" type="submit" name="accion" value="Buscar" >
                        </div>
                    </form>
                </div>
                <form action="Controlador" method="GET">
                    <input type="submit" value="Agregar un empleado" name="accion" class="botton">
                </form>
            </div>
            <div class="contenedorCont">
                <div class="contenedorSecundarioCont">
                    <h4>N° DE EMPLEADOS</h4>
                    <input type="number" readonly value="${cantTotEmp}" >
                </div>
            </div>
            <table class="dwr-table" width="100%" cellpadding="0" cellspacing="0" border="1" align="center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>IDENTIFICACION</th>
                        <th>PRIMER NOMBRE</th>
                        <th>SEGUNDO NOMBRE</th>
                        <th>PRIMER APELLIDO</th>
                        <th>SEGUNDO APELLIDO</th>
                        <th>TELEFONO</th>
                        <th>CELULAR</th>
                        <th>DIRECCION</th>
                        <th>FECHA DE NACIMIENTO</th>
                        <th>SALARIO</th>
                        <th>FECHA DE INGRESO</th>
                        <th>GENERO</th>
                        <th>CARGO</th>
                        <th>SUCURSAL</th>
                        <th>NACIONALIDAD</th>
                        <th>EPS</th>
                        <th>TIPO_DOCUMENTO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dato" items="${datos}">
                        <tr>
                            <td>${dato.getId()}</td>
                            <td>${dato.getIdentificacion()}</td>
                            <td>${dato.getPrimer_nombre()}</td>
                            <td>${dato.getSegundo_nombre()}</td>
                            <td>${dato.getPrimer_apellido()}</td>
                            <td>${dato.getSegundo_apellido()}</td>
                            <td>${dato.getTelefono()}</td>
                            <td>${dato.getCelular()}</td>
                            <td>${dato.getDireccion()}</td>
                            <td>${dato.getFecha_nacimiento()}</td>
                            <td>${dato.getSalario()}</td>
                            <td>${dato.getFecha_ingreso()}</td>
                            <td>${dato.getGenero()}</td>
                            <td>${dato.getCargo()}</td>
                            <td>${dato.getSucursal()}</td> 
                            <td>${dato.getNacionalidad()}</td>   
                            <td>${dato.getEps()}</td>
                            <td>${dato.getTipo_documento()}</td>
                            <td>
                                <form action="Controlador" method="GET">
                                    <input type="hidden" disabled="" id="jsProducto" value="${msg}">
                                    <input type="hidden" name="idU" value="${dato.getId()}">
                                    <input type="submit" name="accion" value="Editar" id="editar">
                                    <input type="submit" name="accion" value="Eliminar" id="eliminar">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    
                </tbody>

            </table>
            
        </div>
        
        
        
        <script>
            const empMsg = document.getElementById("jsProducto").value;
            if (empMsg === "agregarEmp") {
                swal({
                    title: "Listo...",
                    text: "El empleado se ha guardado con éxito",
                    icon: "success",
                    button: "Continuar"
                });
            } else{
                if (empMsg === "editEmp") {
                swal({
                    title: "Perfecto....",
                    text: "El empleado se ha modificado con éxito",
                    icon: "success",
                    button: "Continuar"
                });
                } else{
                    if (empMsg === "eliminarEmp") {
                        swal({
                            title: "Cuidado....",
                            text: "¿Estás Seguro de eliminar el registro?",
                            icon: "warning",
                            buttons: true,
                            dangerMode: true
                        })
                                .then((willDelete) => {
                                    if (willDelete) {
                                        window.location.replace("Controlador?accion=EliminarA");
                                    } else {
                                        window.location.replace("Controlador?accion=Listar");
                                    }
                                });
                    } else {
                        if (empMsg === "eliminarEmpBD") {
                            swal({
                                title: "Okey...",
                                text: "El empleado se ha eliminado de la base de datos.",
                                icon: "success",
                                button: "Continuar"
                            });
                        } else{
                            if (empMsg === "errorInsertEmp") {
                                swal({
                                    title: "Ooops...",
                                    text: "El id o identificación ingresado ya existe en la base de datos",
                                    icon: "error",
                                    button: "Continuar"
                                });
                            } else{
                                if (empMsg === "errorAlInsertarBD") {
                                    swal({
                                        title: "Lo sentimos...",
                                        text: "Algo salió mal. No se insertó el registro.",
                                        icon: "error",
                                        button: "Continuar"
                                    });
                                } else {
                                    if (empMsg === "errorAlUpdateBD") {
                                        swal({
                                            title: "Ooops...",
                                            text: "Algo salió mal. No se actualizó el registro.",
                                            icon: "error",
                                            button: "Continuar"
                                        });
                                    } else{
                                        if (empMsg === "errorAlDeleteBD") {
                                            swal({
                                                title: "Ooops...",
                                                text: "Algo salió mal. No se eliminó el registro.",
                                                icon: "error",
                                                button: "Continuar"
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        </script>
        
        <script defer src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>
</html>
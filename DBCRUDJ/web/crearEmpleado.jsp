<%-- 
    Document   : crearEmpleado
    Created on : 9/12/2022, 02:20:54 PM
    Author     : Santiago Torres
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREAR EMPLEADO</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="crearEmp.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        
    </head>
    <body>
        <div>
            <div class="products-preview"> 
                <div class="preview">
                    <form action="Controlador" method="GET">
                        <label>
                            <i class='far fa-times-circle'></i>  
                            <input type="submit" name="accion" value="Listar" id='botonTrans'>
                        </label>
                    </form>
                    <div>
                        <h1>Crear un empleado</h1>
                        <form action='Controlador' method='GET'>
                            <div class="formGeneral">
                                <div class="formatInputForm">
                                    <label>
                                        ID <span>*</span>
                                        <input type='number' placeholder='Id' required id='nombre' name='tid' min="1" value="${dSigIdUsuario}" readonly>
                                    </label>
                                </div>  
                                <div class="formatInputForm">
                                    <label>
                                        Identificación <span>*</span>
                                        <input type='text' maxlength="20" placeholder='Identificación' required id='nombre' name='tidentificacion'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Primer Nombre <span>*</span>
                                        <input type='text' maxlength="30" placeholder='Primer Nombre' required id='nombre' name='tprimernombre'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Segundo Nombre
                                        <input type='text' maxlength="30" placeholder='Segundo Nombre'  id='nombre' name='tsegundonombre'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Primer Apellido <span>*</span>
                                        <input type='text' maxlength="40" placeholder='Primer Apellido' required id='nombre' name='tprimerapellido'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Segundo Apellido <span>*</span>
                                        <input type='text' maxlength="40" placeholder='Segundo Apellido' required id='nombre' name='tsegundoapellido'>
                                    </label>
                                </div> 
                                <div class="formatInputForm">
                                    <label>
                                        Telefono
                                        <input type='text' maxlength="12" placeholder='Telefono'  id='nombre' name='ttelefono'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Celular <span>*</span>
                                        <input type='text' maxlength="15" placeholder='Celular' required id='nombre' name='tcelular'>
                                    </label>
                                </div> 
                                <div class="formatInputForm">
                                    <label>
                                        Dirección <span>*</span>
                                        <input type='text' maxlength="60" placeholder='Dirección' required id='nombre' name='tdireccion'>
                                    </label>
                                </div> 
                                <div class="formatInputForm">
                                    <label>
                                        Fecha de nacimiento <span>*</span>
                                        <input type='date' max='2022-12-09' placeholder='Fecha - Nacimiento' required  id="limFecha" class="nombreDos" name='tfechanacimiento'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Salario <span>*</span>
                                        <input type='number' max="999.9999" min="1" step=".0001"  placeholder='Salario' required id='nombre' name='tsalario'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Fecha de Ingreso <span>*</span>
                                        <input type='date' placeholder='Fecha Ingreso' required id='nombre' name='tfechaingreso'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Genero 
                                        <input type='text' maxlength="20" placeholder='Genero' id='nombre' name='tgenero'>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Cargo <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='tcargo' required>
                                            <option value="" disabled selected>Seleccione una opcion</option>
                                            <c:forEach var="car"  items="${dCargo}">
                                                <option value="${car.getId_Cargo()}">${car.getDescripcion()}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Sucursal <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='tsucursal' required>
                                            <option value="" disabled selected>Seleccione una opcion</option>
                                            <c:forEach var="suc"  items="${dSucursal}">
                                                <option value="${suc.getId_sucursal()}">${suc.getDescripcion()}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Nacionalidad <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='tnacionalidad' required>
                                            <option value="" disabled selected>Seleccione una opcion</option>
                                            <c:forEach var="nac"  items="${dNacionalidad}">
                                                <option value="${nac.getId_nacionaliad()}">${nac.getDescripcion()}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        EPS <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='teps' required>
                                            <option value="" disabled selected>Seleccione una opcion</option>
                                            <c:forEach var="eps"  items="${dEps}">
                                                <option value="${eps.getId_eps()}">${eps.getDescripcion()}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Tipo Documento <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='ttipodocumento' required>
                                            <option value="" disabled selected>Seleccione una opcion</option>
                                            <c:forEach var="td"  items="${dTipoDocumento}">
                                                <option value="${td.getId_tipo_documento()}">${td.getDescripcion()}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                            </div>
                            
                            <h4>Todos los campos con <span>*</span> son obligatorios</h4>
                            <input type='submit' name='accion' value='Agregar' id='boton'>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="funciones.js" type="text/javascript"></script>
        
    </body>
</html>
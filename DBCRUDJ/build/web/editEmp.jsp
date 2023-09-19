<%-- 
    Document   : editEmp
    Created on : 10/12/2022, 09:32:51 AM
    Author     : Santiago Torres
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR EMPLEADO</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="crearEmp.css" rel="stylesheet" type="text/css"/>
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
                        
                        
                        
                        <form action='Controlador' method='GET'>
                            <h1>Editar a ${datosPerson.getPrimer_nombre()}</h1>
                            <div class="formGeneral">
                                <div class="formatInputForm">
                                    <label>
                                        ID <span>*</span>
                                        <input type='number' placeholder='Id' required id='nombre' name='tid' min="1" readonly value="${datosPerson.getId()}">
                                    </label>
                                </div>  
                                <div class="formatInputForm">
                                    <label>
                                        Identificación <span>*</span>
                                        <input type='text' maxlength="20" placeholder='Identificación' required id='nombre' name='tidentificacion' value="${datosPerson.getIdentificacion()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Primer Nombre <span>*</span>
                                        <input type='text' maxlength="30" placeholder='Primer Nombre' required id='nombre' name='tprimernombre' value="${datosPerson.getPrimer_nombre()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Segundo Nombre
                                        <input type='text' maxlength="30" placeholder='Segundo Nombre'  id='nombre' name='tsegundonombre' value="${datosPerson.getSegundo_nombre()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Primer Apellido <span>*</span>
                                        <input type='text' maxlength="40" placeholder='Primer Apellido' required id='nombre' name='tprimerapellido' value="${datosPerson.getPrimer_apellido()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Segundo Apellido <span>*</span>
                                        <input type='text' maxlength="40" placeholder='Segundo Apellido' required id='nombre' name='tsegundoapellido' value="${datosPerson.getSegundo_apellido()}">
                                    </label>
                                </div> 
                                <div class="formatInputForm">
                                    <label>
                                        Telefono
                                        <input type='text' maxlength="12" placeholder='Telefono'  id='nombre' name='ttelefono' value="${datosPerson.getTelefono()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Celular <span>*</span>
                                        <input type='text' maxlength="15" placeholder='Celular' required id='nombre' name='tcelular' value="${datosPerson.getCelular()}">
                                    </label>
                                </div> 
                                <div class="formatInputForm">
                                    <label>
                                        Dirección <span>*</span>
                                        <input type='text' maxlength="60" placeholder='Dirección' required id='nombre' name='tdireccion' value="${datosPerson.getDireccion()}">
                                    </label>
                                </div> 
                                <div class="formatInputForm">
                                    <label>
                                        Fecha de nacimiento <span>*</span>
                                        <input type='date' max='2022-12-09' placeholder='Fecha - Nacimiento' required  id="limFecha" class="nombreDos" name='tfechanacimiento' value="${datosPerson.getFecha_nacimiento()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Salario <span>*</span>
                                        <input type='number' max="999.9999" min="1" step=".0001"  placeholder='Salario' required id='nombre' name='tsalario' value="${datosPerson.getSalario()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Fecha de Ingreso <span>*</span>
                                        <input type='date' placeholder='Fecha Ingreso' required id='nombre' name='tfechaingreso' value="${datosPerson.getFecha_ingreso()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Genero 
                                        <input type='text' maxlength="20" placeholder='Genero' id='nombre' name='tgenero' value="${datosPerson.getGenero()}">
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Cargo <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='tcargo' required >
                                            <c:forEach var="car"  items="${dCargo}">
                                                <c:choose>
                                                    <c:when test="${car.getId_Cargo() == datosPerson.getCargo()}">
                                                        <option selected value="${car.getId_Cargo()}">${car.getDescripcion()}</option>
                                                    </c:when>    
                                                    <c:otherwise>
                                                        <option value="${car.getId_Cargo()}">${car.getDescripcion()}</option> 
                                                    </c:otherwise>
                                                </c:choose>  
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Sucursal <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='tsucursal' required >
                                            <c:forEach var="suc"  items="${dSucursal}">
                                                <c:choose>
                                                    <c:when test="${suc.getId_sucursal() == datosPerson.getSucursal()}">
                                                        <option selected value="${suc.getId_sucursal()}">${suc.getDescripcion()}</option>
                                                    </c:when>    
                                                    <c:otherwise>
                                                        <option value="${suc.getId_sucursal()}">${suc.getDescripcion()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Nacionalidad <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='tnacionalidad' required >
                                            <c:forEach var="nac"  items="${dNacionalidad}">
                                                <c:choose>
                                                    <c:when test="${nac.getId_nacionaliad() == datosPerson.getNacionalidad()}">
                                                        <option selected value="${nac.getId_nacionaliad()}">${nac.getDescripcion()}</option>
                                                    </c:when>    
                                                    <c:otherwise>
                                                        <option value="${nac.getId_nacionaliad()}">${nac.getDescripcion()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        EPS <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='teps' required>
                                            <c:forEach var="eps"  items="${dEps}">
                                                <c:choose>
                                                    <c:when test="${eps.getId_eps() == datosPerson.getEps()}">
                                                        <option selected value="${eps.getId_eps()}">${eps.getDescripcion()}</option>
                                                    </c:when>    
                                                    <c:otherwise>
                                                        <option value="${eps.getId_eps()}">${eps.getDescripcion()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                                <div class="formatInputForm">
                                    <label>
                                        Tipo Documento <span>*</span>
                                        <select class="cmbColumn"  onchange="ShowSelected();" name='ttipodocumento' required>
                                            <c:forEach var="td"  items="${dTipoDocumento}">
                                                <c:choose>
                                                    <c:when test="${td.getId_tipo_documento() == datosPerson.getTipo_documento()}">
                                                        <option selected value="${td.getId_tipo_documento()}">${td.getDescripcion()}</option>
                                                    </c:when>    
                                                    <c:otherwise>
                                                        <option value="${td.getId_tipo_documento()}">${td.getDescripcion()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>
                            </div>
                            
                            <h4>Todos los campos con <span>*</span> son obligatorios</h4>
                            <input type='submit' name='accion' value='Guardar Cambios' id='boton'>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="funciones.js" type="text/javascript"></script>                            
    </body>
</html>

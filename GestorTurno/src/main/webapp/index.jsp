<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hab.logica.Ciudadano"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Ciudadanos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  
    </head>
    <body>

        <div class="mt-5 text-center">

            <a href="CargarDatosSv" class="btn btn-primary btn-lg">Registrar Turno</a>
            <a href="ModificarTurnoSv" class="btn btn-primary btn-lg">ModificarTurnos</a>
            <a href="ListarTurnosSv" class="btn btn-primary btn-lg">ListarTurnos</a>
            
        </div>
        <div class="container mt-4">
            <h1>Formulario alta de ciudadanos</h1>
            <form action="CiudadanoSv" method="POST" accept-charset="UTF-8">



                <div class="form-group">
                    <label for="nombre">Nombre:</label> 
                    <input type="text" class="form-control" id="nombre" name="nombre">
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido:</label> 
                    <input type="text" class="form-control" id="apellido" name="apellido"> 
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" class="form-control" id="telefono" name="telefono"> 
                </div>
                <div class="form-group">
                    <label for="curp">CURP:</label>
                    <input type="text" class="form-control" id="curp" name="curp"> 
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

            <!--Búsqueda-->
            <h1 class="mt-4">Búsqueda</h1>
            <form action="CiudadanoSv" method="GET">
                <div class="form-group">
                    <label for="busquedaApellido">Buscar por apellido:</label>
                    <input type="text" class="form-control" id="busquedaApellido" name="busquedaApellido">
                </div>
                <button type="submit" class="btn btn-primary">Buscar</button>
            </form>

            <!--Resultados de la Búsqueda-->
            <div class="results-table mt-4"> 
                <h3 >Resultados</h3>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Teléfono</th>
                            <th>CURP</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            //trae lista de Ciudadanos
                            List<Ciudadano> listaCiudadanos = (List) request.getSession().getAttribute("listaCiudadanos");
                            if (listaCiudadanos != null) {

                                for (Ciudadano ciud : listaCiudadanos) {%>

                        <tr>
                            <td><%=ciud.getNombre()%></td>
                            <td><%=ciud.getApellido()%></td>
                            <td><%=ciud.getTelefono()%></td>
                            <td><%=ciud.getCurp()%></td>
                            <td style="display: flex; width: 230px">
                                <form name="eliminar" action="EliminarCiudadanoSv" method="POST"> <!-- manda el código al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                        <i class="fas fa-trash-alt"></i>Eliminar</button>
                                    <input type="hidden" name="id_persona" value="<%=ciud.getId()%>"> <!-- manda el código al servlet -->
                                </form>

                                <form name="editar" action="EditarCiudadanoSv" method="GET"> <!-- manda el código al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                        <i class="fas fa-pencil-alt"></i>Editar</button>
                                    <input type="hidden" name="id_persona" value="<%=ciud.getId()%>"> <!-- manda el código al servlet -->
                                </form>

                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                    <%}%>

                </table>
            </div>      
        </div>
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>

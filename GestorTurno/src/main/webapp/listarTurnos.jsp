
<%@page import="java.util.List"%>
<%@page import="com.hab.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"> <%-- para que el navegador interprete y envíe los datos correctamente desde el formulario a la base de datos --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <body>

        <h1 class="text-center mt-5">Listar Turnos</h1>
        <div class="container mt-4">
            <form action="ListarTurnosSv" method="GET" class="form-inline d-flex justify-content-center align-items-center">
                <div class="form-group mr-2">
                    <label for="estadoTurno" class="mr-4">Estado del turno:</label>
                    <select class="form-control form-control-sm mr-4" id="estadoTurno" name="estadoTurno">
                        <option value="">Todos</option>
                        <option value="En espera">En espera</option>
                        <option value="Ya atendido">Ya atendido</option>
                    </select>


                    <div class="form-group mr-4">
                        <label for="fechaTurno" class="mr-4">Fecha del turno:</label>
                        <input type="date" id="fechaTurno" name="fechaTurno" class="form-control form-control-sm">
                    </div>


                    <button type="submit" class="btn btn-primary btn-sm">Filtrar turno</button>

                </div>
            </form>
        </div>

        <div class="container mt-5">
            <h2>Resultados de la búsqueda</h2>
            <table class="table table-bordered table-striped">
                <thead class="bg-primary text-white">
                    <tr>
                        <th># Turno</th>
                        <th>Fecha</th>
                        <th>Ciudadano</th>
                        <th>Tipo de trámite</th>
                        <th>Estado</th>
                        <th>Cambiar estado</th>

                    </tr>
                </thead>
                <tbody>
                    <%-- Los turnos se encuentran en una lista --%>
                    <%
                        List<Turno> turnos = (List<Turno>) request.getAttribute("listaTurnos");
                        if (turnos != null && !turnos.isEmpty()) {
                            for (Turno turno : turnos) {
                    %>  
                    <tr>
                        <td><%= turno.getId()%></td>
                        <td><%= turno.getFecha()%></td>
                        <td><%= turno.getCiudadano().getNombre()%> <%= turno.getCiudadano().getApellido()%></td>
                        <td><%= turno.getTipoTramite() != null ? turno.getTipoTramite().getNombre() : "Sin trámite"%></td>
                        <td><%= turno.getEstadoTurno() != null ? turno.getEstadoTurno().getNombre() : "Sin estado"%></td>
                        <td>
                            <% if ("En espera".equals(turno.getEstadoTurno().getNombre())) {%>
                            <form action="CambiarEstadoTurnoSv" method="POST">
                                <input type="hidden" name="idTurno" value="<%= turno.getId()%>">
                                <button type="submit" class="btn btn-success btn-sm">
                                    Marcar como Atendido
                                </button>
                            </form>
                            <% } else { %>
                            <span class="text-secondary">Atendido</span> <!-- Muestra un texto si ya está atendido -->
                            <% } %>
                        </td>
                    </tr>
                    <%
                        }

                    } else {
                    %>
                    <tr>
                        <<td colspan="5" class="text-center">No se encontraron resultados</td>
                    </tr>
                    <% }%>

                </tbody>
            </table>
        </div>



        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>   
    </body>
</html>

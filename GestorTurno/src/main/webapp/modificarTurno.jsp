
<%@page import="com.hab.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"> <%-- para que el navegador interprete y envíe los datos correctamente desde el formulario a la base de datos --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <body>
        
        
        
        <h1 class="text-center mt-5">Modificar Turnos</h1>
        <div class="container mt-5">
            <div class="container mt-5">
                <%
                    Turno turno = (Turno) request.getAttribute("turno");
                    if (turno == null) {
                %>

            </div>
            <form action="ModificarTurnoSv" method="POST" class="form-inline d-flex justify-content-center align-items-center">
                <div class="form-group mr-2">
                    <label for="turnoId" class="mr-4">Selecciona el turno a modificar:</label>
                    <select id="turnoId" name="turnoId" class="form-control form-control-sm mr-4" required>
                        <option value="1">1 - Juan Pérez (Trámite de Licencia de conducir)</option>
                        <option value="2">2 - Juana Montoya (Trámite de pasaporte)</option>
                        <option value="3">3 - Silvio Rodríguez (Renovación de pasaporte)</option>
                    </select>

                    <button type="submit" class="btn btn-primary btn-sm">Modificar turno</button>

                </div>
            </form>
            <% } else {%>
            <form action="GuardarTurnoSv" method="POST" class="mt-4">
                <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                <div class="form-group">
                    <label>Fecha del turno:</label>
                    <input type="date" name="fechaTurno" class="form-control" value="<%= turno.getFecha()%>" required>
                </div>

                <div class="form-group">
                    <label>Estado del turno:</label>
                    <select name="estadoTurno" class="form-control" required>
                        <option value="ESPERA" <%= turno.getEstadoTurno().getNombre().equals("ESPERA") ? "selected" : ""%>>En espera</option>
                        <option value="ATENDIDO" <%= turno.getEstadoTurno().getNombre().equals("ATENDIDO") ? "selected" : ""%>>Ya Atendido</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Ciudadano:</label>
                    <input type="text" class="form-control" value="<%= turno.getCiudadano().getNombre() + " " + turno.getCiudadano().getApellido()%>" >
                </div>    

                <div class="form-group">
                    <label>Tipo de trámite:</label>
                    <select name="tramiteId" class="form-control" required>
                        <option value="1" <%= turno.getTipoTramite().getId() == 1 ? "selected" : ""%>>Trámite de Licencia</option>
                        <option value="2" <%= turno.getTipoTramite().getId() == 2 ? "selected" : ""%>>Renovación de Licencia</option>
                        <option value="3" <%= turno.getTipoTramite().getId() == 3 ? "selected" : ""%>>Trámite de Pasaporte</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">Guardar cambios</button>
                <a href="modificarTurno.jsp" class="btn btn-secundary">Cancelar</a>
            </form>
            <% }%>      
        </div>


    </form>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>   
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.hab.logica.Ciudadano"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Ciudadanos</title>
        <!-- Estilo de la web -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  
    </head>
    <body>
        <h1>Editar Ciudadano</h1>
        <div class="container mt-4">
            <h1>Formulario modificación de ciudadanos</h1>
            <form action="EditarCiudadanoSv" method="POST" accept-charset="UTF-8">
                
                <% 
                    Ciudadano ciud = (Ciudadano) request.getSession().getAttribute("ciudadano_editar");
                    if (ciud == null) {
                        ciud = new Ciudadano(); // Prevenir errores si no hay datos en la sesión
                    }
                %>
                
                <div class="form-group">
                    <label for="nombre">Nombre:</label> 
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= ciud.getNombre() %>">
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido:</label> 
                    <input type="text" class="form-control" id="apellido" name="apellido" value="<%= ciud.getApellido() %>">
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" value="<%= ciud.getTelefono() %>">
                </div>
                <div class="form-group">
                    <label for="curp">CURP:</label>
                    <input type="text" class="form-control" id="curp" name="curp" value="<%= ciud.getCurp() %>">
                </div>

                <button type="submit" class="btn btn-primary">Modificar</button>
            </form>
        </div>
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
    </body>
</html>

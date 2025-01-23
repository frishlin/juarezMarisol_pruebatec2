<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"> <%-- para que el navegador interprete y envíe los datos correctamente desde el formulario a la base de datos --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <h1 class="text-center mt-5">Registrar Turnos</h1>
        <div class="container mt-5">
            <form action="RegistrarTurnosSv" method="POST">
                <div class="form-group">
                    <label>Fecha:</label>
                    <input type="date" name="fechaTurno" class=form-control" required>
                </div>
                <div class="form-group">
                    <label for="ciudadanoId">Ciudadano:</label>
                    <select id="ciudadanoId" name="ciudadanoId" class="form-control" required>
                        <option value="1">Juan Pérez</option>
                        <option value="2">Juana Montoya</option>
                        <option value="3">Silvio Rodríguez</option>
                    </select>
                </div>
                 <div class="form-group">
                    <label for="tipoTramite">Trámite a realizar:</label>
                    <select id="tramiteId" name="tramiteId" class="form-control" required>
                        <option value="1">Trámite de licencia de conducir</option>
                        <option value="2">Renovación de licencia de conducir</option>
                        <option value="3">Trámite de pasaporte</option>
                        <option value="4">Renovación de pasaporte</option>
                    </select>
                </div>
                
                <button type="submit" class="btn btn-primary">Registrar Turno</button>        
            </form>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>   
    </body>
</html>

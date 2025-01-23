<%-- NO OLVIDES BORRAR LOS COMENTARIOS INNECESARIOS --%>
<%-- --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"> <%-- para que el navegador interprete y envíe los datos correctamente desde el formulario a la base de datos --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor de Turnos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <body>

        <div class="container mt-5">
            <h1>Gestor de Turnos</h1>
            <p>¡Te doy la más cordial bienvenida al Sistema de Gestión de Turnos!</p>
            <p>Haz clic en alguna de las opciones para continuar: </p>

            <div class="mb-4">
                <a href="views/registrarTurno.jsp" class="btn btn-primary btn-lg">Registrar Turno</a>
                <a href="views/listarTurnos.jsp" class="btn btn-primary btn-lg">Listar Turnos</a>
                <a href="views/modificarTurno.jsp" class="btn btn-primary btn-lg">Modificar Turno</a>                

            </div>

        </div>


        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
    </body>
</html>

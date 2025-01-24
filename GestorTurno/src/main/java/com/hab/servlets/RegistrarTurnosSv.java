package com.hab.servlets;

import com.hab.logica.ControladoraLogica;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrarTurnosSv", urlPatterns = {"/RegistrarTurnosSv"})
public class RegistrarTurnosSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String fechaTurnoString = request.getParameter("fechaTurno");
        String ciudadanoId = request.getParameter("ciudadanoId");
        String tramiteId = request.getParameter("tramiteId");

        int estadoTurnoId = 1; // Estado 'En espera' 

        // Convierte la fecha de String a Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaTurno = null;

        try {
            fechaTurno = formatter.parse(fechaTurnoString); // Convierte a Date
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Fecha en formato incorrecto");
            return;
        }

        //Contar los turnos para la fecha a registrar
        int numeroTurnos = control.contarTurnosPorFecha(fechaTurno);
        if (numeroTurnos >= 10) {
            request.setAttribute("mensaje", "Es una lástima, se terminaron los turnos para este día, intenta con otra fecha.");
            request.getRequestDispatcher("registrarTurno.jsp").forward(request, response);
            return;
        }
        int numeroTurno = numeroTurnos + 1;

        control.crearTurno(fechaTurno, Long.parseLong(ciudadanoId), estadoTurnoId, Long.parseLong(tramiteId), numeroTurno);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

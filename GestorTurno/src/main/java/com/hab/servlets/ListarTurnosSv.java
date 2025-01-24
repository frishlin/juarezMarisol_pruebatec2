package com.hab.servlets;

import com.hab.logica.ControladoraLogica;
import com.hab.logica.Turno;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarTurnosSv", urlPatterns = {"/ListarTurnosSv"})
public class ListarTurnosSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obtener la fecha
        String fechaTurnoStr = request.getParameter("fechaTurno");
        //obtener estado
        String estadoTurno = request.getParameter("estadoTurno");
        List<Turno> listaTurnos;

        if (estadoTurno != null && !estadoTurno.isEmpty()) {
            // Filtrar solo por estado
            listaTurnos = control.filtrarTurnosPorEstado(estadoTurno);
        } else if (fechaTurnoStr != null && !fechaTurnoStr.isEmpty()) {
            // Filtrar solo por fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaTurno = null;
            try {
                fechaTurno = sdf.parse(fechaTurnoStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            listaTurnos = control.filtrarTurnosPorFecha(fechaTurno);
        } else {
            // Mostrar todos los turnos por default
            listaTurnos = control.traerTurnos();
        }

        request.setAttribute("listaTurnos", listaTurnos);
        request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

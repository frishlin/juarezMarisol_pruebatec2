package com.hab.servlets;

import com.hab.logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CambiarEstadoTurnoSv", urlPatterns = {"/CambiarEstadoTurnoSv"})
public class CambiarEstadoTurnoSv extends HttpServlet {

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
        Long idTurno = Long.parseLong(request.getParameter("idTurno"));
        control.cambiarEstadoTurno(idTurno, "Ya atendido");
        response.sendRedirect("ListarTurnosSv");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

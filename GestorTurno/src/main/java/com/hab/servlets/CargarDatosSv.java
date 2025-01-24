
package com.hab.servlets;

import com.hab.logica.Ciudadano;
import com.hab.logica.ControladoraLogica;
import com.hab.logica.TipoTramite;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CargarDatosSv", urlPatterns = {"/CargarDatosSv"})
public class CargarDatosSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        
        List<Ciudadano>listaCiudadanos = control.traerCiudadanos();
        List<TipoTramite>listaTramites = control.traerTramites();
        
        request.setAttribute("listaCiudadanos",listaCiudadanos);
        request.setAttribute("listaTramites", listaTramites);
        
        //request.getRequestDispatcher("registrarTurno.jsp").forward(request,response);
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaCiudadanos", listaCiudadanos);
        miSesion.setAttribute("listaTramites", listaTramites);
        response.sendRedirect("registrarTurno.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

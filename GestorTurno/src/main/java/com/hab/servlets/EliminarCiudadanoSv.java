package com.hab.servlets;

import com.hab.logica.Ciudadano;
import com.hab.logica.ControladoraLogica;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EliminarCiudadanoSv", urlPatterns = {"/EliminarCiudadanoSv"})
public class EliminarCiudadanoSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id_persona"));
        Ciudadano ciudadano = control.buscarCiudadano(id);
        String apellido = ciudadano.getApellido();
        control.eliminarCiudadano(id);
        List<Ciudadano> listaCiudadanos = control.buscarPorApellido(apellido);
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaCiudadanos", listaCiudadanos);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

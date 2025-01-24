
package com.hab.servlets;

import com.hab.logica.Ciudadano;
import com.hab.logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EditarCiudadanoSv", urlPatterns = {"/EditarCiudadanoSv"})
public class EditarCiudadanoSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id_persona")); //Trae el id del ciudadano
        Ciudadano ciud = control.buscarCiudadano(id);
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("ciudadano_editar", ciud);
        response.sendRedirect("editarCiudadano.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traer datos modificados del ciudadano
        String nombre = request.getParameter("nombre");
        String apelllido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String curp = request.getParameter("curp");
        
        Ciudadano ciud = (Ciudadano) request.getSession().getAttribute("ciudadano_editar");
        ciud.setNombre(nombre);
        ciud.setApellido(apelllido);
        ciud.setTelefono(telefono);
        ciud.setCurp(curp);
        
        control.editarCiudadano(ciud);
        
        List<Ciudadano> listaCiudadanos = control.buscarPorApellido(apelllido);
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaCiudadanos", listaCiudadanos);
        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

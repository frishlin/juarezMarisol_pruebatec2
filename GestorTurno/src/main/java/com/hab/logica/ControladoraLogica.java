package com.hab.logica;

import com.hab.persistencia.ControladoraPersistencia;
import com.hab.persistencia.TipoTramiteJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearCiudadano(String nombre, String apellido, String telefono, String curp) {
        Ciudadano ciud = new Ciudadano(nombre, apellido, telefono, curp);
        controlPersis.crearCiudadano(ciud);
    }

    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {

        List<Ciudadano> ciudadanosCoincidentes = new ArrayList<>();

        /*List<Ciudadano> listaCiudadanos = controlPersis.traerCiudadanos();
        for(Ciudadano ciud : listaCiudadanos) {
            if(ciud.getApellido().equals(busquedaApellido)){
                ciudadanosCoincidentes.add(ciud);
            }
        }*/
        ciudadanosCoincidentes = controlPersis.buscarPorApellido(busquedaApellido);
        return ciudadanosCoincidentes;
    }

    public void eliminarCiudadano(Long id) {
        controlPersis.eliminarCiudadano(id);
    }

    public Ciudadano buscarCiudadano(Long id) {
        return controlPersis.traerCiudadano(id);
    }

    public void editarCiudadano(Ciudadano ciud) {
        controlPersis.editarPersona(ciud);
    }

    public List<Ciudadano> traerCiudadanos() {
        return controlPersis.traerCiudadanos();

    }

    public List<TipoTramite> traerTramites() {
        return controlPersis.traerTramites();

    }

    public int contarTurnosPorFecha(Date fechaTurno) {
        return controlPersis.contarTurnosPorFecha(fechaTurno);
    }

    public void crearTurno(Date fechaTurno, long ciudadanoId, long estadoTurnoId, long tramiteId, int numeroTurno) {
        Turno turno = new Turno();
        turno.setNumeroTurno(numeroTurno);
        turno.setFecha(fechaTurno); // Asegúrate de que Turno.setFecha() acepte String o Date
        turno.setCiudadano(controlPersis.traerCiudadano(ciudadanoId));
        turno.setEstadoTurno(controlPersis.traerEstadoTurno(estadoTurnoId));
        turno.setTipoTramite(controlPersis.traerTipoTramite(tramiteId));

        controlPersis.crearTurno(turno);
    }

    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();
    }

    public List<Turno> filtrarTurnosPorFecha(Date fechaTurno) {
        return controlPersis.filtrarTurnosPorFecha(fechaTurno);
    }

    public List<Turno> filtrarTurnosPorEstado(String estadoTurno) {
        return controlPersis.filtrarTurnosPorEstado(estadoTurno);
    }

}

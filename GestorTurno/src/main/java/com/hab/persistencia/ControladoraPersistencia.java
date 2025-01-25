package com.hab.persistencia;

import com.hab.logica.Ciudadano;
import com.hab.logica.EstadoTurno;
import com.hab.logica.TipoTramite;
import com.hab.logica.Turno;
import com.hab.persistencia.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ControladoraPersistencia {

    CiudadanoJpaController ciudJpa = new CiudadanoJpaController();
    TipoTramiteJpaController tipoTramiteJpa = new TipoTramiteJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    EstadoTurnoJpaController estadoTurnoJpa = new EstadoTurnoJpaController();

    //Métodos para Ciudadano
    public void crearCiudadano(Ciudadano ciud) {
        //llamar al jpa controller
        ciudJpa.create(ciud);
    }

    public List<Ciudadano> traerCiudadanos() {
        return ciudJpa.findCiudadanoEntities();
    }

    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        return ciudJpa.findCiudadanoByApellido(busquedaApellido);
    }

    public void eliminarCiudadano(Long id) {
        //borrado físico, es mejor borrado lógico
        try {
            ciudJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ciudadano traerCiudadano(Long id) {
        return ciudJpa.findCiudadano(id);
    }

    public void editarPersona(Ciudadano ciud) {
        try {
            ciudJpa.edit(ciud);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TipoTramite> traerTramites() {
        return tipoTramiteJpa.findTipoTramiteEntities();
    }

    public void crearTurno(Turno turno) {
        turnoJpa.create(turno);
    }

    public TipoTramite traerTipoTramite(long tramiteId) {
        return tipoTramiteJpa.findTipoTramite(tramiteId);
    }

    public EstadoTurno traerEstadoTurno(Long estadoTurnoId) {
        return estadoTurnoJpa.findEstadoTurno(estadoTurnoId);
    }

    public int contarTurnosPorFecha(Date fechaTurno) {
        EntityManager em = turnoJpa.getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(t) FROM Turno t WHERE t.fecha = :fechaTurno");
            query.setParameter("fechaTurno", fechaTurno);
            return ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            em.close();
        }
    }

    public List<Turno> traerTurnos() {
        return turnoJpa.findTurnoEntities();
    }

    public List<Turno> filtrarTurnosPorFecha(Date fechaTurno) {
        EntityManager em = turnoJpa.getEntityManager();
        try {
            Query query = em.createQuery("SELECT t FROM Turno t WHERE t.fecha = :fechaTurno");
            query.setParameter("fechaTurno", fechaTurno);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Turno> filtrarTurnosPorEstado(String estadoTurno) {
        EntityManager em = turnoJpa.getEntityManager();
        try {
            Query query = em.createQuery("SELECT t FROM Turno t WHERE t.estadoTurno.nombre = :estadoTurno");
            query.setParameter("estadoTurno", estadoTurno);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Turno traerTurno(Long idTurno) {
        return turnoJpa.findTurno(idTurno);
    }

    public void editarTurno(Turno turno) {
        try {
            turnoJpa.edit(turno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public EstadoTurno obtenerEstadoPorNombre(String nombreEstado) {
    EntityManager em = estadoTurnoJpa.getEntityManager();
    try {
        Query query = em.createQuery("SELECT e FROM EstadoTurno e WHERE e.nombre = :nombreEstado");
        query.setParameter("nombreEstado", nombreEstado);
        return (EstadoTurno) query.getSingleResult();
    } finally {
        em.close();
    }
}

}

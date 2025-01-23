
package com.hab.logica;

import java.util.Date;

public class Turno {
   private Long id;
   private int numeroTurno; //para definir el número de turnos por día
   private Date fecha;
   private Ciudadano ciudadano;
   private TipoTramite tipoTramite;
   private EstadoTurno estadoTurno;

    public Turno() {
    }

    public Turno(Long id, int numeroTurno, Date fecha, Ciudadano ciudadano, TipoTramite tipoTramite, EstadoTurno estadoTurno) {
        this.id = id;
        this.numeroTurno = numeroTurno;
        this.fecha = fecha;
        this.ciudadano = ciudadano;
        this.tipoTramite = tipoTramite;
        this.estadoTurno = estadoTurno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public EstadoTurno getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(EstadoTurno estadoTurno) {
        this.estadoTurno = estadoTurno;
    }
   
   
   
}

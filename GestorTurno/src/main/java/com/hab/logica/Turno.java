package com.hab.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NUMEROTURNO")
    private int numeroTurno; //para definir el número de turnos por día
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    private Ciudadano ciudadano;
    @ManyToOne
    private TipoTramite tipoTramite;
    @ManyToOne
    private EstadoTurno estadoTurno;

    public Turno() {
    }

    public Turno(int numeroTurno, Date fecha, Ciudadano ciudadano, TipoTramite tipoTramite, EstadoTurno estadoTurno) {
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

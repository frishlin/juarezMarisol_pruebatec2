package com.hab.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ciudadano implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String curp;

    public Ciudadano() {
    }

    public Ciudadano(String nombre, String apellido, String telefono, String curp) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.curp = curp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "Ciudadano{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", curp=" + curp + '}';
    }
}

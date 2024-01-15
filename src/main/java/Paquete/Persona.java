package Paquete;

import java.time.LocalDate;

public class Persona {
    private String rut;
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fechaIngreso;

    public Persona() {
    }

    public Persona(String rut, String nombre, String apellido, String telefono, LocalDate fechaIngreso) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Persona [rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
                + ", fechaIngreso=" + fechaIngreso + "]";
    }
}

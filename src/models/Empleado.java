package models;

import java.util.Date;

public class Empleado {
    
    private Integer idEmpleado;
    private String nombre;
    private String domicilio;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    private Genero genero;
    
    public Empleado(Integer id, String nombre) {
        this.idEmpleado = id;
        this.nombre = nombre;
    }

    public Empleado(Integer id, String nombre, String domicilio, String telefono, String email, Date fechaNacimiento, Genero genero) {
        this.idEmpleado = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Integer getId() {
        return idEmpleado;
    }

    public void setId(Integer id) {
        this.idEmpleado = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", domicilio=" + domicilio + ", telefono=" + telefono + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + "]";
    }
}

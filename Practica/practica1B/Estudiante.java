/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1B;

/**
 *
 * @author Joaco
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String email;
    private String direccion;

    public Estudiante() {
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

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String tusDatos(){
        String s = "Nombre completo: " + this.getNombre() + " " + this.getApellido() + "\nEmail: " + this.getEmail() + "\nComision: " + this.getComision() + "\nDireccion: " + this.getDireccion();
        return s;
    }
    
}

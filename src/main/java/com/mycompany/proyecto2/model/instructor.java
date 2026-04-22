/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2.model;

import com.mycompany.proyecto2.main.abstracto.Usuario;
import com.mycompany.proyecto2.main.utils.Genero;
import com.mycompany.proyecto2.main.utils.Rol;
import java.util.Date;

/**
 *
 * @author erick
 */
public class instructor extends Usuario{
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Genero genero;
    
    public instructor( String nombre, String apellido, Date fechaNacimiento, Genero genero,String codigo, String contraseña, Rol rol, boolean online) {
        super(codigo, contraseña, rol, online);
        this.nombre= nombre;
        this.apellido= apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
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
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2.main.abstracto;

import com.mycompany.proyecto2.main.utils.Rol;
import java.io.Serializable;

/**
 *
 * @author erick
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String contraseña;
    private Rol rol;
    private boolean online;

    public Usuario(String codigo, String contraseña, Rol rol, boolean online) {
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.online = online;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
    
}

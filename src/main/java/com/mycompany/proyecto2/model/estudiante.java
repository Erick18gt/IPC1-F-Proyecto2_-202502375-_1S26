
package com.mycompany.proyecto2.model;

import com.mycompany.proyecto2.main.abstracto.Usuario;
import com.mycompany.proyecto2.main.utils.Genero;
import com.mycompany.proyecto2.main.utils.Rol;
import java.util.Date;

/**
 *
 * @author erick
 */
public class estudiante extends Usuario{
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Genero genero;
    
    
    public estudiante(String nombre,String apellido,Date fechaNacimiento,Genero genero,String codigo, String password, Rol rol, boolean online) {
        super(codigo, password, rol, online);
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
   /* @Override
    public boolean isOnline(){
        return true;
}*/
}

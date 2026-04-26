
package com.mycompany.proyecto2.main.abstracto;

import java.io.Serializable;


public class Curso implements Serializable{
     private static final long serialVersionUID = 1L;
     private String codigo;
     private String nombre;
     private String descripcion;
     private int cupoMax;
     private int inscritos;
     private String[] estudiantes = new String[100];
private int contadorEstudiantes = 0;
  public Curso(String codigo, String nombre, String descripcion, int cupoMax) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupoMax = cupoMax;
        this.inscritos = 0;
  }
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }
     public void aumentarInscritos(){
        inscritos++;
    }

    public void disminuirInscritos(){
        inscritos--;
    }
    public boolean inscribir(String codigoEstudiante){

    // validar cupo
    if(inscritos >= cupoMax){
        return false;
    }

    // evitar duplicados (opcional pero pro)
    for(int i = 0; i < contadorEstudiantes; i++){
        if(estudiantes[i].equals(codigoEstudiante)){
            return false;
        }
    }

    estudiantes[contadorEstudiantes] = codigoEstudiante;
    contadorEstudiantes++;
    inscritos++;

    return true;
}
    public boolean estaInscrito(String codigo){

    for(int i = 0; i < contadorEstudiantes; i++){
        if(estudiantes[i].equals(codigo)){
            return true;
        }
    }
    return false;
}
    
}

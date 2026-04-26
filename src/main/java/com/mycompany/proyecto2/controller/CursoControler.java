
package com.mycompany.proyecto2.controller;

import com.mycompany.proyecto2.main.abstracto.Curso;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CursoControler {
    
    private static Curso[] cursos = new Curso[100];
    private static int contadorCursos = 0;
    private static int contadorCodigo = 1;

   public static String generarCodigoCurso(){
    return "CUR-" + contadorCodigo++;
   }
    private static final String ARCHIVO = "cursos.ser";

    public CursoControler(){
        cargarCursos();
    
    }
    public void agregarCurso(String nombre, String descripcion, int cupo){
    if(contadorCursos >= cursos.length){
    System.out.println("No hay espacio para más cursos");
    return;
    }
    String codigo = generarCodigoCurso();

    Curso c = new Curso(codigo, nombre, descripcion, cupo);

    cursos[contadorCursos] = c;
    contadorCursos++;

    guardarCursos();
}
    public static void guardarCursos(){

    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))){

        out.writeObject(cursos);
        out.writeInt(contadorCursos);
        out.writeInt(contadorCodigo); 

    }catch(Exception e){
        System.out.println("Error guardando cursos");
    }
}
    public static void cargarCursos(){

    File archivo = new File(ARCHIVO);

    if(!archivo.exists() || archivo.length() == 0){
        cursos = new Curso[100];
        contadorCursos = 0;
        contadorCodigo = 1;
        return;
    }

    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))){

        cursos = (Curso[]) in.readObject();
        contadorCursos = in.readInt();
        contadorCodigo = in.readInt(); 

    }catch(Exception e){
        cursos = new Curso[100];
        contadorCursos = 0;
        contadorCodigo = 1;
    }
   }
    public Curso buscarCurso(String codigo){

    for(int i = 0; i < contadorCursos; i++){
        if(cursos[i].getCodigo().equalsIgnoreCase(codigo)){
            return cursos[i];
        }
    }
    return null;
 }
    public boolean eliminarCurso(String codigo){

    for(int i = 0; i < contadorCursos; i++){

        if(cursos[i].getCodigo().equalsIgnoreCase(codigo)){

            cursos[i] = cursos[contadorCursos - 1];
            cursos[contadorCursos - 1] = null;
            contadorCursos--;

            guardarCursos();
            return true;
        }
    }
    return false;
 }
    public boolean editarCurso(String codigo, String nombre, String descripcion, int cupo){

    Curso c = buscarCurso(codigo);

    if(c != null){
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        c.setCupoMax(cupo);

        guardarCursos();
        return true;
    }
    return false;
}
    public void cargarCSV(){

    JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showOpenDialog(null);

    if(seleccion == JFileChooser.APPROVE_OPTION){

        File archivo = fileChooser.getSelectedFile();

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){

            String linea;
            br.readLine(); // 🔥 saltar encabezado

            while((linea = br.readLine()) != null){

                String[] datos = linea.split(",");

                String nombre = datos[0];
                String descripcion = datos[1];
                int cupo = Integer.parseInt(datos[2]);

                agregarCurso(nombre, descripcion, cupo);
            }

            JOptionPane.showMessageDialog(null, "Cursos cargados correctamente");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar CSV");
        }
    }
}
    public Curso[] getCursos(){
    return cursos;
}

public int getContadorCursos(){
    return contadorCursos;
}
}

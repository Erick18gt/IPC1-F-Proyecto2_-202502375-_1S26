
package com.mycompany.proyecto2.controller;

import com.mycompany.proyecto2.main.abstracto.Usuario;
import com.mycompany.proyecto2.main.utils.GeneradorCodigo;
import com.mycompany.proyecto2.main.utils.Genero;
import com.mycompany.proyecto2.main.utils.Rol;
import com.mycompany.proyecto2.model.estudiante;
import com.mycompany.proyecto2.model.instructor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class UsuarioControler {
    private static Usuario[] usuarios = new Usuario[100];
    private static int contadorUsuarios =0;
    private static int contadorEstudiante = 1;
    private static int contadorInstructor = 1;

    private static final String NOMBRE_ARCHIVO = "estudiantes.ser";
    public UsuarioControler(){
        cargarUsuarios();
    
    }
    
    public void agregarUsuario(String nombre, String apellido, Rol rol, Genero genero, Date fechaNacimiento, String password){
        if(contadorUsuarios>= usuarios.length){
            System.out.println("No hay espacio para mas usuarios");
            JOptionPane.showMessageDialog(null, "No hay espacio para mas usuarios");
            return;
        }
        String codigo= GeneradorCodigo.generarCodigo(rol);
        Usuario nuevoUsuario = null;
        switch(rol){
            case ESTUDIANTE:
                estudiante estudiante = new estudiante(
                           nombre,
                           apellido,
                           fechaNacimiento,
                           genero,
                           codigo,
                           password,
                           rol,
                           false
                        
                );
                nuevoUsuario= estudiante;
                break;
            case INSTRUCTOR:
                instructor instructor = new instructor(
                        nombre,
                           apellido,
                           fechaNacimiento,
                           genero,
                           codigo,
                           password,
                           rol,
                           false
                        
            
            
            
            
                );
            nuevoUsuario = instructor;
            break;
                  
            default:
                System.out.println("Rol no soportado");
                return;
        }
        
        usuarios[contadorUsuarios]= nuevoUsuario;
        contadorUsuarios++;
        guardarUsuarios();
        System.out.println("Usuario agregado: "+ codigo);
    }
    public static void guardarUsuarios(){
        File archivo = new File(NOMBRE_ARCHIVO);
        try{
            if(!archivo.exists()){
            archivo.createNewFile();
            }try(ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))){
              salida.writeObject(usuarios);
              salida.writeInt(contadorUsuarios);
              salida.writeInt(contadorEstudiante);
              salida.writeInt(contadorInstructor);
              System.out.println("Usuarios guardados correctamente en "+ NOMBRE_ARCHIVO);
            }
        }catch(IOException e){
            System.out.println("Error "+ e.getMessage());
        
        }
        

}
         public static void cargarUsuarios(){
        File archivo = new File(NOMBRE_ARCHIVO);
        if(!archivo.exists()){
        usuarios= new Usuario[100];
        contadorUsuarios=0;
            System.out.println("No existe el archivo.ser, datos vacios");
            return;
        }if(archivo.length()==0){
            usuarios= new Usuario[100];
        contadorUsuarios=0;
            System.out.println("El archivo existe pero esta vacio, datos vacios");
            return;
        
        }try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))){
           usuarios = (Usuario[]) entrada.readObject();
           contadorUsuarios = entrada.readInt();
           contadorEstudiante = entrada.readInt();
           contadorInstructor = entrada.readInt();
             System.out.println("Estudiantes cargados exitosamente");
         }catch(IOException | ClassNotFoundException e){
             System.out.println("Error al cargar los usuarios "+e.getMessage());
             usuarios = new Usuario[100];
             contadorUsuarios = 0;
         }
        
        }  
    public void listarUsuarios(){
    if(contadorUsuarios==0 ){
        System.out.println("No hay usuarios ");
        return;
    
    }
    for(int i =0;i<contadorUsuarios;i++){
        System.out.println("Usuario No."+(i+1)+": "+usuarios[i].getCodigo() );
    }
    }
    public Usuario[] getUsuario(){
    return usuarios;
    }
    public int getContadorUsuarios(){
    return contadorUsuarios;
    }
    public static int getSiguienteCodigoEstudiante(){
    return contadorEstudiante++;
    }

    public static int getSiguienteCodigoInstructor(){
    return contadorInstructor++;
    }
    public Usuario buscarUsuario(String codigo, String password){
    for(int i=0; i<contadorUsuarios; i++){
        if(usuarios[i].getCodigo().equals(codigo) && usuarios[i].getContraseña().equals(password)){
        return usuarios[i];   
        }
   
    
    }
        return null;
    }
    public Usuario buscarPorCodigo(String codigo){
    for(int i = 0; i < contadorUsuarios; i++){
        if(usuarios[i] != null &&
           usuarios[i].getCodigo().equalsIgnoreCase(codigo)){
            return usuarios[i];
        }
    }
    return null;
}
    public boolean eliminarUsuario(String codigo){
    for(int i = 0; i < contadorUsuarios; i++){

        if(usuarios[i] != null &&
           usuarios[i].getCodigo().equalsIgnoreCase(codigo)){
            usuarios[i] = usuarios[contadorUsuarios - 1];
            usuarios[contadorUsuarios - 1] = null;
            contadorUsuarios--;
            guardarUsuarios();

            return true;
        }
    }
    return false;
}
}

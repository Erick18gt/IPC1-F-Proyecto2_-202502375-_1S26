
package com.mycompany.proyecto2.main.utils;

import com.mycompany.proyecto2.controller.UsuarioControler;

public class GeneradorCodigo {
    private static int contadorEstudiante=1;
    private static int contadorInstructor=1;
public static String generarCodigo(Rol rol){
    switch(rol){
        case ESTUDIANTE:
            return "EST-" + UsuarioControler.getSiguienteCodigoEstudiante();

        case INSTRUCTOR:
            return "INS-" + UsuarioControler.getSiguienteCodigoInstructor();

        default:
            return "USR-" + System.currentTimeMillis();
    }
}
    
}

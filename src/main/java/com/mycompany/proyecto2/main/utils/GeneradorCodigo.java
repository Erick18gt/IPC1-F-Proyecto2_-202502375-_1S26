
package com.mycompany.proyecto2.main.utils;

public class GeneradorCodigo {
    private static int contadorEstudiante=1;
    private static int contadorInstructor=1;
    public static String generarCodigo(Rol rol){
        switch(rol){
            case ESTUDIANTE: 
                    return "EST-"+ contadorEstudiante++;
                    
            case INSTRUCTOR:
                    return "INS-"+ contadorInstructor++;
                   
            default:
                    return "USR-"+ System.currentTimeMillis();
        
        }
    }
    
}

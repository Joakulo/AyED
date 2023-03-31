/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1B;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Joaco
 */
public class Ejercicio3 {


    public static void main(String[] args) {

        GeneradorAleatorio.iniciar();
        
        Estudiante[] Estudiantes = new Estudiante[2];
        Profesor[] Profesores = new Profesor[3];
        
        
        Estudiante E;
        Profesor P;
        
        for (int i=0; i<2; i++){
            E = new Estudiante();
            E.setNombre(GeneradorAleatorio.generarString(5));
            E.setApellido(GeneradorAleatorio.generarString(10));
            E.setEmail(GeneradorAleatorio.generarString(7)+"@gmail.com");
            E.setComision(GeneradorAleatorio.generarInt(10));
            E.setDireccion(GeneradorAleatorio.generarString(10));
            Estudiantes[i]=E;
        }
        
        for (int i =0; i<3; i++){
            P = new Profesor();
            P.setNombre(GeneradorAleatorio.generarString(10));
            P.setApellido(GeneradorAleatorio.generarString(5));
            P.setEmail(GeneradorAleatorio.generarString(7)+"@gmail.com");
            P.setCatedra(GeneradorAleatorio.generarInt(10));
            P.setFacultad("Informatica");
            Profesores[i]=P;
        }
        
        for (int i=0; i<2; i++){
            System.out.println(Estudiantes[i].tusDatos());
            System.out.println("");
        }
        
        for (int i=0; i<3; i++){
            System.out.println(Profesores[i].tusDatos());
            System.out.println("");
        }
        

    }
    
}

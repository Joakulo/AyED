/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1B;

import java.util.Scanner;

/**
 *
 * @author Joaco
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        int n = s.nextInt();
        int [] vector = Multiplos(n);
        for (int i=0; i<n; i++){
            System.out.println(vector[i]);
        }
        
    }
    
    public static int[] Multiplos(int n){
        
        int [] vector = new int[n];
        for (int i=0; i<n ; i++){
            vector[i] = n*(i+1); 
        }
        
        return vector;
    }
}

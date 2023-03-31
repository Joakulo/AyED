/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1B;

/**
 *
 * @author Joaco
 */
public class Ejercicio1 {


    public static void main(String[] args) {

        ImprimirFor(3,8);
        System.out.println();
        ImprimirWhile(3,8);
        System.out.println();
        ImprimirRecursivo(3,8);        
    }
        
        public static void ImprimirFor(int a, int b){
            for (int i=a; i<=b ; i++){
                System.out.println(i);
            }
        }
        
        public static void ImprimirWhile(int a, int b){
            while (a<=b){
                System.out.println(a);
                a++;
            }
        }
        
        public static void ImprimirRecursivo(int a, int b){
            if (a <= b){
                System.out.println(a);
                a++;
                ImprimirRecursivo(a,b);
            }
        }
}
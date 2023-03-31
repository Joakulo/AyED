/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1B;


public class Ejercicio5 {


    public static void main(String[] args) {

            

    }
    
    public static int[] returnArray(int[] v){
        int[] a = {0, 9999, 0};
        for(int i=0; i < v.length; i++){
            if (a[0]<v[i]){
                a[0]=v[i];
            }
            if (a[1] > v[i]){
                a[1] = v[i];
            }
            a[2]=a[2] + v[i];
        }
        a[2]=a[2] / v.length;
        return a;
    }
    
    public static void MetodoB(Inciso5B objetoB, int[] arreglo) {
        objetoB.setMax(-1);
        objetoB.setMin(9999);
        objetoB.setProm(0);

        for (int i=0; i<arreglo.length;i++){
            if(arreglo[i]>objetoB.getMax()){
                objetoB.setMax(arreglo[i]);
            }
            if(arreglo[i]>objetoB.getMin()){
                objetoB.setMin(arreglo[i]);
            }
            objetoB.setProm(objetoB.getProm()+arreglo[i]);
        }
        objetoB.setProm(objetoB.getProm()/arreglo.length);
    }
}

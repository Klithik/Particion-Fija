package clases;

import java.util.Scanner;

public class Consola extends Thread{
    Scanner sc = new Scanner(System.in);
    int opcion;
    public void elegirAlgoritmo(Integer n){
        opcion = n;
    }
    public void run(){
        String cadena = sc.nextLine();
        try{
            Proceso nuevo = new Proceso(cadena);
            switch(opcion){
                case 0:
                    Algoritmos.ordenamientoStack(nuevo);
                    break;
                case 1:
                    Algoritmos.ordenamientoBestFit(nuevo);
            }
        }catch(Exception e){
            System.out.println("Entrada inválida");
            System.out.println(e.toString());
        }
    }
}

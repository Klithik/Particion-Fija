package clases;

import java.util.Scanner;
import clases.Algoritmos;

public class Consola extends Thread{
    Scanner sc = new Scanner(System.in);
    public void run(){
        String cadena = sc.nextLine();
        try{
            Proceso nuevo = new Proceso(cadena);
            Algoritmos.Stack(nuevo);
        }catch(Exception e){
            System.out.println("Entrada inválida");
            System.out.println(e.toString());
        }
    }
}

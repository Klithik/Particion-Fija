package clases;

import java.util.ArrayList;
import java.util.Scanner;

//CLASE DESTINADA A RECIBIR COMANDOS POR CONSOLA
//PARA AGREGAR PROCESOS EN TIEMPO REAL
public class Consola extends Thread{
    Scanner sc = new Scanner(System.in);
    int opcion;
    public void elegirAlgoritmo(Integer n,ArrayList<Proceso> procesos){
        opcion = n;
        for (Proceso proceso : procesos) {
            try{
                switch(opcion){
                    case 0:
                        Algoritmos.ordenamientoStack(proceso);
                        break;
                    case 1:
                        Algoritmos.bestFit(proceso);
                        break;
                    case 2:
                        Algoritmos.firstFit(proceso);
                        break;
                }
            }catch(Exception e){
                System.out.println("Entrada inválida");
                System.out.println(e.toString());
            }
        }
    }
    public void run(){
        while(true){
        String cadena = sc.nextLine();
            try{
                Proceso nuevo = new Proceso(cadena);
                switch(opcion){
                    case 0:
                        if(Algoritmos.ordenamientoStack(nuevo)){
                            Cronometro.dibujo();
                        }else{
                            System.out.println("ERROR AL INSERTAR PROCESO");
                        }
                        break;
                    case 1:
                        if(Algoritmos.bestFit(nuevo)){
                            Cronometro.dibujo();
                        }else{
                            System.out.println("ERROR AL INSERTAR PROCESO");
                        }
                        break;
                    case 2:
                        if(Algoritmos.firstFit(nuevo)){
                            Cronometro.dibujo();
                        }else{
                            System.out.println("ERROR AL INSERTAR PROCESO");
                        }
                        break;
                }
            }catch(Exception e){
                System.out.println("Entrada inválida");
                System.out.println(e.toString());
            }
        }
    }
}

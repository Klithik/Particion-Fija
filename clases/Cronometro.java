package clases;

import java.util.ArrayList;

public class Cronometro extends Thread{
    int segundos = 0;

    //FUNCION PARA IMPORTAR LISTA DE PARTICIONES
    static ArrayList<Particion> particiones = null;
    public static void setParticiones(ArrayList<Particion> p){
        particiones = p;
    }

    public void run(){
        try{
            dibujo();
            while(true){
                Thread.sleep(1000);
                segundos++;
                for (Particion particion : particiones) {
                    if(particion.procesoActivo != null){
                        //SE REDUCE 1 A LA DURACION DE CADA PROCESO ACTIVO
                        particion.procesoActivo.reduceDuracion();
                        //SI EL TIEMPO RESTANTE ES MENOR O IGUAL A 0 AVANZA LA COLA
                        if(!(particion.procesoActivo.getDuracion()>=0)){
                            particion.avanzarCola();
                            dibujo();
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error en el hilo Cronometro");
            System.out.println(e.toString());
        }
    }

    //FUNCION PARA DIBUJAR RESULTADOS
    public static void dibujo(){
        try{
            System.out.println("|-----------------------------------------------------------------------|");
            System.out.println("|           M1          |           M2          |           M3          |");
            System.out.println("|-----------------------------------------------------------------------|");
            int mayor = 0;
            for (Particion particion : particiones) {
                if(particion.getCola().size()>mayor){mayor=particion.getCola().size();}
            }
            for(int i = 0; i<mayor; i++){
                System.out.print("\n|");
                for (Particion particion : particiones) {
                    if(particion.getCola().size()>i){System.out.print(particion.getCola().get(i));}else{
                        System.out.print("                       ");
                    }
                    System.out.print("|");
                }
            }
            System.out.println("\n|-----------------------------------------------------------------------|");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}

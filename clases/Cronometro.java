package clases;

import java.util.ArrayList;

public class Cronometro extends Thread{
    int segundos = 0;

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
                    if(!particion.procesoActivo.equals(null)){
                        //SE REDUCE 1 A LA DURACION DE CADA PROCESO ACTIVO
                        particion.procesoActivo.reduceDuracion();
                        //System.out.println(particion.procesoActivo.getDuracion());
                        //SI EL TIEMPO RESTANTE ES 0 AVANZA LA COLA
                        if(particion.procesoActivo.getDuracion()==0){
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

    public void dibujo(){
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|       M1      |       "+particiones.get(0).getProcesoActivo().toString()+"            |");
        if(!particiones.get(0).getCola().isEmpty()){
            for (Proceso proceso : particiones.get(0).getCola()) {
                System.out.print(proceso.toString());
            }
        }
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|       M2      |       "+particiones.get(1).getProcesoActivo().toString()+"            |");
        if(!particiones.get(1).getCola().isEmpty()){
            for (Proceso proceso : particiones.get(1).getCola()) {
                System.out.print(proceso.toString());
            }
        }
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|       M3      |       "+particiones.get(2).getProcesoActivo().toString()+"            |");
        if(!particiones.get(2).getCola().isEmpty()){
            for (Proceso proceso : particiones.get(2).getCola()) {
                System.out.print(proceso.toString());
            }
        }
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|=======================================================================|");
        System.out.println("|=======================================================================|");
    }
}

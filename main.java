import clases.Cronometro;
import clases.Particion;
import clases.Algoritmos;
import clases.Proceso;
import java.util.Stack;
import java.util.List;

public class main{
    static Boolean activo = true;
    public static void main(String[] args){
        Cronometro hilo1 = new Cronometro();
        hilo1.start();
        Algoritmos hilo2 = new Algoritmos();
        hilo2.start();
        /*//LISTA DE PROCESOS EXISTENTES
        List<Proceso> procesos = new List<Proceso>();
        //LISTA DE PARTICIONES EXISTENTES
        List<Particion> particiones = new List<Particion>();

        //DECLARACION DE PARTICIONES BASICAS
        Particion M1 = new Particion(0,15);
        Particion M2 = new Particion(1,7);
        Particion M3 = new Particion(2,9);

        //SE AGREGAN LAS PARTICIONES RECIEN CREADAS A LA LISTA
        particiones.add(M1);
        particiones.add(M2);
        particiones.add(M3);

        //DECLARACION DE PROCESOS BASICOS
        Proceso P1 = new Proceso(0,7,12);
        Proceso P2 = new Proceso(1,5,3);
        Proceso P3 = new Proceso(2,12,10);
        Proceso P4 = new Proceso(3,6,7);

        //SE AGREGAN LOS PROCESOS RECIEN CREADOS A LA LISTA
        procesos.add(P1);
        procesos.add(P2);
        procesos.add(P3);
        procesos.add(P4);*/
    }

    String ordenStack(List<Proceso> procesos,List<Particion> particiones){
        Stack<Proceso> lista = new Stack<Proceso>();
        for (Proceso proceso : procesos) {
            for (Particion particion : particiones) {
                //VERIFICA QUE LA PARTICION TENGA LOS RECURSOS NECESARIOS PARA EL PROCESO
                if(proceso.getRecursos()<=particion.getRecursos()){
                    //REVISA SI LA PARTICION ESTA SIENDO USADA POR UN PROCESO
                    if(particion.getProcesoActivo().equals(null)){

                    }
                }
            }
        }
        return null;
    }
}
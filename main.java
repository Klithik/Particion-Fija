import clases.Cronometro;
import clases.Particion;
import clases.Algoritmos;
import clases.Proceso;
import java.util.ArrayList;

public class main{
    static Boolean activo = true;
    public static void main(String[] args){
        //LISTA DE PROCESOS EXISTENTES
        ArrayList<Proceso> procesos = new ArrayList<Proceso>();
        //LISTA DE PARTICIONES EXISTENTES
        ArrayList<Particion> particiones = new ArrayList<Particion>();

        //DECLARACION DE PARTICIONES BASICAS
        Particion M1 = new Particion(15);
        Particion M2 = new Particion(7);
        Particion M3 = new Particion(9);

        //SE AGREGAN LAS PARTICIONES RECIEN CREADAS A LA LISTA
        particiones.add(M1);
        particiones.add(M2);
        particiones.add(M3);

        Algoritmos.setParticiones(particiones);

        //DECLARACION DE PROCESOS BASICOS
        Proceso P1 = new Proceso(7,12);
        Proceso P2 = new Proceso(5,3);
        Proceso P3 = new Proceso(12,10);
        Proceso P4 = new Proceso(6,7);

        //SE AGREGAN LOS PROCESOS RECIEN CREADOS A LA LISTA
        procesos.add(P1);
        procesos.add(P2);
        procesos.add(P3);
        procesos.add(P4);


        Cronometro cronometro = new Cronometro();
        cronometro.start();
    }
}
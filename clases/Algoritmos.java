package clases;

import java.util.ArrayList;

public class Algoritmos{
    static ArrayList<Particion> particiones = null;

    public static void setParticiones(ArrayList<Particion> p){
        particiones = p;
    }
    public static String ordenamientoStack(Proceso p){
        //BUSCA PARTICIONES VACIAS PARA INSERTAR EL PROCESO
        for (Particion particion : particiones) {
            if(p.getRecursos()<=particion.getRecursos()){
                if(particion.procesoActivo == null){
                    particion.setProcesoActivo(p);
                    return particion.toString();
                }
            }
        }

        //BUSCA LA COLA MAS CORTA A LA QUE AGREGAR EL PROCESO
        int menor_espera=9999999;
        int menor = 0;
        boolean cambio = false;
        for (Particion particion : particiones) {
            if(p.getRecursos()<=particion.getRecursos()){
                if(particion.getProcesoActivo().equals(null)){
                    particion.setProcesoActivo(p);
                    continue;
                }
                int suma = particion.getProcesoActivo().getDuracion();
                //REVISA SI HAY ELEMENTOS EN LA COLA Y CUAL ES LA ESPERA TOTAL EN ESA COLA
                if(!particion.getCola().isEmpty()){
                    for (Proceso proceso : particion.getCola()) {
                        suma=+proceso.getDuracion();
                    }
                }
                //SI LA ENCONTRADA ES LA MAS CORTA HASTA EL MOMENTO GUARDA SU INFORMACION PARA USO FUTURO
                if(suma<menor_espera){
                    menor_espera=suma;
                    menor=particion.hashCode();
                    cambio = true;
                }
            }
        }

        
        if(!cambio){
            return "Ninguna particion válida para el proceso";
        }else{
            for (Particion particion : particiones) {
                if(particion.hashCode() == menor){particion.agregarCola(p);}
            }
        }
        return "agregado";
    }

    public static String ordenamientoBestFit(Proceso p){
        return "Proceso no válido para ninguna particion";
    }
}

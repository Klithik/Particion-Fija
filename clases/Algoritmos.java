package clases;

import java.util.ArrayList;

public class Algoritmos{
    static ArrayList<Particion> particiones = null;

    public static void setParticiones(ArrayList<Particion> p){
        particiones = p;
    }
    public static String ordenamientoStack(Proceso p){
        //BUSCA LA COLA MAS CORTA A LA QUE AGREGAR EL PROCESO
        int menor_espera=9999999;
        int menor = 0;
        boolean cambio = false;
        for (Particion particion : particiones) {
            //SOLO SE TIENEN EN CUENTA PARTICIONES CAPACES
            //DE ALOJAR EL PROCESO
            if(p.getRecursos()<=particion.getRecursos()){
                //SI LA PARTICION NO TIENE UN PROCESO ACTIVO, SIGNIFICA QUE
                //ESTA INACTIVA, CON LO QUE EL PROCESO ACTUAL SE INSERTA AHI
                if(particion.getProcesoActivo().equals(null)){
                    particion.setProcesoActivo(p);
                    continue;
                }
                //SI LA PARTICION NO ESTA VACIA, SE CONSIDERA EL TIEMPO RESTANTE DEL PROCESO
                //ACTIVO ACTUAL PARA CONTAR LA LONGITUD TOTAL DE LA COLA
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

        //VERIFICA QUE EN ALGUN MOMENTO SE ENCONTRO UNA PARTICION
        //CAPAZ DE ALOJAR EL PROCESO
        if(!cambio){
            return "Ninguna particion válida para el proceso";
        }else{
            //SE AGREGA EL PROCESO A LA COLA MAS CORTA ENCONTRADA
            for (Particion particion : particiones) {
                if(particion.hashCode() == menor){particion.agregarCola(p);}
            }
        }
        return "agregado";
    }

    //ALGORITMO BEST FIT **PENDIENTE**
    public static String ordenamientoBestFit(Proceso p){
        return "Proceso no válido para ninguna particion";
    }
}

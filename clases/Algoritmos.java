package clases;

import java.util.ArrayList;

public class Algoritmos{
    static ArrayList<Particion> particiones = null;

    public static void setParticiones(ArrayList<Particion> p){
        particiones = p;
    }
    public static void ordenamientoStack(Proceso p){
        //BUSCA LA COLA MAS CORTA A LA QUE AGREGAR EL PROCESO
        int menor_espera = -1;
        Particion menor = null;

        for (Particion particion : particiones) {
            //SOLO SE TIENEN EN CUENTA PARTICIONES CAPACES
            //DE ALOJAR EL PROCESO
            if(p.getRecursos() <= particion.getRecursos()){
                //SI LA PARTICION NO TIENE UN PROCESO ACTIVO, SIGNIFICA QUE
                //ESTA INACTIVA, CON LO QUE EL PROCESO ACTUAL SE INSERTA AHI
                if(particion.getProcesoActivo() == null){
                    particion.setProcesoActivo(p);
                    return;
                }
                //SI LA PARTICION NO ESTA VACIA, SE CONSIDERA EL TIEMPO RESTANTE DEL PROCESO
                //ACTIVO ACTUAL PARA CONTAR LA LONGITUD TOTAL DE LA COLA
                int suma =+ particion.getProcesoActivo().getDuracion();
                //REVISA SI HAY ELEMENTOS EN LA COLA Y CUAL ES LA ESPERA TOTAL EN ESA COLA
                if(!particion.getCola().isEmpty()){
                    for (Proceso proceso : particion.getCola()) {
                        suma =+ proceso.getDuracion();
                    }
                }
                if(menor_espera == -1){
                    menor_espera = suma;
                    menor = particion;
                }else if(suma<menor_espera){
                    menor_espera = suma;
                    menor = particion;
                }
            }
        }

        //VERIFICA QUE EN ALGUN MOMENTO SE ENCONTRO UNA PARTICION
        //CAPAZ DE ALOJAR EL PROCESO
        if(menor_espera == -1){
            System.out.println("Particion válida no encontrada");
            return;
        }
        //SE AGREGA EL PROCESO A LA COLA MAS CORTA ENCONTRADA
        menor.agregarCola(p);
        return;
    }

    //ALGORITMO BEST FIT **POR REVISAR**
    public static String ordenamientoBestFit(Proceso p){
        int menor_diferencia = 999999;
        Particion menor = null;
        for (Particion particion : particiones) {
            if(p.getRecursos()<=particion.getRecursos()){
                //OBTIENE LA CANTIDAD DE RECURSOS QUE SERIAN DESPERDICIADOS SI ESE PROCESO
                //SE ALMACENA EN ESTA PARTICION
                int diferencia = particion.getRecursos()-p.getRecursos();
                if(diferencia<menor_diferencia){
                    menor_diferencia = diferencia;
                    menor = particion;
                }else if(diferencia==menor_diferencia){
                    //COMPARA LA ESPERA DE AMBAS COLAS Y ELIGE LA MAS CORTA
                    int espera1 = 0;
                    int espera2 = 0;
                    //OBTIENE TIEMPO TOTAL DE LA COLA DE LA PARTICION EN REVISION ACTUAL
                    for (Proceso proceso : particion.getCola()) {
                        espera1=+proceso.getDuracion();
                    }
                    //ENCUENTRA LA PARTICION GUARDADA ANTERIORMENTE Y OBTIENE SU TIEMPO TOTAL DE COLA
                    for (Proceso proceso : menor.getCola()) {
                        espera2=+proceso.getDuracion();
                    }
                    //EN CASO DE QUE LA PARTICION EN REVISION ACTUAL TENGA ESPERA MENOR
                    //EL PROCESO SE ALMACENA AHI, EN CASO CONTRARIO SE MANTIENE GUARDADA
                    //LA PARTICION ANTERIOR
                    if(espera1<espera2){
                        menor_diferencia = diferencia;
                        menor = particion;
                    }
                }
            }
        }
        //SE REVISA QUE SE HAYA ENCONTRADO UNA PARTICION VALIDA Y SE
        //ALMACENA EL PROCESO EN ESA PARTICION
        if(menor != null){
            if(menor.getProcesoActivo() == null){
                menor.setProcesoActivo(p);
                return "listo";
            }else{
                menor.agregarCola(p);
                return "listo";
            }
        }
        return "error";
    }

    //BESTFIT SEBA **POR REVISAR**
    public static void bestFit(Proceso p){
        Particion mejor = null;
        for (Particion particion : particiones) {
            if(particion.getRecursos() >= p.getRecursos()){
                if(mejor == null){
                    mejor = particion;
                }else if(mejor.getRecursos() > particion.getRecursos()){
                    mejor = particion;
                }
            }
        }

        if(mejor != null){
            if(mejor.getProcesoActivo() == null){
                mejor.setProcesoActivo(p);
            }else{
                mejor.agregarCola(p);
            }
        }
    }

    public static void firstFit(Proceso p){
        for (Particion particion : particiones) {
            if(particion.getRecursos() >= p.getRecursos()){
                if(particion.getProcesoActivo() == null){
                    particion.setProcesoActivo(p);
                }else{
                    particion.agregarCola(p);
                }
            }
        }
    }
}

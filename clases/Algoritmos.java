package clases;

import java.util.ArrayList;

public class Algoritmos{
    static ArrayList<Particion> particiones = null;

    public static void setParticiones(ArrayList<Particion> p){
        particiones = p;
    }

    public static Boolean ordenamientoStack(Proceso p){
        int menor_espera = -1;
        Particion menor = null;

        for (Particion particion : particiones) {
            //SOLO SE TIENEN EN CUENTA PARTICIONES CAPACES
            //DE ALOJAR EL PROCESO
            if(p.getRecursos() <= particion.getRecursos()){
                //SI LA PARTICION NO TIENE UN PROCESO ACTIVO, SIGNIFICA QUE
                //ESTA INACTIVA, CON LO QUE EL PROCESO ACTUAL SE INSERTA AHI
                if(particion.getProcesoActivo() == null){
                    System.out.println("COLA VACIA");
                    particion.setProcesoActivo(p);
                    return true;
                }
                //SI LA PARTICION NO ESTA VACIA, SE CONSIDERA EL TIEMPO RESTANTE DEL PROCESO
                //ACTIVO ACTUAL PARA CONTAR LA LONGITUD TOTAL DE LA COLA
                int suma =+ particion.getProcesoActivo().getDuracion();
                //REVISA SI HAY ELEMENTOS EN LA COLA Y CUAL ES LA ESPERA TOTAL EN ESA COLA
                if(!particion.getCola().isEmpty()){
                    System.out.println("COLA NO VACIA");
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
            return false;
        }
        //SE AGREGA EL PROCESO A LA COLA MAS CORTA ENCONTRADA
        menor.agregarCola(p);
        return true;
    }

    //BESTFIT
    public static Boolean bestFit(Proceso p){
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
            return true;
        }
        return false;
    }

    public static Boolean firstFit(Proceso p){
        //RECORRE PARTICIONES
        for (Particion particion : particiones) {
            //REVISA QUE EL PROCESO QUEPA EN LA PARTICION
            if(particion.getRecursos() >= p.getRecursos()){
                //SI LA PARTICION NO TIENE PROCESO ACTIVO
                //DEFINE EL PROCESO ACTUAL COMO ACTIVO EN LA PARTICION
                if(particion.getProcesoActivo() == null){
                    particion.setProcesoActivo(p);
                    return true;
                }else{
                    //SI LA PARTICION TIENE PROCESO ACTIVO
                    //AGREGA EL PROCESO ACTUAL A LA COLA DE
                    //LA PARTICION
                    particion.agregarCola(p);
                    return true;
                }
            }
        }
        return false;
    }
}

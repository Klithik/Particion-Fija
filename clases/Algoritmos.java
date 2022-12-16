package clases;

import java.util.ArrayList;

public class Algoritmos{
    static ArrayList<Particion> particiones = null;

    public static void setParticiones(ArrayList<Particion> p){
        particiones = p;
    }
    public String ordenamientoStack(Proceso p){
        //BUSCA PARTICIONES VACIAS PARA INSERTAR EL PROCESO
        for (Particion particion : particiones) {
            if(p.getRecursos()<=particion.getRecursos()){
                if(particion.procesoActivo.equals(null)){
                    particion.setProcesoActivo(p);
                    return particion.toString();
                }
            }
        }

        //BUSCA LA COLA MAS CORTA A LA QUE AGREGAR EL PROCESO
        int menor_espera=0;
        Particion menor = null;
        for (Particion particion : particiones) {
            if(p.getRecursos()<=particion.getRecursos()){
                int suma = particion.getProcesoActivo().getDuracion();
                //REVISA SI HAY ELEMENTOS EN LA COLA Y CUAL ES LA ESPERA TOTAL EN ESA COLA
                if(particion.getCola().size()!=0){
                    for (Proceso proceso : particion.getCola()) {
                        suma=+proceso.getDuracion();
                    }
                }
                //SI LA ENCONTRADA ES LA MAS CORTA HASTA EL MOMENTO GUARDA SU INFORMACION PARA USO FUTURO
                if(suma<menor_espera){
                    menor_espera=suma;
                    menor=particion;
                }
            }
        }

        //SI LA VARIABLE MENOR SIGUE NULA ES PORQUE NINGUNA COLA ERA ADECUADA PARA EL PROCESO
        if(menor.equals(null)){
            return "Ninguna particion válida para el proceso";
        }else{
            //SI MENOR NO ES NULO ES PORQUE ENCONTRO UNA OPCION EN LA QUE INGRESAR EL PROCESO
            menor.agregarCola(p);
            return menor.toString();
        }
    }
}

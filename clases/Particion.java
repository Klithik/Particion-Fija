package clases;

import java.util.ArrayList;

public class Particion {
    Integer recursos; //RECURSOS DISPONIBLES EN LA PARTICION (EN MB)
    Proceso procesoActivo; //PROCESO ACTUALMENTE ALOJADO EN LA PARTICION
    ArrayList<Proceso> cola; //COLA DE PROCESOS DE LA PARTICION

    //CONSTRUCTORES
    public Particion(){
        recursos = null;
        procesoActivo = null;
    }

    public Particion(Integer rec){
        recursos = rec;
    }

    //GETTERS Y SETTERS
    public Integer getRecursos() {
        return recursos;
    }

    public void setRecursos(Integer recursos) {
        this.recursos = recursos;
    }

    public Proceso getProcesoActivo() {
        return procesoActivo;
    }

    public void setProcesoActivo(Proceso procesoActivo) {
        this.procesoActivo = procesoActivo;
    }

    public ArrayList<Proceso> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Proceso> cola) {
        this.cola = cola;
    }

    public void agregarCola(Proceso p){
        cola.add(p);
    }

    public Boolean avanzarCola(){
        if(cola.equals(null)){
            procesoActivo = null;
            return true;
        }else{
            try{
                Proceso p = cola.remove(0);
                procesoActivo = p;
            }catch(Exception e){
                System.out.println(e.toString());
            }
            return true;
        }
    }
}

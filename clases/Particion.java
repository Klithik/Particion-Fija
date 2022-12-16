package clases;

import java.util.ArrayList;

public class Particion {
    Integer recursos; //RECURSOS DISPONIBLES EN LA PARTICION (EN MB)
    Proceso procesoActivo; //PROCESO ACTUALMENTE ALOJADO EN LA PARTICION
    ArrayList<Proceso> cola = new ArrayList<Proceso>(); //COLA DE PROCESOS DE LA PARTICION

    //CONSTRUCTORES
    public Particion(){
        recursos = null;
        procesoActivo = null;
    }

    public Particion(Integer rec){
        recursos = rec;
        procesoActivo = null;
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
        try{
            if(this.cola.isEmpty()){
                this.procesoActivo = null;
                return true;
            }else{
                Proceso p = this.cola.remove(0);
                this.procesoActivo = p;
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return true;
    }
}

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
        return this.procesoActivo;
    }

    public void setProcesoActivo(Proceso p) {
        this.procesoActivo = p;
    }

    public ArrayList<Proceso> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Proceso> cola) {
        this.cola = cola;
    }

    //AGREGA EL PROCESO P A LA COLA
    public void agregarCola(Proceso p){
        cola.add(p);
    }

    //AVANZA LA COLA
    public Boolean avanzarCola(){
        try{
            //SI LA COLA ESTA VACIA Y SE ESTABLECE COMO NULO EL PROCESO ACTIVO
            //SIGNIFICANDO QUE ESA PARTICION ESTA INACTIVA
            if(this.cola.isEmpty()){
                this.procesoActivo = null;
                return true;
            }else{
                //SI EL LA COLA NO ESTA VACIA, SE QUITA EL PRIMER ELEMENTO Y SE COLOCA
                //COMO PROCESO ACTIVO DE LA PARTICION
                Proceso p = this.cola.remove(0);
                this.procesoActivo = p;
                return true;
            }
        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
}

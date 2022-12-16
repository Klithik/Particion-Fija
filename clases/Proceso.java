package clases;

public class Proceso {
    Integer pid;
    Integer duracion;
    Integer recursos;

    //CONSTRUCTORES
    public Proceso(){
        pid = null;
        duracion = null;
        recursos = null;
    }

    public Proceso(Integer id,Integer dur,Integer rec){
        pid = id;
        duracion = dur;
        recursos = rec;
    }
}

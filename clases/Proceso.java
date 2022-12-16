package clases;

public class Proceso {
    Integer pid; //ID DEL PROCESO
    Integer duracion; //TIEMPO DE EJECUCION DEL PROCESO
    Integer recursos; //RECURSOS EXIGIDOS POR EL PROCESO (EN MB)

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

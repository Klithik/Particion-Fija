package clases;

public class Proceso {
    Integer duracion; //TIEMPO DE EJECUCION DEL PROCESO
    Integer recursos; //RECURSOS EXIGIDOS POR EL PROCESO (EN MB)

    //CONSTRUCTORES
    public Proceso(){
        duracion = null;
        recursos = null;
    }

    public Proceso(Integer dur,Integer rec){
        duracion = dur;
        recursos = rec;
    }

    public Proceso(String str){
        String[] partes = str.split(",");
        duracion = Integer.parseInt(partes[0]);
        recursos = Integer.parseInt(partes[1]);
    }

    //GETTERS Y SETERS
    public Integer getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getRecursos() {
        return recursos;
    }

    public void setRecursos(Integer recursos) {
        this.recursos = recursos;
    }

    //REDUCE EN 1 LA CANTIDAD DE SEGUNDOS DE UN PROCESO
    public void reduceDuracion(){
        this.duracion--;
    }
}

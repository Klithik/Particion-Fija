package clases;

public class Particion {
    Integer numero; //ID DE LA PARTICION
    Integer recursos; //RECURSOS DISPONIBLES EN LA PARTICION (EN MB)
    Proceso procesoActivo; //PROCESO ACTUALMENTE ALOJADO EN LA PARTICION
    Proceso[] cola; //COLA DE PROCESOS DE LA PARTICION

    //CONSTRUCTORES
    public Particion(){
        numero = null;
        recursos = null;
        procesoActivo = null;
    }

    public Particion(Integer n, Integer rec){
        numero = n;
        recursos = rec;
    }
}

public class Particion {
    Integer numero;
    Integer recursos;
    Proceso procesoActivo;
    Proceso[] cola;

    //CONSTRUCTORES
    public Particion(){
        numero = null;
        recursos = null;
        procesoActivo = null;
    }
}

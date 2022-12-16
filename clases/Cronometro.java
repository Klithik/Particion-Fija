package clases;

public class Cronometro extends Thread{
    int segundos = 0;

    public void run(){
        try{
            while(true){
                Thread.sleep(1000);
                segundos++;
            }
        }catch(Exception e){
            System.out.println("Error en el hilo Cronometro");
            System.out.println(e.toString());
        }
    }

    public int getSegundos(){
        return this.segundos;
    }
}

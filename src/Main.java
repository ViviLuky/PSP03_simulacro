import java.util.concurrent.Semaphore;

public class Main {
    public static String[] colores;
     static {
         colores= new String[]{"rojo","verde","azul","rojo","azul","rojo","violeta"};
     }
    public static void main(String[] args) {

        Semaphore semaphore=new Semaphore(1);
        Hilohijo rojo=new Hilohijo("rojo",semaphore);
        Hilohijo azul=new Hilohijo("azul",semaphore);
        Hilohijo verde=new Hilohijo("verde",semaphore);

        rojo.start();
        azul.start();
        verde.start();

        try {
            rojo.join();
            azul.join();
            verde.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total Colores " +Hilohijo.coontadorTotal);
    }
}
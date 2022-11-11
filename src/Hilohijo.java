import java.util.concurrent.Semaphore;

public class Hilohijo extends Thread{

    public static int contador=0;
    public static int coontadorTotal;
   private Semaphore semaphore;

    public Hilohijo(String name, Semaphore semaphore){
        super(name);
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            contador=0;
            for (String color : Main.colores) {
                if(color.equals(this.getName())) {
                    contador++;
                    coontadorTotal++;
                }
            }
            System.out.println("soy " +this.getName()+ " tengo "+contador+ "colores");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}

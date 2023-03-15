import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ExemploThread extends Thread {
     private static final double TOTAL_NUMEROS = 2_000_000_000;
     private static final int THREADS = 12;
     private static final int SUB_TOTAL = (int) (TOTAL_NUMEROS / THREADS);
     private Random radom = new Random();
     //private List<Double> numeros = new ArrayList<>(SUB_TOTAL);

     public static void main(String[] args) throws InterruptedException{          
        Instant startTime2 = Instant.now();

          var threads = new Thread[THREADS];
          for (int i = 0; i < THREADS; i++) {
               var t = new ExemploThread();
               threads[i]= t;
               t.start();
          }

          for (Thread thread : threads) {
               thread.join();               
          }          
          Duration totalTime2 = Duration.between(startTime2, Instant.now());
          System.out.println("Intant time: " + totalTime2);         

     }

     public void run() {
          double soma=0;
          for (int i = 0; i < SUB_TOTAL; i++) {
               //numeros.add(radom.nextDouble());
               soma += Math.pow(radom.nextDouble(), 10);
          }
          //System.out.println("A soma é: " + soma);
     }
}
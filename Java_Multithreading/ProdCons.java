package Assignment;

import java.util.LinkedList;

public class ProdCons
{
 public static void main(String[] args)
                     throws InterruptedException
 {
     final PC pc = new PC();

     Thread t1 = new Thread(new Runnable()
     {
         @Override
         public void run()
         {
             try
             {
                 pc.produce();
             }
             catch(InterruptedException e)
             {
                 e.printStackTrace();
             }
         }
     });

     Thread[] t = new Thread[10];
    
     for(int i=0;i<10;i++){
     Thread t2 = new Thread(new Runnable()
     {
         @Override
         public void run()
         {
             try
             {
                 pc.consume();
             }
             catch(InterruptedException e)
             {
                 e.printStackTrace();
             }
         }
     });
     t[i] = t2;
     }
     
     t1.start();
     for(int i=0;i<10;i++)
    	 t[i].start();

    
     t1.join();
     for(int i=0;i<10;i++)
    	 t[i].join();
 }

 
 public static class PC
 {
     
     LinkedList<Integer> list = new LinkedList<>();
     int capacity = 5;

     
     public void produce() throws InterruptedException
     {
         int value = 0;
         while (true)
         {
             synchronized (this)
             {
                 
                 while (list.size()==capacity)
                     wait();

                 System.out.println("Producer produced-"
                                               + value);

                 
                 list.add(value++);

                 notify();

                 Thread.sleep(1000);
             }
         }
     }

     public void consume() throws InterruptedException
     {
         while (true)
         {
             synchronized (this)
             {
                 while (list.size()==0)
                     wait();

                 int val = list.removeFirst();

                 System.out.println("Consumer consumed-"
                                                 + val);

                 
                 notify();

                 Thread.sleep(1000);
             }
         }
     }
 }
}
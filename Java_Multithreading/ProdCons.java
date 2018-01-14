package Assignment;

//Java program to implement solution of producer
//consumer problem.
import java.util.LinkedList;

public class ProdCons
{
 public static void main(String[] args)
                     throws InterruptedException
 {
     // Object of a class that has both produce()
     // and consume() methods
     final PC pc = new PC();

     // Create producer thread
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
     // Create consumer thread1
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
     // Start both threads
     t1.start();
     for(int i=0;i<10;i++)
    	 t[i].start();

     // t1 finishes before t2
     t1.join();
     for(int i=0;i<10;i++)
    	 t[i].join();
 }

 // This class has a list, producer (adds items to list
 // and consumber (removes items).
 public static class PC
 {
     // Create a list shared by producer and consumer
     // Size of list is 2.
     LinkedList<Integer> list = new LinkedList<>();
     int capacity = 5;

     // Function called by producer thread
     public void produce() throws InterruptedException
     {
         int value = 0;
         while (true)
         {
             synchronized (this)
             {
                 // producer thread waits while list
                 // is full
                 while (list.size()==capacity)
                     wait();

                 System.out.println("Producer produced-"
                                               + value);

                 // to insert the jobs in the list
                 list.add(value++);

                 // notifies the consumer thread that
                 // now it can start consuming
                 notify();

                 // makes the working of program easier
                 // to  understand
                 Thread.sleep(1000);
             }
         }
     }

     // Function called by consumer thread
     public void consume() throws InterruptedException
     {
         while (true)
         {
             synchronized (this)
             {
                 // consumer thread waits while list
                 // is empty
                 while (list.size()==0)
                     wait();

                 //to retrive the ifrst job in the list
                 int val = list.removeFirst();

                 System.out.println("Consumer consumed-"
                                                 + val);

                 // Wake up producer thread
                 notify();

                 // and sleep
                 Thread.sleep(1000);
             }
         }
     }
 }
}
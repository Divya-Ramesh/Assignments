import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ProdConsExecutors {
	public static void main(String args[])
    {
        try
        {
            Broker broker = new Broker();
 
            ExecutorService threadPool = Executors.newFixedThreadPool(11);
 
 
            threadPool.execute(new Consumer("1", broker));
            threadPool.execute(new Consumer("2", broker));
            threadPool.execute(new Consumer("3", broker));
            threadPool.execute(new Consumer("4", broker));
            threadPool.execute(new Consumer("5", broker));
            threadPool.execute(new Consumer("6", broker));
            threadPool.execute(new Consumer("7", broker));
            threadPool.execute(new Consumer("8", broker));
            threadPool.execute(new Consumer("9", broker));
            threadPool.execute(new Consumer("10", broker));
            Future producerStatus = threadPool.submit(new Producer(broker));
 
            producerStatus.get();
 
 
            threadPool.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable
{
    private Broker broker;
 
    public Producer(Broker broker)
    {
        this.broker = broker;
    }
 
 
    @Override
    public void run()
    {
        try
        {
            for(int i=1;i<10;i++)
            {
                System.out.println("Producer produced: " + i);
                Thread.sleep(100);
                broker.put(i++);
            }
 
            this.broker.continueProducing = Boolean.FALSE;
            System.out.println("Producer finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
 
    }
}

class Consumer implements Runnable
{
 
    private String name;
    private Broker broker;
 
 
    public Consumer(String name, Broker broker)
    {
        this.name = name;
        this.broker = broker;
    }
 
 
    @Override
    public void run()
    {
        try
        {
            Integer data = broker.get();
 
            while (broker.continueProducing || data != null)
            {
                Thread.sleep(1000);
                System.out.println("Consumer " + this.name + " processed data from broker: " + data);
 
                data = broker.get();
            }
 
 
            System.out.println("Comsumer " + this.name + " finished its job; terminating.");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
 
}

class Broker
{
    public ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
    public Boolean continueProducing = Boolean.TRUE;
 
    public void put(Integer data) throws InterruptedException
    {
        this.queue.put(data);
    }
 
    public Integer get() throws InterruptedException
    {
        return this.queue.poll(1, TimeUnit.SECONDS);
    }
}
package com.au.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdConsExecutors {
	private static final Logger logger =
	        Logger.getLogger(ProdConsExecutors.class.getName());
	public static void main(String[] args) {
		try {
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
		} catch (Exception e) {
			logger.log(Level.WARNING,"Error1",e);
			Thread.currentThread().interrupt();
		}
	}
}
package com.au.threading;

import java.util.logging.Level;
import java.util.logging.Logger;

class Consumer implements Runnable {

	private String name;
	private Broker broker;
	private static final Logger logger =
	        Logger.getLogger(ProdConsExecutors.class.getName());
	public Consumer(String name, Broker broker) {
		this.name = name;
		this.broker = broker;
	}

	@Override
	public void run() {
		try {
			Integer data = broker.get();

			while (broker.getContinueProducing() || data != null) {
				Thread.sleep(1000);
				logger.log(Level.INFO,"Output2","Consumer " + this.name + " processed data from broker: " + data);

				data = broker.get();
			}
			logger.log(Level.INFO,"Output3","Comsumer " + this.name + " finished its job; terminating.");
		} catch (InterruptedException ex) {
			logger.log(Level.WARNING,"Error3",ex);
			Thread.currentThread().interrupt();
		}
	}

}


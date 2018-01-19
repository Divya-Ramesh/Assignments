package com.au.threading;

import java.util.logging.Level;
import java.util.logging.Logger;

class Producer implements Runnable {
	private Broker broker;
	private static final Logger logger =
	        Logger.getLogger(ProdConsExecutors.class.getName());
	public Producer(Broker broker) {
		this.broker = broker;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i < 10; i++) {
				logger.log(Level.INFO,"Output","Producer produced: " + i);
				Thread.sleep(100);
				broker.put(i);
			}

			this.broker.setContinueProducing(Boolean.FALSE);
			logger.log(Level.INFO,"Output1","Producer finished its job; terminating.");
		} catch (InterruptedException ex) {
			logger.log(Level.WARNING,"Error2",ex);
			Thread.currentThread().interrupt();
		}

	}
}
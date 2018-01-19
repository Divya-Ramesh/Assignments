package com.au.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

class Broker {
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
	private Boolean continueProducing = Boolean.TRUE;

	public void put(Integer data) throws InterruptedException {
		this.queue.put(data);
	}

	public Integer get() throws InterruptedException {
		return this.queue.poll(1, TimeUnit.SECONDS);
	}

	public Boolean getContinueProducing() {
		return continueProducing;
	}

	public void setContinueProducing(Boolean continueProducing) {
		this.continueProducing = continueProducing;
	}
}
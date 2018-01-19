package com.au.threading;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdCons {
	private static final Logger logger =
	        Logger.getLogger(ProdCons.class.getName());

	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();

		Thread t1 = new Thread(() -> {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					logger.log(Level.WARNING,"Error",e);
					Thread.currentThread().interrupt();
				}
			});

		Thread[] t = new Thread[10];

		for (int i = 0; i < 10; i++) {
			Thread t2 = new Thread(() -> {
					try {
						pc.consume();
					} catch (InterruptedException e) {
						logger.log(Level.WARNING,"Error",e);
						Thread.currentThread().interrupt();
					}
				});
			t[i] = t2;
		}

		t1.start();
		for (int i = 0; i < 10; i++)
			t[i].start();

		t1.join();
		for (int i = 0; i < 10; i++)
			t[i].join();
	}

	public static class PC {

		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 5;
		int x = 0;
		public void produce() throws InterruptedException {
			int value = 0;
			while (x==0) {
				synchronized (this) {

					while (list.size() == capacity)
						wait();

					logger.log(Level.INFO,"Output","Producer produced-" + value);

					list.add(value++);

					notifyAll();

					this.wait(1000);
				}
			}
		}

		public void consume() throws InterruptedException {
			while (x==0) {
				synchronized (this) {
					while (list.isEmpty())
						wait();

					int val = list.removeFirst();

					logger.log(Level.INFO,"Output","Consumer consumed-" + val);

					notifyAll();

					this.wait(1000);
				}
			}
		}
	}
}
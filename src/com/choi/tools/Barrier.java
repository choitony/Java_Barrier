package com.choi.tools;

public class Barrier {

	private int count;

	private InterruptedException iex;

	public Barrier(int nThreads) {
		this.count = nThreads;
	}

	public synchronized int waitForRest() throws InterruptedException {
		if (iex != null)
			throw iex;
		count--;
		if (count <= 0) {
			notifyAll();
			return count;
		}
		while (count > 0) {
			if(iex!=null)
				throw iex;
			try {
				wait();
			} catch (InterruptedException e) {
				iex = e;
				notifyAll();
			}
		}
		return count;
	}
}

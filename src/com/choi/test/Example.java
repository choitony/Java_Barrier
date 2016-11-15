package com.choi.test;

import com.choi.tools.Barrier;

public class Example implements Runnable{

	private Barrier barrier1;
	
	private Barrier barrier2;
	@Override
	public void run() {
		System.out.println("开始");
		try {
			barrier1.waitForRest();
		} catch (InterruptedException e) {
			System.out.println("laiyige yichang");
		}
		System.out.println("第一阶段结束");
		try {
			barrier2.waitForRest();
		} catch (Exception e) {
		}
		System.out.println("第二阶段结束");
	}
	
	public Example(int nThreads){
		barrier1 = new Barrier(nThreads);
		barrier2 = new Barrier(nThreads);
	}
	
	public static void main(String[] args){
		Example example = new Example(10);
		Thread[] threads = new Thread[10];
		for(int i=0; i<10; i++){
			threads[i] = new Thread(example);
			threads[i].start();
		}
	}
}

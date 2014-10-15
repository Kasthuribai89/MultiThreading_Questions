package com.sukanya.producer_Consumer;

public class ProducerConsumer_Main 
{
	public static void main(String args[])
	{
		blockingQueue queue = new blockingQueue();
		Producer producer1 = new Producer(queue,1);
		Consumer consumer1 = new Consumer(queue,1);
		producer1.start();
		consumer1.start();
		
	}

}

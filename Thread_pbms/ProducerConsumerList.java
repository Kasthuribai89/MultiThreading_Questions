package Thread1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerList 
{
	public static void main(String args[]) throws InterruptedException
	{
		final PrdCon pc = new PrdCon();
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				try {
					pc.produce();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
			}
		});
	
		
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				try {
					pc.consume();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	
	}
}

class PrdCon
{
	LinkedList<Integer> list = new LinkedList<Integer>();
	private int Limit = 10;
	int value = 0;
	private Object lock = new Object();
	public void produce() throws InterruptedException
	{
		while(true)
		{
			synchronized(lock)
			{
				while(list.size() == Limit)
					lock.wait();
				list.add(value++);
				lock.notify();
			}
		}
	}
	public void consume() throws InterruptedException
	{
		Random random = new Random();
		while(true)
		{
			synchronized(lock)
			{
				while(list.size() == 0)
				lock.wait();
				System.out.print("List size is "+list.size());
				Integer val = list.removeFirst();
				System.out.println("; Value is "+val);
				lock.notify();
			
			}
			
			Thread.sleep(random.nextInt(1000));
		}
	}
}

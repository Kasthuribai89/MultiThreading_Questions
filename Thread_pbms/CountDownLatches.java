package Thread1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

// Countdown latch is used to run a particular steps for particular number of times. :)

public class CountDownLatches 
{
	public static void main(String args[]) throws InterruptedException
	{
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService execute = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<5;i++)
		{
			execute.submit(new Processor(latch,i));
		}
		latch.await();
		execute.shutdown();
	}
}

class Processor implements Runnable
{
	private CountDownLatch latch;
	private int id = 0;
	
	public Processor(CountDownLatch latch,int id)
	{
		this.latch = latch;
		this.id = id;
	}
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " Starting id is .. "+ id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		latch.countDown();
		System.out.println(Thread.currentThread().getName() + " Ending id is .. "+ id);
	}
	
	
}

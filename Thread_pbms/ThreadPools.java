package Thread1;

// Thread pool is used to manage threads . 
// It creates the thread and manage itself till it ends

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools
{
	public static void main(String args[])
	{
		ExecutorService excecute = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++)
		{
			excecute.execute((new Process(i)));
		}
		
		excecute.shutdown();
	}
}

class Process implements Runnable
{
	private int id ;
	public Process(int id)
	{
		this.id = id;
	}
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " Starting id is .. "+ id);
		try
		{
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			
		}
		
		System.out.println(Thread.currentThread().getName() + " Ending id is .. "+ id);
	}
}

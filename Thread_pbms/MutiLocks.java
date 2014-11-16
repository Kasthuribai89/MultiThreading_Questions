package Thread1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MutiLocks 
{
	
	public static void main(String args[])
	{
		
		
		LockExample lck = new LockExample();
		lck.main_this();
		
		
	}
}
class LockExample
{
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	Random random = new Random();
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	
	public void method1()
	{
		synchronized(lock1)
		{
		try
		{
		Thread.sleep(1);	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		list1.add(random.nextInt(100));
		}
	}
	
	public void method2()
	{
		synchronized(lock2)
		{
		try
		{
		Thread.sleep(1);	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		list2.add(random.nextInt(100));
		}
	}
	
	public void process()
	{
		
		for(int i=0;i<1000;i++)
		{
		method1();
		method2();
		}
		
	}
	
	public void main_this()
	{
		System.out.println("Starting ...");
		long start = System.currentTimeMillis();
		new Thread(new Runnable()
		{
			public void run()
			{
				
				process();
			}
		}).start();;
		
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time is :" + (end - start));
		System.out.println("List 1 :"+list1.size() + " List 2 :" + list2.size());
	}

}

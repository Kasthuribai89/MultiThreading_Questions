package Thread1;

public class FirstThread 
{
	public static void main(String args[])
	{
		
		Thread2 t2 = new Thread2();
		t2.start();
		Thread t3 = new Thread(new Thread3());
		t3.start();
		Thread t4 = new Thread(new Runnable()
		{
			public void run()
			{

				for(int i=0;i<=10;i++)
				{
					System.out.println("Thread 4 :" + i);
				}
			}
		});
		t4.start();
		for(int i=0;i<=10;i++)
		{
			System.out.println("Main :" + i);
		}
	
	}
	
}

class Thread2 extends Thread
{
	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.println("Thread 2 :" + i);
		}
		
	}
}

class Thread3 implements Runnable
{
	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.println("Thread 3 :" + i);
		}
	}
}

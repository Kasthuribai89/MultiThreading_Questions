package Thread1;

//https://www.youtube.com/watch?v=lotAYC3hLVo&list=PLBB24CFB073F1048E&index=3

public class JoinExample 
{
	
	// Example for Join Keyword.
	// Example for Synchronized Keyword
	
	private int count = 0;
	
	public synchronized void increament()
	{
		count ++;
	}
	public static void main(String args[])
	{
		JoinExample join1 = new JoinExample();
		join1.doThis();
	}
	
	public void doThis()
	{
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=0;i<10000;i++)
				{
					increament();
					
				}
			}
		}
		);
		
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=0;i<10000;i++)
				{
					increament();
					
				}
			}
		}
		);
		
		t1.start();
		t2.start();
		try
		{
		t1.join();
		t2.join();
		}
		catch(Exception e)
		{
			
		}
		
		System.out.println(count);
	}

}

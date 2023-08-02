package Aggregate;
class SyncBlock {
  void tables(int num)
  {
	  synchronized(this)
	  {
		  try {
			  Thread.sleep(200);
	  for(int i=0;i<=5;i++)
	  {
		  System.out.println(i*num);
	  }
		  }
		  catch(Exception e)
		  {
			  
		  }
	  }
  }

}
class Tab extends Thread
{
	SyncBlock ob;
	Tab(SyncBlock ob)
	{
		this.ob=ob;
	}
	public void run()
	{
		ob.tables(5);
	}
}
class Max extends Thread 
{
	SyncBlock ob;
	Max(SyncBlock ob)
	{
		this.ob=ob;
	}
	public void run()
	{
		ob.tables(10);
	}
}
public class MainBlock
{
	public static void main(String args[])
	{
	SyncBlock ob = new SyncBlock();
	Tab t1 = new Tab(ob);
	Max t2 = new Max(ob);
	t1.start();
	t2.start();
	}
}
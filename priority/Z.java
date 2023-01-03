package priority;

public class Z implements Runnable{
	
	public void run(){
		System.out.println("Thread Z started");	
		for(int k = 0; k <= 4; k++)
		{
			System.out.println("Thread Z: " +k);	 
		}
		System.out.println("Exit from Z");
	}

}

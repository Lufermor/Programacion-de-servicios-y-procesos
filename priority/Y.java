package priority;

public class Y implements Runnable{
	
	public void run(){
		System.out.println("Thread Y started");	
		for(int j = 0; j <= 4; j++)
		{
			System.out.println("Thread Y: " +j);	 
		}
		System.out.println("Exit from Y");
	}

}

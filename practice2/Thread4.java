package practice2;

/*
 * This java class is used to calculate the final result (module) 
 * having the vectorResult of SharedData object completed
 */
public class Thread4 extends Thread{
	private SharedData data;
	private float module;
	
	public Thread4(SharedData data) {
		super();
		this.data = data;
		module = 0;
	}
	
	/*
	 * Pre: --- 
	 * Post: This method calculates the module of a vector and prints it on
	 * the console screen. The slower process id and time are also printed.
	 * 
	 */
	@Override
	public void run() {
		for (float n : data.getVectorResult()) module += Math.pow(n, 2);
		System.out.println("The resulting module = " + Math.sqrt(module));
		System.out.println("The maximum time required by the slower thread was: " + data.gettMax() + " miliseconds");
		System.out.println("Slower thread id: " + data.getIdSlower());
	}

}

package practice2;

/*
 * This java class is used to calculate the final result (module) 
 * having the vectorResult of SharedData object completed
 */
public class Thread2 extends Thread{
	private SharedData data;
	private float module;
	
	public Thread2(SharedData data) {
		super();
		this.data = data;
		module = 0;
	}
	
	/*
	 * Pre: ---
	 * Post: This method calculates the module of a vector 
	 * and prints it on the console screen
	 */
	@Override
		public void run() {
			float squaresSum = 0;
			for(float n : data.getVectorResult()) squaresSum += Math.pow(n, 2);
			System.out.println("The resulting module = " + Math.sqrt(squaresSum));
		}
	
}

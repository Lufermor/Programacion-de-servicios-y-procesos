package practice2;

/*
 * This java class creates several threads to perform large algebraic operations
 */
public class Exercise2 {
	
	/*
	 * Pre: ---
	 * Post: This method creates an data object with a matrix and vectors
	 * and creates threads to perform algebraic operations with them, and finally
	 * visualize the result 
	 */
	public static void main(String[] args) {
		SharedData data = new SharedData(512, 512);
		Thread3[] t = new Thread3[16]; //Array where the threads will be stored
		int rowsPerThread = data.getMatrix().length/t.length;
		for(int i = 0; i<t.length; i++) {
			t[i] = new Thread3(data, (i)*rowsPerThread, rowsPerThread, i);
		}
		
		for(int i = 0; i<t.length; i++) {
			t[i].start();
		}
		
		for(int i = 0; i<t.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		// Now we will create a last thread for calculating and printing the module
		Thread4 reporter = new Thread4(data); 
		reporter.start();
		try {
			reporter.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		for(int i = 0; i<data.getVectorResult().length; i++) {
//			System.out.println(data.getVectorResult()[i]);
//		}
		
		System.out.println("End");
	}
}

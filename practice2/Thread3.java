package practice2;
/*
 * This java class is used to create different Thread instances and make them 
 * work concurrently
 * Each instance's work is to get a partial result of a vector-matrix product. 
 */
public class Thread3 extends Thread{
	private SharedData data;
	private int i;
	private int rows;
	private int id;

	public Thread3(SharedData data, int i, int rows, int id) {
		super();
		this.data = data;
		this.i = i;
		this.rows = rows;
		this.id = id;
	}

	/*
	 * Pre: ---
	 * Post: This method contains the executable code for the thread
	 * Here the thread multiplies an scalar by an indicated matrix row and 
	 * saves the result in the data vector vectorResult. 
	 * Besides, it calculates the processing time and store it in the shared object 
	 */
	public void run() {
		long processingTime = System.currentTimeMillis();
		for(int j = 0; j < rows; j++) {
			float suma = 0;
			for(int k = 0; k < data.getMatrix()[i].length; k++) {
				suma += data.getVector1()[i] * data.getMatrix()[i][k];
			}
			data.getVectorResult()[i] = suma;
			i++;
		}
//		System.nanoTime()
		processingTime = System.currentTimeMillis() -  processingTime;
		System.out.println("Thread n: " + id + ", processing time= " + processingTime);
		data.setSlower(processingTime, id);
	}

}

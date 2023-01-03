package practice2;
/*
 * This java class is used to create different Thread instances and make them 
 * work concurrently
 * Each instance's work is to get a partial result of a vector-matrix product. 
 */
public class Thread1 extends Thread{
	private SharedData data;
	private int i;
	private int rows;

	public Thread1(SharedData data, int i, int rows) {
		super();
		this.data = data;
		this.i = i;
		this.rows = rows;
	}

	/*
	 * Pre: ---
	 * Post: This method contains the executable code for the thread
	 * Here the thread multiplies an scalar by an indicated matrix row and 
	 * saves the result in the data vector vectorResult 
	 */
	public void run() {
		for(int j = 0; j < rows; j++) {
			float suma = 0;
			for(int k = 0; k < data.getMatrix()[i].length; k++) {
				suma += data.getVector1()[i] * data.getMatrix()[i][k];
			}
			data.getVectorResult()[i] = suma; //Here the result is saved
			i++;
		}
	}

}

package practice2;

/*
 * This java class contains and initialize a few variables that will be shared
 * by many threads concurrently
 */
public class SharedData {
	private float[][] matrix; // Matrix that will be multiplied
	private float[] vector1; //Vector that will multiply the matrix
	private float[] vectorResult; //Vector where the product will be stored
	private int idSlower; //Slowest thread identifier 
	private long tMax; //Largest thread execution time 
	private boolean disponible = true;
	private boolean disponible2 = true;

	public SharedData(int m, int n) {
		matrix = new float[m][n]; 
		vector1  = new float[matrix[0].length]; 
		vectorResult  = new float[matrix[0].length];
		initialize();
		this.idSlower = -1;
		this.tMax = -1;
	}
	
	public float[][] getMatrix() {
		return matrix;
	}

	public float[] getVector1() {
		return vector1;
	}

	public float[] getVectorResult() {
		return vectorResult;
	}
	
	public int getIdSlower() {
		return idSlower;
	}

	public synchronized void setIdSlower(int idSlower) {
		while (!disponible){
			try{ 
				wait();
			}catch (InterruptedException e){}
		}
		disponible = false;
		this.idSlower = idSlower;
		disponible=true;
		notifyAll();
	}

	public long gettMax() {
		return tMax;
	}

	public synchronized void settMax(long tMax) {
		while (!disponible){
			try{ 
				wait();
			}catch (InterruptedException e){}
		}
		disponible = false;
		this.tMax = tMax;
		disponible=true;
		notifyAll();
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	/*
	 * Pre: ---
	 * Post: This method update in a synchronized way, two values of this class
	 * that would be used simultaneously by many threads
	 */
	public synchronized void setSlower(long t, int id) {
		if(this.tMax<=t) {
			this.tMax = t;
			this.idSlower = id;
		}
	}

	/*
	 * Pre: ---
	 * Post: This method fills the vector1 and matrix values
	 */
	private void initialize() {
		for(int i = 0; i<vector1.length; i++) {
//			vector1[i] = i;//(float)(Math.random()*11); //The vector is randomly filled
			vector1[i] = (float)(Math.random()*11); //The vector is randomly filled
			for(int j = 0; j<matrix[i].length; j++) {
//				matrix[i][j] = 1; //(float)(Math.random()*11); //The matrix is randomly filled
				matrix[i][j] = (float)(Math.random()*11); //The matrix is randomly filled
			}
		}
	}

}

package practice1;

public class MaxMin implements Runnable{
	private int max;
	private int min;
	private int[] datos;
	
	public MaxMin(int[] datos) {
		this.datos = datos;
		this.max = datos[0];
		this.min = datos[0];
	}
	
	/*
	 * Pre:---
	 * Post: This method calculates the maximum and minimum values of the vector
	 */
	public void run(){
		System.out.println("Starting maximum and minimum calculation");
		for(int n:datos) {
			if(n<min) min = n;
			else if(n>max) max = n;
		}
		System.out.println("The maximum value is: " + max + 
				"\nThe minimum value is: " + min);
		System.out.println("Exit from maximum and minimum calculation proccess");
	}

}

package practice1;

public class Media implements Runnable{
	private Double miMedia;
	private int[] datos;
	
	public Media(int[] datos) {
		this.miMedia = 0.0;
		this.datos = datos;
	}
	
	/*
	 * Pre:---
	 * Post: This method calculates the aritmetic mean of the vector
	 */
	public void run(){
		int suma = 0;
		System.out.println("Starting mean calculation");
		for(int i = 0; i<datos.length; i++){
			suma += datos[i]; 
		}
		miMedia = (double) (suma/datos.length);
		System.out.println("The arithmetic mean is: " + miMedia);
		System.out.println("Exit from mean calculation process");
	}

}

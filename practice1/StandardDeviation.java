package practice1;

public class StandardDeviation implements Runnable{
	private Double miMedia;
	private int[] datos;
	private Double[] cuadrados;
	
	public StandardDeviation(int[] datos) {
		this.miMedia = 0.0;
		this.datos = datos;
		cuadrados = new Double[datos.length];
	}
	
	/*
	 * Pre:---
	 * Post: This method calculates the standard deviation of the vector
	 */
	public void run(){
		int suma = 0;
		System.out.println("Starting standard deviation calculation");
//		First we need to calculate the mean again
		for(int i = 0; i<datos.length; i++){
			suma += datos[i]; 
		}
		miMedia = (double) (suma/datos.length);
		suma = 0;
		//Ahora calculamos los cuadrados de la diferencia de los valores con la media
		for(int i = 0; i<datos.length; i++){
			cuadrados[i] =  Math.pow((datos[i] - miMedia),2);
			suma += cuadrados[i]; 
		}
		Double varianza = (double) (suma/cuadrados.length);
		Double std = Math.sqrt(varianza);
		System.out.println("The standard deviation is: " + std);
		System.out.println("Exit from standard deviation calculation process");
	}

}

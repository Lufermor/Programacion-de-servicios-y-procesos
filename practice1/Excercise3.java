package practice1;


public class Excercise3 {
	/*
	 * Pre: ---
	 * Post: crea tres hilos distintos con sus atributos y los ejecuta
	 */
	public static void main(String[] args) {
		
		
		//Creamos el array de 100 enteros aleatorios:
		int[] numbers = new int[100];
		for(int i = 0; i<100; i++) numbers[i] = (int)(Math.random()*(300)+1);
		
		//Creación de hilos
		Media media = new Media(numbers);
		MaxMin maxMin = new MaxMin(numbers);
		StandardDeviation std = new StandardDeviation(numbers);
 
		Thread t1 = new Thread(media);
		Thread t2 = new Thread(maxMin);
		Thread t3 = new Thread(std);
		
		//Imprimimos la prioridad de los hilos
		System.out.println("t1 priority: " + t1.getPriority());
		System.out.println("t2 priority: " + t2.getPriority());
		System.out.println("t3 priority: " + t3.getPriority());
		
		//Inicialización de los hilos
		t1.start();
		t2.start();
		t3.start();
		
		//Esperamos a que terminen los hilos
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Fin");
	}

}

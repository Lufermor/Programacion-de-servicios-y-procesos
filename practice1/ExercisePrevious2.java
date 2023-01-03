package practice1;

import priority.Thread1;

public class ExercisePrevious2 {
	
	/*
	 * Pre: ---
	 * Post: crea tres hilos distintos con sus atributos y los ejecuta
	 */
	public static void main(String[] args) {
		//Creación de hilos
		Thread1[] t = new Thread1[3];
		t[0] = new Thread1("Soy A", 100, 10);
		t[1] = new Thread1("Soy B", 150, 15);
		t[2] = new Thread1("Soy C", 300, 5);
		
		//Imprimimos la prioridad de los hilos
		System.out.println("t[0] priority: " + t[0].getPriority());
		System.out.println("t[1] priority: " + t[1].getPriority());
		System.out.println("t[2] priority: " + t[2].getPriority());
		
		//Cambiamos la prioridad de los hilos
		t[0].setPriority(1);
		t[1].setPriority(1);
		t[2].setPriority(10);
		
		//Inicialización de los hilos
		t[0].start();
		t[1].start();
		t[2].start();
		
		//Esperamos a que terminen los hilos
		try {
			t[0].join();
			t[1].join();
			t[2].join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Fin");
	}

}

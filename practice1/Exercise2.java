package practice1;

public class Exercise2 {
		
	/*
	 * Pre: ---
	 * Post: crea tres hilos distintos con sus atributos y los ejecuta
	 */
	public static void main(String[] args) {
		//Creación de hilos
		Thread1 t1 = new Thread1("Soy 1", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t2 = new Thread1("Soy 2", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t3 = new Thread1("Soy 3", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t4 = new Thread1("Soy 4", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t5 = new Thread1("Soy 5", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t6 = new Thread1("Soy 6", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t7 = new Thread1("Soy 7", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t8 = new Thread1("Soy 8", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t9 = new Thread1("Soy 9", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		Thread1 t10 = new Thread1("Soy 10", ((int)(Math.random()*(300-100+1))+100), ((int)(Math.random()*(15-5+1))+5));
		
		
		//Inicialización de los hilos
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();

		//Esperamos a que terminen los hilos
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
			t9.join();
			t10.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Fin");
	}
}

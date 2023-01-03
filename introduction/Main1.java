package introduction;
/*
 * Clase que realiza pruebas sobre la clase objeto Thread1
 */
public class Main1 {
	/*
	 * Pre: ---
	 * Post: crea tres hilos distintos con sus atributos y los ejecuta
	 */
	public static void main(String[] args) {
		//Creación de hilos
		Thread1 t1 = new Thread1("Soy A", 100, 10);
		/*
		Thread1 t2 = new Thread1("Soy B", 150, 15);
		Thread1 t3 = new Thread1("Soy C", 300, 5);
		Thread1 t4 = new Thread1("Soy D", 400, 5);
		Thread1 t5 = new Thread1("Soy E", 500, 5);
		Thread1 t6 = new Thread1("Soy F", 600, 5);
		*/
		
		//Inicialización de los hilos
		t1.start();
		Thread1 t2 = new Thread1("Soy B", 150, 15, t1.getContador());
		//Nada, esto no funciona, los contadores empiezan en 1 todos
		t2.start();
		Thread1 t3 = new Thread1("Soy C", 300, 5, t2.getContador());
		t3.start();
		Thread1 t4 = new Thread1("Soy D", 400, 5, t3.getContador());
		t4.start();
		Thread1 t5 = new Thread1("Soy E", 500, 5, t4.getContador());
		t5.start();
		Thread1 t6 = new Thread1("Soy F", 600, 5, t5.getContador());
		t6.start();
		
		//Esperamos a que terminen los hilos
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Fin");
	}
}

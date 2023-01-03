package priority;
/*
 * Clase que realiza pruebas sobre la clase objeto Thread1
 */
public class MainEjercicioClase2 {
	/*
	 * Pre: ---
	 * Post: crea tres hilos distintos con sus atributos y los ejecuta
	 */
	public static void main(String[] args) {
		//Creación de hilos
		Thread1 t1 = new Thread1("Soy A", 100, 10);
		Thread1 t2 = new Thread1("Soy B", 100, 10);
		Thread1 t3 = new Thread1("Soy C", 100, 10);
		
		//Imprimimos la prioridad de los hilos
		System.out.println("t1 priority: " + t1.getPriority());
		System.out.println("t2 priority: " + t2.getPriority());
		System.out.println("t3 priority: " + t3.getPriority());
		
		//Cambiamos la prioridad de los hilos
		t1.setPriority(1);
		t2.setPriority(1);
		t3.setPriority(10);
		
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

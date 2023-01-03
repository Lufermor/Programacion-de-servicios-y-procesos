package introduction;

public class Thread1 extends Thread{
	private String message;
	private int retardo;
	private int veces;
	private int contador;
	
	public Thread1(String message, int retardo, int veces) {
		super();
		this.message = message;
		this.retardo = retardo;
		this.veces = veces;
		this.contador = 0;
	}
	
	public Thread1(String message, int retardo, int veces, int contador) {
		super();
		this.message = message;
		this.retardo = retardo;
		this.veces = veces;
		this.contador = contador;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRetardo() {
		return retardo;
	}

	public void setRetardo(int retardo) {
		this.retardo = retardo;
	}

	public int getVeces() {
		return veces;
	}

	public void setVeces(int veces) {
		this.veces = veces;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	/*
	 * Pre: ---
	 * Post: This method will contain the executable code for the thread
	 */
	public void run() {
		for(int i = 0; i < veces; i++) {
			contador++;
			System.out.println(message + " " + contador);
			try {
				// Paraliza la ejecución del hilo [retardo] milisegundos
				Thread.sleep(retardo);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Thread1 [message=" + message + ", retardo=" + retardo + ", veces=" + veces + ", contador=" + contador
				+ "]";
	}
	
}

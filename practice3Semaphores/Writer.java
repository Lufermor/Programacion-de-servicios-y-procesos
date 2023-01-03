package practice3Semaphores;
/*
 * This java class is used to create different Thread instances and make them 
 * work concurrently
 * Each instance's work is to adding messages in a queue. 
 */
public class Writer extends Thread{
	//Attributes
	private SharedData data;
	private String message;
	private int id;
	private int nEscrituras;

	//Constructor
	public Writer(SharedData data, int id, int nEscrituras) {
		super();
		this.data = data;
		getRandomMessage();
		this.id = id;
		this.nEscrituras = nEscrituras;
	}
	
	/*
	 * Pre: ---
	 * Post: This method gets a random message from the string array in sharedData
	 */
	public void getRandomMessage() {
		/*We randomly pick a message from an array of words, 
		 * this array can be easily replaced by any array of strings*/  
		message = data.getPalabras()[(int)(Math.random()*(data.getPalabras().length))];
		//We make sure the message is not too short:
		if(message.length()<3)
			message += " " + data.getPalabras()[(int)Math.random()*(data.getPalabras().length)];
	}
	
	/*
	 * Pre: ---
	 * Post: This method contains the executable code for the thread
	 * Here the thread get a random string from an string array, and push it 
	 * in the queue 
	 * Besides, it calculates the processing time and prints it in the console 
	 */
	public void run() {
		long processingTime = System.currentTimeMillis();
		boolean messageAdded = false; //This variable will help us to avoid an infinite loop and lost messages
		for(int i = 0; i < nEscrituras; i++) {
			if(messageAdded) getRandomMessage();
			try { //Asking for permission from the semaphores:
				System.out.println("Writer " + this.id + " requesting permission 1");
				data.getWrite().acquire(); 
				System.out.println("Writer " + this.id + " requesting permission 2");
				data.getMutex().acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Writer " + this.id + " working");
			/*We store the boolean result in a variable to check if the operation succeeded,
			 * if not, then we try the iteration again with the same message:*/ 
			messageAdded = data.getQueue().pushString(message);
			
			if(messageAdded) {
				System.out.println("Writer tread id: " + this.id + ", message writed: " + message);
				data.getRead().release();
				data.setTotalWrited(data.getTotalWrited()+1);
				System.out.println("Total written messages = " + data.getTotalWrited());
			}
			else {
				System.out.println("Writer tread id: " + this.id + ", messaje \"" + message + "\" not writed");
				i--;
			}
			System.out.println("Messages in the queue: " + data.getQueue().getSize());
			
			// Finally send release signal to the mutex semaphore
			System.out.println("Writer " + this.id + " releasing permission 2");
			data.getMutex().release();
			
		}
		processingTime = System.currentTimeMillis() -  processingTime;
		System.out.println("Writer thread n " + id + " finished. Processing time = " + processingTime);
	}

}

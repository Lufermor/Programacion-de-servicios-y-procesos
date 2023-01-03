package practice3Semaphores;
/*
 * This java class is used to create different Thread instances and make them 
 * work concurrently
 * Each instance's work is to extract and print messages from a queue. 
 */
public class Reader extends Thread{
	private SharedData data;
	private int nLecturas;
	private int id;
	private String message;
	
	public Reader(SharedData data, int id, int nLecturas) {
		super();
		this.data = data;
		this.id = id;
		this.nLecturas = nLecturas;
		this.message = "";
	}

	/*
	 * Pre: ---
	 * Post: This method contains the executable code for the thread
	 * Here the thread gets the next available string from the queue and prints it.
	 * Besides, it calculates the processing time and prints it in the console 
	 */
	public void run() {
		long processingTime = System.currentTimeMillis();
		boolean messageReaded = false; //This variable will help us to avoid an infinite loop
		for(int i = 0; i < nLecturas; i++) {
			if(data.getQueue().getSize() > 0) {//We use this condition to try to prevent the program from crashing
				try { //Asking for permission from the semaphores:
					System.out.println("Reader " + this.id + " requesting permission 1");
					if(data.getQueue().getSize() > 0) data.getRead().acquire(); 
					else {
						System.out.println("Reader " + this.id + ": the queue is empty");
						i--;
						continue;
					}
					System.out.println("Reader " + this.id + " requesting permission 2");
					data.getMutex().acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("Reader " + this.id + " the queue is empty, skipping iteration");
				i--;
				continue;
			}
			System.out.println("Reader " + this.id + " WORKING!!!");
			/*We store the boolean result in a variable to check if the operation succeeded,
			 * if not, then we'll try the iteration again with the same message:*/ 
			if(!data.getQueue().isEmpty()) {
				message = data.getQueue().pop().getContent();
				if(message != null) {
					messageReaded = true;
					data.setTotalReaded(data.getTotalReaded()+1);
					System.out.println("Reader " + this.id + " releasing 1 seat in the queue");
					data.getWrite().release();
				}else {
					System.out.println("message reader = null");
					messageReaded = false;
					i--;
				}
			}else {
				messageReaded = false;
				i--;
				System.out.println("Can't read a new message, queue is empty");
			}
			if(messageReaded) {
				System.out.println("Reader tread id: " + this.id + ", message readed: " + message);
				System.out.println("Total messages read = " + data.getTotalReaded());
				System.out.println("Messages in the queue: " + data.getQueue().getSize());
			}
			// Finally send release signal to mutex semaphore
			System.out.println("Reader " + this.id + " releasing permission 2");
			data.getMutex().release();
		}
		processingTime = System.currentTimeMillis() -  processingTime;
		System.out.println("Reader thread n " + this.id + " finished. Processing time = " + processingTime);
	}

}

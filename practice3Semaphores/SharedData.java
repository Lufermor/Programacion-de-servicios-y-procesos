package practice3Semaphores;

import java.util.concurrent.Semaphore;

/*
 * This java class contains and initialize a few variables that will be shared
 * by many threads concurrently
 */
public class SharedData {
	//Attributes
	private ConcurrentQueue queue;
	private String[] palabras;
	private Semaphore write;
	private Semaphore read;
	private Semaphore mutex;
	private int totalWrited;
	private int totalReaded;

	//Constructors
	public SharedData(ConcurrentQueue queue) {
		this.queue = queue;
		write = new Semaphore(10);
		read = new Semaphore(0);
		mutex = new Semaphore(1);
		fillPalabras();
		this.totalWrited = queue.getSize();
		this.totalReaded = 0;
	}

	public SharedData() {
		this.queue = new ConcurrentQueue();
		write = new Semaphore(10);
		read = new Semaphore(0);
		mutex = new Semaphore(1);
		fillPalabras();
		this.totalWrited = 0;
		this.totalReaded = 0;
	}

	//Getters and setters
	public ConcurrentQueue getQueue() {
		return queue;
	}

	public void setQueue(ConcurrentQueue queue) {
		this.queue = queue;
	}

	public String[] getPalabras() {
		return palabras;
	}

	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}
	
	public Semaphore getWrite() {
		return write;
	}

	public void setWrite(Semaphore write) {
		this.write = write;
	}

	public Semaphore getRead() {
		return read;
	}

	public void setRead(Semaphore read) {
		this.read = read;
	}
	
	public Semaphore getMutex() {
		return mutex;
	}

	public void setMutex(Semaphore mutex) {
		this.mutex = mutex;
	}

	public int getTotalWrited() {
		return totalWrited;
	}

	public void setTotalWrited(int totalWrited) {
		this.totalWrited = totalWrited;
	}

	public int getTotalReaded() {
		return totalReaded;
	}

	public void setTotalReaded(int totalReaded) {
		this.totalReaded = totalReaded;
	}

	/*
	 * Pre: ---
	 * Post: This method fills the palabras array 
	 */
	public void fillPalabras() {
		String poema = "Brother, I’ve seen some "
				+ "Astonishing sights: "
				+ "A lion keeping watch "
				+ "Over pasturing cows; "
				+ "A mother delivered "
				+ "After her son was; "
				+ "A guru prostrated "
				+ "Before his disciple; "
				+ "Fish spawning "
				+ "On treetops; "
				+ "A cat carrying away "
				+ "A dog; "
				+ "A gunny-sack "
				+ "Driving a bullock-cart; "
				+ "A buffalo going out to graze, "
				+ "Sitting on a horse; "
				+ "A tree with its branches";
		palabras = poema.split(" ");
	}
}

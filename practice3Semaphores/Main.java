package practice3Semaphores;
/*
 * This Java main class creates a shared object, and Writer and Reader class Threads.
 * It initializes them, so they start to work with the shared object concurrently.
 * Once the threads have finished, the remaining messages in the queue are printed.
 */
public class Main {
	public static void main(String[] args) {
		SharedData data = new SharedData();
		Writer[] writers = new Writer[4];
		Reader[] readers = new Reader[5];
		int nEscriturasWriter = 8;
		int nLecturasReader = 6;
		for(int i = 0; i<readers.length; i++) {
			if(i < writers.length) {
				writers[i] = new Writer(data, i, nEscriturasWriter);	
			}
			readers[i] = new Reader(data, i, nLecturasReader);
		}
		
		for(int i = 0; i<readers.length; i++) {
			if(i < writers.length) writers[i].start();
			readers[i].start();
		}
		
		for(int i = 0; i<readers.length; i++) {
			if(i < writers.length) {
				try {
					writers[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				readers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		data.getQueue().show();
//		for(String palabra : data.getPalabras()) System.out.println(palabra);
//		System.out.println(data.getPalabras().length);
	}
}

package practice3Semaphores;

/*
 * Pre: ---
 * Post: This class implements a heap in which nodes, texts are going to be stored
 * This heap has the attribute maxSize which specifies the total amount of nodes
 * that the heap can store at the time.
 */
public class ConcurrentQueue {
	//Attributes
	private int size;
	private Node first;
	private Node last;
	private int maxSize;
	
	//Constructors
	public ConcurrentQueue() {
		this.first = null;
		this.last = null;
		this.size = 0;
		this.maxSize = 10;
	}

	public ConcurrentQueue(Node first) {
		this.first = first;
		this.last = first;
		this.size = 1;
		this.maxSize = 10;
	}
	
	public ConcurrentQueue(Node first, int maxSize) {
		this.first = first;
		this.last = first;
		this.size = 1;
		setMaxSize(maxSize);
	}
	
	//Getters and setters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}
	
	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	/*
	 * Pre: ---
	 * Post: setter method that verifies that the value is valid, 
	 * before setting it, if not, it sets a valid value
	 */
	public void setMaxSize(int maxSize) {
		if(maxSize > 0) {
			if(maxSize >= size) this.maxSize = maxSize;
			else this.maxSize = size;
		}
		else if(this.maxSize <= 0) {
			if(size < 10) this.maxSize = 10;
			else this.maxSize = size;
		}
	}

	/*
	 * Pre: ---
	 * Post: Adds a node to the heap, in its last position, as long as the heap 
	 * isn't full
	 */
	public boolean push(Node node) {
		try {
			if(isFull()) {
				System.out.println("Heap is full, new node can't be added.");
				return false;
			}else if(isEmpty()) { first = node; last = node;
			}else { last.setNext(node); last = node;
			}size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post:This method receives a string, crates a node and adds it to the heap 
	 */
	public boolean pushString(String message) {
		return push(new Node(message));
	}
	
	/*
	 * Pre: ---
	 * Post: returns the first heap element, and delete the element from the heap.
	 */
	public Node pop() {
		try {
			if(isEmpty()) {
				System.out.println("La cola est� vac�a");
				return null;
			}else {
				Node p = first;
				first = first.getNext();
				size--;
				return p;
			}
		}catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: returns true if heap is empty, or false if it isn't
	 */
	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}
	
	/*
	 * Pre: ---
	 * Post: returns true if the heap is full, else, returns false
	 */
	public boolean isFull() {
		if(size == maxSize) return true;
		return false;
	}
	
	/*
	 * Pre: ---
	 * Post: Prints heap's elemnts's contents 
	 */
	public void show() {
		Node p = first;
		for (int i = 1; i<=size; i++) {
			System.out.println("[" +i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}
}

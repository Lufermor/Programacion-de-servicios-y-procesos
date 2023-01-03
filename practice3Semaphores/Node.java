package practice3Semaphores;

/*
 * Pre: ---
 * Post: This class implements a node that contains text, 
 * and that is intended to be stored in a queue.
 */
public class Node {
	//Attributes
	private String content;
	private Node next;
	
	//Constructors
	public Node(String content, Node next) {
		this.content = content;
		this.next = next;
	}
	
	public Node(String content) {
		this.content = content;
		this.next = null;		
	}

	//Getters and Setters
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [content=" + content + ", next=" + next + "]";
	}
	
}

import java.io.Serializable;

public class Node<E> implements Serializable {

	private E element;
	private Node<E> next;
	
	public Node () {
		element = null;
		next = null;
	}
	
	public Node(Node<E> n) {
		this();
		next = n;
	}
	
	public Node(E s) {
		this();
		element = s;
	}
	
	public Node(Node<E> n, E s) {
		this();
		next = n;
		element = s;	
	}
	
	public Node<E> getNext() { return next;}
	public E getElement() { return element;}
	
	public void setNext(Node<E> n) { next = n;}
	public void setElement(E e) { element = e;}
	
	public String toString() { return element.toString();}
	
	public static void main(String[] args) {
		
	}
}
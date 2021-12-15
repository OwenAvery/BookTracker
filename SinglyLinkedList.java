import java.io.Serializable;

class SinglyLinkedList<E> implements Serializable {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public SinglyLinkedList() {
		// not much to do here!
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;

		return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;

		return tail.getElement();
	}

	public E getAt(int index) {

		// error check
		if (index >= size) {
			System.out.println("Error: index out of range");
			return null;
		}

		Node<E> n = head;
		for (int i = 0; i < index; i++) {
			n = n.getNext();
		}

		return (E) n.getElement();
	}

	public void addFirst(E s) {
		Node<E> n = new Node<>(head, s);
		head = n;

		if (size == 0)
			tail = n;

		size++;
	}

	public void addLast(E s) {
		Node<E> n = new Node<>(s);
		tail.setNext(n);

		if (size == 0)
			head = n;
		else
			tail.setNext(n);

		tail = n;

		size++;
	}

	public E removeFirst() {

		if (isEmpty()) {
			System.out.println("Error: The list is empty.");
			return null;
		}

		E s = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;

		return s;
	}

	public String toString() {

		if (size == 0)
			return "The list is empty";

		String outstr = "";
		Node<E> n = head;
		while (n != null) {
			outstr = outstr + n.getElement().toString() + "\n";
			n = n.getNext();
		}
		return outstr;
	}
	public void remove(int id){
		Node temp = head, prev = null;
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
		for(int i = 1;i<id;i++){
			prev = temp;
            temp = temp.getNext();
		}
    
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        prev.setNext(temp.getNext());
		size--;

	}
	public void removeLast(){
		Node temp = head, prev = null;
		temp = head;
		while(temp.getNext()!=null){
			prev = temp;
			temp= temp.getNext();
		}
		tail = prev;
		prev.setNext(null);
		size--;
		
	}
	
	

	public static void main(String[] args) {

	}
}
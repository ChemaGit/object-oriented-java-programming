package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) {
		// TODO: Implement this method
		if(element != null) {
			LLNode<E> node = new LLNode<E>(element);
			node.data = element;
			LLNode h = this.tail.prev;
			h.next = node;
			node.prev = h;
			tail.prev = node;
			node.next = tail;
			this.size++;
			return true;
		} else {
			return false;
		}
	}

	private LLNode getNode(int tam, int i, LLNode node) {
		if(tam < i) return getNode(++tam, i, node.next);
		else return node;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException{
		// TODO: Implement this method.
		if(index < 0 || index > this.size - 1)
			throw new IndexOutOfBoundsException();
		else {
			return (E)getNode(0,index,this.head.next).data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) {
		// TODO: Implement this method
		LLNode node = new LLNode(element);
		if(element != null) {
			if(index == 0) { // at the start of the list
				LLNode node0 = this.head.next;
				this.head.next = node;
				node.prev = this.head;
				node.next = node0;
				node0.prev = node;
				this.size++;
			} else if(index == this.size - 1) { // at the end of the list
				add(element);
			} else if(index < 0 || index > this.size - 1) {
				throw  new IndexOutOfBoundsException();
			} else { // in the middle of the list
				LLNode nodeIndex = this.getNode(0,index, this.head.next);
				nodeIndex.prev.next = node;
				node.prev = nodeIndex.prev;
				nodeIndex.prev = node;
				node.next = nodeIndex;
				this.size++;
			}
		} else throw new NullPointerException();
	}


	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method
		if(index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			this.size--;
			LLNode nodeRemove = getNode(0,index,this.head.next);
			nodeRemove.prev.next = nodeRemove.next;
			nodeRemove.next.prev = nodeRemove.prev;
			return (E)nodeRemove.data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		E removed = null;
		if(index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			if(element != null) {
				LLNode nodeRemove = getNode(0, index, this.head.next);
				removed = (E) nodeRemove.data;
				nodeRemove.data = element;
			}else {
				throw new NullPointerException();
			}
			return removed;
		}
	}

	public String toString() {
		if(this.head.next.data != null) {
			return "[" + printList(this.head.next) + "]";
		} else {
			return "";
		}
	}

	private String printList(LLNode node) {
		if(node.data == null) {
			return "";
		} else if(node.next.data == null) {
			return node.data.toString().concat(printList(node.next));
		} else {
			return node.data.toString().concat("," + printList(node.next));
		}
	}

//	public static void main(String[] args) {
//		MyLinkedList<String> lst = new MyLinkedList<String>();
//		System.out.println(lst.toString());
//		lst.add("A");
//		lst.add("B");
//		lst.add("C");
//		System.out.println(lst.toString());
//		System.out.println(lst.size);
//		System.out.println(lst.get(0));
//		System.out.println(lst.get(1));
//		System.out.println(lst.get(2));
//		lst.add("D");
//		System.out.println(lst.get(3));
//		System.out.println("****************REMOVE***********************");
//		System.out.println(lst.remove(0));
//		System.out.println(lst.remove(1));
//		System.out.println(lst.remove(0));
//		System.out.println(lst.remove(0));
//		System.out.println(lst.size);
//		System.out.println("****************SET***********************");
//		System.out.println(lst.set(0,"Z"));
//		System.out.println(lst.get(0));
//		System.out.println(lst.set(1,"Y"));
//		System.out.println(lst.get(1));
//	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}
}

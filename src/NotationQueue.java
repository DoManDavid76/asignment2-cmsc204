import java.util.ArrayList;
/**
 * @author David Do
 */

public class NotationQueue<T> implements QueueInterface<T> {

	private ArrayList<T> que;
	private int capacity;

	/**
	 * takes an int as the size of the queue
	 * @param size the size of the queue
	 */
	NotationQueue(int i) {
		que = new ArrayList<>();
		capacity = i;
	}
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if(que.isEmpty()) {
			return true;
		}
		return false;
	}
	/**
	 * Determines of the Queue is full
	 * @return
	 */
	@Override
	public boolean isFull() {
		if(que.size() >= capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(que.isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T top = que.get(0);
		que.remove(0);
		que.trimToSize();
		que.ensureCapacity(capacity);
		return top;
		
	}
	
	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return que.size();
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(que.size() >=capacity) {
			throw new QueueOverflowException();
		}
		que.add(e);
		return true;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String s = "";
		
		for(T item: que) {
			s += item.toString();
			System.out.println(s);
		}
		return s;
	}
		
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String s = "";

		for(T item: que) {
			s += item.toString();
			s += delimiter;
			System.out.println(s);
		}
		s = s.substring(0,s.length()-1);
		return s;
	}

	@Override
	public void fill(ArrayList<T> list) {
		que.clear();
		
		for(T item: list) {
			que.add(item);
		}
	}
	
}

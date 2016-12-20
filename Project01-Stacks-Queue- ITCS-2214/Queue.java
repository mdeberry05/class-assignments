/**
 * @Author Matthew DeBerry
 * @Date 9/30/2014
 * ITCS 2214
 */


public class Queue {
	private Node first;
	private Node last;

	public Queue() {
		first = null;
		last = null;
	}

    /**
     * Enqueue method
     * @param Value
     */
	public void enqueue(int Value) {
		Node obj = new Node();

		obj.value = Value;

		if(first == null) {
			first = obj;
			last = obj;
		}
		else {
			last.next = obj;
			last = obj;
		}
	}

    /**
     * Dequeue Method
     * @return value
     */

	public int dequeue() {
		int value = first.value;

		first = first.next;

		if(first == null) {
			last = null;
		}

		return value;
	}

    /**
     * Get first method
     * @return  first value
     */
	public int GetFirst() {
		if(first == null) {
			return 1337;
		}
		else {
			return first.value;
		}
	}

    /**
     * Get Last Method
     * @return last value
     */
	public int GetLast() {
		if(last == null) {
			return -1337;
		}
		else {
			return last.value;
		}
	}
}

/**
 * @Author Matthew DeBerry
 * @Date 9/30/2014
 * ITCS-2214
 *
 */


public class Stack {
	private Node first;

	public Stack() {
		first = null;
	}

    /**
     * Pop Method
     * @return value
     */
	public int pop() {
		int value = first.value;
		first = first.next;

		return value;
	}

    /**
     * Push Method
     * @param Value
     */
	public void push(int Value) {
		Node obj = first;

		first = new Node();
		first.value = Value;
		first.next = obj;
	}
}
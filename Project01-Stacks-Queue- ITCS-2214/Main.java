/**
 * @Author Matthew DeBerry
 * @Date 9/30/2014
 * ITCS-2214
 *
 */

public class Main {
    public static void main(String[] args) {
	    // Testing the Stack class
	    Stack stack = new Stack();
	    Queue queue = new Queue();

	    // Load numbers 1 - 10 in the stack and queue.
	    for(int i = 1; i < 11; i++) {
		    stack.push(i);
		    queue.enqueue(i);
	    }

	    // Pop the last 5 values
	    System.out.println("Pop the last 5 values of the stack");
	    for(int i = 0; i < 5; i++) {
		    System.out.println(stack.pop());
	    }
	    System.out.println("Done.\n");

	    // Dequeue the last 5 values
	    System.out.println("Dequeue the last 5 values of the queue");
	    for(int i = 0; i < 5; i++) {
		    int first = queue.GetFirst();
		    int last = queue.GetLast();
		    int value = queue.dequeue();

		    System.out.println(value + " (First: " + first + ", Last: " + last + ")");
	    }
    }
}

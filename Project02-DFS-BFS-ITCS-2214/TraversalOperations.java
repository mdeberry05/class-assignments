package edu.uncc.projectAssignment02;

import java.util.*;

/**
 * Created by novabrains on 10/16/14.
 *
 * ITCS-2214 Matthew DeBerry
 */
public class TraversalOperations
{
    static Map<String, Integer> nodesThatBeenVisited = new Hashtable<String, Integer>();

    static Stack<String> myStack = new Stack<String>();
    static Queue<String> myQueue = new LinkedList<String>();

    public static void depthFirstSearch(String startingNode, Map myDictionary)
    {
        // Print out the starting node
        System.out.print(startingNode + " ");

        // Put the starting node in the HashTable
        nodesThatBeenVisited.put(startingNode, 1);

        LinkedList<String> node = (LinkedList<String>)myDictionary.get(startingNode);

        // Push all the elements into the stack then loop through
        // the linked list and push each element to the stack
        // if the node hasn't been visited yet
        int iteration = 0;
        while(iteration < node.size()) {
            if(!nodesThatBeenVisited.containsKey(node.get(iteration))) {
                nodesThatBeenVisited.put(node.get(iteration), 1);

                myStack.push(node.get(iteration));
            }

            iteration++;
        }

        // Exit recursion if the stack is empty
        // else perform a Depth-First Search on
        // the next node.
        if(myStack.empty()) {
            return;
        }
        else {
            depthFirstSearch(myStack.pop(), myDictionary);
        }
    }

    public static void breadthFirstSearch(String startingNode, Map myDictionary)
    {
        // Print out the starting node
        System.out.print(startingNode + " ");

        // Put the starting node in the HashTable
        nodesThatBeenVisited.put(startingNode, 1);

        LinkedList<String> node = (LinkedList<String>)myDictionary.get(startingNode);

        // Push all the elements into the queue then loop through
        // the linked list and push each element to the queue
        // if the node hasn't been visited yet
        int iteration = 0;
        while(iteration < node.size()) {
            if(!nodesThatBeenVisited.containsKey(node.get(iteration))) {
                nodesThatBeenVisited.put(node.get(iteration), 1);

                myQueue.add(node.get(iteration));
            }

            iteration++;
        }

        // Exit recursion if the stack is empty
        // else perform a Breadth-First Search on
        // the next node.
        if(myQueue.isEmpty()) {
            return;
        }
        else {
            breadthFirstSearch(myQueue.remove(), myDictionary);
        }
    }
}
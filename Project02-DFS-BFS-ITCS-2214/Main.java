package edu.uncc.projectAssignment02;

import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by novabrains on 10/14/14.
 * ITCS-2214 Matthew DeBerry
 */
public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Map<String, LinkedList> myDictionary = ReadOperations.readFile();

        // I will uncomment the next two lines to make sure your implementation of DFS and BFS is correct
        //
        //TraversalOperations.depthFirstSearch("A", myDictionary);
        //TraversalOperations.breadthFirstSearch("A", myDictionary);


        // The following few lines code is to show how the Class Queue works in Java
        //
        /*
        Queue<String> myQueue = new LinkedList<String>();

        myQueue.add("A");
        myQueue.add("B");
        System.out.println(myQueue.remove());
        */

        // The following few lines of code show how dictionaries work
        //
        /*
        Map<String, Integer> test = new Hashtable<String, Integer>();

        test.put("A", 1);

        if (test.get("A") == null)
            System.out.println("We add it...");
        */


        // The following few lines of code show how dictionaries work
        /*
        Map<String, Integer> mySimpleDictionary = new Hashtable<String, Integer>();

        mySimpleDictionary.put("A", 100);
        mySimpleDictionary.put("Hello", 50);

        System.out.println(mySimpleDictionary.get("A"));
        */
        System.out.println("");
    }
}
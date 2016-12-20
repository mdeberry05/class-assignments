package edu.uncc.ITCS2214.HuffmanEncoding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by novabrains on 11/11/14.
 */
public class Huffman
{
    static Node createTree(Map<String, Integer> myFrequency)
    {
        // What you'd want to do is to create a LinkedList<Node> of nodes
        // Each node is a letter
        // Loop through myDictionary
        // inside the loop, create a node
        // give it the letter
        // give it the value
        // and it should have null left and null right
        //
        // Loop through the nodes, find the two minimum nodes
        // create a new node, assign the left child of it to one of mins
        // assign the right child of it to the other min; value of new
        // node is the sum of the two
        //
        // remove the two nodes from the linkedlist; and add the new one
        //
        LinkedList<Node> nodes = new LinkedList<Node>();

        // Add elements from the map into the
        // LinkedList and set their left
        // and right values to null.
        for (Map.Entry<String, Integer> entry : myFrequency.entrySet()) {
            Node newNode = new Node();

            newNode.letter = entry.getKey();
            newNode.value = entry.getValue();
            newNode.left = null;
            newNode.right = null;

            nodes.add(newNode);
        }

        // Huffman Encoding
        while(nodes.size() > 1) {
            Node node = new Node();

            // Remove the smallest two nodes
            // and set them to the left and right
            // values of a parent node.
            node.left = nodes.remove(DetermineSmallestNode(nodes));
            node.right = nodes.remove(DetermineSmallestNode(nodes));

            // Set the value of the parent node
            // to the the sum of the two children.
            node.value = node.left.value + node.right.value;

            nodes.add(node);
        }

        return nodes.remove(DetermineSmallestNode(nodes));
    }

    private static int DetermineSmallestNode(LinkedList<Node> nodes) {
        int index = 0;
        int smallestValue = 9999;

        for(int i = 0; i < nodes.size(); i++) {
            Node buffer = nodes.get(i);

            if(buffer.value <= smallestValue) {
                smallestValue = buffer.value;
                index = i;
            }
        }
        return index;
    }
}

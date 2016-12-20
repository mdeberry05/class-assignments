package edu.uncc.ITCS2214.HuffmanEncoding;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by novabrains on 11/6/14.
 */
public class Main
{
    static String currString = null;

    public static void main(String[] args) throws FileNotFoundException
    {
        Map<String, Integer> myDictionary = new HashMap<String, Integer>();

        myDictionary = ReadOperations.readFile();





        String sequence = "";

        Node root = Huffman.createTree(myDictionary);
        printTree(root, sequence, "");

        /*
        Node root = new Node();
        root.value = 100;

        root.left = new Node();
        root.left.value = 55;

        root.right = new Node();
        root.right.value = 45;
        root.right.letter = "A";

        root.left.left = new Node();
        root.left.left.value = 30;

        root.left.left.left = new Node();
        root.left.left.left.value = 16;
        root.left.left.left.letter = "D";

        root.left.right = new Node();
        root.left.right.value = 25;

        root.left.right.left = new Node();
        root.left.right.left.value = 13;
        root.left.right.left.letter = "B";

        root.left.right.right = new Node();
        root.left.right.right.value = 12;
        root.left.right.right.letter = "C";

        root.left.left.right = new Node();
        root.left.left.right.value = 14;

        root.left.left.right.left = new Node();
        root.left.left.right.left.value = 9;
        root.left.left.right.left.letter = "E";

        root.left.left.right.right = new Node();
        root.left.left.right.right.value = 5;
        root.left.left.right.right.letter = "F";

        String seq = "";
        printTree(root, seq, "");

        System.out.println();
        */
    }

    static void printTree(Node node, String sequence, String concat)
    {
        sequence = sequence + concat;

        if (node.letter != null)
            System.out.println(node.letter + ": " + sequence);
        else
        {
            printTree(node.left, sequence, "0");
            printTree(node.right, sequence, "1");
        }
    }
}

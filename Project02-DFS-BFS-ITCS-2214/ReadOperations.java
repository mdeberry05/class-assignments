package edu.uncc.projectAssignment02;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by novabrains on 10/14/14.
 *
 * ITCS-2214 Matthew DeBerry
 */
public class ReadOperations
{
    static public Map readFile() throws FileNotFoundException
    {
        Map<String, LinkedList> myDictionary = new Hashtable<String, LinkedList>();

        Scanner in = new Scanner(new FileReader("input.txt"));

        while (in.hasNext())
        {
            String currLine = in.nextLine();

            String[] nodes = currLine.split(",");

            LinkedList<String> currList = new LinkedList<String>();

            for(int i = 0; i < nodes.length; i ++)
                currList.add(nodes[i]);

            myDictionary.put(nodes[0], currList);
        }

        return myDictionary;

    }
}
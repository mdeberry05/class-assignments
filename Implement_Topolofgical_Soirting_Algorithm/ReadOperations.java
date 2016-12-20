import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.io.FileReader;
import java.util.ArrayList;



 /**
 * Created by Matthew DeBerry on 3/25/2015.
 * ITCS-2215 Topological Sort
 *
 * This code will read codes from a text file of adjacency lists for a directed graph
 * and will throw an exception if a cycle is detected.
 *
 */

public class ReadOperations {
    public static TreeMap readFile() throws FileNotFoundException {
        TreeMap<String, ArrayList<String>> dictionary = new TreeMap<String, ArrayList<String>>();

        //Read In File
        Scanner in = new Scanner(new FileReader("graph.txt"));

        ArrayList<String> map = new ArrayList<String>();

        while (in.hasNext()) {
            String currLine = in.nextLine();

            String[] nodes = currLine.split(",");

            for(int i = 1; i < nodes.length; i++) {
                map.add(nodes[i]);
            }

            dictionary.put(nodes[0], map);

            map = new ArrayList<String>();
        }

        return dictionary;
    }
}

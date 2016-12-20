/**
 * @author  Matthew DeBerry
 * @version 1.0
 * @since 2015-04-15
 *
 * To perform read operations on a text file
 * that translates the graph encoding into
 * a Java TreeMap.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ReadOperations {
    private String filename;
    private TreeMap<String, VertexSet> vertices;
    private TreeSet<Edge> edges;
    private Comparator<Edge> edgeComparator = new Comparator<Edge>()
    {
        public int compare(Edge edgeOne, Edge edgeTwo)
        {
            int weightOne = edgeOne.Weight;
            int weightTwo = edgeTwo.Weight;

            if (weightOne < weightTwo) {  //compare weights
                return -1;
            }
            else if (weightOne > weightTwo) { //compare weights
                return 1;
            }
            else
            {
                String nodeOne = edgeOne.NodeOne;
                String nodeTwo = edgeTwo.NodeOne;
                return nodeOne.compareTo(nodeTwo);
            }
        }
    };

    public ReadOperations() {
        filename = "graph.txt"; //reads file name of graph.txt
        ReadFile();
    }
    public ReadOperations(String Filename) {

        if((Filename == null) || (Filename.equals("")))
            filename = "graph.txt";
        else
            filename = Filename;

        ReadFile();
    }

    /**
     * Read file and convert it into vertices and edges
     * <p>
     *     Sample of text file:
     *     A,1,B,2,D,2,F
     *     B,1,A,1,C,2,D
     *     C,1,B,1,D,3,E
     *     E,3,C,2,D,1,G
     *     G,1,E,3,D,3,F
     *     F,1,D,3,G,2,A
     *     D,2,A,2,B,1,C,2,E,3,G,1,F
     * </p>
     */
    public void ReadFile() {
        Scanner file = null;
        String mainVertex = null;

        vertices = new TreeMap<String, VertexSet>();
        edges = new TreeSet<Edge>(edgeComparator);

        try {
            // Open file for reading
            file = new Scanner(new FileReader(filename));

            while(file.hasNextLine()) {
                String rawLine = file.nextLine();

                StringTokenizer tokenizer = new StringTokenizer(rawLine, ",", false);
                mainVertex = tokenizer.nextToken();

                VertexSet set = new VertexSet(mainVertex);
                vertices.put(mainVertex, set);

                while(tokenizer.hasMoreTokens()) {
                    int weight = Integer.parseInt(tokenizer.nextToken());
                    String vertex = tokenizer.nextToken();

                    if(mainVertex.compareTo(vertex) < 0) {
                        Edge newEdge = new Edge(mainVertex, vertex, weight);
                        edges.add(newEdge);
                    }
                }
            }
        }

        //Try and catch block
        catch(FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(0);
        }
        catch(NumberFormatException ex) {
            System.out.println("Incorrect Weight at vertex " + mainVertex);
        }
        finally {
            file.close();
        }
    }

    /**
     *
     * @return Return the vertices of the graph
     */
    public TreeMap GetVertices() {
        return vertices;
    }

    /**
     *
     * @return Return the edges of the graph
     */
    public TreeSet GetEdges() {
        return edges;
    }
}
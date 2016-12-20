/**
 * @author  Matthew DeBerry
 * @version 1.0
 * @since 2015-04-15
 *
 */

import java.util.*;
import java.io.*;

public class Kruskal
{
    // Represents the graph vertices

    private static TreeMap<String, VertexSet> vertices;

    //Represents the graph edsges
    private static TreeSet<Edge> edges;


    // Store the minimum spanning tree edges
    private static ArrayList<Edge> mstEdges = new ArrayList<Edge>();

    public static void main(String[] args) throws FileNotFoundException
    {
        ReadOperations reader = new ReadOperations();
        vertices = reader.GetVertices();
        edges = reader.GetEdges();

        findRoot();

        //Calculate the weight of the minimum spanning tree

        int mstWeight = 0; //initialize the weight to zero
        for(Iterator<Edge> edgeIterator = mstEdges.iterator(); edgeIterator.hasNext();)
        {
            Edge edge = edgeIterator.next();
            mstWeight += edge.Weight;
        }
        System.out.println("\nTotal MST Weight: " + mstWeight); //calculates the MST weight
    }


    //Find Root Function
    private static void findRoot() {
        for(Iterator<Edge> edgeIterator = edges.iterator(); edgeIterator.hasNext();)
        {
            //grab an edge from the list
            Edge edge = edgeIterator.next();
            String firstEndpoint = edge.NodeOne;
            String lastEndpoint = edge.NodeTwo;             //retreive the edge end points

            if(findSet(firstEndpoint) != findSet(lastEndpoint))    // check for difference
            {
                mstEdges.add(edge);
                union(edge.NodeOne, edge.NodeTwo);         // join the vertex sets

                System.out.println("Edges " + firstEndpoint + " and " + lastEndpoint + " are part of the MST");
            }
        }
    }

    // Return the pointer at given vertex
    public static VertexSet findSet(String c)
    {
        VertexSet v = vertices.get(c);
        return(v.firstVertex);
    }

   //Kruskal union
    public static void union(String firstEndpoint, String lastEndpoint)
    {
        //point to correct vertex
        VertexSet vertexOne = vertices.get(firstEndpoint);
        VertexSet vertexTwo = vertices.get(lastEndpoint);

        vertexOne.firstVertex.lastVertex.nextVertex = vertexTwo.firstVertex;   // join second list and firstvertex list

        vertexOne.firstVertex.lastVertex = vertexTwo.firstVertex.lastVertex;   //points to the end of the list
        for (VertexSet v = vertexTwo.firstVertex; v != null; v = v.nextVertex) {
            v.firstVertex = vertexOne.firstVertex;
        }
    }
}
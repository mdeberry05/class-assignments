/**
 * @author  Matthew DeBerry
 * @version 1.0
 * @since 2015-04-15
 *
 */

public class VertexSet {
    String label;              //Root
    VertexSet nextVertex;            // pointer to the nextVertex vertex in the set
    VertexSet firstVertex;            // pointer to the firstVertex vertex in the set
    VertexSet lastVertex;            // pointer to the last vertex in the set

    public VertexSet(String label) // constructor
    {
        this.label = label;      // set up the node label
        nextVertex = null;             // reference to the nextVertex set node
        firstVertex = lastVertex = this;      // references to the set lastVertex and the firstVertex
    }
}

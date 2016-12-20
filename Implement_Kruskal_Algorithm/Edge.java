/**
 * @author  Matthew DeBerry
 * @version 1.0
 * @since 2015-04-15
 *
 */

public class Edge {
    String NodeOne;              // label of the firstVertex edge node
    String NodeTwo;              // label of the second edge node
    int Weight;             // edge Weight

    public Edge(String nodeOne, String nodeTwo, int weighto)
    {
        NodeOne = nodeOne;
        NodeTwo = nodeTwo;
        Weight = weighto;
    }
}

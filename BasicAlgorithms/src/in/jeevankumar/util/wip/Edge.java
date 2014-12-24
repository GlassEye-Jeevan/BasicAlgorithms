package in.jeevankumar.util.wip;

/**
 * This class represents an edge of a Graph. It has a link to the next edge. 
 * The class also has an integer weight indicator. 
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 */
public class Edge implements Comparable{
    public int nodeNum;
    public Edge nextEdge;
    public int weight;
    public Edge(int num, Edge e, int weight) {
        nodeNum = num;
        nextEdge = e;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge otherEdge = (Edge) o;
        return Integer.compare(this.weight, otherEdge.weight);
    }
}

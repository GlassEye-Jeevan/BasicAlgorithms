package in.jeevankumar.util.wip;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 */
public class Edge implements Comparable{
    public int nodeNum;
    public Edge nextEdge;
    public int edgeWeight;
    public Edge(int num, Edge e, int weight) {
        nodeNum = num;
        nextEdge = e;
        edgeWeight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge otherEdge = (Edge) o;
        return this.edgeWeight - otherEdge.edgeWeight;
    }
}

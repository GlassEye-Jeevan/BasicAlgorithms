package in.jeevankumar.util.wip;

/**
 * This class represents an edge of a Graph. It has a link to the next edge. 
 * The class also has an integer weight indicator. 
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 */
public class Edge<T extends Comparable> implements Comparable{
    private int nodeNum;
    private Edge nextEdge;
    private T weight;
    public Edge(int num, Edge e, T weight) {
        nodeNum = num;
        nextEdge = e;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge otherEdge = (Edge) o;
        return this.getWeight().compareTo(otherEdge.getWeight());
    }

    /**
     * @return the weight
     */
    public T getWeight() {
        return weight;
    }

    /**
     * @return the nextEdge
     */
    public Edge getNextEdge() {
        return nextEdge;
    }

    /**
     * @param nextEdge the nextEdge to set
     */
    public void setNextEdge(Edge nextEdge) {
        this.nextEdge = nextEdge;
    }

    /**
     * @return the nodeNum
     */
    public int getNodeNum() {
        return nodeNum;
    }
}

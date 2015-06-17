
package in.jeevankumar.util.wip;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 * @param <T>
 */
public class Node <T extends Comparable> implements Comparable{
    private int nodeNum;
    private Edge<T> firstEdge;
    private int minDistance;
    public Node<T> previous;
    T value;
    
    private Node() {
        firstEdge = null;
    }
    
    public Node(int num, T value) {
        firstEdge = null;
        this.nodeNum = num;
        this.value = value;
        this.minDistance = Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(Object o) {
        Node otherNode = (Node) o;
        return value.compareTo(otherNode.value);//Integer.compare(this.minDistance, otherNode.minDistance);
    }
    
    @Override
    public String toString() {
        return getNodeNum() + "";
    }

    /**
     * @return the nodeNum
     */
    public int getNodeNum() {
        return nodeNum;
    }

    /**
     * @return the firstEdge
     */
    public Edge<T> getFirstEdge() {
        return firstEdge;
    }

    /**
     * @param firstEdge the firstEdge to set
     */
    public void setFirstEdge(Edge<T> firstEdge) {
        this.firstEdge = firstEdge;
    }

    /**
     * @return the minDistance
     */
    public int getMinDistance() {
        return minDistance;
    }

    /**
     * @param minDistance the minDistance to set
     */
    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }
}

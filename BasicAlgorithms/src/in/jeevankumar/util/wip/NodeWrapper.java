
package in.jeevankumar.util.wip;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 * @param <T>
 */
public class NodeWrapper <T extends Comparable> implements Comparable{
    private Node<T> node;
    private int minDistance = Integer.MAX_VALUE;
    public NodeWrapper<T> previous;
    
    public NodeWrapper(int num, T value) {
        node = new Node(num, value);
//        firstEdge = null;
//        this.nodeNum = num;
//        this.value = value;
        //this.minDistance = Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(Object o) {
        return node.compareTo(o);
    }
    
    @Override
    public String toString() {
        return node.getNodeNum() + "";
    }

    /**
     * @return the nodeNum
     */
    public int getNodeNum() {
        return node.getNodeNum();
    }

    /**
     * @return the firstEdge
     */
    public Edge<T> getFirstEdge() {
        return node.getFirstEdge();
    }

    /**
     * @param firstEdge the firstEdge to set
     */
    public void setFirstEdge(Edge<T> firstEdge) {
        node.setFirstEdge(firstEdge);
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

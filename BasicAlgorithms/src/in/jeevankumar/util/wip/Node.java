
package in.jeevankumar.util.wip;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 */
public class Node implements Comparable {
    private int nodeNum;
    public Edge firstEdge;
    public int minDistance = Integer.MAX_VALUE;
    public Node previous;
    
    
    private Node() {
        firstEdge = null;
    }
    
    public Node(int num) {
        firstEdge = null;
        this.nodeNum = num;
    }

    @Override
    public int compareTo(Object o) {
        Node otherNode = (Node) o;
        return Integer.compare(this.minDistance, otherNode.minDistance);
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
}

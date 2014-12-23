
package in.jeevankumar.util.wip;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 */
public class Node {
    int nodeNum;
    public Edge firstEdge;
    
    public Node() {
        firstEdge = null;
    }
    
    public Node(int num) {
        firstEdge = null;
        this.nodeNum = num;
    }
}

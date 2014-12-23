
package in.jeevankumar.util.wip;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author Donald Knuth
 */
public class Graph {
    public int nodes;
    public Node[] graph;
    public Graph(int n) {
        nodes = n;
        graph = new Node[nodes];
        for(int i = 0; i < nodes; i++) {
            graph[i] = new Node();
        }
    }
    
    public void insertEdge(int fromNode, int toNode, int weight) {
        graph[fromNode].firstEdge = new Edge(toNode, graph[fromNode].firstEdge, weight);
    }
    
    public void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.format("%3d :", i);
            Edge currentEdge = graph[i].firstEdge;
            while(currentEdge != null) {
                System.out.print("[" + currentEdge.nodeNum + ", " + currentEdge.edgeWeight + "] ");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println("");
        }
    }
}

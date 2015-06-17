
package in.jeevankumar.util.wip;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author Donald Knuth
 */
public class Graph<T extends Comparable> {
    private int nodes;
    private Node<T>[] graph;
    
    public Graph(int[] intValues, T[] values) {
        nodes = intValues.length;
        graph = new Node[nodes];
        for(int i = 0; i < nodes; i++) {
            graph[i] = new Node<T>(intValues[i], values[i]);
        }
    }
    
    public void insertEdge(int fromNode, int toNode, int weight) {
        getGraph()[fromNode].setFirstEdge(new Edge(toNode, getGraph()[fromNode].getFirstEdge(), weight));
    }
    
    public void printGraph() {
        for (int i = 0; i < getGraph().length; i++) {
            System.out.format("%3d :", i);
            Edge currentEdge = getGraph()[i].getFirstEdge();
            while(currentEdge != null) {
                System.out.print("[" + currentEdge.getNodeNum() + ", " + currentEdge.getWeight() + "] ");
                currentEdge = currentEdge.getNextEdge();
            }
            System.out.println("");
        }
    }

    /**
     * @return the graph
     */
    public Node<T>[] getGraph() {
        return graph;
    }
}

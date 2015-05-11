/*
 * Copyright 2014 Jeevan Kumar <mail@jeevankumar.in>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.jeevankumar.algorithms;

import in.jeevankumar.util.GraphNode;
import in.jeevankumar.util.LinkedListNode;
import in.jeevankumar.util.MinHeap;
import in.jeevankumar.util.Queue;
import in.jeevankumar.util.DefaultQueue;
import in.jeevankumar.util.wip.Edge;
import in.jeevankumar.util.wip.Graph;
import in.jeevankumar.util.wip.Node;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class GraphProblemSolver {
    
    private static final String[] algorithmList = {
        "DepthFirstTraversal",
        "BreadthFirstTraversal"
    };
    public static final String k = "ss";
    public static void main(String[] args) {
        GraphProblemSolver gps = new GraphProblemSolver();
        gps.run(args);
    }
    
    public void run(String[] args) {
        int noOfNodes;
        GraphNode root;
        Map<Integer,GraphNode> inputNodeMap;
        Graph graph;
        switch(args[0]) {
            case "DepthFirstTraversal":
                noOfNodes = Integer.parseInt(args[1]);
                root = readInputAdjMatrix(args, noOfNodes);
                depthFirstTraversal(root, new boolean[noOfNodes]);
                //java GraphProblemSolver DepthFirstTraversal 8 0,1,0,0,0,0,0,0 0,0,1,0,0,0,0,1 0,0,0,1,1,0,0,0 0,0,0,0,0,0,0,0 0,0,0,0,0,1,1,1 0,0,0,0,0,0,0,0 0,0,0,0,0,0,0,0 0,0,0,0,0,0,0,0 
                break;
            case "BreadthFirstTraversal":
                noOfNodes = Integer.parseInt(args[1]);
                root = readInputAdjMatrix(args, noOfNodes);
                breadthFirstTraversal(root, new boolean[noOfNodes]);
                //java GraphProblemSolver BreadthFirstTraversal 8 0,1,0,0,0,0,0,0 0,0,1,0,0,0,0,1 0,0,0,1,1,0,0,0 0,0,0,0,0,0,0,0 0,0,0,0,0,1,1,1 0,0,0,0,0,0,0,0 0,0,0,0,0,0,0,0 0,0,0,0,0,0,0,0 
                break;
            case "UnweightedShortestPath":
                noOfNodes = Integer.parseInt(args[1]);
                inputNodeMap = createNodeMap(noOfNodes);
                int noOfEdges = Integer.parseInt(args[2]);
                inputNodeMap = createGraphBasedOnEdgeList(args, 3, inputNodeMap, noOfNodes, noOfEdges );
                unweightedShortestPath(inputNodeMap.get(new Integer(2)), noOfNodes, 0);
                //java UnweightedShortestPath 7 10 0-1 0-3 1-3 1-4 2-0 2-5 3-5 3-6 4-6 6-5
                break;
            case "Djikstra":
                graph = readGraph(args[1], false);
                graph.printGraph();
                int[] distance;
                distance = djikstra(graph,0);
                break;
            
            case "BellmanFord":
                graph = readGraph(args[1], false);
                graph.printGraph();
                bellmanFord(graph,0);
                break;
            
            case "Prims":
                graph = readGraph(args[1], false);
                graph.printGraph();
                bellmanFord(graph,0);
                break;
                
            default:
                System.out.println("Usage: java GraphProblemSolver "
                        + "<AlgorithmName> <No. of Nodes> <Adjacency Matrix>" + args[0]);
                System.out.println("Algorithms List" 
                        + Arrays.toString(algorithmList));
                
        }
    }
    private HashMap<Integer,GraphNode> createNodeMap(int noOfNodes) {
        HashMap<Integer,GraphNode> inputNodeMap = new HashMap<Integer,GraphNode>();
        for (int i = 0; i < noOfNodes; i++) {
            Integer information = new Integer(i);
            GraphNode temp = new GraphNode(information);
            inputNodeMap.put(information,temp);
        }
        return inputNodeMap;
    }
    private GraphNode readInputAdjMatrix(String[] args, int noOfNodes) {
        HashMap<Integer,GraphNode> inputNodeMap = createNodeMap(noOfNodes);
        GraphNode root = inputNodeMap.get(new Integer(0));
        
        
        for (int i = 0, k = 2; i < noOfNodes; i++,k++) {
            String[] edgeList = args[k].split(",");
            System.out.println(Arrays.toString(edgeList));
            for(int j = 0; j < noOfNodes; j++) {
                if(edgeList[j].equals("1")) {
                    Integer key = new Integer(i);
                    
                    GraphNode fromNode = inputNodeMap.get(key);
                    GraphNode toNode = inputNodeMap.get(new Integer(j));
                    System.out.println("Adding edge from " + fromNode.getInfo() 
                            + " to " + toNode.getInfo());
                    fromNode.addEdge(toNode);
                }
            }
        }
        return root;
    }
    
    public Map<Integer,GraphNode> createGraphBasedOnEdgeList(String[] args, int startIndex, Map<Integer,GraphNode> nodeMap, int noOfNodes, int noOfEdges) {
        GraphNode root = nodeMap.get(new Integer(0));
        for (int i = startIndex; i < noOfEdges + startIndex; i++) {
            String[] edge = args[i].split("-");
            Integer fromNodeKey = new Integer(edge[0]);
            Integer toNodeKey = new Integer(edge[1]);
            GraphNode fromNode = nodeMap.get(fromNodeKey);
            GraphNode toNode = nodeMap.get(toNodeKey);
            fromNode.addEdge(toNode);
            System.out.println(" Added Edge " + fromNode.toString() + " " + toNode.toString());
        }
        return nodeMap;
    }
    
    public void depthFirstTraversal(GraphNode<Integer> node, boolean[] visited) {
        if(node != null ) {
            if(!visited[node.getInfo().intValue()]) {
                System.out.print(node.getInfo() + " ");
                visited[node.getInfo().intValue()] = true;
                
                LinkedListNode<GraphNode> adjNodes = node.getAdjNodes();
                while(adjNodes != null) {
                    //System.out.println("Going after " + adjNodes.getInformation().getInfo());
                    depthFirstTraversal(adjNodes.getInformation(), visited);
                    adjNodes = adjNodes.getNext();
                }
                
            }
        }
    }
    
    private void breadthFirstTraversal(GraphNode<Integer> node, boolean[] visited) {
        if(node != null) {
            DefaultQueue<GraphNode> parentQ = new DefaultQueue<GraphNode>();
            
            parentQ.add(node);
            GraphNode<Integer> currentNode = node;
            
            currentNode = parentQ.getNext();
            while(currentNode != null ) {
                //System.out.println("Seeing " + currentNode.getInfo() + " " + parentQ.hasNext());
                if((!visited[currentNode.getInfo().intValue()]))    {
                    visited[currentNode.getInfo().intValue()] = true;
                    System.out.print(currentNode.getInfo() + " ");
                    LinkedListNode<GraphNode<Integer>> adjNodes = currentNode.getAdjNodes();
                    
                    while(adjNodes != null) {
                        parentQ.add(adjNodes.getInformation());
                        //System.out.println("Adding " + adjNodes.getInformation().getInfo() + " " + visited[adjNodes.getInformation().getInfo().intValue()]);
                        adjNodes = adjNodes.getNext();
                        

                    }
                    //currentNode = parentQ.getNext();
                    //System.out.println("Going after " + adjNodes.getInformation().getInfo());
                    //depthFirstTraversal(adjNodes.getInformation(), visited);
                    //System.out.println("Seeing " + currentNode.getInfo());
                }
                currentNode = parentQ.getNext();
            } 
            
        }
    }
    
    private int[] unweightedShortestPath(GraphNode<Integer> sourceNode, int noOfNodes, int sourceNodeIndex) {
        DefaultQueue<GraphNode<Integer>> nodeQueue = new DefaultQueue<GraphNode<Integer>>();
        nodeQueue.add(sourceNode);
        int[] distance = new int[noOfNodes];
        int[] path = new int[noOfNodes];
        distance = Helper.setAll(distance, -1);
        path = Helper.setAll(path, -1);
        distance[sourceNode.getInfo().intValue()] = 0;
        while(nodeQueue.hasNext()) {
            GraphNode<Integer> currentNode = nodeQueue.getNext();
            LinkedListNode<GraphNode<Integer>> adjNodes = currentNode.getAdjNodes();
            while(adjNodes != null) {
                if(distance[adjNodes.getInformation().getInfo().intValue()] == -1) {
                    distance[adjNodes.getInformation().getInfo().intValue()] = distance[currentNode.getInfo().intValue()] + 1;
                    path[adjNodes.getInformation().getInfo().intValue()] = currentNode.getInfo().intValue();
                    nodeQueue.add(adjNodes.getInformation());
                }
                adjNodes = adjNodes.getNext();
            }
        }
        System.out.println("Distance " + Arrays.toString(distance));
        System.out.println("Path     " + Arrays.toString(path));
        return distance;
    }
    
    private Graph readGraph(String fileName, boolean undirected) {
        int nodes = 0;
        Scanner sc = null; // compiler wants
        int num1 = 0, num2 = 0, weight = 0;
        try {
            sc = new Scanner(new
            File(fileName)); // file
        } catch (Exception exception ) { 
            exception.printStackTrace(); 
            err(1); 
        }
        if (sc.hasNextInt())
            nodes = sc.nextInt();
        else err(2);
        int[] intValues = new int[nodes];
        Integer[] integerValues = new Integer[nodes];
        for (int i = 0; i < nodes; i++) {
            intValues[i] = i;
            integerValues[i] = new Integer(i);
        }
        Graph<Integer> graph = new Graph<Integer>(intValues, integerValues);
        // get vertices = num of vertices
      
        while (sc.hasNextInt()) {
            num1 = sc.nextInt();
            if (sc.hasNextInt())
                num2 = sc.nextInt();
            else 
                err(2);
            if (sc.hasNextInt())
                weight = sc.nextInt();
            else 
                err(3);
            graph.insertEdge(num1, num2, weight);
            if(undirected)
                graph.insertEdge(num2, num1, weight);
        }
        return graph;
    }
    
    private static void err(int code) {
      System.exit(code);
    }

    private int[] djikstra(Graph<Integer> graph, int source) {
        
        PriorityQueue<Node> nodeHeap = new PriorityQueue<>();
        Node<Integer> sourceNode = graph.getGraph()[source];
        sourceNode.setMinDistance(0);
        nodeHeap.add(sourceNode);
        
        while(!nodeHeap.isEmpty()) {
            Node fromNode = nodeHeap.poll();
            System.out.print(" From Node " + fromNode.toString());
            Edge<Integer> edge = fromNode.getFirstEdge();
            while(edge!=null) {
                Node currentNode = graph.getGraph()[edge.getNodeNum()];
                int weight = edge.getWeight();
                int distanceThroughfromNode = fromNode.getMinDistance() + weight;
                
                if(distanceThroughfromNode < currentNode.getMinDistance()) {
                    
                    nodeHeap.remove(currentNode);
                    currentNode.setMinDistance(distanceThroughfromNode);
                    currentNode.previous = fromNode;
                    nodeHeap.add(currentNode);
                }
                edge = edge.getNextEdge();
            }
            System.out.println("");
        }
        printDjikstraOutput(graph);
        return null;
    }
    
    private void printDjikstraOutput(Graph graph) {
        for(int i = 0; i < graph.getGraph().length; i++) {
            System.out.println("Node " + i + " min " + graph.getGraph()[i].getMinDistance() + " prev " + graph.getGraph()[i].previous);
        }
    }
    
    private void bellmanFord(Graph graph, int source) {
        Queue<Node<Integer>> nodeQueue = new DefaultQueue<Node<Integer>>() {};
        Node<Integer> sourceNode = graph.getGraph()[source];
        
        sourceNode.setMinDistance(0);
        nodeQueue.add(sourceNode);
        while(nodeQueue.hasNext()) {
            Node<Integer> fromNode = nodeQueue.getNext();
            Edge<Integer> currentEdge = fromNode.getFirstEdge();
            //System.out.print(" From Node " + fromNode.toString());
            while(currentEdge != null) {
                int dist = fromNode.getMinDistance() 
                        + currentEdge.getWeight();
                Node<Integer> toNode = graph.getGraph()[currentEdge.getNodeNum()];
                //System.out.println(" at Edge to " + toNode.toString() + " with weight " + currentEdge.getWeight() + " dist to v" + fromNode.getMinDistance() + " old dist to w " + toNode.getMinDistance());
                if(toNode.getMinDistance() > dist) {
                    toNode.setMinDistance(dist);
                    toNode.previous = fromNode;
                    //graph.currentEdge.getNodeNum()
                    if(!nodeQueue.contains(toNode)) {
                        nodeQueue.add(toNode);
                    }
                }
                currentEdge = currentEdge.getNextEdge();
            }
        }
        //System.out.println();
        printDjikstraOutput(graph);
    }
    
    private int[] prims(Graph<Integer> graph, int source) {
        
        PriorityQueue<Node> nodeHeap = new PriorityQueue<>();
        Node<Integer> sourceNode = graph.getGraph()[source];
        sourceNode.setMinDistance(0);
        nodeHeap.add(sourceNode);
        
        while(!nodeHeap.isEmpty()) {
            Node fromNode = nodeHeap.poll();
            System.out.print(" From Node " + fromNode.toString());
            Edge<Integer> edge = fromNode.getFirstEdge();
            while(edge!=null) {
                Node toNode = graph.getGraph()[edge.getNodeNum()];
                int weight = edge.getWeight();
                int distanceThroughfromNode = fromNode.getMinDistance() + weight;
                if(graph.getGraph()[edge.getNodeNum()].getMinDistance() == -1) {
                    graph.getGraph()[edge.getNodeNum()].setMinDistance(edge.getWeight().intValue());
                    //insert with priority d
                }
                if(distanceThroughfromNode < toNode.getMinDistance()) {
                    
                    nodeHeap.remove(toNode);
                    toNode.setMinDistance(distanceThroughfromNode);
                    toNode.previous = fromNode;
                    nodeHeap.add(toNode);
                }
                edge = edge.getNextEdge();
            }
            System.out.println("");
        }
        printDjikstraOutput(graph);
        return null;
    }
    
    
    public boolean find(GraphNode root, GraphNode node) {
        if(root == null) {
            return false;
        } else if(root.equals(node)) {
            return true;
        } else {
            
            LinkedListNode child = root.getAdjNodes();
            boolean retVal = false;
            do {
               retVal = retVal && find((GraphNode)child.getInformation(), node);
                child = child.getNext();
            } while(child!=null);
            
            return retVal;
        }
        
    }
}

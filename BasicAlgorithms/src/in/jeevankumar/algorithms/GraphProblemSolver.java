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
import in.jeevankumar.util.IntMaxHeap;
import in.jeevankumar.util.LinkedListNode;
import in.jeevankumar.util.Queue;
import in.jeevankumar.util.wip.Graph;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
                Graph graph = readGraph(args[1], false);
                graph.printGraph();
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
    
    private void depthFirstTraversal(GraphNode<Integer> node, boolean[] visited) {
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
            Queue<GraphNode> parentQ = new Queue<GraphNode>();
            
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
        Queue<GraphNode<Integer>> nodeQueue = new Queue<GraphNode<Integer>>();
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
        Graph graph = new Graph(nodes);
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
}

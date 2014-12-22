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
import in.jeevankumar.util.IntegerMinHeap;
import in.jeevankumar.util.LinkedListNode;
import in.jeevankumar.util.Queue;
import java.util.Arrays;
import java.util.HashMap;

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
        switch(args[0]) {
            case "DepthFirstTraversal":
                noOfNodes = Integer.parseInt(args[1]);
                root = readInput(args, noOfNodes);
                depthFirstTraversal(root, new boolean[noOfNodes]);
                //java GraphProblemSolver DepthFirstTraversal 8 0,1,0,0,0,0,0,0 0,0,1,0,0,0,0,1 0,0,0,1,1,0,0,0 0,0,0,0,0,0,0,0 0,0,0,0,0,1,1,1 0,0,0,0,0,0,0,0 0,0,0,0,0,0,0,0 0,0,0,0,0,0,0,0 
                break;
            case "BreadthFirstTraversal":
                noOfNodes = Integer.parseInt(args[1]);
                root = readInput(args, noOfNodes);
                breadthFirstTraversal(root, new boolean[noOfNodes]);
                break;
            default:
                System.out.println("Usage: java GraphProblemSolver "
                        + "<AlgorithmName> <No. of Nodes> <Adjacency Matrix>" + args[0]);
                System.out.println("Algorithms List" 
                        + Arrays.toString(algorithmList));
                
        }
    }
    
    private GraphNode readInput(String[] args, int noOfNodes) {
        HashMap<Integer,GraphNode> inputNodeMap = new HashMap<Integer,GraphNode>();
        GraphNode root = null;
        for (int i = 0; i < noOfNodes; i++) {
            Integer information = new Integer(i);
            GraphNode temp = new GraphNode(information);
            inputNodeMap.put(information,temp);
            if(i == 0) {
                root = temp;
            }
        }
        
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
    
    
}

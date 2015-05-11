/*
 * Copyright 2015 Jeevan Kumar <mail@jeevankumar.in>.
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

import in.jeevankumar.util.DefaultQueue;
import in.jeevankumar.util.GraphNode;
import in.jeevankumar.util.Queue;
import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class GraphProblemSolverTest extends TestCase {
    public GraphProblemSolverTest (String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testDepthFirstTraversal() {
        //assertTrue(true);
        GraphNode root = new GraphNode(0);
        int max = 4;
        Queue<GraphNode> nodeQueue = new DefaultQueue<GraphNode>();
        nodeQueue.add(root);
        int i = 1;
        while(nodeQueue.hasNext() && i < max) {
            GraphNode parent = nodeQueue.getNext();
            
            GraphNode leftChild = new GraphNode(i);
            parent.addEdge(leftChild);
            nodeQueue.add(leftChild);
            String rightChildAdd = "";
            if( i + 1 < max) {
                GraphNode rightChild = new GraphNode(i+1);
            
                parent.addEdge(rightChild);
                nodeQueue.add(rightChild);
                rightChildAdd = parent.getInfo() + "->" + rightChild.getInfo();
            }
            
            System.out.println(parent.getInfo() + "->" + leftChild.getInfo() + " " + rightChildAdd); 
                
            i += 2;
        }
        GraphProblemSolver gps = new GraphProblemSolver();
        
        gps.depthFirstTraversal(root, new boolean[max+1]);
        //not really testing - just printing out the value
    }
    
    
    
    
}

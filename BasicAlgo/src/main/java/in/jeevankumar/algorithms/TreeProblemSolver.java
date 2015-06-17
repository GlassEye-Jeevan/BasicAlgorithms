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

import in.jeevankumar.algorithms.config.Constants;
import in.jeevankumar.util.DefaultQueue;
import in.jeevankumar.util.TreeImpl;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class TreeProblemSolver<T extends Comparable> {
    public static void main (String[] args) {
        TreeProblemSolver<Integer> tps = new TreeProblemSolver<Integer>();
        tps.run(args);
    }
    
    public void run(String[] args) {
        String command = args[0];
        String parents = args[1];
        TreeImpl<Integer> anotherRoot = this.createTree(parents);
        String[] algoList = { 
            "LevelOrderTraversal",
            "MaxElement",
            "FindElement"
        };
        switch(command) {
            case "LevelOrderTraversal":
                levelOrderTraversal((TreeImpl<T>) anotherRoot);
                break;
            case "MaxElement":
                findMaxElement((TreeImpl<T>) anotherRoot);
                break;
            case "FindElement":
                searchElement((TreeImpl<T>) anotherRoot, Integer.parseInt(args[2]));
                break;
            case "DeepestNode":
                deepestNodeInATree((TreeImpl<T>) anotherRoot);
                break;
            default:
                System.out.println("Unrecognized Command \n "
                        + "Usage: java TreeProblemSolver <Algorithm Name> <list of parents>");
                System.out.println(Arrays.toString(algoList));
                
        }
        
    }
    
    private TreeImpl<Integer> createTree(int[] nodes, int[][] edges) {
        HashMap<Integer, TreeImpl<Integer>> nodeMap = new HashMap<>();
        TreeImpl<Integer> root = null;
        TreeImpl<Integer> temp;
            
        for(int i = 0; i<nodes.length; i++) {
            temp = new TreeImpl<Integer>(nodes[i]);
            nodeMap.put(new Integer(nodes[i]), temp);
            if (i==0) {
                root = temp;
            }
        }
        
        for(int i = 0; i<edges.length; i++) {
            TreeImpl<Integer> node = nodeMap.get( new Integer(edges[i][0]));
            node.addChild(nodeMap.get(new Integer(edges[i][1])));
            //System.out.println(node.getInfo() + " Adding Child " + edges[i][1]);
        }
        
        return root;
    }
    /**
     * Thins function creates a tree based on the parentChildArray. Where the 
     * indicies of the array are children and the value in the array of a
     * given index is the parent of the child. This is a quick way of defining 
     * the tree.
     * @param parentChildArray
     * @return 
     */
    private TreeImpl<Integer> createTree(int[] parentChildArray) {
        HashMap<Integer, TreeImpl<Integer>> nodeMap = new HashMap<>();
        TreeImpl<Integer> root = null;
        TreeImpl<Integer> temp;
        for (int i = 0; i < parentChildArray.length; i++) {
            temp = new TreeImpl<Integer>(i);
            nodeMap.put(i, temp);
            if (i==0) {
                root = temp;
            }
        }
        for (int i = 0; i < parentChildArray.length; i++) {
            int parent = parentChildArray[i];
            if (parent > -1)
                nodeMap.get(parent).addChild(nodeMap.get(new Integer(i)));
        }
        
        return root;
    }
    /**
     * This is a wrapper for createTree(int[]). This function has been written
     * to access input as a comma seperated integer values. It reads the 
     * String, and converts it into an integer array and then calls 
     * createTree(int[])
     * @param input
     * @return 
     */
    private TreeImpl<Integer> createTree(String input) {
        String split = ",";
        String[] inputs = input.split(split);
        int[] parents = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            parents[i] = Integer.parseInt(inputs[i]);
        }
        return createTree(parents);
    }
    
    private void levelOrderTraversal(TreeImpl<T> root) {
        DefaultQueue<TreeImpl> nodeQueue = new DefaultQueue<TreeImpl>();
        TreeImpl<T> currentNode = null;
        if(root!=null) {
            nodeQueue.add(root);
            currentNode = root;
            do {
                currentNode = nodeQueue.getNext();
                System.out.print(currentNode.getInfo() + " ");
                for (TreeImpl<T> child : currentNode.getChildren()) {
                    nodeQueue.add(child);
                }
            } while(nodeQueue.hasNext());
        }
        System.out.println();
    }
    
    /**
     * This function finds the maximum element in the tree using level order
     * traversal. 
     * @param root
     * @return 
     */
    private T findMaxElement(TreeImpl<T> root) {
        DefaultQueue<TreeImpl> nodeQueue = new DefaultQueue<TreeImpl>();
        TreeImpl<T> currentNode = null;
        T retVal = null;
        if(root!=null) {
            nodeQueue.add(root);
            currentNode = root;
            retVal = root.getInfo();
            do {
                currentNode = nodeQueue.getNext();
                T info = currentNode.getInfo();
                if(info.compareTo(retVal) > 0) {
                    retVal = currentNode.getInfo();
                }
                for (TreeImpl<Integer> child : currentNode.getChildren()) {
                    nodeQueue.add(child);
                }
            } while(nodeQueue.hasNext());
        }
        
        return retVal;
    }
    
    /**
     * This function searches the node with the given value in the given tree 
     * using level order traversal. 
     * @param root
     * @param nodeVal
     * @return  
     */
    private TreeImpl<T> searchElement(TreeImpl<T> root, int nodeVal) {
        DefaultQueue<TreeImpl> nodeQueue = new DefaultQueue<TreeImpl>();
        TreeImpl<T> currentNode = null;
        TreeImpl<T> retVal = null;
        if(root!=null) {
            nodeQueue.add(root);
            currentNode = root;
            do {
                currentNode = nodeQueue.getNext();
                if (currentNode==null)
                    continue;
                T info = currentNode.getInfo();
                if(info.compareTo(nodeVal) == 0) {
                    retVal = currentNode;
                    break;
                }
                //System.out.print(currentNode.getInfo() + " x  ");
                for (TreeImpl<Integer> child : currentNode.getChildren()) {
                    nodeQueue.add(child);
                }
            } while(nodeQueue.hasNext());
        }
        return retVal;
    }
    
    /**
     * The height of a given tree. 
     * @param node
     * @return 
     */
    private int heightOfTree(TreeImpl<T> node) {
        int retVal = 0;
        if(node!=null) {
            int maxHeight = -1;
            int currentHeight;
            for (TreeImpl child : node.getChildren()) {
                currentHeight = 1 + heightOfTree(child);
                if (currentHeight > maxHeight) {
                    currentHeight = maxHeight;
                }
            }
            
            retVal = maxHeight; 
        }
        return retVal;
    }
    
    /**
     * This function returns the deepest node in a TreeImpl. The logic
     * simply picks the last node added to the queue in a level order 
     * traversal.
     * @param root
     * @return 
     */
    private T deepestNodeInATree(TreeImpl<T> root) {
        T retVal = null;
        TreeImpl<T> currentNode = null;
        if (root!=null) {
            DefaultQueue<TreeImpl> parentQ = new DefaultQueue<TreeImpl>();
            parentQ.add(root);
            //currentNode = root;
            do {
                currentNode = parentQ.getNext();
                for (int i = 0; i < currentNode.children(); i++) {
                    parentQ.add(currentNode.getChild(i));
                }
            } while(parentQ.hasNext());
            retVal = currentNode.getInfo();
        }
        
        return retVal;
    }
}   

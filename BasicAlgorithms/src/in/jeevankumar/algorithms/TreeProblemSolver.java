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

import in.jeevankumar.util.Constants;
import in.jeevankumar.util.Queue;
import in.jeevankumar.util.Tree;
import java.util.HashMap;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class TreeProblemSolver<T extends Comparable> {
    public static void main (String[] args) {
        TreeProblemSolver<Integer> tps = new TreeProblemSolver<Integer>();
        tps.run();
    }
    
    public void run() {
        int[] nodes = { 1,2,3,4,5,6,7,8,9,10,11};
        int[][] edges = {
                            {1,2},
                            {1,3},
                            {2,4},
                            {2,5},
                            {3,6},
                            {3,7},
                            {4,8},
                            {4,9},
                            {4,10},
                            {4,11}
                        };
        Tree<Integer> root = this.createTree(nodes, edges);
        int[] parentChildArray = { -1 ,0, 1, 6, 6, 0, 0, 2, 7 };
        Tree<Integer> anotherRoot = this.createTree(parentChildArray);
        levelOrderTraversal((Tree<T>) root);
        
    }
    
    private Tree<Integer> createTree(int[] nodes, int[][] edges) {
        HashMap<Integer, Tree<Integer>> nodeMap = new HashMap<>();
        Tree<Integer> root = null;
        Tree<Integer> temp;
            
        for(int i = 0; i<nodes.length; i++) {
            temp = new Tree<Integer>(nodes[i]);
            nodeMap.put(new Integer(nodes[i]), temp);
            if (i==0) {
                root = temp;
            }
        }
        
        for(int i = 0; i<edges.length; i++) {
            Tree<Integer> node = nodeMap.get( new Integer(edges[i][0]));
            node.addChild(nodeMap.get(new Integer(edges[i][1])));
            //System.out.println(node.getInfo() + " Adding Child " + edges[i][1]);
        }
        
        return root;
    }
    
    private void levelOrderTraversal(Tree<T> root) {
        Queue<Tree> nodeQueue = new Queue<Tree>();
        Tree<T> currentNode = null;
        System.out.println("");
        if(root!=null) {
            nodeQueue.add(root);
            currentNode = root;
            do {
                currentNode = nodeQueue.getNext();
                System.out.print(currentNode.getInfo() + " ");
                for (Tree<Integer> child : currentNode.getChildren()) {
                    nodeQueue.add(child);
                    System.out.print(child.getInfo() + " ");
                }
                System.out.println();
            } while(nodeQueue.hasNext());
        }
        System.out.println("");
        
    }
    
    /**
     * This function finds the maximum element in the tree using level order
     * traversal. 
     * @param root
     * @return 
     */
    private T findMaxElement(Tree<T> root) {
        Queue<Tree> nodeQueue = new Queue<Tree>();
        Tree<T> currentNode = null;
        T retVal = null;
        //System.out.println("");
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
                //System.out.print(currentNode.getInfo() + " ");
                for (Tree<Integer> child : currentNode.getChildren()) {
                    nodeQueue.add(child);
                }
            } while(nodeQueue.hasNext());
        }
        //System.out.println("");
        
        return retVal;
    }
    
    /**
     * This function searches the node with the given value in the given tree 
     * using level order traversal. 
     * @param root
     * @param nodeVal
     * @return  
     */
    private Tree<T> searchElement(Tree<T> root, int nodeVal) {
        Queue<Tree> nodeQueue = new Queue<Tree>();
        Tree<T> currentNode = null;
        Tree<T> retVal = null;
        //System.out.println("");
        if(root!=null) {
            nodeQueue.add(root);
            currentNode = root;
            //retVal = root;
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
                for (Tree<Integer> child : currentNode.getChildren()) {
                    nodeQueue.add(child);
                }
            } while(nodeQueue.hasNext());
        }
        //System.out.println("");
        
        return retVal;
    }
    
    /**
     * The height of a given tree. 
     * @param node
     * @return 
     */
    private int heightOfTree(Tree<T> node) {
        int retVal = 0;
        if(node!=null) {
            int maxHeight = -1;
            int currentHeight;
            for (Tree child : node.getChildren()) {
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
     * This function returns the deepest node in a Tree. The logic
     * simply picks the last node added to the queue in a level order 
     * traversal.
     * @param root
     * @return 
     */
    private T deepestNodeInATree(Tree<T> root) {
        T retVal = null;
        Tree<T> currentNode = null;
        if (root!=null) {
            Queue<Tree> parentQ = new Queue<Tree>();
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
    /**
     * Thins function creates a tree based on the parentChildArray. Where the 
     * indicies of the array are children and the value in the array of a
     * given index is the parent of the child. This is a quick way of defining 
     * the tree.
     * @param parentChildArray
     * @return 
     */
    private Tree<Integer> createTree(int[] parentChildArray) {
        HashMap<Integer, Tree<Integer>> nodeMap = new HashMap<>();
        Tree<Integer> root = null;
        Tree<Integer> temp;
        for (int i = 0; i < parentChildArray.length; i++) {
            temp = new Tree<Integer>(i);
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
}   

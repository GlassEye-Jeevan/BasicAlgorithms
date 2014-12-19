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

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class BinaryTreeProblemSolver<T extends Comparable> {
    public static void main (String[] args) {
        BinaryTreeProblemSolver<Integer> tps = new BinaryTreeProblemSolver<Integer>();
        tps.run();
    }
    
    public void run() {
        //Tree<T> treeRoot = (Tree<T>) Helper.setUpBinaryTree((int)(Math.pow(2.0, 5) - 1.0 ), Constants.BOUND, false);
        Tree<T> treeRoot = (Tree<T>) Helper.setUpBinaryTree((int)(8 ), Constants.BOUND, false);
        /*preOrderTraversal(treeRoot);
        System.out.println();
        postOrderTraversal(treeRoot);
        System.out.println();
        inOrderTraversal(treeRoot);
        
        levelOrderTraversal(treeRoot);*/
        //System.out.println("Max Element:    " + findMaxElement(treeRoot));
        //System.out.println("Height Of Tree: " + heightOfBinaryTree(treeRoot));
        //System.out.println("Deepest Node:   " + deepestNodeInBinaryTree(treeRoot));
        int value1 = 8;
        int value2 = 5;
        inOrderTraversal(treeRoot);
        System.out.println("\n");
        System.out.println(leastCommonAncestorBinaryTree(treeRoot, value1, value2).getInfo());
        treeRoot = mirrorBinaryTree(treeRoot);
        inOrderTraversal(treeRoot);
        System.out.println("");
        System.out.println(leastCommonAncestorBinaryTree(treeRoot, value1, value2).getInfo());
        
    }
    
    private void preOrderTraversal(Tree<T> root) {
        System.out.print(root.getInfo() + " ");
        for(Tree child : root.getChildren()) {
            preOrderTraversal(child);
        }
    }
    
    private void postOrderTraversal(Tree<T> root) {
        for(Tree child : root.getChildren()) {
            postOrderTraversal(child);
        }
        System.out.print(root.getInfo() + " ");
    }
    
    private void inOrderTraversal(Tree<T> root) {
        if (root != null) {
            //System.out.print("( ");
            inOrderTraversal(root.getChild(0));
            System.out.print(root.getInfo() + " ");
            inOrderTraversal(root.getChild(1));
            //System.out.print(") ");
        }
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
                }
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
     * The height of the binary tree. 
     * @param node
     * @return 
     */
    private int heightOfBinaryTree(Tree<T> node) {
        int retVal = 0;
        if(node!=null) {
            int heightLeft;
            int heigthRight;
            
            heightLeft = 1 + heightOfBinaryTree(node.getChild(0));
            heigthRight = 1 + heightOfBinaryTree(node.getChild(1));
            
            retVal = (heightLeft > heigthRight)? heightLeft: heigthRight; 
        }
        return retVal;
    }
    
    /**
     * This function returns the deepest node in a Binary Tree. The logic
     * simply picks the last node added to the queue in a level order 
     * traversal.
     * @param root
     * @return 
     */
    private T deepestNodeInBinaryTree(Tree<T> root) {
        T retVal = null;
        Tree<T> currentNode = null;
        if (root!=null) {
            Queue<Tree> parentQ = new Queue<Tree>();
            parentQ.add(root);
            //currentNode = root;
            do {
                currentNode = parentQ.getNext();
                if(currentNode.children() > 0) {
                    parentQ.add(currentNode.getChild(0));
                } 
                
                if(currentNode.children() > 1) {
                    parentQ.add(currentNode.getChild(1));
                }
            } while(parentQ.hasNext());
            return currentNode.getInfo();
        }
        
        return retVal;
    }
    
    /**
     * This function turns a binary tree into as it is reflected in a mirror.
     * @param root
     * @return
     */
    private Tree<T> mirrorBinaryTree(Tree<T> root) {
        Tree<T> retVal = null;
        if(root != null) {
            Tree<T> leftChild = root.getChild(0);
            Tree<T> rightChild = root.getChild(1);
            //System.out.println("Switching " + ((leftChild!=null)?leftChild.getInfo():"") + " with " +  ((rightChild!=null)?rightChild.getInfo():"") );
            root.resetChildren();
            root.setChild(0,mirrorBinaryTree(rightChild));
            root.setChild(1,mirrorBinaryTree(leftChild));
            
            retVal = root;
        }
        return retVal;
    }
    
    /**
     * This function find the lease common ancestor of two given values in a 
     * given tree.
     * @param root
     * @param value1
     * @param value2
     * @return 
     */
    private Tree<T> leastCommonAncestorBinaryTree(Tree<T> root, int value1, int value2) {
        Tree<T> retVal = null;
        Tree<T> left, right;
        if (root != null) {
            if((root.getInfo().compareTo(value1) == 0) || (root.getInfo().compareTo(value2) == 0)) {
                retVal = root;
            } else {
                left = leastCommonAncestorBinaryTree(root.getChild(0), value1, value2);
                right = leastCommonAncestorBinaryTree(root.getChild(1), value1, value2);
                if(left != null && right != null) {
                    retVal = root;
                } else {
                    retVal = (left != null)? left:right;
                }
            }
        }
        return retVal;
    }
}   

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

import in.jeevankumar.util.BinaryTree;
import in.jeevankumar.util.Constants;
import in.jeevankumar.util.Queue;
import in.jeevankumar.util.Tree;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class BinaryTreeProblemSolver<T extends Comparable> {
    public static void main (String[] args) {
        BinaryTreeProblemSolver<Integer> btps = new BinaryTreeProblemSolver<Integer>();
        btps.run();
    }
    
    public void run() {
        //Tree<T> treeRoot = (Tree<T>) Helper.setUpBinaryTree((int)(Math.pow(2.0, 5) - 1.0 ), Constants.BOUND, false);
        BinaryTree<Integer> treeRoot = Helper.setUpBinaryTree((int)(8 ), Constants.BOUND, false);
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
    
    private void preOrderTraversal(BinaryTree<T> root) {
        if(root != null) {
            System.out.print(root.getInfo() + " ");
                preOrderTraversal(root.getLeft());
                preOrderTraversal(root.getRight());
        }
    }
    
    private void postOrderTraversal(BinaryTree<T> root) {
        if(root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(root.getInfo() + " ");
        }
    }
    
    private void inOrderTraversal(BinaryTree root) {
        if (root != null) {
            //System.out.print("( ");
            inOrderTraversal(root.getLeft());
            System.out.print(root.getInfo() + " ");
            inOrderTraversal(root.getRight());
            //System.out.print(") ");
        }
    }
    
    private void levelOrderTraversal(BinaryTree root) {
        Queue<BinaryTree> nodeQueue = new Queue<BinaryTree>();
        BinaryTree<T> currentNode = null;
        System.out.println("");
        if(root!=null) {
            nodeQueue.add(root);
            currentNode = root;
            do {
                currentNode = nodeQueue.getNext();
                System.out.print(currentNode.getInfo() + " ");
                if(currentNode.getLeft() != null) {
                    nodeQueue.add(currentNode.getLeft());
                }
                
                if(currentNode.getRight() != null) {
                    nodeQueue.add(currentNode.getRight());
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
    private T findMaxElement(BinaryTree<T> root) {
        Queue<BinaryTree> nodeQueue = new Queue<BinaryTree>();
        BinaryTree<T> currentNode = null;
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
                if(currentNode.getLeft() != null) {
                    nodeQueue.add(currentNode.getLeft());
                }
                
                if(currentNode.getRight() != null) {
                    nodeQueue.add(currentNode.getRight());
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
    private BinaryTree<T> searchElement(BinaryTree<T> root, int nodeVal) {
        Queue<BinaryTree> nodeQueue = new Queue<BinaryTree>();
        BinaryTree<T> currentNode = null;
        BinaryTree<T> retVal = null;
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
                if(currentNode.getLeft() != null) {
                    nodeQueue.add(currentNode.getLeft());
                }
                
                if(currentNode.getRight() != null) {
                    nodeQueue.add(currentNode.getRight());
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
    private int heightOfBinaryTree(BinaryTree<T> node) {
        int retVal = 0;
        if(node!=null) {
            int heightLeft;
            int heigthRight;
            
            heightLeft = 1 + heightOfBinaryTree(node.getLeft());
            heigthRight = 1 + heightOfBinaryTree(node.getRight());
            
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
    private T deepestNodeInBinaryTree(BinaryTree<T> root) {
        T retVal = null;
        BinaryTree<T> currentNode = null;
        if (root!=null) {
            Queue<BinaryTree> parentQ = new Queue<BinaryTree>();
            parentQ.add(root);
            //currentNode = root;
            do {
                currentNode = parentQ.getNext();
                if(currentNode.getLeft() != null) {
                    parentQ.add(currentNode.getLeft());
                }
                
                if(currentNode.getRight() != null) {
                    parentQ.add(currentNode.getRight());
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
    private BinaryTree mirrorBinaryTree(BinaryTree root) {
        BinaryTree<T> retVal = null;
        if(root != null) {
            BinaryTree<T> leftChild = root.getLeft();
            BinaryTree<T> rightChild = root.getRight();
            //System.out.println("Switching " + ((leftChild!=null)?leftChild.getInfo():"") + " with " +  ((rightChild!=null)?rightChild.getInfo():"") );
            //root.resetChildren();
            root.setLeft(mirrorBinaryTree(rightChild));
            root.setRight(mirrorBinaryTree(leftChild));
            
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
    private BinaryTree leastCommonAncestorBinaryTree(BinaryTree root, int value1, int value2) {
        BinaryTree<T> retVal = null;
        BinaryTree<T> left, right;
        if (root != null) {
            if((root.getInfo().compareTo(new Integer(value1)) == 0) || (root.getInfo().compareTo(new Integer(value2)) == 0)) {
                retVal = root;
            } else {
                left = leastCommonAncestorBinaryTree(root.getLeft(), value1, value2);
                right = leastCommonAncestorBinaryTree(root.getRight(), value1, value2);
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

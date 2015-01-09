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
package in.jeevankumar.util;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a binary tree that has the following property:
 * 1. Each parent can have at most two children
 * 
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class BinaryTree<T extends Comparable> {
    private T info;
    private BinaryTree left;
    private BinaryTree right;
    private BinaryTree parent;
    
    public BinaryTree(T info, BinaryTree left, BinaryTree right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    public BinaryTree(T info) {
        this.info = info;
    }
    
    /**
     * This method returns a reference to right child. 
     * 
     * @return 
     */
    public BinaryTree<T> getRight() {
        return this.right;
    }
    
    /**
     * This method returns a reference to left child. 
     * 
     * @return 
     */
    public BinaryTree<T> getLeft() {
        return this.left;
    }
    
    /**
     * This method sets the reference of the right child.
     * 
     * @param right 
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    /**
     * This method sets the reference of the left child. 
     * 
     * @param left 
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * This method returns the reference to the info object contained in the 
     * node.
     * 
     * @return the info
     */
    public T getInfo() {
        return info;
    }

    /**
     * This method sets the reference of info object contained in the 
     * node. 
     * @param info the info to set
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * This method gets the reference to the parent of the current node. 
     * 
     * @return the parent
     */
    public BinaryTree getParent() {
        return parent;
    }

    /**
     * This method sets the reference to the parent of the current node.
     * 
     * @param parent the parent to set
     */
    public void setParent(BinaryTree parent) {
        this.parent = parent;
    }
}

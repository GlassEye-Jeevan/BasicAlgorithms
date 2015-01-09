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

/**
 * Binary Search Tree is a tree with the following properties: 
 * 1. Each node can have at most two children
 * 2. The left child has a value that is lower than that of the parent
 * 3. The right child is greater than that of the parent. 
 * 
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class BinarySearchTree<T extends Comparable> {
    private T info;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;
    
    public BinarySearchTree(T info) {
        this.info = info;
    }
    
    public BinarySearchTree(T info, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        this.info  = info;
        this.left  = left;
        this.right = right;
    }

    /**
     * This method returns a reference to the info object.
     * 
     * @return the info
     */
    public T getInfo() {
        return info;
    }

    /**
     * This method sets the reference of info.
     * 
     * @param info the info to set
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * This method returns a reference to the left child. 
     * 
     * @return the left
     */
    public BinarySearchTree<T> getLeft() {
        return left;
    }

    /**
     * This method sets the reference of the left child. 
     * 
     * @param left the left to set
     */
    public void setLeft(BinarySearchTree<T> left) {
        this.left = left;
    }

    /**
     * This method returns a reference to the right child.
     * 
     * @return the right
     */
    public BinarySearchTree<T> getRight() {
        return right;
    }

    /**
     * This method sets the reference of the right child. 
     * 
     * @param right the right to set
     */
    public void setRight(BinarySearchTree<T> right) {
        this.right = right;
    }
    
    /**
     * Adding an element to the Binary Search Tree. 
     * 
     * @param element 
     */
    
    public void add(BinarySearchTree<T> element) {
        if (this.getInfo().compareTo(element) > 0) {
            if (this.getRight() != null) {
                this.getRight().add(element);
            } else {
                this.setRight(element);
            }
        } else {
            if(this.getLeft() != null) {
                this.getLeft().add(element);
            } else {
                this.setLeft(element);
            }
        }
    }
}

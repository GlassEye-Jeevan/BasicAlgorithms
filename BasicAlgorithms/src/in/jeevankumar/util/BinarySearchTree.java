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
     * @return the info
     */
    public T getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * @return the left
     */
    public BinarySearchTree<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BinarySearchTree<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinarySearchTree<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BinarySearchTree<T> right) {
        this.right = right;
    }
    
    
    
}

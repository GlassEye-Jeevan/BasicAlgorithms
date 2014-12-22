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
    
    
    public BinaryTree<T> getRight() {
        return this.right;
    }
    
    public BinaryTree<T> getLeft() {
        return this.left;
    }
    
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
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
     * @return the parent
     */
    public BinaryTree getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(BinaryTree parent) {
        this.parent = parent;
    }
}

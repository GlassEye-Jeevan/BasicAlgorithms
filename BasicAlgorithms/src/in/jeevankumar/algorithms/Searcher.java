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

import in.jeevankumar.util.Queue;
import java.util.Arrays;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class Searcher {
    
    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Usage: java Searcher <AlgorigthmName> <int array in csv>\n "
                    + "Ex: \"java Searcher BinarySearch 1,23,98,6,1,5,1,55,2,12,11" );
        } else {
            Searcher searcher = new Searcher();
            searcher.run(args);
        }
    }
    
    public void run(String[] args) {
        int[] tree = Helper.stringToIntArray(args[1]);
        int resultIndex = -1;
        System.out.println("Searching " + args[2] + " in " + Arrays.toString(tree));
        switch(args[0]) {
            case "BinarySearch":
                resultIndex = this.binarySearchRunner(tree, Integer.parseInt(args[2]));
                break;
            case "BreadthFirstSearch":
                resultIndex = this.breadthFirstSearch(tree, Integer.parseInt(args[2]));
                break;
            case "DepthFirstSearch":
                resultIndex = this.depthFirst(tree, Integer.parseInt(args[2]),0);
                break;
            default:
                System.out.println("Error: Unrecognized Algorithm " + args[0]);
        }
        System.out.println("Result Index: " + resultIndex);

    }
    
    private int binarySearchRunner(int[] intArray, int searchElement) {
        Sorter sorter = new Sorter();
        int[] sorted = sorter.mergeSort(intArray);
        int resultIndex = -1;
        
        System.out.println("Searching " + searchElement + " in " + Arrays.toString(sorted));
        resultIndex = binarySearch(sorted, 0, sorted.length, searchElement);
        System.out.println("Result Index: " + resultIndex);
        
        return resultIndex;
    }
    
    private int binarySearch(int[] searchArray, int start, int end, int searchElement) {
        int mid = (end+start)/2;
        //System.out.println("mid " + mid + " searchTerm " + searchElement);
        int retVal;
        if (searchArray[mid] == searchElement) {
            retVal = mid;
        } else if (searchArray[mid] > searchElement) {
            retVal = binarySearch(searchArray, 0, mid, searchElement);
        } else {
            retVal = binarySearch(searchArray, mid, searchArray.length, searchElement);
        }
        return retVal;
    }
    
    /**
     * This method searches a binary tree breadth first. It assumes an array 
     * implementation of tree. <Breadth first in a tree representation is just
     * iterating over from 0 to 1>
     * @param tree
     * @param searchElement
     * @return 
     */
    private int breadthFirstSearch(int[] tree, int searchElement) {
        Queue<Integer> myQueue = new Queue<Integer>();
        int resultIndex = -1;
        for (int i = 0; i < tree.length;) {
            System.out.println(i);
            if(tree[i] == searchElement) {
                resultIndex = i;
                break;
            } else {
                myQueue.add(i * 2 + 1);
                myQueue.add(i * 2 + 2);
            }
            
            i = myQueue.getNext().intValue();
        }
        
        return resultIndex;
    }
    
    /**
     * This method searches a binary tree depth first. It assumes an array 
     * implementation of tree. 
     * @param tree
     * @param searchElement
     * @return 
     */
    private int depthFirstSearch(int[] tree, int searchElement) {
        Queue<Integer> myQueue = new Queue<Integer>();
        int resultIndex = -1;
        for (int i = 0; i < tree.length;) {
            System.out.println(i);
            if(tree[i] == searchElement) {
                resultIndex = i;
                break;
            } else {
                myQueue.add(i * 2 + 1);
                myQueue.add(i * 2 + 2);
            }
            
            i = myQueue.getNext().intValue();
        }
        
        return resultIndex;
    }
    
    private int depthFirst(int[] tree, int searchElement, int index) {
        int retVal = -1;
        if (index < tree.length) {
            System.out.println(tree[index]);
        
            if (tree[index] == searchElement) {
                retVal =  index;
            } else {
                retVal = depthFirst(tree, searchElement, index * 2 + 1);
                if (retVal == -1)
                    retVal = depthFirst(tree, searchElement, index * 2 + 2);
            }
        }
        
        return retVal;
    }
    
}

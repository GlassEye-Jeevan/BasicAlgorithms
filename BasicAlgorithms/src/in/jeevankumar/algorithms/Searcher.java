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
        switch(args[0]) {
            case "BinarySearch":
                resultIndex = this.binarySearchRunner(tree, Integer.parseInt(args[2]));
                break;
            case "DepthFirstSearch":
                break;
            default:
                System.out.println("Error: Unrecognized Algorithm " + args[0]);
        }
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
     * implementation of tree.
     * @param tree
     * @param searchElement
     * @return 
     */
    private int breadthFirstSearch(int[] tree, int searchElement) {
        
        for (int i = 0; i < tree.length;) {
            
        }
        
        return 0;
    }
    
}

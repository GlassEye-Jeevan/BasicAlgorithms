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
public class Sorter {
    
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        if (args.length < 2) {
            System.out.println("Usage: java Sorter BubbleSort 11,23,1,2,4,-6,8,43,73,12,0,-23");
        } else {
            sorter.run(args);
        }
    }
    
    public void run(String[] args) {
        
        int[] unsorted = Helper.stringToIntArray(args[1]);
        int[] sorted = null;
        System.out.println(Arrays.toString(unsorted));
        
        switch(args[0]) {
                case "BubbleSort":
                    sorted = this.bubbleSort(unsorted);
                    break;
                case "MergeSort":
                    sorted = this.mergeSort(unsorted);
                    break;
                default:
                    System.out.println("Sort algorithm unrecognized: " + args[0]);
            }
         
        System.out.println(Arrays.toString(sorted));
        
        
    }
    
    private int[] bubbleSort(int[] unsorted) {
        for (int i = 0 ; i < unsorted.length; i++) {
            for (int j = 1; j < unsorted.length - i; j++) {
                if (unsorted[j-1] > unsorted[j]) {
                    int temp = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
        return unsorted;
    }
    
    /**
     * This is the ever popular merge sort. The algorithm splits the 
     * unsorted array in the middle and sorts each one in turn. The left and 
     * right halves are merged in ascending order to finally sort the array. 
     * Even the worst case the merge sort has O(n * log n).
     * 
     * @param unsorted
     * @return 
     */
    public int[] mergeSort(int[] unsorted) {
        int[] sorted = null;
        if (unsorted.length == 1) {
            sorted = unsorted;
        } else {
            int mid = unsorted.length / 2;
            
            int[] left = Arrays.copyOfRange(unsorted, 0, mid);
            int[] right = Arrays.copyOfRange(unsorted, mid, unsorted.length);
            
            mergeSort(left);
            mergeSort(right);
            
            sorted = merge(unsorted, left, right);
        }
        
        return sorted;
    }
    
    /**
     * This is a utility function for merge sort. It merges left and the right 
     * array into the 'unsorted' array, it merges the left and right arrays in
     * ascending manner.
     * 
     * @param unsorted
     * @param left
     * @param right
     * @return 
     */
    private int[] merge(int[] unsorted, int[] left, int[] right) {
        
        for (int i = 0, j=0, k=0; k < unsorted.length ;k++) {
            if (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    unsorted[k] = left[i++];
                } else {
                    unsorted[k] = right[j++];
                }
            } else if (i < left.length) {
                unsorted[k] = left[i++];
            } else if (j < right.length) {
                unsorted[k] = right[j++];
            }
        }
        return unsorted;
    }
}

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

import in.jeevankumar.util.MinHeap;
import java.util.Arrays;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class Sorter {
    
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.run(args);
    }
    
    public void run(String[] args) {
        
        int[] unsorted = Helper.stringToIntArray(args[1]);
        int maxElement = 0;
        if (args.length > 2) {
            maxElement = Integer.parseInt(args[2]);
        }
        int[] sorted = null;
        System.out.println(Arrays.toString(unsorted));
        
        switch(args[0]) {
                case "BubbleSort":
                    sorted = this.bubbleSort(unsorted);
                    break;
                case "ImprovedBubbleSort":
                    sorted = this.improvedBubbleSort(unsorted);
                    break;
                case "MergeSort":
                    sorted = this.mergeSort(unsorted);
                    break;
                case "QuickSort":
                    sorted = this.quickSort(unsorted, 0, unsorted.length);
                    break;    
                case "SelectionSort":
                    sorted = this.selectionSort(unsorted);
                    break;
                case "InsertionSort":
                    sorted = this.insertionSort(unsorted);
                    break;
                case "CountingNonRepeatingSort":
                    sorted = this.countingNonRepeatingSort(unsorted, maxElement);
                    break;
                
                case "CountingSort":
                    sorted = this.countingSort(unsorted, maxElement);
                    break;
                case "BucketSort":
                    sorted = this.bucketSort(unsorted, maxElement);
                    break;
                
                case "HeapSort":
                    sorted = this.heapSort(unsorted);
                    break;
                default:
                zdefault:
                    System.out.println("Sort algorithm unrecognized: " + args[0]);
            }
         
        System.out.println(Arrays.toString(sorted));
        
        
    }
    
    public int[] bubbleSort(int[] unsorted) {
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
    public int[] improvedBubbleSort(int[] unsorted) {
        boolean swapFlag = true;
        int swapCount = 0;
        for (int i = 0 ; i < unsorted.length && swapFlag; i++) {
            System.out.println(Arrays.toString(unsorted));
            swapFlag = false;
            for (int j = 1; j < unsorted.length - i; j++) {
                if (unsorted[j-1] > unsorted[j]) {
                    int temp = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = temp;
                    swapFlag = true;
                    //System.out.println("Swap Count " + ++swapCount);
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
    public int[] quickSort(int[] unsorted, int left, int right) {
        
        int index = partition (unsorted, left, right);
        
        //System.out.println(Arrays.toString(unsorted) + " " + left + " " + right + " " + index);
        if (left < index - 1 )
            quickSort(unsorted, left, index - 1);
        if (index < right) {
            quickSort(unsorted,index , right);
        }
        return unsorted;
    }
    
    private int partition(int[] unsorted, int left, int right) {
        int i = left; 
        int j = right;
        int temp;
        int pivot = unsorted[(left + right) / 2];
        //System.out.println(pivot);
        while (i <= j) {
            while (unsorted[i] < pivot )
                i++;
            while (unsorted[j] > pivot)
                j--;
            if  (i <= j ) {
                //System.out.println("Swapping "+ unsorted[i] + " and " + unsorted[j]);
                temp = unsorted[i];
                unsorted[i] = unsorted [j];
                unsorted[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    
    public int[] selectionSort(int[] unsorted) {
        int min, temp;
        for (int i = 0; i < unsorted.length; i++) {
            min = i;
            for (int j = i + 1; j < unsorted.length; j++ ) {
                if(unsorted[j] < unsorted[min])
                    min = j;
            }
            temp = unsorted[min];
            unsorted[min] = unsorted[i];
            unsorted[i] = temp;
        }
        return unsorted;
    }
    
    public int[] insertionSort(int[] unsorted) {
        int var;
        int j;
            
        for(int i = 1; i < unsorted.length ; i++) {
            //System.out.println(Arrays.toString(unsorted));
            var = unsorted[i];
            j = i;
            for (; j > 0 && unsorted[j-1] > var; j--) {
                unsorted[j] = unsorted[j-1];
            }
            unsorted[j] = var;
            //System.out.println( " Moving " + var + " to " + j);
        }
        return unsorted;
    }
    
    public int[] countingNonRepeatingSort(int[] unsorted, int maxElement) {
        System.out.println("Max " + maxElement);
        int minElement = 0;
        int[] temp = new int[maxElement + 1];
        int[] result = new int[unsorted.length];
        Helper.setAll(temp, -1);
        result = Helper.setAll(result, -1);
        
        
        for (int i = 0; i < unsorted.length; i++) {
            temp[unsorted[i]] = temp[unsorted[i]] + 2;
            System.out.println(" element " + unsorted[i]);
        }
        //int j;
        for (int i = 0,j = 0; i< temp.length; i++) {
            if(temp[i] == 1) {
                result[j++] = i;
            }
        }
        
        return result;
    }
    
    public int[] countingSort(int[] unsorted, int maxElement) {
        int[] temp = new int[maxElement + 1];
        int[] result = new int[unsorted.length ];
        Helper.setAll(result, -1);
        
        for(int i = 0; i < unsorted.length; i++) {
            temp[unsorted[i]] = temp[unsorted[i]] +1;
        }
        //System.out.println(" temp " + Arrays.toString(temp));
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i-1];
        }
        
        //System.out.println(" temp " + Arrays.toString(temp));
        
        for (int i = unsorted.length-1; i>=0; i--) {
            System.out.println(Arrays.toString(result) );
            int tempa = unsorted[i];
            int tempb = temp[tempa];
            //System.out.println("TempA " + tempa + " TempB " + (tempb-1));
            result[tempb-1] = tempa;
            temp[unsorted[i]] = temp[unsorted[i]] - 1;
        }
        return result;
    }
    
    /**
     * Bucket Sort assumes that the elements to be sorted are in a range between 
     * 0 and maxElement. The logic simply counts that number of occurrences of 
     * each element between 0 and maxElements and writes them into the output.
     * @param unsorted
     * @param maxElement
     * @return 
     */
    public int[] bucketSort(int[] unsorted, int maxElement) {
        int[] buckets = new int[maxElement + 1];
        Helper.setAll(buckets, 0);
        
        for (int i = 0; i < unsorted.length; i++) {
            ++buckets[unsorted[i]];
        }
        
        for(int i = 0, j = 0; j <= maxElement; j++) {
            for(int k = buckets[j]; k > 0; --k) {
                unsorted[i++] = j;
            }
        }
        return unsorted;
    }
    
    public int[] heapSort(int[] input) {
        MinHeap<Integer> minHeap = new MinHeap<Integer>();
        for(int i = 0; i < input.length; i++) {
            minHeap.add(new Integer(input[i]));
        }
        for(int i = 0; i < input.length; i++) {
            input[i] = minHeap.removeTop().intValue();
        }
        return input;
    }
    
    
}

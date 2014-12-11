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
public class QuickSort {
    public static void main(String[] args) {
         if (args.length == 0) {
            System.out.println("Usage: java QuickSort 12,23,24,24,16,16");
        } else {
            QuickSort qs = new QuickSort();
            qs.run(args);
        }
    }
    
    public void run(String[] args) {
        int[] unsorted = Helper.stringToIntArray(args[0]);
        System.out.println(Arrays.toString(unsorted));
        
        quickSort(unsorted, 0, unsorted.length - 1);
        System.out.println(Arrays.toString(unsorted));
    }
    
    private void quickSort(int[] unsorted, int left, int right) {
        
        int index = partition (unsorted, left, right);
        
        //System.out.println(Arrays.toString(unsorted) + " " + left + " " + right + " " + index);
        if (left < index - 1 )
            quickSort(unsorted, left, index - 1);
        if (index < right) {
            quickSort(unsorted,index , right);
        }
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
}

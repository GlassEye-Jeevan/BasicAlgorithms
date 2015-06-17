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

import in.jeevankumar.algorithms.config.Constants;
import java.util.Arrays;
import java.util.Random;
import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class SorterTest extends TestCase {
    public SorterTest (String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testMergeSort() {
        Random randome = new Random();
        int limit = randome.nextInt(100);
        Integer[] input = new Integer[limit];
        
        for (int i = 0; i < limit; i++) {
            input[i] = randome.nextInt();
        }
        Sorter<Integer> sorter = new Sorter<Integer>();
        
        Integer[] output = sorter.mergeSort(input);
        
        for (int i = 1; i < limit; i++) {
            assertTrue(output[i] > output[i-1]);
        }
    }
    
    public void testBubbleSort() {
        Random randome = new Random();
        int limit = randome.nextInt(100);
        Integer[] input = new Integer[limit];
        
        for (int i = 0; i < limit; i++) {
            input[i] = randome.nextInt();
        }
        Sorter<Integer> sorter = new Sorter<Integer>();
        
        Integer[] output = sorter.bubbleSort(input);
        
        for (int i = 1; i < limit; i++) {
            assertTrue(output[i] > output[i-1]);
        }
    }
    
    public void testQuickSort() {
        Random randome = new Random();
        int limit = randome.nextInt(100);
        int[] input = new int[limit];
        
        for (int i = 0; i < limit; i++) {
            input[i] = randome.nextInt();
        }
        Sorter sorter = new Sorter();
        
        int[] output = sorter.quickSort(input,0,input.length-1);
        
        assertArrayIsSorted(output);
        
    }
    
    private void assertArrayIsSorted(int[] apparentlySorted) {
        for (int i = 1; i < apparentlySorted.length; i++) {
            assertTrue(apparentlySorted[i] > apparentlySorted[i-1]);
        }
    }
    
    public void testInsertionSort() {
        Random rand = new Random();
        int limit = rand.nextInt(Constants.BOUND);
        Integer[] input = new Integer[limit];
        Integer[] copy = new Integer[limit];
        
        for(int i = 0; i < limit; i++) {
            input[i] = rand.nextInt();
            copy[i] = input[i];
        }
        
        Arrays.sort(copy);
        Sorter<Integer> sorter = new Sorter<Integer>();
        input = sorter.insertionSort(input);
        for(int i = 0; i < limit; i++) {
            assertEquals(input[i], copy[i]);
        }
    }
    
    public void testHeapSort() {
        Random rand = new Random();
        int limit = rand.nextInt(Constants.BOUND);
        int[] input = new int[limit];
        int[] copy = new int[limit];
        
        for(int i = 0; i < limit; i++) {
            input[i] = rand.nextInt();
            copy[i] = input[i];
        }
        
        Arrays.sort(copy);
        Sorter sorter = new Sorter();
        input = sorter.heapSort(input);
        for(int i = 0; i < limit; i++) {
            assertEquals(input[i], copy[i]);
        }
    }
}

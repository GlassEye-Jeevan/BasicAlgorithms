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

import in.jeevankumar.algorithms.config.Constants;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class MinHeapTest extends TestCase {
    
    public MinHeapTest(String testName) {
        super(testName);
    }
    
    public void setUp() throws Exception {
        super.setUp();
    }
    
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testAddRemove() {
        Random rand = new Random();
        MinHeap<Integer> minHeap = new MinHeap<Integer>();
        int limit = rand.nextInt(Constants.BOUND);
        int[] randInts = new int[limit];
        assertNull(minHeap.removeTop());
        for(int i = 0; i < limit; i++) {
            randInts[i] = rand.nextInt();
            minHeap.add(randInts[i]);
        }
        
        Arrays.sort(randInts);
        for(int i = 0; i < limit; i++) {
            assertEquals(randInts[i], minHeap.removeTop().intValue());
        }
        assertNull(minHeap.removeTop());
    }
        
}

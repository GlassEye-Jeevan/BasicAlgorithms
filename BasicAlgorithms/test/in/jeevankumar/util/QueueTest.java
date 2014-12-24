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
import java.util.Random;
import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class QueueTest extends TestCase {
    
    public QueueTest(String testName) {
        super(testName);
    }
    
    public void setUp() throws Exception {
        super.setUp();
    }
    
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testAdd() {
        Random rand = new Random();
        QueueImpl<Integer> newQ = new QueueImpl<Integer>();
        int testInt = rand.nextInt();
        newQ.add(testInt);
        
        Integer output = newQ.getNext();
        assertEquals(output.intValue(), testInt);
        
        int limit = rand.nextInt(Constants.BOUND);
        int[] array = new int[limit];
        for (int i = 0; i < limit; i++) {
            array[i] = rand.nextInt();
            newQ.add(array[i]);
        }
        
        for (int i = 0; i < limit; i++) {
            assertEquals(array[i], newQ.getNext().intValue());
        }
        assertNull(newQ.getNext());
    }
    
    public void testGetNext() {
        Random rand = new Random();
        QueueImpl<Integer> newQ = new QueueImpl<Integer>();
        assertNull(newQ.getNext());
        int testInt = rand.nextInt();
        newQ.add(testInt);

        Integer output = newQ.getNext();
        assertNull(newQ.getNext());
    }
}

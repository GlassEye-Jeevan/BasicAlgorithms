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

import java.util.Random;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class LinkedListNodeTest extends TestCase {
    
    public LinkedListNodeTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception{
        super.setUp();
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    @Test
    public void testLinkedList() {
        Random rand = new Random();
        int random = rand.nextInt();
        LinkedListNode<Integer> temp = new LinkedListNode<Integer>(random);
        assertEquals(temp.getInformation().intValue(), random);
        assertNull(temp.getNext());
        /*int limit = rand.nextInt(Constants.BOUND);
        int[] numbers = new int[limit];
        for (int i = 0; i < limit; i++) {
            numbers[i] = rand.nextInt();
            LinkedListNode<Integer> newItem = new LinkedListNode(numbers[i]);
            
        }
                */
    }
    
}

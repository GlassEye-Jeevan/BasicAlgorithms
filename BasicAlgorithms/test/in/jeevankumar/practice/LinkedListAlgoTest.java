/*
 * Copyright 2015 Jeevan Kumar <mail@jeevankumar.in>.
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
package in.jeevankumar.practice;

import java.util.Random;
import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class LinkedListAlgoTest extends TestCase {
    public LinkedListAlgoTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception{
        super.setUp();
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testMakeList() {
        Random rand = new Random();
        rand.nextInt();
        int limit = 10;
        Node head = createListDescending(limit);
        Node n = head;
        
        while(n != null) {
            assertEquals(n.data, limit--);
            n = n.next;
        }
        
    }
    private Node createListDescending(int limit) {
        Node head = new Node(limit--);
        while(limit > -1) {
            head.appendToTail(limit--);
        }
        return head;
    }
    private Node createListAscending(int limit) {
        if(limit == 0)
            return null;
        
        int i = 0;
        Node head = new Node(i++);
        while(i < limit) {
            head.appendToTail(i++);
        }
        return head;
    }
    private Node createListFromArray(int[] input) {
        if(input == null || input.length == 0)
            return null;
        int i = 0;
        Node head = new Node(input[i++]);
        while (i < input.length ) {
            head.appendToTail(input[i++]);
        }
        return head;
    }
    
    public void deleteNodeTest() {
        Node head = createListDescending(10);
        LinkedListAlgo lla = new LinkedListAlgo();
        
        //deleteMiddle node
        head = lla.deleteNod(head, 5);
        Node n = head;
        int limit = 10;
        while(n != null) {
            if( limit != 5 ) {
                assertEquals(n.data, limit);
                n = n.next;
            } 
            limit--;
        }
        
        //delete first
        head = createListDescending(10);
        head = lla.deleteNod(head, 10);
        limit = 10 - 1;
        n = head;
        while(n != null) {
            assertEquals(n.data, limit);
            n = n.next;
            limit--;
        }
        
        //delete last
        head = createListDescending(10);
        head = lla.deleteNod(head, 10);
        limit = 10 ;
        n = head;
        while(n != null) {
            assertEquals(n.data, limit);
            n = n.next;
            limit--;
        }
        
    }
    
    public void testCreateUnionOfSortedLists() {
        
        int limit = 10;
        Node a = createListAscending(limit);
        Node b = createListAscending(limit);
        LinkedListAlgo lla = new LinkedListAlgo();
        Node c = lla.createUnionOfSortedLists(a, b);
        Node n = c;
        
        for (int i = 0; i < limit; i++) {
            assertEquals(n.data, i);
            n = n.next;
        }
        
        //printList(c);
        int[] arr = {1,2,2,2,2,4};
        int[] brr = {0,3,3,3,5};
        a = createListFromArray(arr);
        b = createListFromArray(brr);
        //printList(a);
        //printList(b);
        
        limit = 6;
        n = lla.createUnionOfSortedLists(a, b);
        //printList(n);
        
        for (int i = 0; i < limit; i++) {
            assertEquals(n.data, i);
            n = n.next;
        }
        
    }
    private void printList(Node n) {
        
        while(n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }
}

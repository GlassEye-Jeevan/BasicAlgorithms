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
package in.jeevankumar.algorithms.chap1;

import in.jeevankumar.practice.Node;
import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class TestLinkedListSolution extends TestCase{
    public void testRemoveDuplicate() {
        LinkedListSolution sol = new LinkedListSolution();
        Node head = new Node(10);
        head.appendToTail(10);
        head.appendToTail(8);
        head.appendToTail(2);
        head.appendToTail(9);
        head.appendToTail(-3);
        head.appendToTail(10);
        head.appendToTail(-3);
        this.printList(head);
        head = sol.removeDuplicate(head);
        this.printList(head);
        
    }
    private Node createDescendingList(int i) {
        if(i < 0) 
            return null;
        
        Node head = new Node(i--);
        Node n = head;
        boolean flag = false;
        while(i > -1) {
            Node temp = new Node(i--);
            n.next = temp;
            n = temp;
            
        }
        return head;
    }
    private void printList(Node n) {
        while(n!=null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }
}

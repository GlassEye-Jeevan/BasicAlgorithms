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

import java.util.HashSet;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class LinkedListAlgo {
    public Node deleteNod(Node head, int d) {
        if(head.data == d) {
            Node temp = head;
            head = head.next;
            temp.next = null;
        } else {
            Node n = head;
            Node prev = head;
            while(n.next!=null) {
                if(n.next.data == d) {
                    n.next = n.next.next;
                    break;
                }
                n = n.next;
            }
            
        }
        return head;
    }
    public Node deleteDuplicate(Node head) {
        HashSet<Integer> hSet = new HashSet();
        Node prev = head;
        Node n = head;
        while(n != null) {
            if(!hSet.contains(n.data)) {
                hSet.add(n.data);
                prev = n;
            } else {
                prev.next = n.next;
            }
            n = n.next;
        }
        return null;
    }
    
    //Kth last element
    // if length is known problem is trial
    // else have a runner
    // alternatively use recursion - no value
    
    //delete a node from linkedlist
    //you have access to only the node in the linkedlist that neeeds to be 
    //deleted
    
    public void deleteCurrentNode(Node n) {
        while(n != null) {
            if(n.next != null)
                n.data = n.next.data;
            
            if(n.next.next == null)
                n.next = null;
                
        }
    }
    
    //pivot linkedlist based on a partciular node value
    //Logic: Keep 5 pointers (a) beg of First Half, (b) end of First Half
    //(c) beg of Second Half (d) end of Second Half (e) pivot node
    //Iterate through all nodes and place it in first and second half nodes
    //Merge at the end.
    
    
    // Is there a loop in the linkedList. Return pointer to begining of loop
    
    // Write a function that takes in two sorted lists and 
    // outputs   a sorted list that is their union. 
    public Node mergeList(Node a, Node b) {
        Node head;
        if(a.data < b.data) {
            head = a;
            a = a.next;
        } else { 
            head = b;
            b= b.next;
        }
        Node n = null;
        do {
            if(a != null && b != null)  {
                if(a.data < b.data) {
                    head.next = a;
                    a = a.next;
                } else {
                    head.next = b;
                    b = b.next;
                }
            } else {
                if(a == null)
                    n = b;
                else if (b == null) 
                    n = a;
                
                head.next = n;
                n = n.next;
            } 
        } while(a != null || b != null);
        return head;
    }

}
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

import in.jeevankumar.util.LinkedList;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class LinkedListProblemSolver {
    public static void main(String[] args) {
        LinkedListProblemSolver llps = new LinkedListProblemSolver();
        llps.run();
    }
    
    public void run() {
        //this.generateRandomLLAndPrint();
        //this.reverseLinkedListRunner();
        this.josephusSolverRunner();
    }
    
    public void generateRandomLLAndPrint() {
        int size = 10;
        LinkedList head = Helper.generateRandomList(size);
        System.out.println(head.toString());
    }
    
    private void reverseLinkedListRunner() {
        LinkedList head = Helper.generateRandomList(4);
        System.out.println("Base List  " + head);
        
        head = this.reverseLinkedList(head);
        System.out.println("Rvrsd List " + head);
    }
    
    /**
     * This function recursively reverses a singly linked list. 
     * @param head
     * @return 
     */
    private LinkedList reverseLinkedList(LinkedList head) {
        LinkedList retVal, second;
        //System.out.println("reversing " + head.getInformation());
            
        if (head == null) {
            retVal = head;  
        } else if (head.getNext() == null) {
            retVal = head;
        } else {
           
            second = head.getNext();
            head.setNext(null);
            retVal  = reverseLinkedList(second);
            second.setNext(head);
            //System.out.println(head.getInformation() + " " + second.getInformation() + " " + retVal.getInformation());
            
        }
        return retVal;
    }
    
    private void josephusSolverRunner() {
        for (int i = 5; i <10; i++) {
            System.out.println(i + ": " + josephusSolver(i, 3));
        }
    }
    
    /**
     * This function solves the Josephus problem using Linked List. 
     */
    private int josephusSolver(int size, int m) {
        LinkedList<Integer> josephusList = Helper.generateSequentialLinkedList(size);
        System.out.println("input " + josephusList.toString());
        
        LinkedList lastNode = this.getLastNode(josephusList);
        
        lastNode.setNext(josephusList);
        int i = 1;
        while(josephusList.getNext() != josephusList) {
            if ( (i % (m-1)) == 0 ) {
                //System.out.println("ditching " + josephusList.getNext().getInformation());
                josephusList.setNext(josephusList.getNext().getNext());
                
            }
            i++;
            //System.out.println(" At " + josephusList.getInformation());
            josephusList = josephusList.getNext();
        }
        return josephusList.getInformation();
    }
    
    private LinkedList getLastNode(LinkedList head) {
        LinkedList temp, retVal = null;
        //temp = head;
        while(head.getNext()!=null) {
            head = head.getNext();
        }
        return head;
    }
    
    
}

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

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class DoublyLinkedList<T> implements List<T> {
    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;        
    public DoublyLinkedList() {
        
    }
    /**
     * This method returns true if there is at least one item in the list.
     * 
     * @return 
     */
    @Override
    public boolean hasNext() {
        boolean retVal = true;
        if(head == null) {
            retVal = false;
        }
        return retVal;
    }
    /**
     * This method adds a node at the end of the List. 
     * 
     * @param information 
     */
    @Override
    public void add(T information) {
        LinkedListNode newNode = new LinkedListNode(information);
        
        if(head == null) {
            tail = head = newNode;
        }
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }
    /**
     * This method adds the new information node at the head of the list. 
     * 
     * @param information 
     */
    @Override
    public void addAtHead(T information) {
        LinkedListNode newNode = new LinkedListNode(information);
        if(head == null) {
            tail = head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }
    /**
     * This method adds the information node at the the given index.
     * 
     * @param information
     * @param index 
     */
    @Override
    public void add(T information, int index) {
        if (index == 0) {
            this.addAtHead(information);
        } else {
            size++;
            LinkedListNode currentNode = head;
            for(int i = 0; i < index-1; i++) {
                currentNode = currentNode.getNext();
            }
            LinkedListNode newNode = new LinkedListNode(information);
            LinkedListNode newChild = currentNode.getNext();
            newNode.setNext(newChild);

            currentNode.setNext(newNode);
        }
    }
    
    @Override
    public String toString() {
        LinkedListNode currentNode = head;
        StringBuffer sb = new StringBuffer();
        while (head!=null) {
            sb.append(currentNode.getInformation().toString())
                    .append(", ");
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }

    /**
     * This method returns the size of the List. 
     * @return the size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}

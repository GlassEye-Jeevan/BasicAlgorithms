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
public class DefaultStack<T> implements Stack<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    
    public DefaultStack() {
        //myList = new LinkedList<T>();
    }
    @Override
    public T pop() {
        LinkedListNode<T> temp = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
        return temp.getInformation();
    }
    
    @Override
    public void push(T element) {
        if (head == null) {
            head = new LinkedListNode<T>(element);
            tail = head;
        } else {
            LinkedListNode newNode = new LinkedListNode<T> (element);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean retVal = false;
        if (head == null) {
            retVal = true;
        }
        
        return retVal;
    }
}

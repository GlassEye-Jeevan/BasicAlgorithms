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

import java.util.List;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class Queue<T> {
    private LinkedList<T> head;
    private LinkedList<T> tail;
    public Queue() {
        //myList = new LinkedList<T>();
    }
    
    public void add(T element) {
        if (head == null) {
            head = new LinkedList(element);
            tail = head;
        } else {
            LinkedList lastElement = tail;
            tail = new LinkedList(element);
            lastElement.setNext(tail);
        }
    }
    
    public T getNext() {
        T retVal;
        if (head == null) {
            retVal = null;
        } else {
            retVal = head.getInformation();
            head = head.getNext();
        }
        return retVal;
    }
    
    public boolean hasNext() {
        boolean retVal = false;
        if (head != null) {
            retVal = true;
        }
        return retVal;
    }
    
    private LinkedList getLastElement(LinkedList<T> myList) {
        LinkedList start = myList;
        while (start.getNext()!=null) {
            start = start.getNext();
        }
        return start;
    }
}

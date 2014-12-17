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
public class Stack<T> {
    private DoublyLinkedList<T> first;
    private DoublyLinkedList<T> last;
    
    
    public Stack() {
        //myList = new LinkedList<T>();
    }
    public T pop() {
        DoublyLinkedList<T> temp = last;
        last = last.getPrev();
        last.setNext(null);
        temp.setPrev(null);
        return temp.getInformation();
    }
    
    public void push(T element) {
        if (first == null) {
            first = new DoublyLinkedList<T>(element);
            last = first;
        } else {
            DoublyLinkedList newNode = new DoublyLinkedList<T> (element);
            last.setNext(newNode);
            newNode.setPrev(last);
            last = newNode;
        }
    }
}

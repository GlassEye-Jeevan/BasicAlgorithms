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
public class LinkedListNode <T>{
    private T information;
    private LinkedListNode next;
    
    public LinkedListNode() {
        this.next = null;
    }
    
    public LinkedListNode(T info) {
        this.information = info;
        this.next = null;
    }
    /**
     * @return the information
     */
    public T getInformation() {
        return information;
    }

    /**
     * @param information the information to set
     */
    public void setInformation(T information) {
        this.information = information;
    }

    /**
     * @return the next
     */
    public LinkedListNode getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(LinkedListNode next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        LinkedListNode head = this;
        StringBuffer sb = new StringBuffer();
        while (head!=null) {
            sb.append(head.information.toString())
                    .append(", ");
            head = head.next;
        }
        return sb.toString();
    }
    
}

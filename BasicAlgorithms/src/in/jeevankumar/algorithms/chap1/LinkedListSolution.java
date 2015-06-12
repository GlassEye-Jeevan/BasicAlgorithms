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

import static com.sun.javafx.geom.Curve.prev;
import in.jeevankumar.practice.Node;
import java.util.HashMap;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class LinkedListSolution {
    public Node removeDuplicate(Node head) {
        if(head == null || head.next == null)
            return head;
			
        HashMap<Integer, Integer> map = new HashMap<>();
        Node n = head;
        Node prev = null;
        while(n != null) {
            if(map.containsKey(n.data) && n == head) {
                    head = head.next;
                    n.next = null;
                    break;
            } else if (map.containsKey(n.data)) {
                    prev.next = n.next;
                    n.next = null;
                    n = prev;
            } else {
                    map.put(n.data,0);
            }
            prev = n; 
            n = n.next;
        }
		
        return head;
    }
    /**
     * Return kth last element. 
     * 
     */
    public Node kThElement(Node head) {
        return null;
    }
}

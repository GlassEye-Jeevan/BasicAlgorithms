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

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class GraphNode<T> {
    private T Info;
    LinkedListNode<GraphNode> adjNodes;
    
    public GraphNode(T info) {
        this.Info = info;
    }
    /**
     * @return the Info
     */
    public T getInfo() {
        return Info;
    }

    /**
     * @param Info the Info to set
     */
    public void setInfo(T Info) {
        this.Info = Info;
    }
    
    public void addEdge(GraphNode adjNode) {
        LinkedListNode<GraphNode> item = new LinkedListNode<GraphNode>(adjNode);
        if(adjNodes == null) {
            adjNodes = item;
        } else {
            LinkedListNode<GraphNode> last = adjNodes;
            while(last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(item);
        }
    }
    
    public LinkedListNode getAdjNodes() {
        return adjNodes;
    }
    
    @Override
    public String toString() {
        return this.Info.toString();
    }
}

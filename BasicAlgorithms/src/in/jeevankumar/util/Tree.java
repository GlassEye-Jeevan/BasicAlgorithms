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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class Tree<T extends Comparable> {
    private T info;
    private List<Tree> children;

    
    public Tree(T information) {
        this.info = information;
        children = new ArrayList<Tree>();
    }

    /**
     * @return the info
     */
    public T getInfo() {
        return info;
    }
    
    public void addChild(Tree<Integer> child) {
        System.out.println(this.info + "Added Child " + child.getInfo());
        this.children.add(child);
    }
    
    public int children() {
        return children.size();
    }
    
    public Tree getChild(int index) {
        Tree<T> retVal = null;
        try {
            retVal = this.children.get(index);
        } catch (IndexOutOfBoundsException ex) {
            //do nothing
            retVal = null;
        }
        return retVal;
    }
    
    public void setChild(int index, Tree element ) {
        if (element == null )
            return;
        for (int i = 0; i <= index; i++) {
            
            if (i == index) {
                //System.out.println("Parent: " + this.getInfo() + " Added " + element.getInfo() + " at " + index);
                if (i == this.children())
                    this.children.add(element);
                else 
                    this.children.set(i, element);
            } else if (this.getChild(i)==null) {
                this.addChild(null);
            } 
        }
        
    }
    
    public List<Tree> getChildren() {
        return children;
    }

    public void resetChildren() {
        this.children = new ArrayList<Tree>();
    }
    
}

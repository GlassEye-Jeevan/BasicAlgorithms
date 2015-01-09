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
import java.util.Arrays;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class MinHeap<T extends Comparable> implements Heap<T> {
    
    private ArrayList<T> elements;
    int size;
    public MinHeap() {
        elements = new ArrayList<T>();
        size = 0;
    }
    
    @Override
    public ArrayList<T> add(T element) {
        //System.out.println("Adding " + element.toString());
        elements.add(element);
        //size++;
        int insertIndex = elements.size() - 1;
        int currentIndex = insertIndex;
        int parentIndex = (currentIndex - 1)/2;
        T temp;
        boolean flag = true;
        do {
            if(elements.get(parentIndex).compareTo(elements.get(currentIndex)) > 0) {
                //System.out.println("Swapping " + elements[parentIndex] + " " + elements[currentIndex]);
                swap(elements, parentIndex, currentIndex);
            }
            if(parentIndex == 0 ) {
                flag = false;
            }
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2 ;
            //System.out.println(" parent " + parentIndex);
        } while(flag);
        return this.getElements();
    }
    
    private void swap(ArrayList<T> list, int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
    
    @Override
    public T removeTop() {
        //System.out.println("removing " + elements.get(0) + " size " + size);
        T retVal = null;
        if(elements != null && elements.size() > 0) {
            retVal = elements.get(0);
            elements.set(0, elements.get(elements.size()-1));
            elements.remove(elements.size()-1);
            int parentIndex = 0;
            int childIndex;
            int selectedChild;
            boolean atBottom = false;
            do {
                childIndex = 2 * parentIndex + 1;
                selectedChild = -1;
                if (childIndex + 1 < elements.size()) {
                    T parent = elements.get(parentIndex); 
                    T leftChild = elements.get(childIndex);
                    T rightChild = elements.get(childIndex+1);
                    
                    if(((parent.compareTo(leftChild) > 0 ) 
                            || (parent.compareTo(rightChild) > 0))) {
                        selectedChild = (leftChild.compareTo(rightChild))  < 0 ? childIndex: childIndex +1;
                        swap(elements, parentIndex, selectedChild);
                    }
                } else if (childIndex < elements.size()) {
                    if(elements.get(parentIndex).compareTo(elements.get(childIndex)) > 0) {
                        swap(elements, parentIndex, childIndex);
                    }
                }
                parentIndex = selectedChild;
    //            System.out.println(" parent is now " + parentIndex + " " + elements[parentIndex]);
            } while(selectedChild > -1);
        }
        return retVal;
    }
    @Override
    public void printLevelOrderTraversal() {
        
        System.out.println("Level Order " + elements.toString());
    }

    /**
     * @return the elements
     */
    @Override
    public ArrayList<T> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    private void setElements(ArrayList<T> elements) {
        this.elements = elements;
    }
    
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

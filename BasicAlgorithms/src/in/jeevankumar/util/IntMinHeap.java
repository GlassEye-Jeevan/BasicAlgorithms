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

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class IntMinHeap {
    
    private int[] elements;
    int size;
    public IntMinHeap() {
        elements = new int[20];
        size = 0;
    }
    
    private void doubleSize() {
        int[] temp = new int[getElements().length * 2];
        for (int i = 0; i<getElements().length; i++) {
            temp[i] = getElements()[i];
        }
        setElements(temp);
    }
    
    public int[] add(int element) {
        if(size == getElements().length -1) {
            doubleSize();
        }
        elements[size++] = element;
        int insertIndex = size - 1;
        int currentIndex = insertIndex;
        int parentIndex = (currentIndex - 1)/2;
        int temp;
        boolean flag = true;
        do {
            if(elements[parentIndex] > elements[currentIndex]) {
                //System.out.println("Swapping " + elements[parentIndex] + " " + elements[currentIndex]);
                temp = elements[parentIndex];
                elements[parentIndex] = elements[currentIndex];
                elements[currentIndex] = temp;
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
    
    public int removeTop() {
        //System.out.println("removing " + elements[0] + " size " + size);
        int retVal = elements[0];
        elements[0] = elements[size-1];
        size--;
        int parentIndex = 0;
        int childIndex = parentIndex + 1;
        int selectedChild = 0;
        int temp;
        boolean flag = true;
        do {
            childIndex = 2 * parentIndex + 1;
            selectedChild = -1;
            //System.out.println("Child Index is "  + childIndex);
            if((elements[parentIndex] > elements[childIndex] || elements[parentIndex] > elements[childIndex + 1]) && (childIndex +1 < size )) {
                selectedChild = (elements[childIndex] < elements[childIndex + 1])? childIndex: childIndex +1;
                //System.out.println("Swapping: " + elements[parentIndex] + " " + elements[selectedChild]);
                temp = elements[parentIndex];
                elements[parentIndex] = elements[selectedChild];
                elements[selectedChild] = temp;
            }
            parentIndex = selectedChild;
//            System.out.println(" parent is now " + parentIndex + " " + elements[parentIndex]);
        } while(selectedChild > -1);
        return retVal;
    }
    public void printLevelOrderTraversal() {
        
        System.out.println("Level Order " + Arrays.toString(Arrays.copyOf(elements, size)));
    }

    /**
     * @return the elements
     */
    public int[] getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(int[] elements) {
        this.elements = elements;
    }
}

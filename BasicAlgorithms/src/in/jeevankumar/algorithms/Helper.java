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
package in.jeevankumar.algorithms;

import in.jeevankumar.util.Constants;
import in.jeevankumar.util.LinkedList;
import in.jeevankumar.util.Queue;
import in.jeevankumar.util.Tree;
import java.util.Random;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class Helper {
    
    public static void main(String[] args) {
        Helper.setupFullBinary(11);
    }
    
    /**
     * A quick way to round numbers.
     * @param input
     * @return 
     */
    public static double round (double input) {
        input = input * 1000.0;
        int tempInt = (int) input;
        double output = ((double)tempInt)/1000;
        return output;
    }
    /**
     * This function takes a comma separated integers in a String 
     * and into a array of integers. 
     * @param input
     * @return 
     */
    public static int[] stringToIntArray(String input ) {
        //String input = args[0];
        String inputs[] = input.split(",");
        int[] unsorted = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            unsorted[i] = Integer.parseInt(inputs[i].trim());
        }
        return unsorted;
    }
    
    public static LinkedList generateRandomList(int size) {
        LinkedList retVal = null;
        LinkedList head = null;
        LinkedList current = null;
        LinkedList previous = null;
        
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int randomInt = rand.nextInt(Constants.BOUND);
            current = new LinkedList(randomInt);
            
            if (previous != null) {
                previous.setNext(current);
            }
            
            if(i == 0) {
                head = current;
            }
            previous = current;
        }
        retVal = head;
        return retVal;
    }
    
    public static LinkedList generateSequentialLinkedList(int size) {
        LinkedList<Integer> retVal = null;
        LinkedList<Integer> head = null;
        LinkedList<Integer> current = null;
        LinkedList<Integer> previous = null;
        
        for (int i = 0; i < size; i++) {
            current = new LinkedList(new Integer(i));
            
            if (previous != null) {
                previous.setNext(current);
            }
            
            if(i == 0) {
                head = current;
            }
            previous = current;
        }
        retVal = head;
        return retVal;
    }
    
    public static Tree setupFullBinary(int size) {
        Queue<Tree> setupQ1 = new Queue<Tree>();
        Queue<Tree> setupQ2 = new Queue<Tree>();
        Tree<Integer>  head = null;
        Tree<Integer>  temp, tempParent, leftChild, rightChild;
        StringBuffer output = new StringBuffer();
            String LEFT = " Left: ";
            String RIGHT = " Right: ";
            
        for (int i = 1; i <= size; i += 2) {
            temp = new Tree<Integer>(i);
            
            if ( i == 1 ) {
                setupQ1.add(temp);
                head = temp;
                tempParent = setupQ1.getNext();
                output.append("Root: " + tempParent.getInfo());
                if (i+1 <= size) {
                    leftChild = new Tree<Integer>(i+1);
                    tempParent.addChild(leftChild);
                    setupQ1.add(leftChild);
                    output.append(LEFT).append(leftChild.getInfo());
                }
                if (i+2 <= size) {
                
                    rightChild = new Tree<Integer>(i+2);
                
                    tempParent.addChild(rightChild);
                    setupQ1.add(rightChild);
                    output.append(RIGHT).append(rightChild.getInfo())
                            .append(Constants.NEWLINE);
                }
                i++;
                
            } else {
                leftChild = new Tree<Integer>(i);
               
                tempParent = setupQ1.getNext();
                tempParent.addChild(leftChild);
                setupQ1.add(leftChild);
                
                output.append("Parent: ").append(tempParent.getInfo());
                output.append(LEFT).append(leftChild.getInfo());
                
                if (i+1 <= size) {
                    rightChild = new Tree<Integer>(i+1);
                    tempParent.addChild(rightChild);
                    setupQ1.add(rightChild);
                    output.append(RIGHT).append(rightChild.getInfo())
                            .append(Constants.NEWLINE);
                }
            }
        }
        System.out.print(output.toString());
        System.out.println("");
        
        return head;
    }
}

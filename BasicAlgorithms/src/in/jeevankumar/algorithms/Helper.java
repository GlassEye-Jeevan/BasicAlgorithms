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
        
        Helper.setUpBinaryTree(16, Constants.BOUND, false);
    }
    
    /**
     * A quick way to round numbers.
     * 
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

    /**
     * This function creates a binary tree of a given size. The nodes are 
     * numbered with random integers with a given bound.
     * @param size
     * @return 
     */    
    public static Tree<Integer> setUpBinaryTree(int size, int bound, boolean randomNumbering) {
        Random rand = new Random();
        Queue<Tree> parentQueue = new Queue<Tree>();
        Tree parentWithOneChild = null; 
        Tree head = null;
        Tree current;
        String ROOT_STRING = "Root: ";
        String PARENT_STRING = "Parent: ";
        String LEFT_STRING = " Left: ";
        String RIGHT_STRING = " Right: ";
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < size; i++) {
            int value = randomNumbering?rand.nextInt(bound):i+1;
            current = new Tree<Integer>(value);
            //current = new Tree<Integer>(i+1);
            parentQueue.add(current);
            if (head == null) {
                head = current;
                output.append(ROOT_STRING).append(head.getInfo())
                        .append(Constants.NEWLINE);
            } else if(parentWithOneChild != null) {
                parentWithOneChild.addChild(current);
                output.append(RIGHT_STRING).append(current.getInfo())
                        .append(Constants.NEWLINE);
                parentWithOneChild = null;
            } else {
                Tree newParent = parentQueue.getNext();
                newParent.addChild(current);
                parentWithOneChild = newParent;
                output.append(PARENT_STRING).append(newParent.getInfo())
                        .append(LEFT_STRING).append(current.getInfo());
            }
        }
        System.out.println(output.toString());
        return head;
    }
}

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

import in.jeevankumar.util.BinaryTree;
import in.jeevankumar.algorithms.config.Constants;
import in.jeevankumar.util.LinkedListNode;
import in.jeevankumar.util.DefaultQueue;
import in.jeevankumar.util.TreeImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterReader;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    /**
     * This function takes a comma separated integers in a String 
     * and into a array of integers. 
     * @param input
     * @return 
     */
    public static Integer[] stringToGenericIntArray(String input ) {
        //String input = args[0];
        String inputs[] = input.split(",");
        Integer[] unsorted = new Integer[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            unsorted[i] = new Integer(Integer.parseInt(inputs[i].trim()));
        }
        return unsorted;
    }
    public static LinkedListNode generateRandomList(int size) {
        LinkedListNode retVal = null;
        LinkedListNode head = null;
        LinkedListNode current = null;
        LinkedListNode previous = null;
        
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int randomInt = rand.nextInt(Constants.BOUND);
            current = new LinkedListNode(randomInt);
            
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
    
    public static LinkedListNode generateSequentialLinkedList(int size) {
        LinkedListNode<Integer> retVal = null;
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> current = null;
        LinkedListNode<Integer> previous = null;
        
        for (int i = 0; i < size; i++) {
            current = new LinkedListNode(new Integer(i));
            
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
    public static BinaryTree<Integer> setUpBinaryTree(int size, int bound, boolean randomNumbering) {
        Random rand = new Random();
        DefaultQueue<BinaryTree> parentQueue = new DefaultQueue<BinaryTree>();
        BinaryTree parentWithOneChild = null; 
        BinaryTree head = null;
        BinaryTree current;
        String ROOT_STRING = "Root: ";
        String PARENT_STRING = "Parent: ";
        String LEFT_STRING = " Left: ";
        String RIGHT_STRING = " Right: ";
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < size; i++) {
            int value = randomNumbering?rand.nextInt(bound):i+1;
            current = new BinaryTree<Integer>(value);
            //current = new TreeImpl<Integer>(i+1);
            parentQueue.add(current);
            if (head == null) {
                head = current;
                output.append(ROOT_STRING).append(head.getInfo())
                        .append(Constants.NEWLINE);
            } else if(parentWithOneChild != null) {
                parentWithOneChild.setRight(current);
                output.append(RIGHT_STRING).append(current.getInfo())
                        .append(Constants.NEWLINE);
                parentWithOneChild = null;
            } else {
                BinaryTree newParent = parentQueue.getNext();
                newParent.setLeft(current);
                parentWithOneChild = newParent;
                output.append(PARENT_STRING).append(newParent.getInfo())
                        .append(LEFT_STRING).append(current.getInfo());
            }
        }
        //System.out.println(output.toString());
        return head;
    }
    /**
     * Set all the values in the integer array to value. 
     * @param input
     * @param value
     * @return 
     */
    public static int[] setAll (int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            input[i] = value;
        }
        return input;
    }

    static int[] readFileIntoIntArray(String inputFileName) {
        int[] retVal = null;
        try {
            Scanner sc = new Scanner(new File(inputFileName));
            
            String inputString = sc.nextLine();
            
            retVal = Helper.stringToIntArray(inputString);
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retVal;
    }
    
    /**
     * Creates an int array of given size.
     * @param size (int) - expected size of output array
     * @param rangeLimit (int) - the expected range of values 0 (inclusive) and rangeLimit (exclusive)
     * @return output int array of given size
     */
    static int[] createArray(int size, int rangeLimit) {
        Random rand = new Random();
        int[] retVal = new int[size];
        for(int i = 0; i < size; i++) {
            retVal[i] = rand.nextInt(rangeLimit);
        }
        return retVal;
    }
    
    /**
     * Prints a matrix
     * @param a (int[][]) - Input square matrix
     */
    public static void printMatrix(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }
}

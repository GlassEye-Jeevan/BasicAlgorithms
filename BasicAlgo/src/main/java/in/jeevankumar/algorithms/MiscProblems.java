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
import in.jeevankumar.util.DefaultQueue;
import in.jeevankumar.util.GraphNode;
import in.jeevankumar.util.LinkedListNode;
import in.jeevankumar.util.MinHeap;
import in.jeevankumar.util.wip.Node;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class MiscProblems {
    public static void main(String[] args) {
        MiscProblems mp = new MiscProblems();
        mp.run(args);
    }
    
    public void run(String[] args) {
        int[] integers;
        switch(args[0]) {
            case "RotateMatrix":
                int[][] input = readMatrix(args);
                printMatrix(input);
                int[][] output = rotateMatrix(input);
                printMatrix(output);
                //java MiscProblems RotateMatrix 4x3 1,1,1 2,2,2 3,3,3 4,4,4
                break;
            case "GenericMinHeap":
                String inputFileName = args[1];
                integers = Helper.readFileIntoIntArray(inputFileName);
                System.out.println("Input " + Arrays.toString(integers));
                //MinHeap<Integer> minHeap = new MinHeap<Integer>();
                MinHeap<Integer> minHeap = addToGenericMinHeap(integers);
                minHeap.printLevelOrderTraversal();
                System.out.print("Removing top " + minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                System.out.print("Removing top "+ minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                System.out.print("Removing top "+ minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                System.out.print("Removing top "+ minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                System.out.print("Removing top "+ minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                System.out.print("Removing top "+ minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                System.out.print("Removing top "+ minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                System.out.print("Removing top "+ minHeap.removeTop()+ " ");minHeap.printLevelOrderTraversal();
                break;
            case "meetingConflict":
                int noOfInputs = Integer.parseInt(args[1]);
                int[] start = new int[noOfInputs];
                int[] end = new int[noOfInputs];
                int i = 0;
                while(noOfInputs > 1) {
                    String inputString = args[i+2];
                    String[] split = inputString.split(",");
                    start[i] = Integer.parseInt(split[0]);
                    end[i] = Integer.parseInt(split[1]);
                    i++;
                }
                if(isThereAConflict(start, end)) {
                    System.out.println("Conflict");
                } else {
                    System.out.println("No Conflict");
                }
                break;
            
        }
    }
    
    private int[][] readMatrix(String[] args) {
        String[] indexString;
        indexString = args[1].split("x");
        int rows = Integer.parseInt(indexString[0]);
        int cols = Integer.parseInt(indexString[1]);
        //System.out.println(rows + " X " +cols);
        int[][] inputMatrix = new int[rows][cols];
        int argIndex = 2;
        for(int i = 0; i< rows; i++,argIndex++) {
            String[] row = args[argIndex].split(",");
            for (int j = 0; j<cols; j++) {
                inputMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        return inputMatrix;
    }
    
    
    private void printMatrix(int[][] input) {
        for(int i = 0; i<input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }
    
    private int[][] rotateMatrix(int[][] input) {
        int temp;
        int[][] output = new int[input[0].length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j< input[i].length; j++) {
                output[j][input.length - i - 1] = input[i][j];
            }
        }
        return output;
    }

    private MinHeap<Integer> addToGenericMinHeap(int[] inputs) {
        MinHeap<Integer> myHeap = new MinHeap<Integer>();
        for(int i = 0; i < inputs.length; i++) {
            myHeap.add(new Integer(inputs[i]));
        }
        return myHeap;
    }
    
    /** Write a program to find conflicts in meetings. 
     * 
     * @param start
     * @param end
     * @return 
     */
    public boolean isThereAConflict(int[] start, int[] end) {
        boolean conflict = false;
        int[] hours = new int[24];
        for(int i = 0; i < start.length ; i++) {
            for(int j = start[i]; j < end[i]; j++) {
                if(hours[j] == 1) {
                    conflict = true; 
                    break;
                } else {
                    hours[j] = 1;
                }
            }
            if(conflict)
                break;
        }
        
        return conflict;
    }
    
    /** Write a program to find no of rooms required for meetings. 
     * 
     * @param start
     * @param end
     * @return 
     */
    public int countMeetingRooms(int[] start, int[] end) {
        int[] hours = new int[24];
        int max = -1;
        for(int i = 0; i < start.length; i++) {
            for(int j = start[i]; j < end[i]; j++) {
                hours[j]++;
                if(hours[j] > max) {
                    max = hours[j];
                }
            }
        }
        return max;
    }
    
    /**
     * Add two strings of binary numbers. Do not covert the string to integers.
     * @param input
     * @return 
     */
    public String booleanAddString(String[] input) {
        StringBuffer retVal = new StringBuffer();
        final int zeroSum = '0'<<1;
        final int oneZeroSum = '0' + '1';
        final int oneSum = '1'<<1;
        int i = input[0].length() - 1;
        int j = input[1].length() - 1;
        boolean carry = false;
        while( i > -1 || j > -1) {
            int sum = 0;
            if (i > -1 && j > -1) {
                sum = input[0].charAt(i) + input[1].charAt(j);
                if(!carry && sum == zeroSum) {
                    retVal.append("0");
                } else if (carry && sum == zeroSum) {
                    retVal.append("1");
                    carry = false;
                } else if (!carry && sum == oneZeroSum) {
                    retVal.append("1");
                } else if (carry && sum == oneZeroSum) {
                    retVal.append("0");
                    carry = true;
                } else if (!carry && sum == oneSum) {
                    retVal.append("0");
                    carry = true;
                } else if(carry && sum == oneSum) {
                    retVal.append("1");
                    carry = true;
                }
            } else {
                int index = 0;
                if (i > -1)
                    index = 0;
                else 
                    index = 1;
                
                if(carry && input[index].charAt(i) == '0') {
                    retVal.append("1");
                    carry = false;
                    //System.out.println(" test " + retVal.reverse().toString());
                } else if(carry && input[index].charAt(i) == '1') {
                    retVal.append("0");
                    carry = true;
                } else if (!carry ) {
                    retVal.append(input[index].charAt(i));
                }
            }
            
            i--;
            j--;
        }
        if(carry)
            retVal.append("1");
        
        retVal = retVal.reverse();
        return retVal.toString();
    }
    //N-queen problem
    //Server Logs: Each log has two data types (a) integer (b) string
    
    //Local minima or maxima
    
    //maxDiff in array elemets with second coming after the first
    int maxDiff(int[] input) {
        int[][] output = new int[input.length][input.length];
        int maxSecond = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < input.length; i++) {
            int diff;
            if(i==0) {
                for(int j = i+1; j < input.length; j++) {
                    diff = input[j] - input[i];
                    if(diff > max ){
                        max = diff;
                        maxSecond = input[j];
                    }
                }
            } else {
                diff = maxSecond - input[i];
                if(diff > max ){
                        max = diff;
                }
            }
        }
        return max;
    }
    public char[] inPlaceReverseString(char[] input, int start, int end) {
        
        if(start < end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            return inPlaceReverseString(input, start+1, end-1);
        } else 
            return input;
    }
    
    public boolean isBinaryTreeBalanced(BinaryTree node) {
        boolean retVal = false;
        if(node == null || ( node.left == null && node.right == null)) {
            retVal = true;
        } else {
            
            int leftHieght = treeHeight(node.left);
            int rightHieght = treeHeight(node.right);
            if(Math.abs(leftHieght-rightHieght) > 1) {
                retVal = false;
            } else {
                retVal = isBinaryTreeBalanced(node.left) && isBinaryTreeBalanced(node.right);
            }
        }
        return retVal;
    }
    
    public int treeHeight(BinaryTree node) {
        int retVal;
        if(node == null) {
            retVal = 0;
        } else if( node.left == null && node.right == null) {
            retVal = 1;
        } else {
            int leftHeight = treeHeight(node.left);
            int rightHeight = treeHeight(node.right);
            if(leftHeight > rightHeight)
                retVal = leftHeight + 1;
            else
                retVal = rightHeight + 1;
            //return treeHeight(node.left) + treeHeight(node.right);
        }
        return retVal;
    }
    
    public int checkHeight(BinaryTree root) {
        
        if(root == null) {
            return 0;
        }
        
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1) {
            return -1;
        } 
        
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }
        
        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        
    }
    
    public boolean routeExists(GraphNode start, GraphNode end) {
        List<GraphNode> nodeQueue = new LinkedList<GraphNode>();
        nodeQueue.add(start);
        boolean retVal = false;
        while(!nodeQueue.isEmpty()) {
            GraphNode node = nodeQueue.get(0);
            nodeQueue.remove(node);
            if(node.equals(end)) {
                retVal = true;
                break;
            } else {
                LinkedListNode<GraphNode> lgNode = node.getAdjNodes();
                while(lgNode!=null) {
                    nodeQueue.add(lgNode.getInformation());
                    lgNode = lgNode.getNext();
                }
            }
            
        }
        return retVal;
    }
    public BinaryTree createBinaryTreeOfMinimalHieght(int[] sortedInts) {
        BinaryTree retVal = null;
        Queue<BinaryTree> nodeQueue = (Queue<BinaryTree>) new DefaultQueue<BinaryTree>();
        int counter = 0;
        for(int i = sortedInts.length / 2 + 1; i > -1; i--) {
            BinaryTree leftBinTree = new BinaryTree(sortedInts[i]);
            BinaryTree rightBinTree;// = new BinaryTree(sortedInts[i]);
            
            if(retVal == null) {
                retVal = leftBinTree;
                nodeQueue.add(retVal);
                counter++;
            } else {
                BinaryTree node = nodeQueue.element();
                nodeQueue.remove(node);
                
                node.setLeft(leftBinTree);
                counter++;
                nodeQueue.add(leftBinTree);
                if(sortedInts.length/2 + counter-1 < sortedInts.length) {
                    rightBinTree = new BinaryTree(sortedInts[sortedInts.length/2 + counter]);

                    node.setRight(rightBinTree);
                    counter++;
                    nodeQueue.add(rightBinTree);
                }
            }
           
        }
        return retVal;
        
    }
    
    public BinaryTree createMinimalBinaryTree(int[] sortedInts, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start + end)/2;
        BinaryTree binNode = new BinaryTree(sortedInts[mid]);
        binNode.left = createMinimalBinaryTree(sortedInts, start, mid-1);
        binNode.right = createMinimalBinaryTree(sortedInts, mid+1, end);
        
        return binNode;
    }
    
    public boolean isBinarySearchTree(BinaryTree root, Integer min, Integer max) {
        boolean retVal = true;
        if(root == null) {
            return true;
        } 
        if((min!=null && root.info.compareTo(min) < 0) && 
                max!=null && root.info.compareTo(max) > 0) {
            return false;
        }
            
        if(!isBinarySearchTree(root.left, min, (Integer)root.info) ||
                !isBinarySearchTree(root.left, (Integer)root.info, max)) {
            return false;
        }
        return true;
    }
    
    public int insertMinN(int m, int n, int start, int end) {
        System.out.println(~0);
        int allOnes = ~0;
        int leftMask  = allOnes << (start + 1);
        int rightMask = (1 << end ) - 1;
        int totalMask = leftMask | rightMask;
        
        int n_cleared = n & totalMask;
        int m_shifted = m << end;
        return n_cleared | m_shifted;
    }
    
    public void calculationQuestionOrder() {
        //Assume that userid, question
        
    }
    
    public void printPairsThatSumToK(int k, int[] input) {
        int first, second;
        for (int i = 0; i < input.length; i++) {
            first = input[i];
            for(int j = i + 1; j < input.length; j++) {
                second = input[j];
                if(first + second == k) {
                    System.out.println("( " + first + ", " + second + " )");
                }
            }
        }
    }
}

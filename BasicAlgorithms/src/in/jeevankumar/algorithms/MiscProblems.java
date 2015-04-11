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

import in.jeevankumar.util.MinHeap;
import java.util.Arrays;

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
    /*public String booleanAdd(String input1, String input2) {
        StringBuffer sb = new StringBuffer("");
        
        int length1 = input1.length();
        int length2 = input2.length();
        boolean carry = false;
        for(int i = length1 - 1, j = length2 - 1 ; i > -1 || j > -1; i--, j--) {
            if(i < length1 && j < length2) {
                if(input1.charAt(i) == 1 && input2.charAt(j) == 1) {
                    if(!carry)
                        sb.append("0");
                      else 
                        sb.append("1");

                    carry = true;
                } else if((input1.charAt(i) == 0 && input2.charAt(j) == 1) || (input1.charAt(i) == 1 && input2.charAt(j) == 0)) {
                    if(!carry)
                        sb.append("1");
                      else {
                        sb.append("0");
                        carry = true;
                    }

                }
            } else {
                if (i > -1) {
                    if(carry) {
                        
                    }
                }
            }
        }
        
    }*/
    
}

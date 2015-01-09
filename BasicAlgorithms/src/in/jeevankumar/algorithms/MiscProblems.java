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
}

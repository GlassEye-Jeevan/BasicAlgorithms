/*
 * Copyright 2015 jeevanWork.
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
package in.jeevankumar.practice;

import java.util.Arrays;
import junit.framework.TestCase;

/**
 *
 * @author jeevanWork
 */
public class ArrayAlgoTest extends TestCase {
    
    /**
     * Test the shuffle function. Take 10 sequential numbers and shuffle them.
     * 
     */
    public void testShuffle() {
        ArrayAlgo aa = new ArrayAlgo();
        int[] inputArray = new int[10];
        for(int i = 0; i < 10; i++) {
            inputArray[i] = i + 1;
        } 
        System.out.println(Arrays.toString(inputArray));
        int[] output = aa.shuffleArray(inputArray);
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += output[i];
        }
        assertEquals(sum, 10*11 / 2);
        System.out.println(Arrays.toString(output));
    }
    
    /**
     * Returns true if any two numbers sum up to the given sum.
     * @param input (int[]) - input integer array
     * @param sum (int) expected sum
     * @return 
     */
    public boolean hasTwoNumberSum(int[] input, int sum) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if(input[i] + input[j] == sum)
                    return true;
            }
        }
        return false;
    }
    
    public void testRotateMatrix() {
        int[][] a = {{1,2,3},
                     {4,5,6},
                     {7,8,9}};
        ArrayAlgo aa = new ArrayAlgo();
        aa.rotateMatrix(a);
    }
    
}

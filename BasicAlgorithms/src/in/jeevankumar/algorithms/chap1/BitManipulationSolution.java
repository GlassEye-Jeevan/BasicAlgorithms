/*
 * Copyright 2015 Jeevan Kumar <mail@jeevankumar.in>.
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
package in.jeevankumar.algorithms.chap1;

import in.jeevankumar.algorithms.Helper;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class BitManipulationSolution {
    public static void main(String[] args) {
        BitManipulationSolution sol = new BitManipulationSolution();
        sol.copyBits(0, 0, 5, 4);
    }
    /**
     * Copy m into n such that m starts at bit j and ends at bit i. 
     * Assume distance between jth and ith bit is the exact length of m.
     * @param n
     * @param m
     * @param i
     * @param j
     * @return 
     */
    public int copyBits(int n, int m, int i, int j) {
        int mask1 = ~0;
        int mask2 = ~0;
        
        mask1 = mask1 << (j+1);
        mask1 = ~mask1;
        mask2 = mask2 <<(i + 1);
        
        mask1 = mask1 | mask2;
        //System.out.println("mask1 " + Integer.toBinaryString(mask1));
        n = n & mask1;
        
        m = m << i ;
        n = n | m;
        
        return n;
    }
    
    public void printInBinary(double i) {
        
    }
}

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
package in.jeevankumar;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class FibonacciSeries {
    private Map<Integer, Integer> fibCache = null;
    public static void main(String[] args) {
        FibonacciSeries fs = new FibonacciSeries();
        fs.run(args);
    }
    public void run(String[] args){
        if (args.length == 0) {
            System.out.println("Usage: java FibonacciSeries 11");
        } else {
            
            int n = Integer.parseInt(args[0]);
            long startIterFib = System.currentTimeMillis();
            
            fibonacciIterative(n);
            
            long startRecFib = System.currentTimeMillis();
            int fibNo = fib(n);
            long endRecFib = System.currentTimeMillis();
            
            System.out.println(n + "th fibonacci is " + fibNo);
            fibCache = new HashMap<Integer, Integer>();
            
            long startRecFibCache = System.currentTimeMillis();
            fibNo = fibCache(n);
            long endRecFibCache = System.currentTimeMillis();
            
            System.out.println(n + "th fibonacci is " + fibNo);
            System.out.println(" Time Comparison " + (startRecFib - startIterFib) + " " 
                    + (endRecFib - startRecFib) + " " 
                    + (endRecFibCache - startRecFibCache));
            
        }
    }
    
    /**
     * This function returns the nth Fibonacci number. It iteratively starts 
     * from the first Fibonacci number and continues counting until the nth
     * Fibonacci number is found.
     * That is fib (n) = fib (n -1) + fib (n-2);
     * @param n
     * @return nth Fibonacci
     */
    
    private void fibonacciIterative(int noOfTerms) {
            int currentFibonacci = 1;
            int previousFibonacci = 1;
            for (int i = 1; i <= noOfTerms; i++) {
                if (i ==1) {
                    //System.out.print(previousFibonacci + " ");
                } else if (i == 2) {
                    //System.out.print(currentFibonacci + " ");
                } else {
                    int newFib = currentFibonacci + previousFibonacci;
                    if (i == noOfTerms) 
                        System.out.print(noOfTerms + "th fibonacci is " + newFib + " ");
                    previousFibonacci = currentFibonacci;
                    currentFibonacci = newFib;
                }
            }
        System.out.println();
    }
    
    /**
     * This function returns the nth Fibonacci number. It uses recursion
     * to calculate the Fibonacci Sequence. It uses a cache that saves 
     * previously calculated numbers.
     * That is fib (n) = fib (n -1) + fib (n-2);
     * @param n
     * @return nth Fibonacci
     */
    
    private int fibCache(int n) {
        if (n == 1) {
            //System.out.print (1 + " ");
            return 1;
        } else if (n == 2) {
            //System.out.print (1 + " ");
            return 1;
        } else {
            
            Integer fibn2 = fibCache.get(n-2);
            if (fibn2 == null) {
                fibCache.put(n-2, fib(n-2));
                fibn2 = fibCache.get(n-2);
            }

            Integer fibn1 = fibCache.get(n-1);
            if (fibn1 == null) {
                fibCache.put(n-1, fib(n-1));
                fibn1 = fibCache.get(n-1);
            } 
            
            //System.out.print(nextfib + " ");
            
            int nextfib  = fibn2 + fibn1;
            return nextfib;
        }
    }
    /**
     * This function returns the nth Fibonacci number. It uses pure recursion
     * to calculate the Fibonacci Sequence. 
     * That is fib (n) = fib (n -1) + fib (n-2);
     * @param n
     * @return nth Fibonacci
     */
    private int fib(int n) {
        int retVal = 0;
        if (n == 1) {
            retVal = 1;
        } else if (n == 2) {
            retVal = 1;
        } else {
            
            int nextfib  = fib(n-2) + fib(n-1);
            retVal = nextfib;
        }
        
        return retVal;
    }
    
}

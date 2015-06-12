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

import java.util.ArrayList;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class NumbersSolution {
    public ArrayList<Integer> sieve(int A) {

        int[] sieve = new int[A];

        for(int i = 0; i < sieve.length; i++) {
            sieve[i] = i;

        }

        for(int i = 3; i < sieve.length;i++) {
            for(int j = i+2;j < sieve.length; j+=2) {
                if(sieve[j] ==0)
                    continue;
                if(sieve[j]%i ==0) {
                    sieve[j] = 0; 
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        output.add(2);
        for(int i = 3; i < sieve.length; i+=2) {
            if(sieve[i] != 0) {
                output.add(sieve[i]);
            }
        }
        return output;
    }
    public String convertToBase(int n, int b) {
        StringBuffer sb = new StringBuffer();
            char[] rep = new char[b];
            for(int i = 0; i < b; i++) {
                if(i < 10) {
                    rep[i] = (char) ('0' + i);
                } else {
                    rep[i] = (char) ('A' + i - 10);
                }
            }
            int t = 0;
            while(n > 0) {
                t = n%b;
                sb.append(rep[t]);
                n = n / b;
            }
        return sb.reverse().toString();
    }
    //this is wrong
    public int titleToNumber(String A) {
        int num = 1;
        int limit = A.length();
        for(int i = limit - 1; i > -1 ; i--) {
            num += Math.pow(26,i) * (A.charAt(i) - 'A' +1);
            //System.out.println(num);
        }
        return num-1;
    }
}

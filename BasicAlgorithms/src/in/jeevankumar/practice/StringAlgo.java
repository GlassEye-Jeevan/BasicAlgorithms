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

/**
 *
 * @author jeevanWork
 */
public class StringAlgo {
    /**
     * The function checks if the input String is a palindrome. The fuction 
     * considers only alphanumeric character and ignores the rest. 
     * @param input
     * @return 
     */
    public boolean isPalindrome(String input) {
        input = input.toLowerCase();
        boolean retVal = true;
        for(int i = 0, j = input.length()-1; i < input.length()/2; ) {
            int a = input.charAt(i) - 'a';
            int b = input.charAt(j) - 'a';
            
            if (a < 0 || a > 26) {
                i++;
                continue;
            }
            if (b < 0 || b > 26) {
                j--;
                continue;
            }
            
            if(a != b) {
                retVal = false;
                break;
            } else {
                i++;
                j--;
            }
        }
        return retVal;
    }
}

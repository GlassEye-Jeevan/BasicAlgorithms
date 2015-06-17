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
    
    
    /**
     * This function returns true if rotString is a rotation of searchString. 
     * @param searchString
     * @param rotString
     * @return 
     */
    public boolean isRotation(String searchString, String rotString) {
        String doubleRotString = rotString + rotString;
        
        return doubleRotString.contains(searchString);
    }
    
    /**
     * This function adds two binary strings. 
     * @param a (String) - A binary String 
     * @param b (String) - A binary String
     * @return - A binary string that is the sum of a and b
     */
    public String addBinaryString(String a, String b) {
        StringBuffer retVal = new StringBuffer(Math.max(a.length(), b.length()) + 1);
        char zeroSum = '0' + '0';
        char zeroOneSum = '0' + '1';
        char oneOneSum = '1' + '1';
        char carry = '0';
        for(int i = a.length() - 1, j = b.length() - 1; i > 0 || j > 0; i--,j--) {
            if( i < 0 )
                return copyRest(b, j, carry, retVal);
            else if(j < 0)
                return copyRest(a, i, carry, retVal);
            
            char sum = (char) (a.charAt(i) + b.charAt(j));
            
            if(sum == zeroSum) {
                retVal.append(carry);
                carry = '0';
            } else if (sum == zeroOneSum) {
                if(carry == '0') {
                    retVal.append('1');
                    carry = '0';
                } else {
                    retVal.append('0');
                    carry = '1';
                }
            } else if(sum == oneOneSum) {
                if(carry == '0') {
                    retVal.append('0');
                    carry = '1';
                }
                else {
                    retVal.append('1');
                    carry = '1';
                }
            }
            
        }
        
        return null;
    }
    public String copyRest(String a, int index, char carry, StringBuffer out) {
        return null;
    }
}

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

import java.util.HashMap;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.isUniqueChar(args[0]);
		
	}
        /**
         * Checks if the input String s are permutations of each other.
         * @param input1
         * @param input2
         * @return 
         */
        public boolean arePermutations(String input1, String input2) {
            if((input1== null && input2==null)) 
                    return true;

            if((input1 == null && input2!=null) 
                    || (input1 != null && input2 ==null))
                return false;


            if(input1.length() != input2.length())
                    return false;

            HashMap<Character, Integer> map = new HashMap<>();

            char[] iChar1 = input1.toCharArray();
            char[] iChar2 = input2.toCharArray();

            for(Character ch : iChar1) {
                if(map.get(ch) == null) 
                    map.put(ch, 1);
                else {
                    int count = map.get(ch);
                    map.put(ch,++count);
                }
            }
            for(Character ch: iChar2) {
                if(!map.containsKey(ch))
                    return false;
                int count = map.get(ch);
                count--;
                if(count == 0) 
                    map.remove(ch);
                else
                    map.put(ch,count);
            }
            if(map.isEmpty())
                return true;
            else
                return false;
	}

        /**
         * This reverses a String.
         * @param input
         * @return 
         */
        public String reverseString(String input) {
            if(input == null || input.length() < 2) 
                return input;
            
            char[] iChar = input.toCharArray();
            for(int i = 0; i < iChar.length / 2; i++) {
                char temp = iChar[i];
                iChar[i] = iChar[iChar.length - i - 1];
                iChar[iChar.length - i - 1] = temp;
            }
            return new String(iChar);
	}
        /**
         * This checks if the String is made up of unique characters.
         * @param input
         * @return 
         */
	public boolean isUniqueChar(String input) {
                if(input == null)
                    return true;
                        
		char[] inputChar = input.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < inputChar.length; i++) {
			if(map.containsKey(inputChar[i]))
				return false;
			else {
				map.put(inputChar[i],0);
			}
		}
		return true;
	}
}

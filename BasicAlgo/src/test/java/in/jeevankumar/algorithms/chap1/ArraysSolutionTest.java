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

import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class ArraysSolutionTest extends TestCase {
    public void testIsUniqueChar() {
        ArraysSolution sol = new ArraysSolution();
        String input = "";
        assertTrue(sol.isUniqueChar(input));
        
        input = "a";
        assertTrue(sol.isUniqueChar(input));
        
        input = "abc";
        assertTrue(sol.isUniqueChar(input));
        
        input = "abca";
        assertFalse(sol.isUniqueChar(input));
        
        input = "abc78432fsdkiu";
        assertTrue(sol.isUniqueChar(input));
        
        input = null;
        assertTrue(sol.isUniqueChar(input));
        
    }
    public void testReverseString() {
        ArraysSolution sol = new ArraysSolution();
        
        String input = "a";
        assertEquals(input, sol.reverseString(input));
        
        input = "ab";
        assertEquals("ba", sol.reverseString(input));

        input = "abc";
        assertEquals("cba", sol.reverseString(input));
        
        input = null;
        assertEquals(null, sol.reverseString(input));
    }
    
    public void testPermutations() {
        ArraysSolution sol = new ArraysSolution();
        String input1 = null;
        String input2 = null;
        
        assertTrue(sol.arePermutations(input1, input2));
        
        input1 = null;
        input2 = "a";
        assertFalse(sol.arePermutations(input1, input2));
        
        input1 = "a";
        input2 = "a";
        assertTrue(sol.arePermutations(input1, input2));
        
        input1 = "ab";
        input2 = "ba";
        assertTrue(sol.arePermutations(input1, input2));
        
        input1 = "adfsdfsdfsdf";
        input2 = "addddsssffff";
        assertTrue(sol.arePermutations(input1, input2));
        
        input1 = "adfsdfsdfsdf";
        input2 = "adfsdfsdfsdx";
        assertFalse(sol.arePermutations(input1, input2));
        
    }
    
    public void testSimpleCompression() {
    	ArraysSolution as = new ArraysSolution();
    	String output;
    	
    	output = as.simpleCompression(null);
    	assertEquals(output, null);
    	
    	output = as.simpleCompression("c");
    	assertEquals(output, "c");
    	
    	output = as.simpleCompression("ab");
    	assertEquals(output, "ab");
    	
    	output = as.simpleCompression("aaaa");
    	assertEquals(output, "a4");
    	
    	output = as.simpleCompression("aaaab");
    	assertEquals(output, "a4b1");
    	
    	output = as.simpleCompression("abcdefg");
    	assertEquals(output, "abcdefg");
    	
    	output = as.simpleCompression("aaaabbbbbcc");
    	assertEquals(output, "a4b5c2");
    	
    }
    
}

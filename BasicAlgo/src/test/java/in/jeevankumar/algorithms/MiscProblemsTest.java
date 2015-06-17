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
package in.jeevankumar.algorithms;

import java.util.Arrays;
import junit.framework.TestCase;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class MiscProblemsTest extends TestCase {
    public MiscProblemsTest (String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testIsThereAConflict() {
        MiscProblems mp = new MiscProblems();
        
        int[] start = { 00, 02, 01, 02, 05, 14};
        int[] end   = { 01, 03, 02, 04, 06, 17};
        assertTrue(mp.isThereAConflict(start, end));
        
        start[3] = 11;
        end[3] = 12;
        assertFalse(mp.isThereAConflict(start, end));
    }
    
    public void testBooleanAddString() {
        MiscProblems mp = new MiscProblems();
        
        String[] input = new String[2];
        
        input[0] ="00";
        input[1] = "00";
        assertEquals(mp.booleanAddString(input), "00");
        
        input[0] = "01";
        input[1] = "00";
        assertEquals(mp.booleanAddString(input), "01");
        
        input[0] = "01";
        input[1] = "01";
        assertEquals(mp.booleanAddString(input), "10");
        
        input[0] = "10";
        input[1] = "10";
        assertEquals(mp.booleanAddString(input), "100");
        
        input[0] = "1101010";
        input[1] =    "1000";
        assertEquals(mp.booleanAddString(input), "1110010");
    }
    
    public void testInPlaceReverse() {
        String input= "12345";
        char[] inputChar = input.toCharArray();
        
        String inputReverse = new StringBuffer(input).reverse().toString();
        char[] inputReverseChar = inputReverse.toCharArray();
        
        MiscProblems mp = new MiscProblems();
        char[] testOut = mp.inPlaceReverseString(inputChar, 0, inputChar.length-1);
        //System.out.println(Arrays.toString(testOut) + " ~ " + Arrays.toString(inputReverseChar));
        assertTrue(isSame(testOut, inputReverseChar));
        
        
    }
    private boolean isSame(char[] input1, char[] input2) {
        boolean retVal = true;
        if(input1.length != input2.length) {
            retVal = false;
        } else {
            for(int i = 0; i < input1.length; i++) {
                if(input1[i] != input2[i]) {
                    retVal = false;
                    break;
                }
            }
        }
        return retVal;
    }
    public void testInsertMInN() {
        MiscProblems mp = new MiscProblems();
        //mp.insertMinN(1, 2);
    }
}


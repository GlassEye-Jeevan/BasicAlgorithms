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

import junit.framework.TestCase;

/**
 *
 * @author jeevanWork
 */
public class StringAlgoTest extends TestCase {
    public void testIsPalindrome() {
        StringAlgo sa = new StringAlgo();
        assertTrue(sa.isPalindrome("a"));
        assertTrue(sa.isPalindrome("a,"));
        
        assertTrue(sa.isPalindrome("aaa"));
        assertFalse(sa.isPalindrome("abb"));
        assertTrue(sa.isPalindrome("A man, a plan, a canal, Panama!"));
    }
}

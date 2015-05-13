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

import java.util.Random;

/**
 *
 * @author jeevanWork
 */
public class ArrayAlgo {
    /**
     * Shuffles the given array using a random number generator. 
     * @param a (int[]) - Input array
     * @return shuffled input array
     */
    public int[] shuffleArray(int[] a) {
        Random rng = new Random();
        int limit = a.length;
        int randIndex, temp;
        for (int i = 0; i < limit; i++) {
            randIndex = rng.nextInt(limit);
            temp = a[randIndex];
            a[randIndex] = a[i];
            a[i] = temp;
        }
        return a;
    }
}

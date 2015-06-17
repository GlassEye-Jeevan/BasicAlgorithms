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
package in.jeevankumar.practice;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;
    public int data;
    boolean visited;
    public TreeNode(int d) {
        this.data = d;
    }
          
}

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

import in.jeevankumar.practice.TreeNode;
import in.jeevankumar.util.wip.Node;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class TreeSolution {
    public TreeNode invertTree(TreeNode n) {
        if(n==null)
            return n;
        
        TreeNode temp = n.left;
        
        invertTree(left);
        invertTree(right);
        
        n.left = n.right;
        n.right = temp;
        
        return n;
    }
    public int height(TreeNode n) {
        if(n==null)
            return 0;
        return Math.max(height(n.left), height(n.right)) + 1;
    }
}

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

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class TreeNodeAlgo {
    public TreeNode search(TreeNode n, int d) {
        if(n.data == d) {
            return n;
        } else {
            TreeNode left = search(n.left, d);
            TreeNode right = search(n.right,d);
            if(left != null)
                return left;
            
            if(right != null) {
                return right;
                
            
            }
        }
        return null;
    }
    public void depthFirstTraversal(TreeNode n) {
        if(n != null) {
            System.out.println(n.data);
            depthFirstTraversal(n.left);
            depthFirstTraversal(n.right);
        }
    }
    
    public void breadthFirstTraversal(TreeNode n) {
        if(n!=null) {
            Queue q = new LinkedList<TreeNode>();
            q.add(n);
            
            while(!q.isEmpty()) {
                TreeNode node = (TreeNode) q.remove();
                System.out.println(node.data);
                
                if(node.left != null)
                    q.add(node.left);
            
                if(node.right != null)
                    q.add(node.right);
            
            }
        }
    }
    
    public int hieght(TreeNode n) {
        if(n == null) 
            return 0;
       return Math.max(hieght(n.left), hieght(n.right)) + 1;
       
    }
    
    
    public int checkHieght(TreeNode n) {
        if(n == null)
            return 0;
        
        int lHieght = checkHieght(n.left);
        if(lHieght == -1) 
            return lHieght;
        
        int rHieght = checkHieght(n.left);
        if(rHieght == -1) 
            return rHieght;
        
        int diff = Math.abs(rHieght - lHieght);
        
        if(diff > 1) 
            return -1;
        
        return Math.max(rHieght, lHieght);
    }
    
    public boolean routeExists(TreeNode from, TreeNode to) {
        
        Queue q = new LinkedList<TreeNode>();
        q.add(from);

        while(!q.isEmpty()) {
            TreeNode node = (TreeNode) q.remove();
            if(node == to)
                return true;
            //System.out.println(node.data);

            if(node.left != null)
                q.add(node.left);

            if(node.right != null)
                q.add(node.right);
        }
        return false;
    }
    
    public TreeNode createMinimalBST(int[] arr, int minIndex, int maxIndex) {
        if(maxIndex < minIndex)
            return null;
        int mid = (minIndex + maxIndex) / 2 ; 
        TreeNode tNode = new TreeNode(arr[mid]);
        tNode.left = createMinimalBST(arr, minIndex, mid-1);
        tNode.right = createMinimalBST(arr, mid + 1, maxIndex);
        
        return tNode;
    }
    
    public boolean isSubTree(TreeNode parent, TreeNode child) {
        if(child == null) 
            return true;
        
        if (parent == null)
            return false;
        
        if(parent.data == child.data) 
            return matchTree(parent, child);
        else 
            return isSubTree(parent.left, child) || isSubTree(parent.right, child);
        
    }
    
    private boolean matchTree(TreeNode parent, TreeNode child) {
        if(parent == null && child == null)
            return true;
        
        if(parent.data == child.data) 
            return matchTree(parent.left, child.left) 
                    && matchTree(parent.right, child.right);
        else 
            return false;
    }
}

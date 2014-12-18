/*
 * Copyright 2014 Jeevan Kumar <mail@jeevankumar.in>.
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

import in.jeevankumar.util.Tree;

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class TreeProblemSolver {
    public static void main (String[] args) {
        TreeProblemSolver tps = new TreeProblemSolver();
        tps.run();
    }
    
    public void run() {
        Tree<Integer> treeRoot = Helper.setupFullBinary(15);
        preOrderTraversal(treeRoot);
        System.out.println();
        postOrderTraversal(treeRoot);
        System.out.println();
        inOrderTraversal(treeRoot);
    }
    
    private void preOrderTraversal(Tree<Integer> root) {
        System.out.print(root.getInfo() + " ");
        for(Tree child : root.getChildren()) {
            preOrderTraversal(child);
        }
    }
    
    private void postOrderTraversal(Tree<Integer> root) {
        for(Tree child : root.getChildren()) {
            postOrderTraversal(child);
        }
        System.out.print(root.getInfo() + " ");
    }
    
    private void inOrderTraversal(Tree<Integer> root) {
        
        if(root.children() > 0) {
            System.out.print("( ");
            inOrderTraversal(root.getChild(0));
            System.out.print(root.getInfo() + " ");
            if(root.children()==2) 
                inOrderTraversal(root.getChild(1));
            System.out.print(") ");
        } else {
            System.out.print(root.getInfo() + " ");
        }
        
        
        //System.out.println(")");
    }
    
    
}

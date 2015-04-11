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

/**
 *
 * @author Jeevan Kumar <mail@jeevankumar.in>
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run(args);
    }
    public void run(String[] args) {
        String NEWLINE = "\n";
        switch(args[0]) {
            
            case "help":
                // Need to create a good design with registers to ensure
                //this help text does not need to be updated. 
                StringBuffer message = new StringBuffer
                               ("Hi, Thanks for using Basic Algorithms. ")
                        .append("Would appreciate any feedback you may have.")
                        .append(NEWLINE)
                        .append("This program has implementations for some basic ")
                        .append("algorithms listed below. To use the algorithms ")
                        .append("just type in the command as per the recommended ")
                        .append("usage. You can also use this in your software ")
                        .append("project through the API.")
                        .append(NEWLINE)
                        //sorting algorithms
                        .append("")
                        
                        ;
                
                System.out.println("");
                break;
                
            default:
                System.out.println("Usage: java BasicAlgorithms <Algorithm Name> "
                        + "<input 1> <input 2> ...");
                System.out.println("Type \"java BasicAlgorithms help\" for help");
                
               
        }
    }
}

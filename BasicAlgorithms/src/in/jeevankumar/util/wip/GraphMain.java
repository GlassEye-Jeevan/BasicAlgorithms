package in.jeevankumar.util.wip;

import java.io.*;
import java.util.Scanner;

/**
 * From UTSA, http://www.cs.utsa.edu/~wagner/CS3343/newgraph/graphrep.html
 * @author  Donald Knuth
 */
// GraphMain.java: Controls Graph Program
public class GraphMain {

   private static void err(int code) {
      System.exit(code);
   }

   public static void main(String[] args) {
      int nodes = 0;
      Scanner sc = null; // compiler wants
      int num1 = 0, num2 = 0, len = 0;
      try {
         sc = new Scanner(new
            File("capdist.txt")); // file
      }
      catch (Exception exception ) { err(1); }
      if (sc.hasNextInt())
         nodes = sc.nextInt();
      else err(2);
      Graph graph = new Graph(nodes);
      // get vertices = num of vertices
      while (sc.hasNextInt()) {
         num1 = sc.nextInt();
         if (sc.hasNextInt())
            num2 = sc.nextInt();
         else err(2);
         if (sc.hasNextInt())
            len = sc.nextInt();
         else err(3);
         // undirected, insert both ways
         graph.insertEdge(num1, num2, len);
         graph.insertEdge(num2, num1, len);
     }
     graph.printGraph();
   }
}
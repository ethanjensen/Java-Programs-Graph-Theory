import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GraphTest
{
  public static void main(String[] args)
  {
    Tree<String, String> t1 = new Tree<>(new Vertex<String>("V1"));
    Tree<String, String> t2 = new Tree<>(new Vertex<String>("V2"));
    Tree<String, String> t3 = new Tree<>(new Vertex<String>("V3"));
    Tree<String, String> t4 = new Tree<>(new Vertex<String>("V4"));
    Tree<String, String> t5 = new Tree<>(new Vertex<String>("V5"));
    Tree<String, String> t6 = new Tree<>(new Vertex<String>("V6"));
    Tree<String, String> t7 = new Tree<>(new Vertex<String>("V7"));
    Tree<String, String> t8 = new Tree<>(new Vertex<String>("V8"));

    System.out.println(t4.getVertex());
    System.out.println(t4.getParent());
    System.out.println(t1.isRoot());
    t4.add(t1, "e1", 18);
    t4.add(t6, "e2", 19);
    t4.add(t5, "e3", 15);
    t5.add(t7, "e4", 27);
    t5.add(t8, "e5", 32);
    t5.add(t3, "e6", 21);
    t3.add(t2, "e7", 17);
    // System.out.println(t1.isRoot());
    // System.out.println(t2.isRoot());
    // System.out.println(t3.isRoot());
    // System.out.println(t4.isRoot());
    // System.out.println(t5.isRoot());
    // System.out.println(t6.isRoot());
    // System.out.println(t7.isRoot());
    // System.out.println(t8.isRoot());
    // System.out.println(t1.getParent().getVertex());
    //
    // t4.remove(t5);
    // t4.add(t5, "e3", 15);
    //
    // System.out.println(t4.isAncestorOf(t2));
    // System.out.println(t4.pathCost(t2));
    // System.out.println(t3.size());
    //
    // System.out.println(t4.height());
    // System.out.println(t5.height());
    //
    // System.out.println(t4.level());
    // System.out.println(t5.level());
    // System.out.println(t3.level());
    // System.out.println(t2.level());
    //
    // System.out.println(t6.isSiblingOf(t1));
    //
    // System.out.println(t5.isBalanced());
    // t5.remove(t3);
    // System.out.println(t5.isBalanced());
  }
}

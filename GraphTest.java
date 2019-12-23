import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GraphTest
{
  public static void main(String[] args)
  {
    Graph<String, String> g1 = new Graph<>();
    Vertex<String> v1 = new Vertex<>("v1");
    Vertex<String> v2 = new Vertex<>("v2");
    Vertex<String> v3 = new Vertex<>("v3");
    Vertex<String> v4 = new Vertex<>("v4");
    Vertex<String> v5 = new Vertex<>("v5");
    Vertex<String> v6 = new Vertex<>("v6");
    Vertex<String> v7 = new Vertex<>("v7");
    Vertex<String> v8 = new Vertex<>("v8");

    Edge<String, String> e1 = new Edge<>(v1, v2, "e1", 25);
    Edge<String, String> e2 = new Edge<>(v2, v1, "e2", 25);
    Edge<String, String> e3 = new Edge<>(v1, v4, "e3", 18);
    Edge<String, String> e4 = new Edge<>(v4, v1, "e4", 18);
    Edge<String, String> e5 = new Edge<>(v1, v6, "e5", 30);
    Edge<String, String> e6 = new Edge<>(v6, v1, "e6", 30);
    Edge<String, String> e7 = new Edge<>(v4, v2, "e7", 23);
    Edge<String, String> e8 = new Edge<>(v2, v4, "e8", 23);
    Edge<String, String> e9 = new Edge<>(v4, v6, "e9", 19);
    Edge<String, String> e10 = new Edge<>(v6, v4, "e10", 19);
    Edge<String, String> e11 = new Edge<>(v6, v7, "e11", 31);
    Edge<String, String> e12 = new Edge<>(v7, v6, "e12", 31);
    Edge<String, String> e13 = new Edge<>(v4, v7, "e13", 28);
    Edge<String, String> e14 = new Edge<>(v7, v4, "e14", 28);
    Edge<String, String> e15 = new Edge<>(v4, v5, "e15", 15);
    Edge<String, String> e16 = new Edge<>(v5, v4, "e16", 15);
    Edge<String, String> e17 = new Edge<>(v5, v7, "e17", 27);
    Edge<String, String> e18 = new Edge<>(v7, v5, "e18", 27);
    Edge<String, String> e19 = new Edge<>(v7, v8, "e19", 35);
    Edge<String, String> e20 = new Edge<>(v8, v7, "e20", 35);
    Edge<String, String> e21 = new Edge<>(v2, v5, "e21", 22);
    Edge<String, String> e22 = new Edge<>(v5, v2, "e22", 22);
    Edge<String, String> e23 = new Edge<>(v2, v3, "e23", 17);
    Edge<String, String> e24 = new Edge<>(v3, v2, "e24", 17);
    Edge<String, String> e25 = new Edge<>(v3, v5, "e25", 21);
    Edge<String, String> e26 = new Edge<>(v5, v3, "e26", 21);
    Edge<String, String> e27 = new Edge<>(v5, v8, "e27", 32);
    Edge<String, String> e28 = new Edge<>(v8, v5, "e28", 32);
    Edge<String, String> e29 = new Edge<>(v3, v8, "e29", 33);
    Edge<String, String> e30 = new Edge<>(v8, v3, "e30", 33);

    g1.addVertex(v1);
    g1.addVertex(v2);
    g1.addVertex(v3);
    g1.addVertex(v4);
    g1.addVertex(v5);
    g1.addVertex(v6);
    g1.addVertex(v7);
    g1.addVertex(v8);

    g1.addEdge(e1);
    g1.addEdge(e2);
    g1.addEdge(e3);
    g1.addEdge(e4);
    g1.addEdge(e5);
    g1.addEdge(e6);
    g1.addEdge(e7);
    g1.addEdge(e8);
    g1.addEdge(e9);
    g1.addEdge(e10);
    g1.addEdge(e11);
    g1.addEdge(e12);
    g1.addEdge(e13);
    g1.addEdge(e14);
    g1.addEdge(e15);
    g1.addEdge(e16);
    g1.addEdge(e17);
    g1.addEdge(e18);
    g1.addEdge(e19);
    g1.addEdge(e20);
    g1.addEdge(e21);
    g1.addEdge(e22);
    g1.addEdge(e23);
    g1.addEdge(e24);
    g1.addEdge(e25);
    g1.addEdge(e26);
    g1.addEdge(e27);
    g1.addEdge(e28);
    g1.addEdge(e29);
    g1.addEdge(e30);

    Tree<String, String> tree = g1.minWeightTree(v5);
    System.out.println(tree.size());
    System.out.println(tree.childCount());
    for (Vertex<String> v : tree)
    {
      System.out.println(v);
    }
    Graph<String, String> g2 = tree.toGraph();
    System.out.println(g2.vertexCount());
    System.out.println(g2.edgeCount());
    System.out.println(g2.totalEdgeWeight());
  }
}

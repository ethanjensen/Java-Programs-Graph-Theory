import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GraphTest
{
  public static void main(String[] args)
  {
    Vertex<Integer> v1 = new Vertex<>(1, 1);
    Vertex<Integer> v2 = new Vertex<>(2, 2);
    Vertex<Integer> v3 = new Vertex<>(3, 3);
    Vertex<Integer> v4 = new Vertex<>(4, 4);
    Vertex<Integer> v5 = new Vertex<>(5, 5);
    Vertex<Integer> v6 = new Vertex<>(6, 6);

    System.out.println(v1.getWeight());
    System.out.println(v2.getWeight());
    System.out.println(v1.compareTo(v2));

    Edge<Integer, Integer> e1 = new Edge<>(v1, v4, 1, 1);
    Edge<Integer, Integer> e2 = new Edge<>(v1, v5, 2, 3);
    Edge<Integer, Integer> e3 = new Edge<>(v1, v6, 3, 6);
    Edge<Integer, Integer> e4 = new Edge<>(v2, v4, 4);
    Edge<Integer, Integer> e5 = new Edge<>(v2, v5, 5);
    Edge<Integer, Integer> e6 = new Edge<>(v2, v6, 6);
    Edge<Integer, Integer> e7 = new Edge<>(v3, v4, 7);
    Edge<Integer, Integer> e8 = new Edge<>(v3, v5, 8);
    Edge<Integer, Integer> e9 = new Edge<>(v3, v6, 9);
    Edge<Integer, Integer> e10 = new Edge<>(v6, v1, 10, 77);

    Graph<Integer, Integer> graph1 = new Graph<>();

    ArrayList<Vertex<Integer>> vertices = new ArrayList<>();
    vertices.add(v1);
    vertices.add(v2);
    vertices.add(v3);
    vertices.add(v4);
    vertices.add(v5);
    vertices.add(v6);

    ArrayList<Edge<Integer, Integer>> edges = new ArrayList<>();
    edges.add(e1);
    edges.add(e2);
    edges.add(e3);
    edges.add(e4);
    edges.add(e5);
    edges.add(e6);
    edges.add(e7);
    edges.add(e8);
    edges.add(e9);
    edges.add(e10);

    graph1.addVertices(vertices);
    graph1.addEdges(edges);

    System.out.println(graph1.vertexCount());
    System.out.println(graph1.edgeCount());

    for(Vertex<Integer> v : graph1)
    {
      System.out.print("spicy");
    }

    System.out.println();

    Iterator<Vertex<Integer>> vertexIterator = graph1.vertices();
    while(vertexIterator.hasNext())
    {
      System.out.print(vertexIterator.next());
      System.out.print("   ");
    }

    System.out.println();

    Iterator<Vertex<Integer>> vertexIterator2 = graph1.adjacent(v2);
    while(vertexIterator2.hasNext())
    {
      System.out.print(vertexIterator2.next());
      System.out.print("   ");
    }

    System.out.println();

    Iterator<Edge<Integer, Integer>> vertexIterator3 = graph1.edges();
    while(vertexIterator3.hasNext())
    {
      System.out.print(vertexIterator3.next());
      System.out.print("   ");
    }
    System.out.println();

    System.out.println(graph1.canReach(v1, v2));
    System.out.println(graph1.canReach(v1, v4));
    System.out.println(graph1.canReach(v1, v1));
    System.out.println(graph1.hasCycle());

    System.out.println();
    System.out.println(graph1.adjacentCount(v1));

    System.out.println(graph1.totalVertexWeight());
    System.out.println(graph1.totalEdgeWeight());

    graph1.removeEdge(e1);
    System.out.println(graph1.removeVertex(v1));

    System.out.println(graph1.vertexCount());
    System.out.println(graph1.edgeCount());

    graph1.clearEdges();
    System.out.println(graph1.vertexCount());
    System.out.println(graph1.edgeCount());

    System.out.println(graph1.adjacentCount(v1));

    Tree<String, String> t1 = new Tree<>();

    Vertex<String> node1 = new Vertex<>("N1", 23);
    t1.addVertex(node1);
    for (Vertex<String> vertex : t1)
    {
      System.out.println(vertex);
    }
  }
}

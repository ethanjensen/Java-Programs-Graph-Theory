import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph<V, E> implements Iterable<Vertex<V>>
{
  private int _vertexCount;
  private int _edgeCount;
  private int _position;
  private HashMap<Vertex<V>, Integer> _vertexMap;
  private HashMap<Integer, ArrayList<Edge<V, E>>> _edgeMap;

  private boolean canReach(Vertex<V> v1, Vertex<V> v2, ArrayList<Vertex<V>> visited)
  {
    boolean reached = false;
    if (containsVertex(v1))
    {
      visited.add(v1);
      Vertex<V> tempVertex;
      Iterator<Vertex<V>> adjacentVertices = adjacent(v1);
      while(adjacentVertices.hasNext() && !reached)
      {
        tempVertex = adjacentVertices.next();
        if (tempVertex.compareTo(v2) == 0)
        {
          reached = true;
        }
        else if(!visited.contains(tempVertex))
        {
          reached = canReach(tempVertex, v2, visited);
        }
      }
    }
    return reached;
  }

  Graph()
  {
    clear();
  }

  public void clear()
  {
    _vertexCount = 0;
    _vertexMap = new HashMap<>();
    clearEdges();
    _position = 0;
  }

  public void clearEdges()
  {
    _edgeMap = new HashMap<>();
    _edgeCount = 0;
  }

  public int vertexCount()
  {
    return _vertexCount;
  }

  public int edgeCount()
  {
    return _edgeCount;
  }

  public void addVertex(Vertex<V> v) throws DuplicateVertexException
  {
    if (!containsVertex(v))
    {
      _vertexMap.put(v, _position);
      _vertexCount = _vertexCount + 1;
      _position = _position + 1;
    }
    else
    {
      throw new DuplicateVertexException();
    }
  }

  public void addVertices(ArrayList<Vertex<V>> vertices)
  {
    for (Vertex<V> v : vertices)
    {
      addVertex(v);
    }
  }

  public boolean containsVertex(Vertex<V> v)
  {
    return _vertexMap.containsKey(v);
  }

  public void addEdge(Edge<V, E> e) throws NoSuchVertexException, DuplicateEdgeException
  {
    if (containsVertex(e.getVertex1()) && containsVertex(e.getVertex2()))
    {
      if (!containsEdge(e))
      {
        if (_edgeMap.get(_vertexMap.get(e.getVertex1())) == null)
        {
          _edgeMap.put(_vertexMap.get(e.getVertex1()), new ArrayList<Edge<V, E>>());
        }
        _edgeMap.get(_vertexMap.get(e.getVertex1())).add(e);
        _edgeCount = _edgeCount + 1;
      }
      else
      {
        throw new DuplicateEdgeException();
      }
    }
    else
    {
      throw new NoSuchVertexException();
    }
  }

  public void addEdges(ArrayList<Edge<V, E>> edges)
  {
    for (Edge<V, E> e : edges)
    {
      addEdge(e);
    }
  }

  public boolean containsEdge(Edge<V, E> edge)
  {
    boolean contains = false;
    Vertex<V> v = edge.getVertex1();
    if (containsVertex(v))
    {
      ArrayList<Edge<V, E>> temp = _edgeMap.get(_vertexMap.get(v));
      if (temp != null)
      {
        contains = temp.contains(edge);
      }
    }
    return contains;
  }

  public Edge<V, E> getEdge(Vertex<V> v1, Vertex<V> v2)
  {
    Iterator<Edge<V, E>> edges = edges();
    Edge<V, E> edge = null;
    Edge<V, E> tempEdge;
    boolean done = false;
    while (edges.hasNext() && !done)
    {
      tempEdge = edges.next();
      if (v1.equals(tempEdge.getVertex1()) && v2.equals(tempEdge.getVertex2()))
      {
        edge = tempEdge;
        done = true;
      }
    }
    return edge;
  }

  public ArrayList<Edge<V, E>> removeVertex(Vertex<V> v) throws NoSuchVertexException
  {
    ArrayList<Edge<V, E>> temp = null;
    if (containsVertex(v))
    {
      temp = _edgeMap.remove(_vertexMap.get(v));
      _edgeCount = _edgeCount - temp.size();
      _vertexMap.remove(v);
      _vertexCount = _vertexCount - 1;
    }
    else
    {
      throw new NoSuchVertexException();
    }
    return temp;
  }

  public void removeEdge(Edge<V, E> e) throws NoSuchEdgeException
  {
    if (containsEdge(e))
    {
      _edgeMap.get(_vertexMap.get(e.getVertex1())).remove(e);
      _edgeCount = _edgeCount - 1;
    }
    else
    {
      throw new NoSuchEdgeException();
    }
  }

  public Iterator<Vertex<V>> vertices()
  {
    return _vertexMap.keySet().iterator();
  }

  public Iterator<Vertex<V>> iterator()
  {
    return vertices();
  }

  public Iterator<Vertex<V>> adjacent(Vertex<V> v)
  {
    ArrayList<Edge<V, E>> edges = _edgeMap.get(_vertexMap.get(v));
    ArrayList<Vertex<V>> adjacent = new ArrayList<>();
    if (edges != null)
    {
      for(Edge<V, E> edge : edges)
      {
        adjacent.add(edge.getVertex2());
      }
    }
    return adjacent.iterator();
  }

  public Iterator<Edge<V, E>> edges()
  {
    ArrayList<Edge<V, E>> edges = new ArrayList<>();
    _edgeMap.forEach((u,I) -> {
      edges.addAll(I);
    });
    return edges.iterator();
  }

  public int adjacentCount(Vertex<V> v)
  {
    ArrayList<Edge<V, E>> edges = _edgeMap.get(_vertexMap.get(v));
    int count = 0;
    if (edges != null)
    {
      count = edges.size();
    }
    return count;
  }

  public double totalVertexWeight()
  {
    double weight = 0;
    for (Vertex<V> vertex : this)
    {
      weight = weight + vertex.getWeight();
    }
    return weight;
  }

  public double totalEdgeWeight()
  {
    double weight = 0;
    Iterator<Edge<V, E>> edges = edges();
    while (edges.hasNext())
    {
      weight = weight + edges.next().getWeight();
    }
    return weight;
  }

  public boolean canReach(Vertex<V> v1, Vertex<V> v2)
  {
    return canReach(v1, v2, new ArrayList<Vertex<V>>());
  }

  public boolean hasCycle()
  {
    boolean hasCycle = false;
    for (Vertex<V> vertex : this)
    {
      hasCycle = hasCycle | canReach(vertex, vertex);
    }
    return hasCycle;
  }

  // public costBetween(Vertex<V> v1, Vertex<V> v2)
  // REQUIRES MINSPANNINGTREE


  public Tree<V, E> minSpanningTree(Vertex<V> v) throws NoSuchVertexException
  {
    if (containsVertex(v))
    {
      ArrayList<Vertex<V>> done = new ArrayList<>();
      done.add(v);
      return minSpanningTree(done, v, 0, new ArrayList<Edge<V,E>>());
    }
    else
    {
      throw new NoSuchVertexException();
    }
  }

  private Tree<V, E> minSpanningTree(ArrayList<Vertex<V>> done, Vertex<V> pivot,
   double pathWeight, ArrayList<Edge<V, E>> edges)
  {
    Tree<V, E> tree = null;
    ArrayList<Edge<V, E>> relevantEdges = new ArrayList<>();
    Iterator<Vertex<V>> adjacent = adjacent(pivot);
    Vertex<V> vertex;
    Edge<V, E> edge;
    while (adjacent.hasNext())
    {
      vertex = adjacent.next();
      if (!done.contains(vertex))
      {
        edge = getEdge(pivot, vertex);
        edge.setWeight(edge.getWeight() + pathWeight);
        relevantEdges.add(getEdge(pivot, vertex));
        System.out.println(getEdge(pivot, vertex));
      }
    }

    Vertex<V> v1;
    Vertex<V> v2;
    boolean copy;
    for (Edge<V, E> edge1 : relevantEdges)
    {
      v1 = edge1.getVertex1();
      v2 = edge1.getVertex2();
      copy = false;
      for (Edge<V, E> edge2 : edges)
      {
        if (v2.equals(edge2.getVertex2()))
        {
          copy = true;
          if (edge1.getWeight() < edge2.getWeight())
          {
            edge2 = edge1;
          }
        }
      }
      if (!copy)
      {
        edges.add(edge1);
      }
    }

    Edge<V, E> minEdge = null;
    for (Edge<V, E> sledge : edges)
    {
      if (!done.contains(sledge.getVertex2()))
      {
        if (minEdge == null)
        {
          minEdge = sledge;
        }
        else
        {
          if (sledge.getWeight() < minEdge.getWeight())
          {
            minEdge = sledge;
          }
        }
      }
    }
    //Ending condition? But it gets here prematurely.
    if (minEdge == null)
    {
      System.out.println("SPICY");
      for (Edge<V, E> hedge : edges)
      {
        System.out.println(hedge);
      }
      tree = createTree(edges, done);
    }
    else
    {
      done.add(minEdge.getVertex2());
      System.out.println("spicy");
      tree = minSpanningTree(done, minEdge.getVertex2(), minEdge.getWeight(), edges);
    }
    return tree;
  }

  private Tree<V, E> createTree(ArrayList<Edge<V, E>> edges, ArrayList<Vertex<V>> done)
  {
    return new Tree<V, E>(done.get(0));
  }
}

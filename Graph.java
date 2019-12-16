import java.util.HashMap;
import java.util.ArrayList;

public class Graph<V, E>
{
  private int _vertexCount;
  private int _edgeCount;
  private int _position;
  private HashMap<Vertex<V>, Integer> _vertexMap;
  private HashMap<Integer, ArrayList<Edge<V, E>>> _edgeMap;


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
}

public class Edge<V, E>
{
  private Vertex<V> _vertex1;
  private Vertex<V> _vertex2;
  private E _label;
  private int _weight;

  public Edge(Vertex<V> vertex1, Vertex<V> vertex2, E label)
  {
    setVertex1(vertex1);
    setVertex2(vertex2);
    setLabel(label);
    setWeight(0);
  }

  public Edge(Vertex<V> vertex1, Vertex<V> vertex2, E label, int weight)
  {
    setVertex1(vertex1);
    setVertex2(vertex2);
    setLabel(label);
    setWeight(weight);
  }

  public Vertex<V> getVertex1()
  {
    return _vertex1;
  }

  public Vertex<V> getVertex2()
  {
    return _vertex2;
  }

  public E getLabel()
  {
    return _label;
  }

  public int getWeight()
  {
    return _weight;
  }

  public void setVertex1(Vertex<V> vertex1)
  {
    _vertex1 = vertex1;
  }

  public void setVertex2(Vertex<V> vertex2)
  {
    _vertex2 = vertex2;
  }

  public void setLabel(E label)
  {
    _label = label;
  }

  public void setWeight(int weight)
  {
    _weight = weight;
  }

  public boolean equals(Edge<V, E> other)
  {
    boolean equal = true;
    if (equal) equal = other.getVertex1().equals(this.getVertex1());
    if (equal) equal = other.getVertex2().equals(this.getVertex2());
    if (equal) equal = other.getLabel().equals(this.getLabel());
    return equal;
  }

  public String toString()
  {
    return String.format("%s, %s, %s", _vertex1, _vertex2, _label);
  }
}

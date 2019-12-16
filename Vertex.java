public class Vertex<V>
{
  private V _label;
  private int _weight;

  Vertex(V label)
  {
    setLabel(label);
    setWeight(0);
  }

  Vertex(V label, int weight)
  {
    setLabel(label);
    setWeight(weight);
  }

  public V getLabel()
  {
    return _label;
  }

  public int getWeight()
  {
    return _weight;
  }

  public void setLabel(V label)
  {
    _label = label;
  }

  public void setWeight(int weight)
  {
    _weight = weight;
  }

  public boolean equals(Vertex<V> other)
  {
    return other.getLabel().equals(this.getLabel());
  }

  public String toString()
  {
    return _label.toString();
  }
}

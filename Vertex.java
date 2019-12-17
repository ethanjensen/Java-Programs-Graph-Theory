public class Vertex<V> implements Comparable<Vertex<V>>
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

  public String toString()
  {
    return String.format("%s, %d", _label, _weight);
  }

  public int compareTo(Vertex<V> o)
  {
    int result = getWeight() - o.getWeight();
    if (result == 0)
    {
      result = toString().compareTo(o.toString());
    }
    return result;
  }
}

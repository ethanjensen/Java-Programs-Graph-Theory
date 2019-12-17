public class Vertex<V> implements Comparable<Vertex<V>>
{
  private V _label;
  private double _weight;

  Vertex(V label)
  {
    setLabel(label);
    setWeight(0);
  }

  Vertex(V label, double weight)
  {
    setLabel(label);
    setWeight(weight);
  }

  public V getLabel()
  {
    return _label;
  }

  public double getWeight()
  {
    return _weight;
  }

  public void setLabel(V label)
  {
    _label = label;
  }

  public void setWeight(double weight)
  {
    _weight = weight;
  }

  public String toString()
  {
    return String.format("%s, %f", _label, _weight);
  }

  public int compareTo(Vertex<V> o)
  {
    int result = (int)getWeight() - (int)o.getWeight();
    if (result == 0)
    {
      result = toString().compareTo(o.toString());
    }
    return result;
  }
}

import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import java.util.Iterator;

public class Tree<V, E>
{
  private Tree<V, E> _parent;
  private Vertex<V> _vertex;
  private ArrayList<Edge<V, E>> _edges;
  private ArrayList<Tree<V, E>> _children;

  public Tree(Vertex<V> v)
  {
    _parent = null;
    _vertex = v;
    _children = new ArrayList<>();
    _edges = new ArrayList<>();
  }

  private void setParent(Tree<V, E> parent)
  {
    _parent = parent;
  }

  public Tree<V, E> getParent()
  {
    return _parent;
  }

  public Vertex<V> getVertex()
  {
    return _vertex;
  }

  public void add(Tree<V, E> child, E label, double weight) throws IllegalArgumentException
  {
    if (child != null)
    {
      if (!child.isAncestorOf(this) && !child.equals(this))
      {
        Edge<V, E> edge = new Edge<>(getVertex(), child.getVertex(), label, weight);
        _edges.add(edge);
        if (!child.isRoot())
        {
          child.getParent().remove(child);
        }
        child.setParent(this);
        _children.add(child);
      }
      else
      {
        throw new IllegalArgumentException();
      }
    }
    else
    {
      throw new IllegalArgumentException();
    }
  }

  public boolean isRoot()
  {
    return getParent() == null;
  }

  public boolean isLeaf()
  {
    return _children.size() == 0;
  }

  public boolean isAncestorOf(Tree<V, E> tree)
  {
    boolean isAncestor = false;
    if (tree != null)
    {
      isAncestor = this.equals(tree.getParent());
      if (!isAncestor && !tree.isRoot())
      {
        isAncestor = isAncestorOf(tree.getParent());
      }
    }
    return isAncestor;
  }

  public void remove(Tree<V, E> tree) throws IllegalArgumentException
  {
    if (this.equals(tree.getParent()))
    {
      _children.remove(tree);
      Edge<V, E> tempEdge = null;
      for (Edge<V, E> edge : _edges)
      {
        if (edge.getVertex2().equals(tree.getVertex()))
        {
          tempEdge = edge;
        }
      }
      _edges.remove(tempEdge);
      tree.setParent(null);
    }
    else
    {
      throw new IllegalArgumentException();
    }
  }

  public double pathCost(Tree<V, E> tree) throws IllegalArgumentException
  {
    double cost = 0;
    if (isAncestorOf(tree))
    {
      if (tree.getParent().equals(this))
      {
        Edge<V, E> tempEdge = null;
        for (Edge<V, E> edge : _edges)
        {
          if (edge.getVertex2().equals(tree.getVertex()))
          {
            tempEdge = edge;
          }
        }
        cost = tempEdge.getWeight();
      }
      else
      {
        cost = tree.getParent().pathCost(tree) + pathCost(tree.getParent());
      }
    }
    else
    {
      throw new IllegalArgumentException();
    }
    return cost;
  }

  public int size()
  {
    int size = 1;
    if (!isLeaf())
    {
      for (Tree<V, E> child : _children)
      {
        size = size + child.size();
      }
    }
    return size;
  }
}

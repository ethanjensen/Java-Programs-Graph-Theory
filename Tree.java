public class Tree<V, E> extends Graph<V, E>
{
  private Tree<V, E> _parent = null;

  private setParent(Tree<V, E> parent)
  {
    _parent = parent;
  }

  Tree()
  {
    super();
  }  
}

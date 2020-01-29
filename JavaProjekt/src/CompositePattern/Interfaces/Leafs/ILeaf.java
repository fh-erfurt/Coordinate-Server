package CompositePattern.Interfaces.Leafs;

import CompositePattern.Interfaces.*;

/**
* Indicate leafs according to the composite pattern.
*/
public interface ILeaf
        extends IComponent
{
}

/**
 Interface defining leafs according to the composite pattern.
 */
public interface ILeaf<TComposite extends IComposite<TComposite>>
        extends IComponent<TComposite>
        extends ILeaf
{
}
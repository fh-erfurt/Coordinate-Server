package CompositePattern.Interfaces.Leafs;

import CompositePattern.Interfaces.*;
/**
* Indicate a leaf in a composite which is treated as independent object.
*/
public interface ILeafComponent   
{
}

/**
 Represents a leaf in a composite which is treated as independent object.
 */
public interface ILeafComponent<TComposite extends IComposite<TComposite>> extends ILeaf<TComposite>, ILeafComponent
{
}
package CompositePattern.Interfaces.Leafs;

import Compositepattern.Interfaces.*;

/**
 Indicate leaf objects in the composition which act as an extension of the parent composite
 and is bounded to the parent composite.
 */
public interface ILeafEnricher
{
}

/**
 Represents leaf objects in the composition which act as an extension of the parent composite
 and is bounded to the parent composite.
 */
public interface ILeafEnricher<TComposite extends IComposite<TComposite>> extends ILeaf<TComposite>, ILeafEnricher
{
}
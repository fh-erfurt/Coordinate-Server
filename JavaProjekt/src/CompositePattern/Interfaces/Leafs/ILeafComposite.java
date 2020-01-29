package Compositepattern.Interfaces.Leafs;

import Compositepattern.Interfaces.*;

/**
 Indicates a leaf storing a new different composite.
 */
public interface ILeafComposite
{
}

/**
 Represents a leaf storing a new different composite.
 */
public interface ILeafComposite<TComposite extends IComposite<TComposite>>
        extends ILeaf<TComposite>
        extends ILeafComposite
{
}
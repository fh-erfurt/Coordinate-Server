package Compositepattern.Interfaces;

import java.util.*;
import java.io.*;

/**
 Interface which describes the abstraction of all components according to the composite pattern.
 */
public interface IComponent
{
    /**
     Unique identifier of the component.
     */
    UUID getUuid();

    /**
     Type of the component.
     */
    String getType();
}

public interface IComponent<TComposite extends IComposite<TComposite>>
        extends IComponent
        extends Closeable
{
    /**
     Name of the component.
     <p>When set <see cref="ComponentChanged"/>.OnNext() is called.</p>
     */
    String getName();
    void setName(String value);

    /**
     Observer for changes in the component.
     <list type="bullet">
     <item><see cref="Name"/></item>
     <item><see cref="Parent"/></item>
     </list>
     */
	//IObservable<(string change, IComponent<TComposite> component)> ComponentChanged { get; }

    /**
     Get the parent of this composite on layer above in the tree.
     <p>When changed <see cref="ComponentChanged"/>.OnNext() is called.</p>
     */
    TComposite getParent();

    /**
     Get the root of the tree the component is in.
     */
    TComposite GetRootComposite();

    /**
     Move the component to a <see cref="IComposite{TComposite}"/> in the tree.

     @param targetComposite Target composite to move the component to.
     @exception ArgumentNullException <paramref name="targetComposite"/>
     @exception InvalidOperationException Cannot move a unmanged component.
     @exception InvalidOperationException Cannot move the root composite.
     @exception InvalidOperationException A composite cannot be added to itself as a child.
     */
    void MoveTo(TComposite targetComposite);

    /**
     Returns true if the component is part of a tree
     and in case of a composite also if its the root of a tree.

     @return The status if the component is managed.
     */
    boolean IsManaged();
}
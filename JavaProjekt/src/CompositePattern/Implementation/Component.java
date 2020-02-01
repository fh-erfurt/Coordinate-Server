package Compositepattern.Implementation;

import Compositepattern.Implementation.Linq.*;
import CompositePattern.Interfaces.*;
import java.util.*;

public abstract class Component
        extends IComponent
{
    private UUID uuid;
    private String type;

    public UUID getUuid()
    {
        return uuid;
    }
    public String getType()
    {
        return type;
    }

    /**
     Generate a <see cref="Component"/> with a UUID.
     @param uuid The UUID for the component, default is a new UUID.
     */
    public Component(UUID uuid)
    {
        this.uuid = uuid != null ? uuid : UUID.NewUuid();
        Type = this.getClass().toString();
    }
    public Component()
    {
        this(null);
    }

    /**
     Outputs a unique name.
     */
    @Override
    public String toString()    { return String.format("%1$s %2$s", getType(), this.uuid); }
}

public abstract class Component<TComposite extends IComposite<TComposite>>
        extends Component
        extends IComponent<TComposite>
{

    private String name;
    private TComposite parent;

    /**
     Subject for <see cref="ComponentChanged"/> observer.
     */
	protected Subject<(String, IComponent<TComposite>)> ComponentChangedSubject
        = new Subject<(String, IComponent<TComposite>)>();


	public IObservable<(String change, IComponent<TComposite> component)> ComponentChanged
    {
        ComponentChangedSubject.AsObservable();
    }

    public String getName()         { return name; }
    public void setName(String value)
    {
        name = value;
        ComponentChangedSubject.OnNext(("Name", this));
    }

    public TComposite getParent()   { return parent; }
    public void setParent(TComposite value)
    {
        parent = value;
        ComponentChangedSubject.OnNext(("Parent", this));
    }

    public final TComposite GetRootComposite()
    {
        return (getParent() == null)
        ? (TComposite)(IComponent<TComposite>)this
        : getParent();
    }

    /**
     Generate a <see cref="Component{TComposite}"/> with a GUID.

     @param name Name of the component, default is <see cref="Type"></see>/>
     @param guid The GUID for the component, default is a new GUID.
     */
    public Component(String name, UUID guid)
    {
        super(guid);
        setName(name != null ? name : getType());
        setParent(null);
    }
    public Component()                  { this(null, null); }
    public Component(String name)       { this(name, null); }
    public Component(UUID uuid)         { this(null, uuid); }

    /**
     Calls <see cref="Dispose(bool)"/> to restore tree.
     */
    protected void finalize()           { Dispose(false); }

    public void MoveTo(TComposite targetComposite)
    {
        TComposite oldParentComposite = getParent();
        compositepattern.implementation.Component componentToMove = this;

        if (targetComposite == null)
        { throw new NullPointerException("targetComposite"); }

        if (!(componentToMove.IsManaged()))
        { throw new IllegalStateException("Cannot move a unmanged component."); }

        if ((componentToMove instanceof IComposite<TComposite>
            ? (IComposite<TComposite>)componentToMove
            : null)
                == null
                ? null
                : ((componentToMove
                    instanceof IComposite<TComposite>
                    ? (IComposite<TComposite>)componentToMove
                    : null).IsRoot())
                        != null
                        ? (componentToMove
                            instanceof IComposite<TComposite>
                            ? (IComposite<TComposite>)componentToMove
                            : null).IsRoot()
                        : false)
        { throw new IllegalStateException("Cannot move the root composite."); }

        if (targetComposite.equals(componentToMove))
        { throw new IllegalStateException("A composite cannot be added to itself as a child."); }

        // if component is composite
        // move not bounded components to its parent representing this as parent
        boolean tempVar = componentToMove instanceof TComposite;
        TComposite compositeToMove = tempVar ? (TComposite)componentToMove : null;
        if (tempVar)
        {
            compositeToMove.ExecuteThreadSave(
                () -> compositeToMove
                    .SelectNotBoundetComponents()
                    .ToList()
                    .ForEach(
                        boundetComponent-> SwapParants(boundetComponent, boundetComponent.Parent, oldParentComposite)));
        }

        // swap parents
        SwapParants(componentToMove, oldParentComposite, targetComposite);
    }

    private void SwapParants(IComponent<TComposite> component, TComposite fromComposite, TComposite toComposite)
    {
	    fromComposite.Remove(component);
	    toComposite.Add(component);
	}

    public boolean IsManaged()
    {
        return getParent() != null || ((this instanceof IComposite<TComposite>
        ? (IComposite<TComposite>)this
        : null)
            == null
            ? null
            : ((this
                instanceof IComposite<TComposite>
                ? (IComposite<TComposite>)this
                : null).IsRoot())
                    != null
                    ? (this
                        instanceof IComposite<TComposite>
                        ? (IComposite<TComposite>)this
                        : null).IsRoot()
                    : false);
    }

    @Override
    public String toString()
    {
        String addedUuid = compositepattern.implementation.linq.Linq.IsNameUnique(GetRootComposite(), getName()) ? "" : String.format(" %1$s", UUID.toString());
        return String.format("%1$s%2$s", getName(), addedUuid);
    }

    private boolean disposedValue = false;
    /**
     Dispose the component and restores the tree by removing it form the parent.
     */
    protected void Dispose(boolean disposing)
    {
        if (!disposedValue)
        {
            // remove the manged component from the parent
            if (IsManaged())
            { getParent().Remove(this); }

            ComponentChangedSubject.OnCompleted();

            if (disposing)
            { ComponentChangedSubject.Dispose(); }

            disposedValue = true;
        }
    }

    public void Dispose()   { Dispose(true); }
}
package Compositepattern.Implementation;

import CompositePattern.Interfaces.*;
import CompositePattern.Interfaces.Leafs.*;
import Compositepattern.Implementation.Linq.*;
import java.util.*;

public class Composite <TComposite extends IComposite<TComposite>>
	extends Component<TComposite>
	extends IComposite<TComposite>
{
	private Subject<(String operation, TComposite source, IComponent<TComposite> component, TComposite target)> ChildrenChangedSubject
		= new Subject<(String operation, TComposite source, IComponent<TComposite> component, TComposite target)>();

	public IObservable<(String operation, TComposite source, IComponent<TComposite> component, TComposite target)> getChildChanged()
		{ return ChildrenChangedSubject.AsObservable();	}

	protected ObservedChildComponentsCollection ChildrenCollection;

	public Composite(String name, UUID uuid)
	{
		super(name, uuid);
		ChildrenCollection = new ObservedChildComponentsCollection(ComponentChangedSubject, ChildrenChangedSubject);				//TODO: Class have to be implemented
	}
	public Composite()                          { this(null, null);	}
	public Composite(String name)	            { this(name, null);	}
	public Composite(UUID uuid)	                { this(null, uuid);	}
}

public class Composite
		<TComposite extends IComposite<TComposite>,
		 TLeafComponent extends ILeafComponent<TComposite>>
    extends Composite<TComposite> 
    extends IComposite<TComposite, TLeafComponent>
{

	public Iterable<TLeafComponent> SelectLeafComponents()
	{
		return ExecuteThreadSave(() -> this.Where(x -> x instanceof TLeafComponent).<TLeafComponent>Cast());
	}

	public Composite(String name, UUID uuid)	{ super(name, uuid); }
	public Composite()                          { this(null, null);	}
	public Composite(String name)	            { this(name, null);	}
	public Composite(UUID uuid)	                { this(null, uuid);	}
}

public class Composite
		<TComposite extends Composite<TComposite>,
		 TLeafComponent extends ILeafComponent<TComposite>,
		 TLeafEnricher extends ILeafEnricher<TComposite>>
    extends Composite<TComposite, TLeafComponent> 
    extends IComposite<TComposite, TLeafComponent, TLeafEnricher>
{
	public final Iterable<ILeafEnricher> SelectLeafEnricher()
	{
		return ExecuteThreadSave(() -> this.Where(x -> x instanceof ILeafEnricher).<ILeafEnricher>Cast());
	}

	public Composite(String name, UUID uuid)	{ super(name, uuid); }
	public Composite()	                        { this(null, null);	}
	public Composite(String name)	            { this(name, null);	}
	public Composite(UUID uuid)	                { this(null, uuid);	}
}

public class Composite
		<TComposite extends Composite<TComposite>,
		 TLeafComponent extends ILeafComponent<TComposite>,
		 TLeafEnricher extends ILeafEnricher<TComposite>,
		 TLeafComposite extends ILeafComposite<TComposite>>
    extends Composite<TComposite, TLeafComponent, TLeafEnricher> 
    extends IComposite<TComposite, TLeafComponent, TLeafEnricher, TLeafComposite>
{
	public final Iterable<TLeafComposite> SelectLeafComposites()
	{
		return ExecuteThreadSave(() -> this.Where(x -> x instanceof TLeafComposite).<TLeafComposite>Cast());
	}

    public Composite(String name, UUID uuid)    { super(name, uuid); }
	public Composite()	                        { this(null, null); }
	public Composite(String name)	            { this(name, null); }
	public Composite(UUID uuid)	                { this(null, uuid); }
}
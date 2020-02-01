package Compositepattern.Interfaces;

import Compositepattern.Interfaces.Leafs.*;
import java.util.*;
import java.lang.*;

public interface IComposite extends IComponent
{
}

public interface IComposite<TComposite extends IComposite<TComposite>>
        extends IComponent<TComposite>
        extends Collection<IComponent<TComposite>>
        extends IComposite
{
    /**
     Observer for changes in the child structure.
     <list type="bullet">
     <item><c>Add()</c></item>
     <item><c>Remove()</c></item>
     <item><c>Clear()</c></item>
     <item><c>MoveTo()</c></item>
     </list>
     */
	IObservable<(string operation, TComposite source, IComponent<TComposite> component, TComposite target)> ChildChanged { get; }

    /**
     Execute the <paramref name="action"/> on the storage threat save with a look.
     @param action Action delegate to execute.
     @exception ArgumentNullException
     */
    void ExecuteThreadSave(Action action);

    /**
     Execute the <paramref name="function"/> on the storage threat save with a look.
     <typeparam name="T">Return type of <paramref name="function"/></typeparam>
     @param function Function delegate to execute.
     @return The result of <paramref name="function"/> in type <typeparamref name="T"/>.
     @exception ArgumentNullException
     */
    T this.<T>ExecuteThreadSave(Func<T> function);

    /**
     Select alls components in this and asubsequent composites.
     @return Enumerator over all components in this and asubsequent composites.
     */
    Iterable<IComponent<TComposite>> SelectAllComponentsInSubTree();

    /**
     Child components filtert by <typeparamref name="TComposite"/>.
     @return Enumerator for childes of type <typeparamref name="TComposite"/>.
     */
    Iterable<TComposite> SelectChildComposites();

    /**
     Indicate that this component is the root of a tree.
     Compostelas without not bounded components are not indicated as root.
     @return True if this is a root.
     */
    boolean IsRoot();
}

public interface IComposite<TComposite extends IComposite<TComposite>, TLeafComponent extends ILeafComponent<TComposite>> extends IComposite<TComposite>
{
    /**
     Child components filtert by <typeparamref name="TLeafComponent"/>.
     @return Enumerator for childes of type <typeparamref name="TLeafComponent"/>.
     */
    Iterable<TLeafComponent> SelectLeafComponents();
}

public interface IComposite<TComposite extends IComposite<TComposite>, TLeafComponent extends ILeafComponent<TComposite>, TLeafEnricher extends ILeafEnricher<TComposite>> extends IComposite<TComposite, TLeafComponent>
{
    /**
     Child components filtert by <typeparamref name="TLeafEnricher"/>.
     @return Enumerator for children of type <typeparamref name="TLeafEnricher"/>.
     */
    Iterable<ILeafEnricher> SelectLeafEnricher();
}

public interface IComposite<TComposite extends IComposite<TComposite>, TLeafComponent extends ILeafComponent<TComposite>, TLeafEnricher extends ILeafEnricher<TComposite>, TLeafComposit extends ILeafComposite<TComposite>> extends IComposite<TComposite, TLeafComponent, TLeafEnricher>
{
    /**
     Child components filtert by <typeparamref name="TLeafComposit"/>.
     @return Enumerator for children of type <typeparamref name="TLeafComposit"/>.
     */
    Iterable<TLeafComposit> SelectLeafComposites();
}
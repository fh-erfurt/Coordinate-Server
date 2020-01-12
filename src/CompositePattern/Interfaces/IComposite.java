package Compositepattern.Interfaces;

import Compositepattern.Interfaces.Leafs.*;
import java.util.*;
import java.lang.*;

/**
 Interface identifying components as collection of children according to the composite pattern.
 */
public interface IComposite extends IComponent
{
}

/**
 Interface describing the handling of components as collection of children according to the composite pattern.
 The childes are stored by implementing <see cref="ICollection{TComposite}"/>
 */
public interface IComposite<TComposite extends IComposite<TComposite>> extends IComponent<TComposite>, Collection<IComponent<TComposite>>, IComposite
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
    //C# TO JAVA CONVERTER TODO TASK: The following line could not be converted:
	//IObservable<(string operation, TComposite source, IComponent<TComposite> component, TComposite target)> ChildChanged { get; }

    /**
     Execute the <paramref name="action"/> on the storage threat save with a look.

     @param action Action delegate to execute.
     @exception ArgumentNullException
     */
    //void ExecuteThreadSave(Action action);

    /**
     Execute the <paramref name="function"/> on the storage threat save with a look.

     <typeparam name="T">Return type of <paramref name="function"/></typeparam>
     @param function Function delegate to execute.
     @return The result of <paramref name="function"/> in type <typeparamref name="T"/>.
     @exception ArgumentNullException
     */
    //T this.<T>ExecuteThreadSave(Func<T> function);

    /**
     Select alls components in this and asubsequent composites.

     @return Enumerator over all components in this and asubsequent composites.
     */
    Iterable<IComponent<TComposite>> SelectAllComponentsInSubTree();

    /**
     Child components filtert by <typeparamref name="TComposite"/>.

     @return Enumerator for childes of type <typeparamref name="TComposite"/>.
     */
    java.lang.Iterable<TComposite> SelectChildComposites();

    /**
     Indicate that this component is the root of a tree.
     Compostelas without not bounded components are not indicated as root.

     @return True if this is a root.
     */
    boolean IsRoot();
}

/** <inheritdoc/>
 */
//C# TO JAVA CONVERTER TODO TASK: Local functions are not converted by C# to Java Converter:
//public interface IComposite<TComposite, TLeafComponent> : IComposite<TComposite> where TComposite : IComposite<TComposite> where TLeafComponent : ILeafComponent<TComposite>
//	{
//		/**
//		 Child components filtert by <typeparamref name="TLeafComponent"/>.
//
//		 @return Enumerator for childes of type <typeparamref name="TLeafComponent"/>.
//		*/
//		IEnumerable<TLeafComponent> SelectLeafComponents();
//	}

/** <inheritdoc/>
 */
//C# TO JAVA CONVERTER TODO TASK: Local functions are not converted by C# to Java Converter:
//public interface IComposite<TComposite, TLeafComponent, TLeafEnricher> : IComposite<TComposite, TLeafComponent> where TComposite : IComposite<TComposite> where TLeafComponent : ILeafComponent<TComposite> where TLeafEnricher : ILeafEnricher<TComposite>
//	{
//		/**
//		 Child components filtert by <typeparamref name="TLeafEnricher"/>.
//
//		 @return Enumerator for childes of type <typeparamref name="TLeafEnricher"/>.
//		*/
//		IEnumerable<ILeafEnricher> SelectLeafEnricher();
//	}

/** <inheritdoc/>
 */
//C# TO JAVA CONVERTER TODO TASK: Local functions are not converted by C# to Java Converter:
//public interface IComposite<TComposite, TLeafComponent, TLeafEnricher, TLeafComposit> : IComposite<TComposite, TLeafComponent, TLeafEnricher> where TComposite : IComposite<TComposite> where TLeafComponent : ILeafComponent<TComposite> where TLeafEnricher : ILeafEnricher<TComposite> where TLeafComposit : ILeafComposite<TComposite>
//	{
//		/**
//		 Child components filtert by <typeparamref name="TLeafComposit"/>.
//
//		 @return Enumerator for childes of type <typeparamref name="TLeafComposit"/>.
//		*/
//		IEnumerable<TLeafComposit> SelectLeafComposites();
//	}

package CompositePattern.Interfaces.Leafs;

import CompositePattern.Interfaces.*;

/**
 Represents leaf objects in the composition which act as an extension of the parent composite.
 */
public interface ILeafEnricherOrdered<TComposite extends IComposite<TComposite>>
        extends ILeafEnricher<TComposite>
{
    /**
     Represents the position of the enricher in a ordered sequence.
     */
    int getOrderPostion();
}



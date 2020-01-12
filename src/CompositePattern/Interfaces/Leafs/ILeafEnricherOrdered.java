//
// Translated by CS2J (http://www.cs2j.com): 12.01.2020 17:00:41
//

package CompositePattern.Interfaces.Leafs;

import CompositePattern.Interfaces.Leafs.ILeafEnricher;

/**
* Represents leaf objects in the composition which act as an extension of the parent composite.
*/
public interface ILeafEnricherOrdered <TComposite extends IComposite<TComposite>>  extends ILeafEnricher<TComposite>
{
    /**
    * Represents the position of the enricher in a ordered sequence.
    */
    int getOrderPostion() throws Exception ;

}



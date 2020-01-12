//
// Translated by CS2J (http://www.cs2j.com): 12.01.2020 17:00:41
//

package CompositePattern.Implementation.Leafs;

import CompositePattern.Implementation.Leafs.Leaf;
import CompositePattern.Interfaces.Leafs.ILeafComposite;

/**
* 
*/
public class LeafComposite <TComposite extends IComposite<TComposite>> extends Leaf<TComposite> implements ILeafComposite<TComposite>
{
    /**
    * 
    */
    public LeafComposite(String name, Guid? guid) throws Exception {
        super(name, guid);
    }

}



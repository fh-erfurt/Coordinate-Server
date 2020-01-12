//
// Translated by CS2J (http://www.cs2j.com): 12.01.2020 17:00:41
//

package CompositePattern.Implementation.Leafs;

import CompositePattern.Implementation.Leafs.Leaf;
import CompositePattern.Interfaces.Leafs.ILeafComponent;

/**
* 
*/
public class LeafComponent <TComposite extends IComposite<TComposite>> extends Leaf<TComposite> implements ILeafComponent<TComposite>
{
    /**
    * 
    */
    public LeafComponent(String name, Guid? guid) throws Exception {
        super(name, guid);
    }

}



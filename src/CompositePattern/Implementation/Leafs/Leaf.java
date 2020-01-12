//
// Translated by CS2J (http://www.cs2j.com): 12.01.2020 17:00:41
//

package CompositePattern.Implementation.Leafs;

import CompositePattern.Implementation.Component;
import CompositePattern.Interfaces.Leafs.ILeaf;

/**
* 
*/
public abstract class Leaf <TComposite extends IComposite<TComposite>> extends Component<TComposite> implements ILeaf<TComposite>
{
    /**
    * Generate a new leaf type.
    * 
    *  @param name Name of the component, default is 
    *  {@link #Type}
    * />
    *  @param guid The GUID for the component, default is a new GUID.
    */
    public Leaf(String name, Guid? guid) throws Exception {
        super(name, guid);
    }

}



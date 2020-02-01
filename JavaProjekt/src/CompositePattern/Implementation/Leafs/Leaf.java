package CompositePattern.Implementation.Leafs;

import CompositePattern.Implementation.*;
import CompositePattern.Interfaces.*;
import CompositePattern.Interfaces.Leafs.*;
import java.util.*;

public abstract class Leaf <TComposite extends IComposite<TComposite>>
        extends Component<TComposite>
        extends ILeaf<TComposite>
{
    /**
     * Generate a new leaf type.
     *
     *  @param name Name of the component, default is
     *  {@link #Type}
     *
     *  @param guid The UUID for the component, default is a new UUID.
     */
    public Leaf(String name, UUID uuid) { super(name, uuid); }
    public Leaf()                       { this(null, null); }
    public Leaf(String name)            { this(name, null); }
    public Leaf(UUID uuid)              { this(null, uuid); }
}
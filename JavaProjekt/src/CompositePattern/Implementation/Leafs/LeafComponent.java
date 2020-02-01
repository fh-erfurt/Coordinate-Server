package CompositePattern.Implementation.Leafs;

import CompositePattern.Implementation.*;
import CompositePattern.Interfaces.*;
import CompositePattern.Interfaces.Leafs.*;
import java.util.*;

public class LeafComponent <TComposite extends IComposite<TComposite>>
        extends Leaf<TComposite>
        extends ILeafComponent<TComposite>
{
    /**
     * Generate a new leafComponent type.
     *
     *  @param name Name of the component, default is
     *  {@link #Type}
     *
     *  @param guid The UUID for the component, default is a new UUID.
     */
    public LeafComponent(String name, UUID uuid)    { super(name, uuid); }
    public LeafComponent()                          { this(null, null); }
    public LeafComponent(String name)               { this(name, null); }
    public LeafComponent(UUID uuid)                 { this(null, uuid); }
}
package CompositePattern.Implementation.Leafs;

import CompositePattern.Interfaces.*;
import CompositePattern.Interfaces.Leafs.*;
import compositepattern.implementation.*;
import java.util.*;

public class LeafComposite <TComposite extends IComposite<TComposite>>
        extends Leaf<TComposite>
        extends ILeafComposite<TComposite>
{
    /**
     * Generate a new leafComposite type.
     *
     *  @param name Name of the component, default is
     *  {@link #Type}
     *
     *  @param guid The UUID for the component, default is a new UUID.
     */
    public LeafComposite(String name, UUID uuid)    { super(name, uuid); }
    public LeafComposite()                          { this(null, null); }
    public LeafComposite(String name)               { this(name, null); }
    public LeafComposite(UUID uuid)                 { this(null, uuid); }
}
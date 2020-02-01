package CompositePattern.Implementation.Leafs;

import CompositePattern.Interfaces.*;
import CompositePattern.Interfaces.Leafs.*;
import compositepattern.implementation.*;
import java.util.*;


public class LeafEnricher <TComposite extends IComposite<TComposite>>
        extends Leaf<TComposite>
        extends ILeafEnricher<TComposite>
{
    /**
     * Generate a new leafEnricher type.
     *
     *  @param name Name of the component, default is
     *  {@link #Type}
     *
     *  @param guid The UUID for the component, default is a new UUID.
     */
    public LeafEnricher(String name, UUID uuid)     { super(name, uuid); }
    public LeafEnricher()                           { this(null, null); }
    public LeafEnricher(String name)                { this(name, null); }
    public LeafEnricher(UUID uuid)                  { this(null, uuid); }
}
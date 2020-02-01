package CompositePattern.Implementation.Leafs;

import CompositePattern.Interfaces.*;
import CompositePattern.Interfaces.Leafs.*;
import compositepattern.implementation.*;
import java.util.*;

public class LeafEnricherOrdered <TComposite extends IComposite<TComposite>>
        extends Leaf<TComposite>
        extends ILeafEnricherOrdered<TComposite>
{
    /**
     * Generate a new leaf type.
     *
     *  @param name Name of the component, default is
     *  {@link #Type}
     *
     *  @param guid The UUID for the component, default is a new UUID.
     */
    public LeafEnricherOrdered(String name, UUID uuid)      { super(name, uuid); }
    public LeafEnricherOrdered()                            { this(null, null); }
    public LeafEnricherOrdered(String name)                 { this(name, null); }
    public LeafEnricherOrdered(UUID uuid)                   { this(null, uuid); }

    public int getOrderPostion() { return throw new UnsupportedOperationException(); }
}
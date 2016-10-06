package simpl.typing;

import simpl.parser.Symbol;

public class TypeVar extends Type {

    private static int tvcnt = 0;

    private boolean equalityType;
    private Symbol name;

    public TypeVar(boolean equalityType) {
        this.equalityType = equalityType;
        name = Symbol.symbol("tv" + ++tvcnt);
    }

    @Override
    public boolean isEqualityType() {
        return equalityType;
    }

    @Override
    public Substitution unify(Type t) throws TypeCircularityError {
        // DevinZ
        if (t.contains(this) && !t.equals(this)) {
            //System.out.println(this+"=>"+t);
            throw new TypeCircularityError();
        } else {
            return Substitution.of(this,t);
        }
    }

    public final boolean equals(Type t) {
        return (t instanceof TypeVar) && 
            ((TypeVar)t).name.equals(name);
    }
    
    public String toString() {
        return "" + name;
    }

    @Override
    public boolean contains(TypeVar tv) {
        // DevinZ
        return name.equals(tv.name);
    }

    @Override
    public Type replace(TypeVar a, Type t) {
        // DevinZ
        //System.out.println("Replace "+a+" with "+t+" in "+this);
        return name.equals(a.name)? t:this;
    }
}

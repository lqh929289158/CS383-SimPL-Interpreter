package simpl.typing;

public final class ListType extends Type {

    public Type t;

    public ListType(Type t) {
        this.t = t;
    }

    @Override
    public boolean isEqualityType() {
        return t.isEqualityType();
    }

    @Override
    public Substitution unify(Type t) throws TypeError {
        // DevinZ
        if (t instanceof TypeVar) {
            return t.unify(this);
        } else if (t instanceof ListType) {
            return this.t.unify(((ListType)t).t);
        }
        throw new TypeMismatchError();
    }

    @Override
    public boolean contains(TypeVar tv) {
        // DevinZ
        return t.contains(tv);
    }

    @Override
    public Type replace(TypeVar a, Type t) {
        // DevinZ
        Type t1 = this.t.replace(a,t);
        return new ListType(t1);
    }

    public String toString() {
        return t + " list";
    }
}

package simpl.typing;

public final class RefType extends Type {

    public Type t;

    public RefType(Type t) {
        this.t = t;
    }

    @Override
    public boolean isEqualityType() {
       return true;
    }

    @Override
    public Substitution unify(Type t) throws TypeError {
        // DevinZ
        if (t instanceof TypeVar) {
            return t.unify(this);
        } else if (t instanceof RefType) {
            return this.t.unify(((RefType)t).t);
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
        return new RefType(t1);
    }

    public String toString() {
        return t + " ref";
    }
}

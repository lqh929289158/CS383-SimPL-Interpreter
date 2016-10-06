package simpl.typing;

public final class PairType extends Type {

    public Type t1, t2;

    public PairType(Type t1, Type t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public boolean isEqualityType() {
        return t1.isEqualityType() && t2.isEqualityType();
    }

    @Override
    public Substitution unify(Type t) throws TypeError {
        // DevinZ
        if (t instanceof TypeVar) {
            return t.unify(this);
        } else if (t instanceof PairType) {
            Substitution s1 = t1.unify(((PairType)t).t1);
            Substitution s2 = t2.unify(((PairType)t).t2);
            return s2.compose(s1);
        }
        throw new TypeMismatchError();
    }

    @Override
    public boolean contains(TypeVar tv) {
        // DevinZ
        return t1.contains(tv) || t2.contains(tv);
    }

    @Override
    public Type replace(TypeVar a, Type t) {
        // DevinZ
        Type t11 = t1.replace(a,t);
        Type t21 = t2.replace(a,t);
        return new PairType(t11,t21);
    }

    public String toString() {
        return "(" + t1 + " * " + t2 + ")";
    }
}

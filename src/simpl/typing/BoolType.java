package simpl.typing;

final class BoolType extends Type {

    protected BoolType() {
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
        } else if (t instanceof BoolType) {
            return Substitution.IDENTITY;
        }
        throw new TypeMismatchError();
    }

    @Override
    public boolean contains(TypeVar tv) {
        // DevinZ
        return false;
    }

    @Override
    public Type replace(TypeVar a, Type t) {
        // DevinZ
        return Type.BOOL;
    }

    public String toString() {
        return "bool";
    }
}

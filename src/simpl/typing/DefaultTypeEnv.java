package simpl.typing;

import simpl.parser.Symbol;

public class DefaultTypeEnv extends TypeEnv {

    private TypeEnv E;

    public DefaultTypeEnv() {
        // DevinZ
        TypeVar tv1 = new TypeVar(true);
        TypeVar tv2 = new TypeVar(true);
        E = TypeEnv.empty;
        E = TypeEnv.of(E,Symbol.symbol("fst"),
            new ArrowType(new PairType(tv1,tv2),tv1));
        E = TypeEnv.of(E,Symbol.symbol("snd"),
            new ArrowType(new PairType(tv1,tv2),tv2));
        E = TypeEnv.of(E,Symbol.symbol("hd"),
            new ArrowType(new ListType(tv1),tv1));
        E = TypeEnv.of(E,Symbol.symbol("tl"),
            new ArrowType(new ListType(tv1),new ListType(tv1)));
        E = TypeEnv.of(E,Symbol.symbol("iszero"),
            new ArrowType(Type.INT,Type.BOOL));
        E = TypeEnv.of(E,Symbol.symbol("pred"),
            new ArrowType(Type.INT,Type.INT));
        E = TypeEnv.of(E,Symbol.symbol("succ"),
            new ArrowType(Type.INT,Type.INT));
    }

    @Override
    public Type get(Symbol x) {
        return E.get(x);
    }
}

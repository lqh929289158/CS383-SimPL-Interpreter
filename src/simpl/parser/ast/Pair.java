package simpl.parser.ast;

import simpl.interpreter.PairValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.typing.PairType;
import simpl.typing.Substitution;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class Pair extends BinaryExpr {

    public Pair(Expr l, Expr r) {
        super(l, r);
    }

    public String toString() {
        return "(pair " + l + " " + r + ")";
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // DevinZ
        TypeResult lr = l.typecheck(E);
        TypeResult rr = r.typecheck(E);
        Substitution s = rr.s.compose(lr.s);
        return TypeResult.of(s,
            new PairType(s.apply(lr.t),s.apply(rr.t)));
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        // DevinZ
        return new PairValue(l.eval(s),r.eval(s));
    }
}

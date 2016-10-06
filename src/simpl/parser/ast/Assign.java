package simpl.parser.ast;

import simpl.interpreter.RefValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.typing.RefType;
import simpl.typing.Substitution;
import simpl.typing.Type;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class Assign extends BinaryExpr {

    public Assign(Expr l, Expr r) {
        super(l, r);
    }

    public String toString() {
        return l + " := " + r;
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // DevinZ
        TypeResult lr = l.typecheck(E);
        TypeResult rr = r.typecheck(E);
        Substitution s = rr.s.compose(lr.s);
        s = s.compose(lr.t.unify(new RefType(rr.t)));
        return TypeResult.of(s,Type.UNIT);
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        // DevinZ
        RefValue p1 = (RefValue)l.eval(s);
        Value v = r.eval(s);
        s.M.put(p1.p,v);
        return Value.UNIT;
    }
}

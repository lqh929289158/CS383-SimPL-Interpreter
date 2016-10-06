package simpl.parser.ast;

import simpl.interpreter.ConsValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.typing.ListType;
import simpl.typing.Substitution;
import simpl.typing.Type;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class Cons extends BinaryExpr {

    public Cons(Expr l, Expr r) {
        super(l, r);
    }

    public String toString() {
        return "(" + l + " :: " + r + ")";
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // DevinZ
        TypeResult lr = l.typecheck(E);
        TypeResult rr = r.typecheck(E);
        Substitution s = rr.s.compose(lr.s);
        lr.t = s.apply(lr.t);
        rr.t = s.apply(rr.t);
        s = s.compose(rr.t.unify(new ListType(lr.t)));
        return TypeResult.of(s,s.apply(rr.t));
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        // DevinZ
        Value v1 = l.eval(s);
        Value v2 = r.eval(s);
        return new ConsValue(v1,v2);
    }
}

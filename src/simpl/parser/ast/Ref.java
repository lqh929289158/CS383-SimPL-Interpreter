package simpl.parser.ast;

import simpl.interpreter.Int;
import simpl.interpreter.RefValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.typing.RefType;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class Ref extends UnaryExpr {

    public Ref(Expr e) {
        super(e);
    }

    public String toString() {
        return "(ref " + e + ")";
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // DevinZ
        TypeResult r = e.typecheck(E);
        return TypeResult.of(r.s,new RefType(r.t));
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        // DevinZ
        int p1 = s.p.get();
        s.p.set(s.p.get()+1);
        s.M.put(p1, e.eval(s));
        return new RefValue(p1);
    }
}

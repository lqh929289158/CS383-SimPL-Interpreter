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
import simpl.typing.TypeVar;

public class Deref extends UnaryExpr {

    public Deref(Expr e) {
        super(e);
    }

    public String toString() {
        return "!" + e;
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // DevinZ
        TypeResult r = e.typecheck(E);
        if (!(r.t instanceof RefType)) {
            throw new TypeError("Deref");
        } else {
            return TypeResult.of(r.s,((RefType)r.t).t);
        }
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        // DevinZ
        RefValue v = (RefValue) e.eval(s);  
        return s.M.get(v.p);
    }
}

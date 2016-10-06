package simpl.parser.ast;

import simpl.interpreter.RecValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.parser.Symbol;
import simpl.typing.Substitution;
import simpl.typing.Type;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;
import simpl.typing.TypeVar;

public class Name extends Expr {

    public Symbol x;

    public Name(Symbol x) {
        this.x = x;
    }

    public String toString() {
        return "" + x;
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // DevinZ
        Type t = E.get(x);
        if (t==null) {
            throw new TypeError("Name");
        } else {
            return TypeResult.of(t);
        }
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        // DevinZ
        Value v = s.E.get(x);
        if (v instanceof RecValue) {
            return (new Rec(((RecValue)v).x,((RecValue)v).e)).
                eval(State.of(((RecValue)v).E, s.M, s.p));
        } else {
            return v;
        }
    }
}

package simpl.parser.ast;

import simpl.interpreter.BoolValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.typing.Substitution;
import simpl.typing.Type;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class Loop extends Expr {

    public Expr e1, e2;

    public Loop(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public String toString() {
        return "(while " + e1 + " do " + e2 + ")";
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // DevinZ
        TypeResult r1 = e1.typecheck(E);
        TypeResult r2 = e2.typecheck(E);
        Substitution s = r2.s.compose(r1.s);
        s = s.compose(r1.t.unify(Type.BOOL));
        return TypeResult.of(s,Type.UNIT);
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        // DevinZ
        while (((BoolValue)e1.eval(s)).b) {
            e2.eval(s);
        }
        return Value.UNIT;
    }
}

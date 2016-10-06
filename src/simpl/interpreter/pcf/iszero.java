package simpl.interpreter.pcf;

import simpl.interpreter.BoolValue;
import simpl.interpreter.Env;
import simpl.interpreter.FunValue;
import simpl.interpreter.IntValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.parser.Symbol;
import simpl.parser.ast.Eq;
import simpl.parser.ast.Expr;
import simpl.parser.ast.IntegerLiteral;
import simpl.parser.ast.Name;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class iszero extends FunValue {

    public iszero() {
        // DevinZ
        super(Env.empty, Symbol.symbol("$"), new Eq(null,null));
        ((Eq)e).l = new Name(x);
        ((Eq)e).r = new IntegerLiteral(0);
    }
}

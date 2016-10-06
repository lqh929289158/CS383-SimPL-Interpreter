package simpl.interpreter.lib;

import simpl.interpreter.Env;
import simpl.interpreter.FunValue;
import simpl.interpreter.PairValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.parser.Symbol;
import simpl.parser.ast.Expr;
import simpl.parser.ast.Pair;
import simpl.typing.ArrowType;
import simpl.typing.PairType;
import simpl.typing.Type;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;
import simpl.typing.TypeVar;

public class fst extends FunValue {

    public fst() {
        // DevinZ
        super(null,null,null);
    }
    
    public String toString() {
        return "fst";
    }

    public boolean equals(Value other) {
        return (other instanceof fst);
    }
}

package simpl.interpreter;

import static simpl.parser.Symbol.symbol;
import simpl.interpreter.lib.hd;
import simpl.interpreter.lib.tl;
import simpl.interpreter.lib.fst;
import simpl.interpreter.lib.snd;
import simpl.interpreter.pcf.iszero;
import simpl.interpreter.pcf.pred;
import simpl.interpreter.pcf.succ;
import simpl.parser.Symbol;

public class InitialState extends State {

    public InitialState() {
        super(initialEnv(Env.empty), new Mem(), new Int(0));
    }

    private static Env initialEnv(Env E) {
        // DevinZ
        if (E.get(symbol("iszero"))==null) {
            E = new Env(E,Symbol.symbol("iszero"),new iszero());
        }
        if (E.get(symbol("pred"))==null) {
            E = new Env(E,symbol("pred"),new pred());
        }
        if (E.get(symbol("succ"))==null) {
            E = new Env(E,symbol("succ"),new succ());
        }
        if (E.get(symbol("fst"))==null) {
            E = new Env(E,symbol("fst"),new fst());
        }
        if (E.get(symbol("snd"))==null) {
            E = new Env(E,symbol("snd"),new snd());
        }
        if (E.get(symbol("hd"))==null) {
            E = new Env(E,symbol("hd"),new hd());
        }
        if (E.get(symbol("tl"))==null) {
            E = new Env(E,symbol("tl"),new tl());
        }
        return E;
    }
}

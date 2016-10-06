# SimPL Interpreter

An interpreter for the programming language SimPL based on the skeleton code v4.2 provided by [course CS383](http://www.cs.sjtu.edu.cn/~kzhu/cs383/).

SimPL is a dialect of ML, which has both functional and imperative language features (see [project tutorial](doc/spec.pdf)).

## Dependencies

src/simpl/parser/java-cup-11a.jar

src/simpl/parser/JFlex.jar

## Build

To begin with, type "make" in src/simpl/parser/ to generate parser code.

Then import this project to eclipse with the help of bin/formatter.xml.

Finally use eclipse to complile and generate SimPL.jar.

## Test or Run

    java -jar SimPL.jar doc/examples/xxx.spl


# COOL Compiler #

This assignment is phase-A, that is, parser part only (checking syntactic structure of the input COOL program), of the complete parser (which is parser + AST construction) project.

The grammar file, **CoolParser.g4**, has the rules for COOL's syntactic structure. Parser has the lexer already performed on the input cool program and the tokens are already captured/computed which are used in the parser rules (as uppercase symbols). A parser rule has its non-terminal symbols all in lowercase letters.

## Class list, expressions, arguments inside functions and other terms :

The list of classes is defined as **[[class;]] EOF**, which covers the whole text of the program, whatever content is there is defined/declared in the class definitions. **class** is defined as **class TYPE [inherits TYPE] { [[feature;]] * }**.

**feature** defines both function definitions as well as member-variable declarations + initializations.

In the expression **[[expr]]**, the double brackets, **[[]]** are used in the grammar as a meta-symbol to show association of
grammar symbols, for example, the expression **[[a]]*** means that character 'a' can occur zero or more times.

Likewise, in the expression **[expr]**, the single pair of brackets, **[]**, mean whatever expression is inside them (here **expr**) is optional, for example, **[a]** means character 'a' may occur or not, which is the same as **('a')?**, in normal regex expressions.

Also, the expression in rule **expression : A|B|C...** defines all the operator expressions as well major definitions/declarations, identifiers such as OBJECTID, TYPEID, etc. Example - (2 + 3), (new IO), (new A).methodA(arg : Int), etc.

The expression list is defined as follows :

  - **[expr [[, expr]] * ]?**,    where the complete list is optional, and
  - **{ [[expr]]+ }**,    where the expression/expression list is included in braces. Example : class A { { a : Int <- 1; } }

Also, functions can be either with 0 or more number of arguments. This means the **argument_list** is optional inside the parentheses. The argument_list is defined as **[formal [[, formal]] * ]**, where the symbol **formal** is **ID : TYPE**. In general, all list-rules in the grammar are defined in the same manner. Note that the list has the expression in **[]**, thus making it optional.

The constants are defined as INT_CONST, BOOL_CONST and STR_CONST, where each token contains the appropriate value, thanks to the lexer ran on the input COOL program earlier.

## Rules regarding the precedence of operators :

The parser rules are written according to the precedence of the COOL operators. All operators are left-associative except the assignment operator, and operators like <, <= and = have no precedence. This would be important in constructing the AST in phase-B.

## Correct programs :

  - diamond.cl : The program demonstrates the structure of while-loops and if-blocks, in nested form as well.
  - inheritance.cl : The program demonstrates the use of let as well as case constructs, along with multiple classes.
    Nested expressions are demonstrated as well.
  - mergesort.cl : The program has nested let constructs, as well as while and if nested in let constructs as well. The program
    sufficiently complex and long to test major syntactic issues.
  - tail_recursion.cl : The program demonstates multiple function definitions in a single class.

    All the programs above are compiled successfully.

## Syntactically incorrect programs :

  - wrong1.cl : This program has an object_identifier (ID) start with lowercase letter, thus creating parsing error.
  - wrong2.cl : This program has an expression followed by a **;**, inside a block (enclosed by braces - **{}**), thus creating a
    parser error. Such expressions are not allowed according to COOL's syntactic structure.
  - wrong3.cl : The program has illegal expression inside the function's argument space (inside the parentheses, **()**),
    thus creating a parser error
  - wrong4.cl : The program has variable name begin with uppercase letter, which creates a parser error. Note that this program has
    a semantic error (a : 1 + "2", addition of Int and String), but this, is and should not, be reported by a parser.

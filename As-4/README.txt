**SEMANTIC ANALYZER**

This assignment's goal is to implement a working semantic analyzer for COOL. Semantic phase is that phase of compilation where
sanity checks are performed, like, addition of an Int and String doesn't make any sense and needs error highlighting, however, this won't be reported as an error in the lexer and parser phases, and thus an error would be reported in this phase.

NOTE : The core submission of this assignment is **Semantic.java** and **Cyclecheck.java**, where the latter is a separate class, used for cycle detection in the directed inheritance graph and printing it as well.

**DESIGN AND IMPLEMENTATION :**

The whole working of the analyzer can be summarized as follows :
Building an inheritance graph, which is a directed graph, with edges directed from a parent class to its child class, checking for cycles, report if any cycles exist, print them all, and then halt compilation, as done by the COOL compiler.
After this, insertion of classes mapped with their respective internal sturcture involving method and attr list, required for further semantic checks, in a well-organized HashMap, mapping from a class to a C-style struct involving a class's parent, method/attr-list and filename.
Finally, while analysing a class's attrs/methods, each kind of expression is encountered, such as dispatch, assignment, arithmetic operation, new operation, etc. and is analysed, processed, and the type is attached to each expression's node in the abstract syntax tree.

The core of this Semantic Analyzer is Semantic.java, which performs all the possible kinds of semantic checks according to COOL's semantics. This check is further performed in several phases.

**FIRST PASS :**

The FIRST phase includes building an inheritance graph, which is nothing but a directed graph, where the edges are incident/directed from the parent to its child class. A class is said to be a parent of its child class if the child class inherits from its parent. Each class's parent class is known from the parser phase, which can be obtained from AST.java's **AST.class\_**.

This graph is then checked for cycles using DFS, and all the classes which are involved in the cycle are reported on STDOUT.

Examples of such cases are :

    [class A inherits B; class B inherits A;]                     --Here A and B form an inheritance cycle.

        [class A inherits B; class B inherits A; class C inherits A;] --Here, again A and B form an inheritance cycle, but since --class C's ancestor/parent (class A) is involved in the cycle, the analyzer will also report in error on STDOUT, class C as --part of this cycle.

            [class A inherits A;]                                         --A self directed edge is not possible, i.e., a cycle
                                                                              --can't inherit from itself.

                                                                              **SECOND PASS :**

                                                                              The SECOND phase involves traversing all classes using AST.java's **program.classes** list, which is basically an **ArrayList<AST.class\_>**. This list is traversed and since a class has important information associated with it in the form of its internal sturcture, like its parent class (the class it is inheriting from), its feature/method list, its attribute list, its filename, etc., and since
                                                                              these "structues" need to analysed for semantic checks as well, we need to have a well-defined blueprint, which is nothing but a HashMap, mapping a class to its internal-structure as a whole, incorporated in a C-style struct of class's name, its parent's name, its filename, its method-list and its attr-list. There are also some special classes which are not present in AST.java's **AST.program.classes**, and
                                                                              need to be stored manually in this HashMap. These classes are Object, IO, Bool, String and Int, where Object is the default parent of each class, including these special classes as well, with "null" as itself's parent. The method list is usually empty, with the exception of Object, IO and String classes.

                                                                              Semantic checks in there structures (an individual class's internal-structure) are important, for example, when a class inherits from another class, it may overload the parent's method in its method definition, which is a dangerous business, and hence requires thorough analysis, or the child class may have an attr already defined in the parent class, which is also wrong.

                                                                              A class's method's definition and its dispatch, i.e., when the function is called, also needs to be in "semantic-sync". We can't just define the function with 4 formal parameters, and call it with 2, 3 or 5 parameters. Also, while defining a method, we can't have more than one variable used as a formal parameter, or a variable re-introduced in the same scope. Hence, making inheritance graph and checking for
                                                                              cycles and all is just the beginning. Once the classes and its internal structure are well stored, the crucial part of the Semantic Analysis begins. All the above and "more" sanity checks are done, according to COOL's semantics in the next phase.

                                                                              Also, while we insert each class in the HashMap, we make sure it inherits all the methods and attrs of its parent class. This is done by adding all the attrs and methods of the parent class in the child class's method and attr list.

                                                                              **THIRD PASS :**

                                                                              In the third pass, we check for multiple definitions of a class's method/attr, and report error if so. We do this by maintaining a HashMap for method's/attr's name, and check if the encountered method/attr is already present, if so, we report error. Note that methods/attrs with multiple definitions are also inserted (only once) in the HashMap. Hence, we will have only one instance of each method/attr
                                                                              in the maintained HashMap. While inheritance, there may be complications in method/attr overriding/ overloading. Example of such an error can be incorrect number of formal parameters in the method of current class, different return type or a mismatch between type of any formal parameter with that of the same method, defined, in the parent class, which the child class is trying to
                                                                              override/overload. Also, while inheritance, redefined attrs/methods in the current class are not stored, only the ones which are inherited from the parent class are given preference and hence stored in the HashMap.

                                                                              In let expression, we perform conformance checks for each let Object's encountered type, and it's declared type, and report error is there is a conformation issue. This conformation check is performed multiple times in this phase. In the scopes which are further enclosed, the object-type is set to the declared type which is different from the inferred type, obtained from the expression, and both need to
                                                                              conform, if not, error is reported.

                                                                              Same is done for case-branches' objects in each case branch, where the branch type needs to conform with its declared type. In case of erroneous types for an expression, we simply assign "Object" as its type and return. Also, checks for multiple case branches are done, by maintaining a HashMap, and errors are reported if same types are encountered. And further, if the branch type is not defined, then
                                                                              we don't process/infer the expression type of the branch's value and hence no conformance check, as is done by the COOL Compiler.

                                                                              The processing which is common for each expression is type-checking, as well as checking the current scope, and ensuring whether same variable is not redeclared in the scope, using the ScopeTable implementation. Errors reported in these checks are : Invalid comparison between basic types, arithmetic operation not supported between an Int and Bool/String, or assignment to variable of different/incompatible
                                                                              declared type, like [a : Int <- "string"], which will report an error.

                                                                              All the error reporting is done by the pre-defined reportError() method, which prints the line number, associated attr/method and the corresponding error message.

                                                                              **Test-Cases :**

                                                                              **Incorrect programs :**

                                                                              bad1.cl -   Illegal assignment case, inappropriate arguments to out\_string() method.  
                                                                              bad2.cl -   Use of undeclared id, illegal arguments to arithmetic operators, inappropriate argument passed to method.  
                                                                              bad3.cl -   case-branch errors, undefined types in case-branch predicate.  
                                                                              bad4.cl -   Cyclic inheritance error, multiple definition of method and attr, dispatch to undefined method and incorrect overriding of methods.

                                                                              **Correct programs :**

                                                                              atoi.cl  
                                                                              hairyscary.cl  
                                                                              mergesort.cl  
                                                                              sort-list.cl  
                                                                              tail\_recursion.cl

                                                                              All the above semantically correct programs will have the analyzer print their corresponding type-annotated/attached ASTs on STDOUT.

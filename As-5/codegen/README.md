CS3420: Compilers
=================

CODE GENERATOR FOR COOL LANGUAGE
--------------------------------

We made a separate class that stores information for a class, like its parent class name, its name, list of attributes,
list of methods, list of formal arguments, Intermediate Representation name for the names of methods and offset of methods
as well as attributes in the given class.

We then store a hashmap for a String, and the corresponding class declared above, and keep inserting a class_list, along, with
printing its LLVM IR-code.

We also added predefined code for inbuilt methods in the base classes like "abort()", "copy()" for "Object class", "out_string",
"in_string" for the "String" class, etc. A generic code is added for a baseClass, like : {i32, i8*, baseClass}, where "i8*" stores
pointer to the virtual table and "i32" stores the class associated integer, which is a number we assign to a class when we make
the dependance graph, just like in Semantic Analyzer code.

Since in Cool is an expression language and every thing is implemented in classes, we add a main function which calls the main function of class Main . This is done so that LLVM sees the execution to be similar to C++ while we make sure that COOL's execution starts from main function of Main class.

The printClass() and printmethods() function prints the strings, and other base classes's and class definitions at the top of the generated IR.

We also print the virtual table to the .ll file generated in this assignment. Virtual tables are important, because suppose
there are three classes, class A, class B and class C, where class B inherits class A, and in class C, we have a method which
takes as argument the object of type class A and calls A's any one of methods, but an object of class B can also be taken, this ambigouty is resolved by the virtual table. The virtual table stores offsets for methods in a class, and whenever we invoke a
method of class A in class C, we make sure that the offset of the function pointer in the virtual table is the same for both the methods.

The first pass decides the object layout for each class, particularly the offset at which each attribute is stored in an object. Using this information, the second pass recursively walks each feature and generates stack machine code for each expression.

With this in mind, one possible organization for our generator is :

1. compute the inheritance graph,
2. assign tags to all classes in breadth-first order,
3. determine the layout of attributes, temporaries, and dispatch tables for each class 4. generate code for global data: constants, dispatch tables,
5. generate code for each feature.

We considered the following :

Code for Objects : Object layout, method pointers, attribute initialization, Maintaining activation records during dispatch
and Creating and using temorary variables.

# COOL Compiler #

Regarding Testcases :

The test-cases folder comprises of three normal cool files as input to the lexer, plus a "Null.cl" file, which contains the null character, in order to put it inside the zip, I renamed it as "Null.cl" (due to this token - "test-cases/\*.cl" in submit script), but in order to run this file, rename it as "Null.txt" and in order to test it, type ./lexer Null.txt on the terminal.

This assignment is a simple token lexer, which only identifies keywords, objectIDs, typeIDs, string constants,
integer constants, comment's format, null character in string, EOF in string cases, bool_constants, and other cases of keywords
like Class, If, then, etc.

This is not a syntactic/semantic error reporting tool. Its only a lexer/lexical analyzer using regexS defined in grammars.

In order to compile, run the Makefile using the "make" command in the root directory, then proceed to /src/grammar and run ./lexer "test<n>.cl".

The output is the list of names of tokens, followed by the corresponding token, and also errors in case of some mismatch.
Any unrecognized token is reported gracefully.

This grammar file is compiled using the ANTLR Compiler.

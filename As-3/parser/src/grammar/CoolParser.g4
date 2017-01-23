parser grammar CoolParser;

options {
	tokenVocab = CoolLexer;
}

@header{
	import cool.AST;
	import java.util.*;
}

@members{
	int lineNo;
	ArrayList<AST.expression> arraylist;
	ArrayList<AST.formal> formal_arraylist;
	ArrayList<AST.class_> class_arraylist;
	ArrayList<AST.feature> feature_arraylist;
	ArrayList<AST.branch> branch_arraylist;
	ArrayList<AST.attr> attr_arraylist;
	String filename, selfobject = "self", inheritobject = "Object";
	public void setFilename(String f){
		filename = f;
	}
}

//lineNo get by $TOKEN.getLine()
//all variables declared in @members section

// The expression inside the square brackets is namely : data-type, followed by the variable-name in the corresponding class in AST.java
program returns [AST.program value]	:
		cl = class_list EOF
		{
			$value = new AST.program($cl.value, $cl.value.get(0).lineNo);
		}
		;

class_list returns [ArrayList<AST.class_> value]
		//[[class;]]+
		@init{
			class_arraylist = new ArrayList<>();
			$value = class_arraylist;
		} :
		(class_name = class_definition {$value.add($class_name.value);} SEMICOLON)+;

class_definition returns [AST.class_ value] :
		//class TYPE { [[feature;]]* }
		CLASS	typeid = TYPEID LBRACE methodlist = feature RBRACE
		{
			lineNo = $CLASS.getLine();
			$value = new AST.class_(($typeid.getText()).toString(), filename, inheritobject, $methodlist.value, lineNo);
		}
		//class TYPE inherits TYPE {[[feature;]]*}
		|	CLASS	typeid = TYPEID INHERITS typeid1 = TYPEID LBRACE methodlist = feature RBRACE
		{
			lineNo = $CLASS.getLine();
			$value = new AST.class_(($typeid.getText()).toString(), filename, ($typeid1.getText()).toString(), $methodlist.value, lineNo);
		}
		;

feature returns [ArrayList<AST.feature> value]
		//	-> the feature list
		//(declaration_initialization | function_definition;)*
		@init{
			feature_arraylist = new ArrayList<>();
			$value = feature_arraylist;
		}	:
		(feature_name = members {$value.add($feature_name.value);} SEMICOLON)*;

members returns [AST.feature value] :
		// -> the single feature
		//member can either be a variable initialization/declaration or a function definition
		//member -> either a method (function) or an attr (which further may be an argument or a class member variable)
		attribute = declaration_initialization
		{
			$value = $attribute.value;
		}
		| method = function_definition
		{
			$value = $method.value;
		}
		;

declaration_initialization returns [AST.attr value] :
		// -> an attribute
		//ID : TYPE
		objectid = OBJECTID COLON typeid = TYPEID
		{
			int null_expr_lineNo = $objectid.getLine();
			$value = new AST.attr(($objectid.getText()).toString(), ($typeid.getText()).toString(), new AST.no_expr(null_expr_lineNo), null_expr_lineNo);
		}
		//ID : TYPE [ <- expr]
		|	objectid = OBJECTID COLON typeid = TYPEID ASSIGN expr = expression
		{
			lineNo = $objectid.getLine();
			$value = new AST.attr(($objectid.getText()).toString(), ($typeid.getText()).toString(), $expr.value, lineNo);
		}
		;

function_definition returns [AST.method value] :
		// -> a method
		//ID (argument_list)? : TYPE { expr } (there can be 0 or more arguments inside the parentheses in function_definition)
		objectid = OBJECTID LPAREN RPAREN COLON typeid = TYPEID LBRACE expr = expression RBRACE
		{
			lineNo = $objectid.getLine();
			$value = new AST.method(($objectid.getText()).toString(), new ArrayList<AST.formal>(), ($typeid.getText()).toString(), $expr.value, lineNo);
		}
		|	objectid = OBJECTID LPAREN arg_list = argument_list RPAREN COLON typeid = TYPEID LBRACE expr = expression RBRACE
		{
			lineNo = $objectid.getLine();
			$value = new AST.method(($objectid.getText()).toString(), $arg_list.value, ($typeid.getText()).toString(), $expr.value, lineNo);
		}
		;

argument_list returns [ArrayList<AST.formal> value]
		//[formal [[, formal]]*] (multiple comma-separated arguments inside the parentheses in the function definition)
		@init{
			formal_arraylist = new ArrayList<>();
			$value = formal_arraylist;
		}	:
		formal_arg = formal {$value.add($formal_arg.value);} (COMMA formal_arg = formal {$value.add($formal_arg.value);})*;

formal returns [AST.formal value] :
		//ID : TYPE	(single argument)
		objectid = OBJECTID COLON typeid = TYPEID
		{
			lineNo = $objectid.getLine();
			$value = new AST.formal(($objectid.getText()).toString(), ($typeid.getText()).toString(), lineNo);
		}
		;

multiple_expressions returns [ArrayList<AST.expression> value]
		//[expr [[, expr]]∗]	(comma-separated expressions)
		//list of expressions
		@init{
			arraylist = new ArrayList<>();
			$value = arraylist;
		}	:
		(expr = expression {$value.add($expr.value);} (COMMA expr = expression {$value.add($expr.value);})*)?;

brace_expressions returns [ArrayList<AST.expression> value]

		//We wrote a separate rule for a 'block' having expression-lists, since we needed to
		//declare a separate list for storing all the expressions, which was not possible
		//in the common expression rule, since the datatype of 'value' is different in both rules.

		// { [[expr;]]+ }

		//list to capture list of expressions inside curly braces
		@init{
			arraylist = new ArrayList<>();
			$value = arraylist;
		}	:
		(expr = expression {$value.add($expr.value);} SEMICOLON)+;

single_branch returns [AST.branch value] :
		//[[ID : TYPE => expr;]]
		objectid = OBJECTID COLON typeid = TYPEID DARROW expr = expression SEMICOLON
		{
			lineNo = $objectid.getLine();
			$value = new AST.branch(($objectid.getText()).toString(), ($typeid.getText()).toString(), $expr.value, lineNo);
		}
		;

case_expressions returns [ArrayList<AST.branch> value]
		//[[ID : TYPE => expr;]]+
		//list to capture all individual case branch expressions
		@init{
			branch_arraylist = new ArrayList<>();
			$value = branch_arraylist;
		}	:
		(get_single_branch = single_branch {$value.add($get_single_branch.value);})+;

let_exp returns [AST.attr value] :
		// -> similar to an attribute
		//ID : TYPE
		objectid = OBJECTID COLON typeid = TYPEID
		{
			int null_expr_lineNo = $objectid.getLine();
			$value = new AST.attr(($objectid.getText()).toString(), ($typeid.getText()).toString(), new AST.no_expr(null_expr_lineNo), null_expr_lineNo);
		}
		//ID : TYPE [ <- expr]
		|	objectid = OBJECTID COLON typeid = TYPEID ASSIGN expr = expression
		{
			lineNo = $objectid.getLine();
			$value = new AST.attr(($objectid.getText()).toString(), ($typeid.getText()).toString(), $expr.value, lineNo);
		}
		;

let_expressions returns [ArrayList<AST.attr> value]
		//ID : TYPE [ <- expr] [[, ID : [ <- expr]]]*
		//list to capture all let expressions in the form of attributes
		@init{
			attr_arraylist = new ArrayList<>();
			$value = attr_arraylist;
		}	:
		let_expr = let_exp {$value.add($let_expr.value);}	(COMMA let_expr_i = let_exp {$value.add($let_expr_i.value);})*;

expression returns [AST.expression value] :

		//Note that here 'expression' is not an ANTLR token, hence $TOKEN.getLine() can't be used,
		//but 'expression' itself is already processed and returned in the 'expr' variable, hence
		//AST.java can supply its member variable 'lineNo' initialized with line number to the expression object,
		//its member variable can provide the lineNo. (This member variable was itself initialized
		//by some TOKEN itself somewhere before reaching to this grammar rule.)

		//expr [[@ TYPE]] . ID ([expr [[, expr]]*])
		expr = expression ATSYM typeid = TYPEID DOT objectid = OBJECTID LPAREN multiple_expr = multiple_expressions RPAREN
		{
			lineNo = $expr.value.lineNo;
			$value = new AST.static_dispatch($expr.value, ($typeid.getText()).toString(), ($objectid.getText()).toString(), $multiple_expr.value, lineNo);
		}
		//expr . ID ([expr [[, expr]]*])
		|	expr = expression DOT objectid = OBJECTID LPAREN multiple_expr = multiple_expressions RPAREN
		{
			//value is the variable returned by expression rule
			lineNo = $expr.value.lineNo;
			$value = new AST.dispatch($expr.value, ($objectid.getText()).toString(), $multiple_expr.value, lineNo);
		}
		//ID ([expr [[, expr]]*])
		| objectid = OBJECTID LPAREN multiple_expr = multiple_expressions RPAREN
		{
			lineNo = $objectid.getLine();
			AST.expression self_object = new AST.object(selfobject, lineNo);
			$value = new AST.dispatch(self_object, ($objectid.getText()).toString(), $multiple_expr.value, lineNo);
		}
		//ID
		| objectid = OBJECTID
		{
			lineNo = $objectid.getLine();
			$value = new AST.object(($objectid.getText()).toString(), lineNo);
		}
		//int constant (Int)
		| integer = INT_CONST
		{
			int getValue = Integer.parseInt(($integer.getText()).toString()), lineNo = $integer.getLine();
			$value = new AST.int_const(getValue, lineNo);
		}
		//string constant (String)
		| string = STR_CONST
		{
			//convert to string
			String getValue = ($string.getText()).toString();
			lineNo = $string.getLine();
			$value = new AST.string_const(getValue, lineNo);
		}
		//bool constant (true or false)
		| boolean_const = BOOL_CONST
		{
			//the first character ('t' or 'f') of the captured boolean constant token as a string determines
			//whether it is true or false
			char[] array = ($boolean_const.getText()).toCharArray();
			boolean getValue = (array[0] == 't') ? true : false;
			lineNo = $boolean_const.getLine();
			$value = new AST.bool_const(getValue, lineNo);
		}
		//( expr )
		| LPAREN expr = expression RPAREN
		{
			$value = $expr.value;
		}
		//if expr then expr else expr fi
		| IF condition = expression THEN if_continue = expression ELSE else_continue = expression FI
		{
			lineNo = $IF.getLine();
			$value = new AST.cond($condition.value, $if_continue.value, $else_continue.value, lineNo);
		}
		//while expr loop expr pool
		| WHILE condition = expression LOOP body = expression POOL
		{
			lineNo = $WHILE.getLine();
			$value = new AST.loop($condition.value, $body.value, lineNo);
		}
		//{ [[expr;]]+ }
		| LBRACE multiple_brace_enclosed_expr = brace_expressions RBRACE
		{
			lineNo = $LBRACE.getLine();
			$value = new AST.block($multiple_brace_enclosed_expr.value, lineNo);
		}
		//let ID : TYPE [ <- expr] [[, ID : [ <- expr]]]* in expr
		| LET let_exprs = let_expressions IN expr = expression
		{
			lineNo = $LET.getLine();
			ArrayList<AST.attr> arrayList = new ArrayList<>();
			arrayList = $let_exprs.value;
			AST.expression let_body_initial = $expr.value;
			$value = let_body_initial;
			//iterate over the list in backward fashion, since if the expression is "let a : Int <- 3 in let b : Int <- 4 in {expr}",
			//then, the value of a should be visible in b, where b's body should be parsed first hence, therefore iterated in reverse fashion
			for(ListIterator<AST.attr> iterator = arrayList.listIterator(arrayList.size()); iterator.hasPrevious();){
	      final Object listElement = iterator.previous();
				AST.attr curr = (AST.attr) listElement;
				//the body (4th) argument keeps updating by storing the new expression returned by the AST.java's "let" function
				//getting name, type-id and value from attr extending expression object curr and passing them as arguments
	      $value = new AST.let(curr.name, curr.typeid, curr.value, $value, lineNo);
	    }
		}
		//case expr of [[ID : TYPE => expr;]]+ esac
		| CASE expr = expression OF case_expr = case_expressions ESAC
		{
			lineNo = $CASE.getLine();
			$value = new AST.typcase($expr.value, $case_expr.value, lineNo);
		}
		//new TYPE
		|	NEW typeid = TYPEID
		{
			lineNo = $NEW.getLine();
			$value = new AST.new_(($typeid.getText()).toString(), lineNo);
		}
		//~expr
		| TILDE expr = expression
		{
			lineNo = $TILDE.getLine();
			$value = new AST.comp($expr.value, lineNo);
		}
		//isvoid expr
		| ISVOID expr = expression
		{
			lineNo = $ISVOID.getLine();
			$value = new AST.isvoid($expr.value, lineNo);
		}
		//multiply operation (expr * expr)
		//We store the line number of expr1 since we need to store the line of first-most occuring token
		| expr1 = expression STAR expr2 = expression
		{
			lineNo = $expr1.value.lineNo;
			$value = new AST.mul($expr1.value, $expr2.value, lineNo);
		}
		//divide operation (expr / expr)
		| expr1 = expression SLASH expr2 = expression
		{
			lineNo = $expr1.value.lineNo;
			$value = new AST.divide($expr1.value, $expr2.value, lineNo);
		}
		//plus operation (expr + expr)
		| expr1 = expression PLUS expr2 = expression
		{
			lineNo = $expr1.value.lineNo;
			$value = new AST.plus($expr1.value, $expr2.value, lineNo);
		}
		//minus operation (expr - expr)
		| expr1 = expression MINUS expr2 = expression
		{
			lineNo = $expr1.value.lineNo;
			$value = new AST.sub($expr1.value, $expr2.value, lineNo);
		}
		//less than operation (expr < expr)
		| expr1 = expression LT expr2 = expression
		{
			lineNo = $expr1.value.lineNo;
			$value = new AST.lt($expr1.value, $expr2.value, lineNo);
		}
		//less than or equal to operation (expr <= expr)
		| expr1 = expression LE expr2 = expression
		{
			lineNo = $expr1.value.lineNo;
			$value = new AST.leq($expr1.value, $expr2.value, lineNo);
		}
		//expr = expr (in addition to string and integer equality, expr = expr)
		| expr1 = expression EQUALS expr2 = expression
		{
			lineNo = $expr1.value.lineNo;
			$value = new AST.eq($expr1.value, $expr2.value, lineNo);
		}
		//not expr
		| NOT expr = expression
		{
			lineNo = $NOT.getLine();
			$value = new AST.neg($expr.value, lineNo);
		}
		//ID <- expr
		//all binary operations are left-associative, with the exception of assignment, which is right-associative,
		//and the three comparison operations, which do not associate, hence add <assoc = right> before the assignment
		//rule, and no need to add <assoc = left> to other rules, since associativity is left by default, as is in the
		//other cases
		|	<assoc = right> objectid = OBJECTID ASSIGN expr = expression
		{
			lineNo = $objectid.getLine();
			$value = new AST.assign(($objectid.getText()).toString(), $expr.value, lineNo);
		}
		;

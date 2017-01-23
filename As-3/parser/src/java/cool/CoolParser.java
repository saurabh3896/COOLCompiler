// Generated from CoolParser.g4 by ANTLR 4.5
package cool;

	import cool.AST;
	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WS=43, THEEND=44, SINGLE_COMMENT=45, 
		COMMENT_CLOSE=46, CLOSED=47, COM_EOF=48, NEWLINE=49, ESC=50, ESC_NULL=51, 
		STR_EOF=52, ERR1=53, ERR2=54, ERR3=55, LQUOTE=56, NL=57, TAB=58, BACKSPAC=59, 
		LINEFEED=60, SLASHN=61, ESC_NL=62;
	public static final int
		RULE_program = 0, RULE_class_list = 1, RULE_class_definition = 2, RULE_feature = 3, 
		RULE_members = 4, RULE_declaration_initialization = 5, RULE_function_definition = 6, 
		RULE_argument_list = 7, RULE_formal = 8, RULE_multiple_expressions = 9, 
		RULE_brace_expressions = 10, RULE_single_branch = 11, RULE_case_expressions = 12, 
		RULE_let_exp = 13, RULE_let_expressions = 14, RULE_expression = 15;
	public static final String[] ruleNames = {
		"program", "class_list", "class_definition", "feature", "members", "declaration_initialization", 
		"function_definition", "argument_list", "formal", "multiple_expressions", 
		"brace_expressions", "single_branch", "case_expressions", "let_exp", "let_expressions", 
		"expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'*)'", null, null, null, null, null, null, null, null, null, 
		null, null, "'\\t'", "'\\b'", "'\\f'", "'\\n'", "'\\\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WS", "THEEND", "SINGLE_COMMENT", "COMMENT_CLOSE", "CLOSED", "COM_EOF", 
		"NEWLINE", "ESC", "ESC_NULL", "STR_EOF", "ERR1", "ERR2", "ERR3", "LQUOTE", 
		"NL", "TAB", "BACKSPAC", "LINEFEED", "SLASHN", "ESC_NL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CoolParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public AST.program value;
		public Class_listContext cl;
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public Class_listContext class_list() {
			return getRuleContext(Class_listContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((ProgramContext)_localctx).cl = class_list();
			setState(33);
			match(EOF);

						((ProgramContext)_localctx).value =  new AST.program(((ProgramContext)_localctx).cl.value, ((ProgramContext)_localctx).cl.value.get(0).lineNo);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_listContext extends ParserRuleContext {
		public ArrayList<AST.class_> value;
		public Class_definitionContext class_name;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<Class_definitionContext> class_definition() {
			return getRuleContexts(Class_definitionContext.class);
		}
		public Class_definitionContext class_definition(int i) {
			return getRuleContext(Class_definitionContext.class,i);
		}
		public Class_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_listContext class_list() throws RecognitionException {
		Class_listContext _localctx = new Class_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_list);

					class_arraylist = new ArrayList<>();
					((Class_listContext)_localctx).value =  class_arraylist;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				((Class_listContext)_localctx).class_name = class_definition();
				_localctx.value.add(((Class_listContext)_localctx).class_name.value);
				setState(38);
				match(SEMICOLON);
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_definitionContext extends ParserRuleContext {
		public AST.class_ value;
		public Token CLASS;
		public Token typeid;
		public FeatureContext methodlist;
		public Token typeid1;
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<TerminalNode> TYPEID() { return getTokens(CoolParser.TYPEID); }
		public TerminalNode TYPEID(int i) {
			return getToken(CoolParser.TYPEID, i);
		}
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public Class_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_definitionContext class_definition() throws RecognitionException {
		Class_definitionContext _localctx = new Class_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_definition);
		try {
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				((Class_definitionContext)_localctx).CLASS = match(CLASS);
				setState(45);
				((Class_definitionContext)_localctx).typeid = match(TYPEID);
				setState(46);
				match(LBRACE);
				setState(47);
				((Class_definitionContext)_localctx).methodlist = feature();
				setState(48);
				match(RBRACE);

							lineNo = ((Class_definitionContext)_localctx).CLASS.getLine();
							((Class_definitionContext)_localctx).value =  new AST.class_((((Class_definitionContext)_localctx).typeid.getText()).toString(), filename, inheritobject, ((Class_definitionContext)_localctx).methodlist.value, lineNo);
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				((Class_definitionContext)_localctx).CLASS = match(CLASS);
				setState(52);
				((Class_definitionContext)_localctx).typeid = match(TYPEID);
				setState(53);
				match(INHERITS);
				setState(54);
				((Class_definitionContext)_localctx).typeid1 = match(TYPEID);
				setState(55);
				match(LBRACE);
				setState(56);
				((Class_definitionContext)_localctx).methodlist = feature();
				setState(57);
				match(RBRACE);

							lineNo = ((Class_definitionContext)_localctx).CLASS.getLine();
							((Class_definitionContext)_localctx).value =  new AST.class_((((Class_definitionContext)_localctx).typeid.getText()).toString(), filename, (((Class_definitionContext)_localctx).typeid1.getText()).toString(), ((Class_definitionContext)_localctx).methodlist.value, lineNo);
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureContext extends ParserRuleContext {
		public ArrayList<AST.feature> value;
		public MembersContext feature_name;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<MembersContext> members() {
			return getRuleContexts(MembersContext.class);
		}
		public MembersContext members(int i) {
			return getRuleContext(MembersContext.class,i);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_feature);

					feature_arraylist = new ArrayList<>();
					((FeatureContext)_localctx).value =  feature_arraylist;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECTID) {
				{
				{
				setState(62);
				((FeatureContext)_localctx).feature_name = members();
				_localctx.value.add(((FeatureContext)_localctx).feature_name.value);
				setState(64);
				match(SEMICOLON);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MembersContext extends ParserRuleContext {
		public AST.feature value;
		public Declaration_initializationContext attribute;
		public Function_definitionContext method;
		public Declaration_initializationContext declaration_initialization() {
			return getRuleContext(Declaration_initializationContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public MembersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_members; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMembers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MembersContext members() throws RecognitionException {
		MembersContext _localctx = new MembersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_members);
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((MembersContext)_localctx).attribute = declaration_initialization();

							((MembersContext)_localctx).value =  ((MembersContext)_localctx).attribute.value;
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				((MembersContext)_localctx).method = function_definition();

							((MembersContext)_localctx).value =  ((MembersContext)_localctx).method.value;
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaration_initializationContext extends ParserRuleContext {
		public AST.attr value;
		public Token objectid;
		public Token typeid;
		public ExpressionContext expr;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Declaration_initializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_initialization; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitDeclaration_initialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_initializationContext declaration_initialization() throws RecognitionException {
		Declaration_initializationContext _localctx = new Declaration_initializationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration_initialization);
		try {
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				((Declaration_initializationContext)_localctx).objectid = match(OBJECTID);
				setState(80);
				match(COLON);
				setState(81);
				((Declaration_initializationContext)_localctx).typeid = match(TYPEID);

							int null_expr_lineNo = ((Declaration_initializationContext)_localctx).objectid.getLine();
							((Declaration_initializationContext)_localctx).value =  new AST.attr((((Declaration_initializationContext)_localctx).objectid.getText()).toString(), (((Declaration_initializationContext)_localctx).typeid.getText()).toString(), new AST.no_expr(null_expr_lineNo), null_expr_lineNo);
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				((Declaration_initializationContext)_localctx).objectid = match(OBJECTID);
				setState(84);
				match(COLON);
				setState(85);
				((Declaration_initializationContext)_localctx).typeid = match(TYPEID);
				setState(86);
				match(ASSIGN);
				setState(87);
				((Declaration_initializationContext)_localctx).expr = expression(0);

							lineNo = ((Declaration_initializationContext)_localctx).objectid.getLine();
							((Declaration_initializationContext)_localctx).value =  new AST.attr((((Declaration_initializationContext)_localctx).objectid.getText()).toString(), (((Declaration_initializationContext)_localctx).typeid.getText()).toString(), ((Declaration_initializationContext)_localctx).expr.value, lineNo);
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public AST.method value;
		public Token objectid;
		public Token typeid;
		public ExpressionContext expr;
		public Argument_listContext arg_list;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_definition);
		try {
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				((Function_definitionContext)_localctx).objectid = match(OBJECTID);
				setState(93);
				match(LPAREN);
				setState(94);
				match(RPAREN);
				setState(95);
				match(COLON);
				setState(96);
				((Function_definitionContext)_localctx).typeid = match(TYPEID);
				setState(97);
				match(LBRACE);
				setState(98);
				((Function_definitionContext)_localctx).expr = expression(0);
				setState(99);
				match(RBRACE);

							lineNo = ((Function_definitionContext)_localctx).objectid.getLine();
							((Function_definitionContext)_localctx).value =  new AST.method((((Function_definitionContext)_localctx).objectid.getText()).toString(), new ArrayList<AST.formal>(), (((Function_definitionContext)_localctx).typeid.getText()).toString(), ((Function_definitionContext)_localctx).expr.value, lineNo);
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((Function_definitionContext)_localctx).objectid = match(OBJECTID);
				setState(103);
				match(LPAREN);
				setState(104);
				((Function_definitionContext)_localctx).arg_list = argument_list();
				setState(105);
				match(RPAREN);
				setState(106);
				match(COLON);
				setState(107);
				((Function_definitionContext)_localctx).typeid = match(TYPEID);
				setState(108);
				match(LBRACE);
				setState(109);
				((Function_definitionContext)_localctx).expr = expression(0);
				setState(110);
				match(RBRACE);

							lineNo = ((Function_definitionContext)_localctx).objectid.getLine();
							((Function_definitionContext)_localctx).value =  new AST.method((((Function_definitionContext)_localctx).objectid.getText()).toString(), ((Function_definitionContext)_localctx).arg_list.value, (((Function_definitionContext)_localctx).typeid.getText()).toString(), ((Function_definitionContext)_localctx).expr.value, lineNo);
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Argument_listContext extends ParserRuleContext {
		public ArrayList<AST.formal> value;
		public FormalContext formal_arg;
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitArgument_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argument_list);

					formal_arraylist = new ArrayList<>();
					((Argument_listContext)_localctx).value =  formal_arraylist;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			((Argument_listContext)_localctx).formal_arg = formal();
			_localctx.value.add(((Argument_listContext)_localctx).formal_arg.value);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(117);
				match(COMMA);
				setState(118);
				((Argument_listContext)_localctx).formal_arg = formal();
				_localctx.value.add(((Argument_listContext)_localctx).formal_arg.value);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalContext extends ParserRuleContext {
		public AST.formal value;
		public Token objectid;
		public Token typeid;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((FormalContext)_localctx).objectid = match(OBJECTID);
			setState(127);
			match(COLON);
			setState(128);
			((FormalContext)_localctx).typeid = match(TYPEID);

						lineNo = ((FormalContext)_localctx).objectid.getLine();
						((FormalContext)_localctx).value =  new AST.formal((((FormalContext)_localctx).objectid.getText()).toString(), (((FormalContext)_localctx).typeid.getText()).toString(), lineNo);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiple_expressionsContext extends ParserRuleContext {
		public ArrayList<AST.expression> value;
		public ExpressionContext expr;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Multiple_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMultiple_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_expressionsContext multiple_expressions() throws RecognitionException {
		Multiple_expressionsContext _localctx = new Multiple_expressionsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_multiple_expressions);

					arraylist = new ArrayList<>();
					((Multiple_expressionsContext)_localctx).value =  arraylist;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0)) {
				{
				setState(131);
				((Multiple_expressionsContext)_localctx).expr = expression(0);
				_localctx.value.add(((Multiple_expressionsContext)_localctx).expr.value);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(133);
					match(COMMA);
					setState(134);
					((Multiple_expressionsContext)_localctx).expr = expression(0);
					_localctx.value.add(((Multiple_expressionsContext)_localctx).expr.value);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Brace_expressionsContext extends ParserRuleContext {
		public ArrayList<AST.expression> value;
		public ExpressionContext expr;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Brace_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brace_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBrace_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Brace_expressionsContext brace_expressions() throws RecognitionException {
		Brace_expressionsContext _localctx = new Brace_expressionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_brace_expressions);

					arraylist = new ArrayList<>();
					((Brace_expressionsContext)_localctx).value =  arraylist;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				((Brace_expressionsContext)_localctx).expr = expression(0);
				_localctx.value.add(((Brace_expressionsContext)_localctx).expr.value);
				setState(146);
				match(SEMICOLON);
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Single_branchContext extends ParserRuleContext {
		public AST.branch value;
		public Token objectid;
		public Token typeid;
		public ExpressionContext expr;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode DARROW() { return getToken(CoolParser.DARROW, 0); }
		public TerminalNode SEMICOLON() { return getToken(CoolParser.SEMICOLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Single_branchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_branch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitSingle_branch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_branchContext single_branch() throws RecognitionException {
		Single_branchContext _localctx = new Single_branchContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_single_branch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((Single_branchContext)_localctx).objectid = match(OBJECTID);
			setState(153);
			match(COLON);
			setState(154);
			((Single_branchContext)_localctx).typeid = match(TYPEID);
			setState(155);
			match(DARROW);
			setState(156);
			((Single_branchContext)_localctx).expr = expression(0);
			setState(157);
			match(SEMICOLON);

						lineNo = ((Single_branchContext)_localctx).objectid.getLine();
						((Single_branchContext)_localctx).value =  new AST.branch((((Single_branchContext)_localctx).objectid.getText()).toString(), (((Single_branchContext)_localctx).typeid.getText()).toString(), ((Single_branchContext)_localctx).expr.value, lineNo);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_expressionsContext extends ParserRuleContext {
		public ArrayList<AST.branch> value;
		public Single_branchContext get_single_branch;
		public List<Single_branchContext> single_branch() {
			return getRuleContexts(Single_branchContext.class);
		}
		public Single_branchContext single_branch(int i) {
			return getRuleContext(Single_branchContext.class,i);
		}
		public Case_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCase_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_expressionsContext case_expressions() throws RecognitionException {
		Case_expressionsContext _localctx = new Case_expressionsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_case_expressions);

					branch_arraylist = new ArrayList<>();
					((Case_expressionsContext)_localctx).value =  branch_arraylist;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				((Case_expressionsContext)_localctx).get_single_branch = single_branch();
				_localctx.value.add(((Case_expressionsContext)_localctx).get_single_branch.value);
				}
				}
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OBJECTID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Let_expContext extends ParserRuleContext {
		public AST.attr value;
		public Token objectid;
		public Token typeid;
		public ExpressionContext expr;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Let_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet_exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_expContext let_exp() throws RecognitionException {
		Let_expContext _localctx = new Let_expContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_let_exp);
		try {
			setState(178);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((Let_expContext)_localctx).objectid = match(OBJECTID);
				setState(168);
				match(COLON);
				setState(169);
				((Let_expContext)_localctx).typeid = match(TYPEID);

							int null_expr_lineNo = ((Let_expContext)_localctx).objectid.getLine();
							((Let_expContext)_localctx).value =  new AST.attr((((Let_expContext)_localctx).objectid.getText()).toString(), (((Let_expContext)_localctx).typeid.getText()).toString(), new AST.no_expr(null_expr_lineNo), null_expr_lineNo);
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				((Let_expContext)_localctx).objectid = match(OBJECTID);
				setState(172);
				match(COLON);
				setState(173);
				((Let_expContext)_localctx).typeid = match(TYPEID);
				setState(174);
				match(ASSIGN);
				setState(175);
				((Let_expContext)_localctx).expr = expression(0);

							lineNo = ((Let_expContext)_localctx).objectid.getLine();
							((Let_expContext)_localctx).value =  new AST.attr((((Let_expContext)_localctx).objectid.getText()).toString(), (((Let_expContext)_localctx).typeid.getText()).toString(), ((Let_expContext)_localctx).expr.value, lineNo);
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Let_expressionsContext extends ParserRuleContext {
		public ArrayList<AST.attr> value;
		public Let_expContext let_expr;
		public Let_expContext let_expr_i;
		public List<Let_expContext> let_exp() {
			return getRuleContexts(Let_expContext.class);
		}
		public Let_expContext let_exp(int i) {
			return getRuleContext(Let_expContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Let_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_expressionsContext let_expressions() throws RecognitionException {
		Let_expressionsContext _localctx = new Let_expressionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_let_expressions);

					attr_arraylist = new ArrayList<>();
					((Let_expressionsContext)_localctx).value =  attr_arraylist;
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((Let_expressionsContext)_localctx).let_expr = let_exp();
			_localctx.value.add(((Let_expressionsContext)_localctx).let_expr.value);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(182);
				match(COMMA);
				setState(183);
				((Let_expressionsContext)_localctx).let_expr_i = let_exp();
				_localctx.value.add(((Let_expressionsContext)_localctx).let_expr_i.value);
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AST.expression value;
		public ExpressionContext expr;
		public ExpressionContext expr1;
		public Token LET;
		public Let_expressionsContext let_exprs;
		public Token TILDE;
		public Token ISVOID;
		public Token NOT;
		public Token objectid;
		public Multiple_expressionsContext multiple_expr;
		public Token integer;
		public Token string;
		public Token boolean_const;
		public Token IF;
		public ExpressionContext condition;
		public ExpressionContext if_continue;
		public ExpressionContext else_continue;
		public Token WHILE;
		public ExpressionContext body;
		public Token LBRACE;
		public Brace_expressionsContext multiple_brace_enclosed_expr;
		public Token CASE;
		public Case_expressionsContext case_expr;
		public Token NEW;
		public Token typeid;
		public ExpressionContext expr2;
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public Let_expressionsContext let_expressions() {
			return getRuleContext(Let_expressionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TILDE() { return getToken(CoolParser.TILDE, 0); }
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public Multiple_expressionsContext multiple_expressions() {
			return getRuleContext(Multiple_expressionsContext.class,0);
		}
		public TerminalNode INT_CONST() { return getToken(CoolParser.INT_CONST, 0); }
		public TerminalNode STR_CONST() { return getToken(CoolParser.STR_CONST, 0); }
		public TerminalNode BOOL_CONST() { return getToken(CoolParser.BOOL_CONST, 0); }
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public Brace_expressionsContext brace_expressions() {
			return getRuleContext(Brace_expressionsContext.class,0);
		}
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public Case_expressionsContext case_expressions() {
			return getRuleContext(Case_expressionsContext.class,0);
		}
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public TerminalNode STAR() { return getToken(CoolParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(CoolParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public TerminalNode LE() { return getToken(CoolParser.LE, 0); }
		public TerminalNode EQUALS() { return getToken(CoolParser.EQUALS, 0); }
		public TerminalNode ATSYM() { return getToken(CoolParser.ATSYM, 0); }
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(192);
				((ExpressionContext)_localctx).LET = match(LET);
				setState(193);
				((ExpressionContext)_localctx).let_exprs = let_expressions();
				setState(194);
				match(IN);
				setState(195);
				((ExpressionContext)_localctx).expr = expression(14);

							lineNo = ((ExpressionContext)_localctx).LET.getLine();
							ArrayList<AST.attr> arrayList = new ArrayList<>();
							arrayList = ((ExpressionContext)_localctx).let_exprs.value;
							AST.expression let_body_initial = ((ExpressionContext)_localctx).expr.value;
							((ExpressionContext)_localctx).value =  let_body_initial;
							//iterate over the list in backward fashion, since if the expression is "let a : Int <- 3 in let b : Int <- 4 in {expr}",
							//then, the value of a should be visible in b, where b's body should be parsed first hence, therefore iterated in reverse fashion
							for(ListIterator<AST.attr> iterator = arrayList.listIterator(arrayList.size()); iterator.hasPrevious();){
					      final Object listElement = iterator.previous();
								AST.attr curr = (AST.attr) listElement;
								//the body (4th) argument keeps updating by storing the new expression returned by the AST.java's "let" function
								//getting name, type-id and value from attr extending expression object curr and passing them as arguments
					      ((ExpressionContext)_localctx).value =  new AST.let(curr.name, curr.typeid, curr.value, _localctx.value, lineNo);
					    }
						
				}
				break;
			case 2:
				{
				setState(198);
				((ExpressionContext)_localctx).TILDE = match(TILDE);
				setState(199);
				((ExpressionContext)_localctx).expr = expression(11);

							lineNo = ((ExpressionContext)_localctx).TILDE.getLine();
							((ExpressionContext)_localctx).value =  new AST.comp(((ExpressionContext)_localctx).expr.value, lineNo);
						
				}
				break;
			case 3:
				{
				setState(202);
				((ExpressionContext)_localctx).ISVOID = match(ISVOID);
				setState(203);
				((ExpressionContext)_localctx).expr = expression(10);

							lineNo = ((ExpressionContext)_localctx).ISVOID.getLine();
							((ExpressionContext)_localctx).value =  new AST.isvoid(((ExpressionContext)_localctx).expr.value, lineNo);
						
				}
				break;
			case 4:
				{
				setState(206);
				((ExpressionContext)_localctx).NOT = match(NOT);
				setState(207);
				((ExpressionContext)_localctx).expr = expression(2);

							lineNo = ((ExpressionContext)_localctx).NOT.getLine();
							((ExpressionContext)_localctx).value =  new AST.neg(((ExpressionContext)_localctx).expr.value, lineNo);
						
				}
				break;
			case 5:
				{
				setState(210);
				((ExpressionContext)_localctx).objectid = match(OBJECTID);
				setState(211);
				match(ASSIGN);
				setState(212);
				((ExpressionContext)_localctx).expr = expression(1);

							lineNo = ((ExpressionContext)_localctx).objectid.getLine();
							((ExpressionContext)_localctx).value =  new AST.assign((((ExpressionContext)_localctx).objectid.getText()).toString(), ((ExpressionContext)_localctx).expr.value, lineNo);
						
				}
				break;
			case 6:
				{
				setState(215);
				((ExpressionContext)_localctx).objectid = match(OBJECTID);
				setState(216);
				match(LPAREN);
				setState(217);
				((ExpressionContext)_localctx).multiple_expr = multiple_expressions();
				setState(218);
				match(RPAREN);

							lineNo = ((ExpressionContext)_localctx).objectid.getLine();
							AST.expression self_object = new AST.object(selfobject, lineNo);
							((ExpressionContext)_localctx).value =  new AST.dispatch(self_object, (((ExpressionContext)_localctx).objectid.getText()).toString(), ((ExpressionContext)_localctx).multiple_expr.value, lineNo);
						
				}
				break;
			case 7:
				{
				setState(221);
				((ExpressionContext)_localctx).objectid = match(OBJECTID);

							lineNo = ((ExpressionContext)_localctx).objectid.getLine();
							((ExpressionContext)_localctx).value =  new AST.object((((ExpressionContext)_localctx).objectid.getText()).toString(), lineNo);
						
				}
				break;
			case 8:
				{
				setState(223);
				((ExpressionContext)_localctx).integer = match(INT_CONST);

							int getValue = Integer.parseInt((((ExpressionContext)_localctx).integer.getText()).toString()), lineNo = ((ExpressionContext)_localctx).integer.getLine();
							((ExpressionContext)_localctx).value =  new AST.int_const(getValue, lineNo);
						
				}
				break;
			case 9:
				{
				setState(225);
				((ExpressionContext)_localctx).string = match(STR_CONST);

							//convert to string
							String getValue = (((ExpressionContext)_localctx).string.getText()).toString();
							lineNo = ((ExpressionContext)_localctx).string.getLine();
							((ExpressionContext)_localctx).value =  new AST.string_const(getValue, lineNo);
						
				}
				break;
			case 10:
				{
				setState(227);
				((ExpressionContext)_localctx).boolean_const = match(BOOL_CONST);

							//the first character ('t' or 'f') of the captured boolean constant token as a string determines
							//whether it is true or false
							char[] array = (((ExpressionContext)_localctx).boolean_const.getText()).toCharArray();
							boolean getValue = (array[0] == 't') ? true : false;
							lineNo = ((ExpressionContext)_localctx).boolean_const.getLine();
							((ExpressionContext)_localctx).value =  new AST.bool_const(getValue, lineNo);
						
				}
				break;
			case 11:
				{
				setState(229);
				match(LPAREN);
				setState(230);
				((ExpressionContext)_localctx).expr = expression(0);
				setState(231);
				match(RPAREN);

							((ExpressionContext)_localctx).value =  ((ExpressionContext)_localctx).expr.value;
						
				}
				break;
			case 12:
				{
				setState(234);
				((ExpressionContext)_localctx).IF = match(IF);
				setState(235);
				((ExpressionContext)_localctx).condition = expression(0);
				setState(236);
				match(THEN);
				setState(237);
				((ExpressionContext)_localctx).if_continue = expression(0);
				setState(238);
				match(ELSE);
				setState(239);
				((ExpressionContext)_localctx).else_continue = expression(0);
				setState(240);
				match(FI);

							lineNo = ((ExpressionContext)_localctx).IF.getLine();
							((ExpressionContext)_localctx).value =  new AST.cond(((ExpressionContext)_localctx).condition.value, ((ExpressionContext)_localctx).if_continue.value, ((ExpressionContext)_localctx).else_continue.value, lineNo);
						
				}
				break;
			case 13:
				{
				setState(243);
				((ExpressionContext)_localctx).WHILE = match(WHILE);
				setState(244);
				((ExpressionContext)_localctx).condition = expression(0);
				setState(245);
				match(LOOP);
				setState(246);
				((ExpressionContext)_localctx).body = expression(0);
				setState(247);
				match(POOL);

							lineNo = ((ExpressionContext)_localctx).WHILE.getLine();
							((ExpressionContext)_localctx).value =  new AST.loop(((ExpressionContext)_localctx).condition.value, ((ExpressionContext)_localctx).body.value, lineNo);
						
				}
				break;
			case 14:
				{
				setState(250);
				((ExpressionContext)_localctx).LBRACE = match(LBRACE);
				setState(251);
				((ExpressionContext)_localctx).multiple_brace_enclosed_expr = brace_expressions();
				setState(252);
				match(RBRACE);

							lineNo = ((ExpressionContext)_localctx).LBRACE.getLine();
							((ExpressionContext)_localctx).value =  new AST.block(((ExpressionContext)_localctx).multiple_brace_enclosed_expr.value, lineNo);
						
				}
				break;
			case 15:
				{
				setState(255);
				((ExpressionContext)_localctx).CASE = match(CASE);
				setState(256);
				((ExpressionContext)_localctx).expr = expression(0);
				setState(257);
				match(OF);
				setState(258);
				((ExpressionContext)_localctx).case_expr = case_expressions();
				setState(259);
				match(ESAC);

							lineNo = ((ExpressionContext)_localctx).CASE.getLine();
							((ExpressionContext)_localctx).value =  new AST.typcase(((ExpressionContext)_localctx).expr.value, ((ExpressionContext)_localctx).case_expr.value, lineNo);
						
				}
				break;
			case 16:
				{
				setState(262);
				((ExpressionContext)_localctx).NEW = match(NEW);
				setState(263);
				((ExpressionContext)_localctx).typeid = match(TYPEID);

							lineNo = ((ExpressionContext)_localctx).NEW.getLine();
							((ExpressionContext)_localctx).value =  new AST.new_((((ExpressionContext)_localctx).typeid.getText()).toString(), lineNo);
						
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(320);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(268);
						match(STAR);
						setState(269);
						((ExpressionContext)_localctx).expr2 = expression(10);

						          			lineNo = ((ExpressionContext)_localctx).expr1.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.mul(((ExpressionContext)_localctx).expr1.value, ((ExpressionContext)_localctx).expr2.value, lineNo);
						          		
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(272);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(273);
						match(SLASH);
						setState(274);
						((ExpressionContext)_localctx).expr2 = expression(9);

						          			lineNo = ((ExpressionContext)_localctx).expr1.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.divide(((ExpressionContext)_localctx).expr1.value, ((ExpressionContext)_localctx).expr2.value, lineNo);
						          		
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(278);
						match(PLUS);
						setState(279);
						((ExpressionContext)_localctx).expr2 = expression(8);

						          			lineNo = ((ExpressionContext)_localctx).expr1.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.plus(((ExpressionContext)_localctx).expr1.value, ((ExpressionContext)_localctx).expr2.value, lineNo);
						          		
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(283);
						match(MINUS);
						setState(284);
						((ExpressionContext)_localctx).expr2 = expression(7);

						          			lineNo = ((ExpressionContext)_localctx).expr1.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.sub(((ExpressionContext)_localctx).expr1.value, ((ExpressionContext)_localctx).expr2.value, lineNo);
						          		
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(287);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(288);
						match(LT);
						setState(289);
						((ExpressionContext)_localctx).expr2 = expression(6);

						          			lineNo = ((ExpressionContext)_localctx).expr1.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.lt(((ExpressionContext)_localctx).expr1.value, ((ExpressionContext)_localctx).expr2.value, lineNo);
						          		
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(293);
						match(LE);
						setState(294);
						((ExpressionContext)_localctx).expr2 = expression(5);

						          			lineNo = ((ExpressionContext)_localctx).expr1.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.leq(((ExpressionContext)_localctx).expr1.value, ((ExpressionContext)_localctx).expr2.value, lineNo);
						          		
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(298);
						match(EQUALS);
						setState(299);
						((ExpressionContext)_localctx).expr2 = expression(4);

						          			lineNo = ((ExpressionContext)_localctx).expr1.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.eq(((ExpressionContext)_localctx).expr1.value, ((ExpressionContext)_localctx).expr2.value, lineNo);
						          		
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr = _prevctx;
						_localctx.expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(302);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(303);
						match(ATSYM);
						setState(304);
						((ExpressionContext)_localctx).typeid = match(TYPEID);
						setState(305);
						match(DOT);
						setState(306);
						((ExpressionContext)_localctx).objectid = match(OBJECTID);
						setState(307);
						match(LPAREN);
						setState(308);
						((ExpressionContext)_localctx).multiple_expr = multiple_expressions();
						setState(309);
						match(RPAREN);

						          			lineNo = ((ExpressionContext)_localctx).expr.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.static_dispatch(((ExpressionContext)_localctx).expr.value, (((ExpressionContext)_localctx).typeid.getText()).toString(), (((ExpressionContext)_localctx).objectid.getText()).toString(), ((ExpressionContext)_localctx).multiple_expr.value, lineNo);
						          		
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr = _prevctx;
						_localctx.expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(313);
						match(DOT);
						setState(314);
						((ExpressionContext)_localctx).objectid = match(OBJECTID);
						setState(315);
						match(LPAREN);
						setState(316);
						((ExpressionContext)_localctx).multiple_expr = multiple_expressions();
						setState(317);
						match(RPAREN);

						          			//value is the variable returned by expression rule
						          			lineNo = ((ExpressionContext)_localctx).expr.value.lineNo;
						          			((ExpressionContext)_localctx).value =  new AST.dispatch(((ExpressionContext)_localctx).expr.value, (((ExpressionContext)_localctx).objectid.getText()).toString(), ((ExpressionContext)_localctx).multiple_expr.value, lineNo);
						          		
						}
						break;
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 25);
		case 8:
			return precpred(_ctx, 24);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0148\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\6\3+\n\3\r\3\16\3,\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5\7\5E\n\5"+
		"\f\5\16\5H\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bt\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\7\t|\n\t\f\t\16\t\177\13\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u008c\n\13\f\13\16\13\u008f\13\13\5\13\u0091\n"+
		"\13\3\f\3\f\3\f\3\f\6\f\u0097\n\f\r\f\16\f\u0098\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\6\16\u00a6\n\16\r\16\16\16\u00a7\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b5\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00bd\n\20\f\20\16\20\u00c0\13\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u010c\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\7\21\u0143\n\21\f\21\16\21\u0146\13\21\3\21\2\3 \22\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \2\2\u015c\2\"\3\2\2\2\4*\3\2\2\2\6>\3"+
		"\2\2\2\bF\3\2\2\2\nO\3\2\2\2\f\\\3\2\2\2\16s\3\2\2\2\20u\3\2\2\2\22\u0080"+
		"\3\2\2\2\24\u0090\3\2\2\2\26\u0096\3\2\2\2\30\u009a\3\2\2\2\32\u00a5\3"+
		"\2\2\2\34\u00b4\3\2\2\2\36\u00b6\3\2\2\2 \u010b\3\2\2\2\"#\5\4\3\2#$\7"+
		"\2\2\3$%\b\2\1\2%\3\3\2\2\2&\'\5\6\4\2\'(\b\3\1\2()\7\r\2\2)+\3\2\2\2"+
		"*&\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2./\7\34\2\2/\60\7\4"+
		"\2\2\60\61\7\26\2\2\61\62\5\b\5\2\62\63\7\27\2\2\63\64\b\4\1\2\64?\3\2"+
		"\2\2\65\66\7\34\2\2\66\67\7\4\2\2\678\7!\2\289\7\4\2\29:\7\26\2\2:;\5"+
		"\b\5\2;<\7\27\2\2<=\b\4\1\2=?\3\2\2\2>.\3\2\2\2>\65\3\2\2\2?\7\3\2\2\2"+
		"@A\5\n\6\2AB\b\5\1\2BC\7\r\2\2CE\3\2\2\2D@\3\2\2\2EH\3\2\2\2FD\3\2\2\2"+
		"FG\3\2\2\2G\t\3\2\2\2HF\3\2\2\2IJ\5\f\7\2JK\b\6\1\2KP\3\2\2\2LM\5\16\b"+
		"\2MN\b\6\1\2NP\3\2\2\2OI\3\2\2\2OL\3\2\2\2P\13\3\2\2\2QR\7\5\2\2RS\7\13"+
		"\2\2ST\7\4\2\2T]\b\7\1\2UV\7\5\2\2VW\7\13\2\2WX\7\4\2\2XY\7\33\2\2YZ\5"+
		" \21\2Z[\b\7\1\2[]\3\2\2\2\\Q\3\2\2\2\\U\3\2\2\2]\r\3\2\2\2^_\7\5\2\2"+
		"_`\7\t\2\2`a\7\n\2\2ab\7\13\2\2bc\7\4\2\2cd\7\26\2\2de\5 \21\2ef\7\27"+
		"\2\2fg\b\b\1\2gt\3\2\2\2hi\7\5\2\2ij\7\t\2\2jk\5\20\t\2kl\7\n\2\2lm\7"+
		"\13\2\2mn\7\4\2\2no\7\26\2\2op\5 \21\2pq\7\27\2\2qr\b\b\1\2rt\3\2\2\2"+
		"s^\3\2\2\2sh\3\2\2\2t\17\3\2\2\2uv\5\22\n\2v}\b\t\1\2wx\7\16\2\2xy\5\22"+
		"\n\2yz\b\t\1\2z|\3\2\2\2{w\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\21"+
		"\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\5\2\2\u0081\u0082\7\13\2\2\u0082\u0083"+
		"\7\4\2\2\u0083\u0084\b\n\1\2\u0084\23\3\2\2\2\u0085\u0086\5 \21\2\u0086"+
		"\u008d\b\13\1\2\u0087\u0088\7\16\2\2\u0088\u0089\5 \21\2\u0089\u008a\b"+
		"\13\1\2\u008a\u008c\3\2\2\2\u008b\u0087\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0085\3\2\2\2\u0090\u0091\3\2\2\2\u0091\25\3\2\2\2\u0092\u0093"+
		"\5 \21\2\u0093\u0094\b\f\1\2\u0094\u0095\7\r\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0092\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\27\3\2\2\2\u009a\u009b\7\5\2\2\u009b\u009c\7\13\2\2\u009c\u009d"+
		"\7\4\2\2\u009d\u009e\7\31\2\2\u009e\u009f\5 \21\2\u009f\u00a0\7\r\2\2"+
		"\u00a0\u00a1\b\r\1\2\u00a1\31\3\2\2\2\u00a2\u00a3\5\30\r\2\u00a3\u00a4"+
		"\b\16\1\2\u00a4\u00a6\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\33\3\2\2\2\u00a9\u00aa"+
		"\7\5\2\2\u00aa\u00ab\7\13\2\2\u00ab\u00ac\7\4\2\2\u00ac\u00b5\b\17\1\2"+
		"\u00ad\u00ae\7\5\2\2\u00ae\u00af\7\13\2\2\u00af\u00b0\7\4\2\2\u00b0\u00b1"+
		"\7\33\2\2\u00b1\u00b2\5 \21\2\u00b2\u00b3\b\17\1\2\u00b3\u00b5\3\2\2\2"+
		"\u00b4\u00a9\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b5\35\3\2\2\2\u00b6\u00b7"+
		"\5\34\17\2\u00b7\u00be\b\20\1\2\u00b8\u00b9\7\16\2\2\u00b9\u00ba\5\34"+
		"\17\2\u00ba\u00bb\b\20\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\37\3\2\2"+
		"\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\b\21\1\2\u00c2\u00c3\7\"\2\2\u00c3"+
		"\u00c4\5\36\20\2\u00c4\u00c5\7 \2\2\u00c5\u00c6\5 \21\20\u00c6\u00c7\b"+
		"\21\1\2\u00c7\u010c\3\2\2\2\u00c8\u00c9\7\23\2\2\u00c9\u00ca\5 \21\r\u00ca"+
		"\u00cb\b\21\1\2\u00cb\u010c\3\2\2\2\u00cc\u00cd\7+\2\2\u00cd\u00ce\5 "+
		"\21\f\u00ce\u00cf\b\21\1\2\u00cf\u010c\3\2\2\2\u00d0\u00d1\7,\2\2\u00d1"+
		"\u00d2\5 \21\4\u00d2\u00d3\b\21\1\2\u00d3\u010c\3\2\2\2\u00d4\u00d5\7"+
		"\5\2\2\u00d5\u00d6\7\33\2\2\u00d6\u00d7\5 \21\3\u00d7\u00d8\b\21\1\2\u00d8"+
		"\u010c\3\2\2\2\u00d9\u00da\7\5\2\2\u00da\u00db\7\t\2\2\u00db\u00dc\5\24"+
		"\13\2\u00dc\u00dd\7\n\2\2\u00dd\u00de\b\21\1\2\u00de\u010c\3\2\2\2\u00df"+
		"\u00e0\7\5\2\2\u00e0\u010c\b\21\1\2\u00e1\u00e2\7\7\2\2\u00e2\u010c\b"+
		"\21\1\2\u00e3\u00e4\7\b\2\2\u00e4\u010c\b\21\1\2\u00e5\u00e6\7\6\2\2\u00e6"+
		"\u010c\b\21\1\2\u00e7\u00e8\7\t\2\2\u00e8\u00e9\5 \21\2\u00e9\u00ea\7"+
		"\n\2\2\u00ea\u00eb\b\21\1\2\u00eb\u010c\3\2\2\2\u00ec\u00ed\7\37\2\2\u00ed"+
		"\u00ee\5 \21\2\u00ee\u00ef\7%\2\2\u00ef\u00f0\5 \21\2\u00f0\u00f1\7\35"+
		"\2\2\u00f1\u00f2\5 \21\2\u00f2\u00f3\7\36\2\2\u00f3\u00f4\b\21\1\2\u00f4"+
		"\u010c\3\2\2\2\u00f5\u00f6\7&\2\2\u00f6\u00f7\5 \21\2\u00f7\u00f8\7#\2"+
		"\2\u00f8\u00f9\5 \21\2\u00f9\u00fa\7$\2\2\u00fa\u00fb\b\21\1\2\u00fb\u010c"+
		"\3\2\2\2\u00fc\u00fd\7\26\2\2\u00fd\u00fe\5\26\f\2\u00fe\u00ff\7\27\2"+
		"\2\u00ff\u0100\b\21\1\2\u0100\u010c\3\2\2\2\u0101\u0102\7\'\2\2\u0102"+
		"\u0103\5 \21\2\u0103\u0104\7)\2\2\u0104\u0105\5\32\16\2\u0105\u0106\7"+
		"(\2\2\u0106\u0107\b\21\1\2\u0107\u010c\3\2\2\2\u0108\u0109\7*\2\2\u0109"+
		"\u010a\7\4\2\2\u010a\u010c\b\21\1\2\u010b\u00c1\3\2\2\2\u010b\u00c8\3"+
		"\2\2\2\u010b\u00cc\3\2\2\2\u010b\u00d0\3\2\2\2\u010b\u00d4\3\2\2\2\u010b"+
		"\u00d9\3\2\2\2\u010b\u00df\3\2\2\2\u010b\u00e1\3\2\2\2\u010b\u00e3\3\2"+
		"\2\2\u010b\u00e5\3\2\2\2\u010b\u00e7\3\2\2\2\u010b\u00ec\3\2\2\2\u010b"+
		"\u00f5\3\2\2\2\u010b\u00fc\3\2\2\2\u010b\u0101\3\2\2\2\u010b\u0108\3\2"+
		"\2\2\u010c\u0144\3\2\2\2\u010d\u010e\f\13\2\2\u010e\u010f\7\21\2\2\u010f"+
		"\u0110\5 \21\f\u0110\u0111\b\21\1\2\u0111\u0143\3\2\2\2\u0112\u0113\f"+
		"\n\2\2\u0113\u0114\7\22\2\2\u0114\u0115\5 \21\13\u0115\u0116\b\21\1\2"+
		"\u0116\u0143\3\2\2\2\u0117\u0118\f\t\2\2\u0118\u0119\7\17\2\2\u0119\u011a"+
		"\5 \21\n\u011a\u011b\b\21\1\2\u011b\u0143\3\2\2\2\u011c\u011d\f\b\2\2"+
		"\u011d\u011e\7\20\2\2\u011e\u011f\5 \21\t\u011f\u0120\b\21\1\2\u0120\u0143"+
		"\3\2\2\2\u0121\u0122\f\7\2\2\u0122\u0123\7\24\2\2\u0123\u0124\5 \21\b"+
		"\u0124\u0125\b\21\1\2\u0125\u0143\3\2\2\2\u0126\u0127\f\6\2\2\u0127\u0128"+
		"\7\32\2\2\u0128\u0129\5 \21\7\u0129\u012a\b\21\1\2\u012a\u0143\3\2\2\2"+
		"\u012b\u012c\f\5\2\2\u012c\u012d\7\25\2\2\u012d\u012e\5 \21\6\u012e\u012f"+
		"\b\21\1\2\u012f\u0143\3\2\2\2\u0130\u0131\f\33\2\2\u0131\u0132\7\f\2\2"+
		"\u0132\u0133\7\4\2\2\u0133\u0134\7\30\2\2\u0134\u0135\7\5\2\2\u0135\u0136"+
		"\7\t\2\2\u0136\u0137\5\24\13\2\u0137\u0138\7\n\2\2\u0138\u0139\b\21\1"+
		"\2\u0139\u0143\3\2\2\2\u013a\u013b\f\32\2\2\u013b\u013c\7\30\2\2\u013c"+
		"\u013d\7\5\2\2\u013d\u013e\7\t\2\2\u013e\u013f\5\24\13\2\u013f\u0140\7"+
		"\n\2\2\u0140\u0141\b\21\1\2\u0141\u0143\3\2\2\2\u0142\u010d\3\2\2\2\u0142"+
		"\u0112\3\2\2\2\u0142\u0117\3\2\2\2\u0142\u011c\3\2\2\2\u0142\u0121\3\2"+
		"\2\2\u0142\u0126\3\2\2\2\u0142\u012b\3\2\2\2\u0142\u0130\3\2\2\2\u0142"+
		"\u013a\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145!\3\2\2\2\u0146\u0144\3\2\2\2\22,>FO\\s}\u008d\u0090\u0098\u00a7"+
		"\u00b4\u00be\u010b\u0142\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
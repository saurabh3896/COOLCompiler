// Generated from CoolLexer.g4 by ANTLR 4.5
package cool;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
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
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, ELSEIF=43, DIGIT=44, EOF_STR_CONST=45, 
		NULL_CONST=46, NULL_STR_CONST=47, ERROR_STR_CONST=48, WS=49, SINGLE_LINE_COMMENTS=50, 
		ERROR_COMMENT=51, ERROR_COMMENT1=52, ERROR_COMMENT2=53, START_COMMENT=54, 
		EOF_COMMENT=55, CHARS=56, START_COMMENT1=57, END_COMMENT=58;
	public static final int COMMENTS = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "COMMENTS"
	};

	public static final String[] ruleNames = {
		"SEMICOLON", "DARROW", "IF", "FI", "OF", "NEW", "NOT", "LET", "A", "C", 
		"D", "E", "F", "H", "I", "L", "N", "O", "P", "R", "S", "T", "U", "V", 
		"W", "CASE", "ESAC", "ELSE", "THEN", "LOOP", "POOL", "CLASS", "WHILE", 
		"ELSEIF", "ISVOID", "INHERITS", "BOOL_CONST", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "COLON", "ASSIGN", "DOT", "ATSYM", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "LE", "EQUALS", "INT_CONST", "DIGIT", 
		"TYPEID", "OBJECTID", "EOF_STR_CONST", "NULL_CONST", "NULL_STR_CONST", 
		"ERROR_STR_CONST", "STR_CONST", "WS", "ERROR", "SINGLE_LINE_COMMENTS", 
		"ERROR_COMMENT", "ERROR_COMMENT1", "ERROR_COMMENT2", "START_COMMENT", 
		"EOF_COMMENT", "CHARS", "START_COMMENT1", "END_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "ELSEIF", "DIGIT", "EOF_STR_CONST", "NULL_CONST", "NULL_STR_CONST", 
		"ERROR_STR_CONST", "WS", "SINGLE_LINE_COMMENTS", "ERROR_COMMENT", "ERROR_COMMENT1", 
		"ERROR_COMMENT2", "START_COMMENT", "EOF_COMMENT", "CHARS", "START_COMMENT1", 
		"END_COMMENT"
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


		/*
		Function to report errors. Use this function whenever your lexer encounters any erroneous input
		DO NOT EDIT THIS FUNCTION
		*/
		public void reportError(String errorString){									// Error reporting function
			setText(errorString);
			setType(ERROR);
		}

		public void reportTokenError(String errorString){							// function to report Un-recognized token error
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			setText(errorString + text);
			setType(ERROR);
		}

		public void processString(){																	// function to remove extra '\' from the processed string (in case of escaped chars)
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			if(text.length() > 1024){																		// reportError if length >= 1024
				reportError("String constant too long");
				return;
			}
			String text_ = "";
			int index;
			for(int i = 0;i < text.length();i++){
				if(text.charAt(i) == '\\'){
					++i;
					if(text.charAt(i) == 'n'){
						text_ += '\n';
					}
					else if(text.charAt(i) == 't'){
						text_ += '\t';
					}
					else if(text.charAt(i) == 'b'){
						text_ += '\b';
					}
					else if(text.charAt(i) == 'f'){
						text_ += '\f';
					}
					else if(text.charAt(i) == '0'){
						text_ += '0';
					}
					else if(text.charAt(i) == '\\'){
						text_ += '\\';
					}
					else{
						text_ += text.charAt(i);
					}
				}
				else if(text.charAt(i) == '\"'){
					text_ += "";
				}
				else{
					text_ += text.charAt(i);
				}
			}
			setText(text_);
		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 58:
			EOF_STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 59:
			NULL_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 60:
			NULL_STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 61:
			ERROR_STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 62:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 64:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 66:
			ERROR_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			ERROR_COMMENT1_action((RuleContext)_localctx, actionIndex);
			break;
		case 68:
			ERROR_COMMENT2_action((RuleContext)_localctx, actionIndex);
			break;
		case 70:
			EOF_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void EOF_STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			reportError(" : EOF in String constant");
			break;
		}
	}
	private void NULL_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			reportError(" : String contains NULL char");
			break;
		}
	}
	private void NULL_STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			reportError(" : String contains NULL char");
			break;
		}
	}
	private void ERROR_STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			reportError(" : Unterminated String constant");
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			processString();
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			reportTokenError("Un-recognized Token Found : ");
			break;
		}
	}
	private void ERROR_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			reportError(" : EOF in Comment");
			break;
		}
	}
	private void ERROR_COMMENT1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			reportError(" : Unmatched *)");
			break;
		}
	}
	private void ERROR_COMMENT2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			reportError(" : Unmatched *)");
			break;
		}
	}
	private void EOF_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			reportError("EOF in Comment");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u01f9\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#"+
		"\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\5&\u0121\n&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\66\3\66\3\66\3\67\3\67\38\68\u0148\n8\r8\168\u0149\39\39\3:\3:\7"+
		":\u0150\n:\f:\16:\u0153\13:\3;\3;\7;\u0157\n;\f;\16;\u015a\13;\3<\3<\7"+
		"<\u015e\n<\f<\16<\u0161\13<\3<\3<\3<\3=\7=\u0167\n=\f=\16=\u016a\13=\3"+
		"=\7=\u016d\n=\f=\16=\u0170\13=\3=\6=\u0173\n=\r=\16=\u0174\3=\3=\3=\7"+
		"=\u017a\n=\f=\16=\u017d\13=\3=\7=\u0180\n=\f=\16=\u0183\13=\3=\3=\3>\3"+
		">\3>\3>\7>\u018b\n>\f>\16>\u018e\13>\5>\u0190\n>\3>\6>\u0193\n>\r>\16"+
		">\u0194\3>\3>\3>\7>\u019a\n>\f>\16>\u019d\13>\3>\6>\u01a0\n>\r>\16>\u01a1"+
		"\3>\3>\3?\3?\3?\3?\7?\u01aa\n?\f?\16?\u01ad\13?\3?\3?\3?\3@\3@\3@\3@\7"+
		"@\u01b6\n@\f@\16@\u01b9\13@\3@\3@\3@\3A\6A\u01bf\nA\rA\16A\u01c0\3A\3"+
		"A\3B\3B\3B\3C\3C\3C\7C\u01cb\nC\fC\16C\u01ce\13C\3C\3C\3D\3D\3D\3D\3D"+
		"\3E\3E\3E\3E\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\3I"+
		"\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\2\2L\4\r\6\31\b\37\n\36\f)\16*\20"+
		",\22\"\24\2\26\2\30\2\32\2\34\2\36\2 \2\"\2$\2&\2(\2*\2,\2.\2\60\2\62"+
		"\2\64\2\66\'8(:\35<%>#@$B\34D&F-H+J!L\6N\tP\nR\26T\27V\13X\33Z\30\\\f"+
		"^\16`\17b\20d\21f\22h\23j\24l\32n\25p\7r.t\4v\5x/z\60|\61~\62\u0080\b"+
		"\u0082\63\u0084\3\u0086\64\u0088\65\u008a\66\u008c\67\u008e8\u00909\u0092"+
		":\u0094;\u0096<\4\2\3\37\4\2KKkk\4\2HHhh\4\2QQqq\4\2PPpp\4\2GGgg\4\2Y"+
		"Yyy\4\2VVvv\4\2NNnn\4\2CCcc\4\2EEee\4\2FFff\4\2JJjj\4\2RRrr\4\2TTtt\4"+
		"\2UUuu\4\2WWww\4\2XXxx\3\2\62;\3\2C\\\5\2\62;C\\c|\4\2aac|\6\2\62;C\\"+
		"aac|\5\2\f\f$$^^\3\2$$\3\2\2\2\7\2\2\2\f\f\17\17$$^^\7\2$$GHQQ^^pp\5\2"+
		"\13\f\17\17\"\"\4\2\f\f\17\17\u01fd\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2"+
		"\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\66"+
		"\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2"+
		"\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2"+
		"\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\"+
		"\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2"+
		"\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2"+
		"\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2"+
		"\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2\2\2\u008a"+
		"\3\2\2\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\3\u0090\3\2\2\2\3\u0092\3\2\2"+
		"\2\3\u0094\3\2\2\2\3\u0096\3\2\2\2\4\u0098\3\2\2\2\6\u009a\3\2\2\2\b\u009d"+
		"\3\2\2\2\n\u00a0\3\2\2\2\f\u00a3\3\2\2\2\16\u00a6\3\2\2\2\20\u00aa\3\2"+
		"\2\2\22\u00ae\3\2\2\2\24\u00b2\3\2\2\2\26\u00b4\3\2\2\2\30\u00b6\3\2\2"+
		"\2\32\u00b8\3\2\2\2\34\u00ba\3\2\2\2\36\u00bc\3\2\2\2 \u00be\3\2\2\2\""+
		"\u00c0\3\2\2\2$\u00c2\3\2\2\2&\u00c4\3\2\2\2(\u00c6\3\2\2\2*\u00c8\3\2"+
		"\2\2,\u00ca\3\2\2\2.\u00cc\3\2\2\2\60\u00ce\3\2\2\2\62\u00d0\3\2\2\2\64"+
		"\u00d2\3\2\2\2\66\u00d4\3\2\2\28\u00d9\3\2\2\2:\u00de\3\2\2\2<\u00e3\3"+
		"\2\2\2>\u00e8\3\2\2\2@\u00ed\3\2\2\2B\u00f2\3\2\2\2D\u00f8\3\2\2\2F\u00fe"+
		"\3\2\2\2H\u0105\3\2\2\2J\u010c\3\2\2\2L\u0120\3\2\2\2N\u0122\3\2\2\2P"+
		"\u0124\3\2\2\2R\u0126\3\2\2\2T\u0128\3\2\2\2V\u012a\3\2\2\2X\u012c\3\2"+
		"\2\2Z\u012f\3\2\2\2\\\u0131\3\2\2\2^\u0133\3\2\2\2`\u0135\3\2\2\2b\u0137"+
		"\3\2\2\2d\u0139\3\2\2\2f\u013b\3\2\2\2h\u013d\3\2\2\2j\u013f\3\2\2\2l"+
		"\u0141\3\2\2\2n\u0144\3\2\2\2p\u0147\3\2\2\2r\u014b\3\2\2\2t\u014d\3\2"+
		"\2\2v\u0154\3\2\2\2x\u015b\3\2\2\2z\u0168\3\2\2\2|\u0186\3\2\2\2~\u01a5"+
		"\3\2\2\2\u0080\u01b1\3\2\2\2\u0082\u01be\3\2\2\2\u0084\u01c4\3\2\2\2\u0086"+
		"\u01c7\3\2\2\2\u0088\u01d1\3\2\2\2\u008a\u01d6\3\2\2\2\u008c\u01da\3\2"+
		"\2\2\u008e\u01df\3\2\2\2\u0090\u01e5\3\2\2\2\u0092\u01e9\3\2\2\2\u0094"+
		"\u01ed\3\2\2\2\u0096\u01f3\3\2\2\2\u0098\u0099\7=\2\2\u0099\5\3\2\2\2"+
		"\u009a\u009b\7?\2\2\u009b\u009c\7@\2\2\u009c\7\3\2\2\2\u009d\u009e\t\2"+
		"\2\2\u009e\u009f\t\3\2\2\u009f\t\3\2\2\2\u00a0\u00a1\t\3\2\2\u00a1\u00a2"+
		"\t\2\2\2\u00a2\13\3\2\2\2\u00a3\u00a4\t\4\2\2\u00a4\u00a5\t\3\2\2\u00a5"+
		"\r\3\2\2\2\u00a6\u00a7\t\5\2\2\u00a7\u00a8\t\6\2\2\u00a8\u00a9\t\7\2\2"+
		"\u00a9\17\3\2\2\2\u00aa\u00ab\t\5\2\2\u00ab\u00ac\t\4\2\2\u00ac\u00ad"+
		"\t\b\2\2\u00ad\21\3\2\2\2\u00ae\u00af\t\t\2\2\u00af\u00b0\t\6\2\2\u00b0"+
		"\u00b1\t\b\2\2\u00b1\23\3\2\2\2\u00b2\u00b3\t\n\2\2\u00b3\25\3\2\2\2\u00b4"+
		"\u00b5\t\13\2\2\u00b5\27\3\2\2\2\u00b6\u00b7\t\f\2\2\u00b7\31\3\2\2\2"+
		"\u00b8\u00b9\t\6\2\2\u00b9\33\3\2\2\2\u00ba\u00bb\t\3\2\2\u00bb\35\3\2"+
		"\2\2\u00bc\u00bd\t\r\2\2\u00bd\37\3\2\2\2\u00be\u00bf\t\2\2\2\u00bf!\3"+
		"\2\2\2\u00c0\u00c1\t\t\2\2\u00c1#\3\2\2\2\u00c2\u00c3\t\5\2\2\u00c3%\3"+
		"\2\2\2\u00c4\u00c5\t\4\2\2\u00c5\'\3\2\2\2\u00c6\u00c7\t\16\2\2\u00c7"+
		")\3\2\2\2\u00c8\u00c9\t\17\2\2\u00c9+\3\2\2\2\u00ca\u00cb\t\20\2\2\u00cb"+
		"-\3\2\2\2\u00cc\u00cd\t\b\2\2\u00cd/\3\2\2\2\u00ce\u00cf\t\21\2\2\u00cf"+
		"\61\3\2\2\2\u00d0\u00d1\t\22\2\2\u00d1\63\3\2\2\2\u00d2\u00d3\t\7\2\2"+
		"\u00d3\65\3\2\2\2\u00d4\u00d5\5\26\13\2\u00d5\u00d6\5\24\n\2\u00d6\u00d7"+
		"\5,\26\2\u00d7\u00d8\5\32\r\2\u00d8\67\3\2\2\2\u00d9\u00da\5\32\r\2\u00da"+
		"\u00db\5,\26\2\u00db\u00dc\5\24\n\2\u00dc\u00dd\5\26\13\2\u00dd9\3\2\2"+
		"\2\u00de\u00df\5\32\r\2\u00df\u00e0\5\"\21\2\u00e0\u00e1\5,\26\2\u00e1"+
		"\u00e2\5\32\r\2\u00e2;\3\2\2\2\u00e3\u00e4\5.\27\2\u00e4\u00e5\5\36\17"+
		"\2\u00e5\u00e6\5\32\r\2\u00e6\u00e7\5$\22\2\u00e7=\3\2\2\2\u00e8\u00e9"+
		"\5\"\21\2\u00e9\u00ea\5&\23\2\u00ea\u00eb\5&\23\2\u00eb\u00ec\5(\24\2"+
		"\u00ec?\3\2\2\2\u00ed\u00ee\5(\24\2\u00ee\u00ef\5&\23\2\u00ef\u00f0\5"+
		"&\23\2\u00f0\u00f1\5\"\21\2\u00f1A\3\2\2\2\u00f2\u00f3\5\26\13\2\u00f3"+
		"\u00f4\5\"\21\2\u00f4\u00f5\5\24\n\2\u00f5\u00f6\5,\26\2\u00f6\u00f7\5"+
		",\26\2\u00f7C\3\2\2\2\u00f8\u00f9\5\64\32\2\u00f9\u00fa\5\36\17\2\u00fa"+
		"\u00fb\5 \20\2\u00fb\u00fc\5\"\21\2\u00fc\u00fd\5\32\r\2\u00fdE\3\2\2"+
		"\2\u00fe\u00ff\5\32\r\2\u00ff\u0100\5\"\21\2\u0100\u0101\5,\26\2\u0101"+
		"\u0102\5\32\r\2\u0102\u0103\5 \20\2\u0103\u0104\5\34\16\2\u0104G\3\2\2"+
		"\2\u0105\u0106\5 \20\2\u0106\u0107\5,\26\2\u0107\u0108\5\62\31\2\u0108"+
		"\u0109\5&\23\2\u0109\u010a\5 \20\2\u010a\u010b\5\30\f\2\u010bI\3\2\2\2"+
		"\u010c\u010d\5 \20\2\u010d\u010e\5$\22\2\u010e\u010f\5\36\17\2\u010f\u0110"+
		"\5\32\r\2\u0110\u0111\5*\25\2\u0111\u0112\5 \20\2\u0112\u0113\5.\27\2"+
		"\u0113\u0114\5,\26\2\u0114K\3\2\2\2\u0115\u0116\7v\2\2\u0116\u0117\5*"+
		"\25\2\u0117\u0118\5\60\30\2\u0118\u0119\5\32\r\2\u0119\u0121\3\2\2\2\u011a"+
		"\u011b\7h\2\2\u011b\u011c\5\24\n\2\u011c\u011d\5\"\21\2\u011d\u011e\5"+
		",\26\2\u011e\u011f\5\32\r\2\u011f\u0121\3\2\2\2\u0120\u0115\3\2\2\2\u0120"+
		"\u011a\3\2\2\2\u0121M\3\2\2\2\u0122\u0123\7*\2\2\u0123O\3\2\2\2\u0124"+
		"\u0125\7+\2\2\u0125Q\3\2\2\2\u0126\u0127\7}\2\2\u0127S\3\2\2\2\u0128\u0129"+
		"\7\177\2\2\u0129U\3\2\2\2\u012a\u012b\7<\2\2\u012bW\3\2\2\2\u012c\u012d"+
		"\7>\2\2\u012d\u012e\7/\2\2\u012eY\3\2\2\2\u012f\u0130\7\60\2\2\u0130["+
		"\3\2\2\2\u0131\u0132\7B\2\2\u0132]\3\2\2\2\u0133\u0134\7.\2\2\u0134_\3"+
		"\2\2\2\u0135\u0136\7-\2\2\u0136a\3\2\2\2\u0137\u0138\7/\2\2\u0138c\3\2"+
		"\2\2\u0139\u013a\7,\2\2\u013ae\3\2\2\2\u013b\u013c\7\61\2\2\u013cg\3\2"+
		"\2\2\u013d\u013e\7\u0080\2\2\u013ei\3\2\2\2\u013f\u0140\7>\2\2\u0140k"+
		"\3\2\2\2\u0141\u0142\7>\2\2\u0142\u0143\7?\2\2\u0143m\3\2\2\2\u0144\u0145"+
		"\7?\2\2\u0145o\3\2\2\2\u0146\u0148\5r9\2\u0147\u0146\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014aq\3\2\2\2\u014b"+
		"\u014c\t\23\2\2\u014cs\3\2\2\2\u014d\u0151\t\24\2\2\u014e\u0150\t\25\2"+
		"\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0152u\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0158\t\26\2\2\u0155"+
		"\u0157\t\27\2\2\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3"+
		"\2\2\2\u0158\u0159\3\2\2\2\u0159w\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015f"+
		"\7$\2\2\u015c\u015e\n\30\2\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2"+
		"\2\2\u0162\u0163\7\2\2\3\u0163\u0164\b<\2\2\u0164y\3\2\2\2\u0165\u0167"+
		"\t\31\2\2\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2"+
		"\u0168\u0169\3\2\2\2\u0169\u0172\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016d"+
		"\n\32\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2"+
		"\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0173"+
		"\7\2\2\2\u0172\u016e\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u017b\3\2\2\2\u0176\u0177\7^\2\2\u0177\u017a\n\32"+
		"\2\2\u0178\u017a\n\33\2\2\u0179\u0176\3\2\2\2\u0179\u0178\3\2\2\2\u017a"+
		"\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u0181\3\2"+
		"\2\2\u017d\u017b\3\2\2\2\u017e\u0180\t\34\2\2\u017f\u017e\3\2\2\2\u0180"+
		"\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2"+
		"\2\2\u0183\u0181\3\2\2\2\u0184\u0185\b=\3\2\u0185{\3\2\2\2\u0186\u0192"+
		"\7$\2\2\u0187\u0188\7^\2\2\u0188\u0190\n\32\2\2\u0189\u018b\n\32\2\2\u018a"+
		"\u0189\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0187\3\2\2\2\u018f"+
		"\u018c\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\7\2\2\2\u0192\u018f\3\2"+
		"\2\2\u0193\u0194\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u019b\3\2\2\2\u0196\u0197\7^\2\2\u0197\u019a\n\32\2\2\u0198\u019a\n\33"+
		"\2\2\u0199\u0196\3\2\2\2\u0199\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2"+
		"\2\2\u019e\u01a0\t\34\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\b>"+
		"\4\2\u01a4}\3\2\2\2\u01a5\u01ab\7$\2\2\u01a6\u01a7\7^\2\2\u01a7\u01aa"+
		"\n\32\2\2\u01a8\u01aa\n\33\2\2\u01a9\u01a6\3\2\2\2\u01a9\u01a8\3\2\2\2"+
		"\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae"+
		"\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae\u01af\7\f\2\2\u01af\u01b0\b?\5\2\u01b0"+
		"\177\3\2\2\2\u01b1\u01b7\7$\2\2\u01b2\u01b3\7^\2\2\u01b3\u01b6\n\32\2"+
		"\2\u01b4\u01b6\n\33\2\2\u01b5\u01b2\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6"+
		"\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2"+
		"\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bb\7$\2\2\u01bb\u01bc\b@\6\2\u01bc\u0081"+
		"\3\2\2\2\u01bd\u01bf\t\35\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2"+
		"\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3"+
		"\bA\7\2\u01c3\u0083\3\2\2\2\u01c4\u01c5\13\2\2\2\u01c5\u01c6\bB\b\2\u01c6"+
		"\u0085\3\2\2\2\u01c7\u01c8\7/\2\2\u01c8\u01cc\7/\2\2\u01c9\u01cb\n\36"+
		"\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d0\bC"+
		"\7\2\u01d0\u0087\3\2\2\2\u01d1\u01d2\7*\2\2\u01d2\u01d3\7,\2\2\u01d3\u01d4"+
		"\7\2\2\3\u01d4\u01d5\bD\t\2\u01d5\u0089\3\2\2\2\u01d6\u01d7\7,\2\2\u01d7"+
		"\u01d8\7+\2\2\u01d8\u01d9\bE\n\2\u01d9\u008b\3\2\2\2\u01da\u01db\7,\2"+
		"\2\u01db\u01dc\7+\2\2\u01dc\u01dd\7\2\2\3\u01dd\u01de\bF\13\2\u01de\u008d"+
		"\3\2\2\2\u01df\u01e0\7*\2\2\u01e0\u01e1\7,\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e3\bG\f\2\u01e3\u01e4\bG\7\2\u01e4\u008f\3\2\2\2\u01e5\u01e6\13\2"+
		"\2\2\u01e6\u01e7\7\2\2\3\u01e7\u01e8\bH\r\2\u01e8\u0091\3\2\2\2\u01e9"+
		"\u01ea\13\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\bI\7\2\u01ec\u0093\3\2"+
		"\2\2\u01ed\u01ee\7*\2\2\u01ee\u01ef\7,\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1"+
		"\bJ\f\2\u01f1\u01f2\bJ\7\2\u01f2\u0095\3\2\2\2\u01f3\u01f4\7,\2\2\u01f4"+
		"\u01f5\7+\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\bK\16\2\u01f7\u01f8\bK\7"+
		"\2\u01f8\u0097\3\2\2\2\33\2\3\u0120\u0149\u0151\u0158\u015f\u0168\u016e"+
		"\u0174\u0179\u017b\u0181\u018c\u018f\u0194\u0199\u019b\u01a1\u01a9\u01ab"+
		"\u01b5\u01b7\u01c0\u01cc\17\3<\2\3=\3\3>\4\3?\5\3@\6\b\2\2\3B\7\3D\b\3"+
		"E\t\3F\n\7\3\2\3H\13\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
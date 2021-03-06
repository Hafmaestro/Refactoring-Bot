// Generated from botGrammar\BotOperations.g4 by ANTLR 4.7.1
package de.refactoringbot.grammar.botgrammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BotOperationsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		REFACTORING=1, ADD=2, RENAME=3, REORDER=4, REMOVE=5, ADDKIND=6, REORDERKIND=7, 
		REMOVEKIND=8, RENAMEKIND=9, ANNOTATION=10, SUPPORTEDANNOTATIONS=11, PARAMETER=12, 
		WORD=13, USERNAME=14, DIGIT=15, NUMBER=16, SYMBOL=17, WHITESPACE=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"REFACTORING", "ADD", "RENAME", "REORDER", "REMOVE", "ADDKIND", "REORDERKIND", 
		"REMOVEKIND", "RENAMEKIND", "ANNOTATION", "SUPPORTEDANNOTATIONS", "PARAMETER", 
		"WORD", "USERNAME", "UPPERCASE", "LOWERCASE", "DIGIT", "NUMBER", "SYMBOL", 
		"WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'MODIFIER'", null, "'METHOD'", 
		null, "'Override'", null, null, null, null, null, null, "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "REFACTORING", "ADD", "RENAME", "REORDER", "REMOVE", "ADDKIND", 
		"REORDERKIND", "REMOVEKIND", "RENAMEKIND", "ANNOTATION", "SUPPORTEDANNOTATIONS", 
		"PARAMETER", "WORD", "USERNAME", "DIGIT", "NUMBER", "SYMBOL", "WHITESPACE"
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
	  public void recover(RecognitionException ex) 
	  {
	    throw new RuntimeException(ex.getMessage()); 
	  }


	public BotOperationsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BotOperations.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00b2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\5\2\60\n\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\6\16"+
		"\u0098\n\16\r\16\16\16\u0099\3\17\3\17\3\17\3\17\6\17\u00a0\n\17\r\17"+
		"\16\17\u00a1\3\20\3\20\3\21\3\21\3\22\6\22\u00a9\n\22\r\22\16\22\u00aa"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\2#\21%\22\'\23)\24\3\2\6\3"+
		"\2C\\\3\2c|\3\2\62;\b\2\'(//\61\61BBaa\u00e1\u00e1\2\u00b9\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\3/\3\2\2\2\5\61\3\2\2\2\78\3\2\2\2\tH\3\2\2\2\13S\3\2\2\2\r]\3\2\2"+
		"\2\17_\3\2\2\2\21h\3\2\2\2\23j\3\2\2\2\25q\3\2\2\2\27\177\3\2\2\2\31\u0088"+
		"\3\2\2\2\33\u0097\3\2\2\2\35\u009f\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2"+
		"\2\2#\u00a8\3\2\2\2%\u00ac\3\2\2\2\'\u00ae\3\2\2\2)\u00b0\3\2\2\2+\60"+
		"\5\5\3\2,\60\5\7\4\2-\60\5\t\5\2.\60\5\13\6\2/+\3\2\2\2/,\3\2\2\2/-\3"+
		"\2\2\2/.\3\2\2\2\60\4\3\2\2\2\61\62\7C\2\2\62\63\7F\2\2\63\64\7F\2\2\64"+
		"\65\3\2\2\2\65\66\5)\25\2\66\67\5\r\7\2\67\6\3\2\2\289\7T\2\29:\7G\2\2"+
		":;\7P\2\2;<\7C\2\2<=\7O\2\2=>\7G\2\2>?\3\2\2\2?@\5)\25\2@A\5\23\n\2AB"+
		"\5)\25\2BC\7V\2\2CD\7Q\2\2DE\3\2\2\2EF\5)\25\2FG\5\33\16\2G\b\3\2\2\2"+
		"HI\7T\2\2IJ\7G\2\2JK\7Q\2\2KL\7T\2\2LM\7F\2\2MN\7G\2\2NO\7T\2\2OP\3\2"+
		"\2\2PQ\5)\25\2QR\5\17\b\2R\n\3\2\2\2ST\7T\2\2TU\7G\2\2UV\7O\2\2VW\7Q\2"+
		"\2WX\7X\2\2XY\7G\2\2YZ\3\2\2\2Z[\5)\25\2[\\\5\21\t\2\\\f\3\2\2\2]^\5\25"+
		"\13\2^\16\3\2\2\2_`\7O\2\2`a\7Q\2\2ab\7F\2\2bc\7K\2\2cd\7H\2\2de\7K\2"+
		"\2ef\7G\2\2fg\7T\2\2g\20\3\2\2\2hi\5\31\r\2i\22\3\2\2\2jk\7O\2\2kl\7G"+
		"\2\2lm\7V\2\2mn\7J\2\2no\7Q\2\2op\7F\2\2p\24\3\2\2\2qr\7C\2\2rs\7P\2\2"+
		"st\7P\2\2tu\7Q\2\2uv\7V\2\2vw\7C\2\2wx\7V\2\2xy\7K\2\2yz\7Q\2\2z{\7P\2"+
		"\2{|\3\2\2\2|}\5)\25\2}~\5\27\f\2~\26\3\2\2\2\177\u0080\7Q\2\2\u0080\u0081"+
		"\7x\2\2\u0081\u0082\7g\2\2\u0082\u0083\7t\2\2\u0083\u0084\7t\2\2\u0084"+
		"\u0085\7k\2\2\u0085\u0086\7f\2\2\u0086\u0087\7g\2\2\u0087\30\3\2\2\2\u0088"+
		"\u0089\7R\2\2\u0089\u008a\7C\2\2\u008a\u008b\7T\2\2\u008b\u008c\7C\2\2"+
		"\u008c\u008d\7O\2\2\u008d\u008e\7G\2\2\u008e\u008f\7V\2\2\u008f\u0090"+
		"\7G\2\2\u0090\u0091\7T\2\2\u0091\u0092\3\2\2\2\u0092\u0093\5)\25\2\u0093"+
		"\u0094\5\33\16\2\u0094\32\3\2\2\2\u0095\u0098\5!\21\2\u0096\u0098\5\37"+
		"\20\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\34\3\2\2\2\u009b\u00a0\5\37\20"+
		"\2\u009c\u00a0\5!\21\2\u009d\u00a0\5%\23\2\u009e\u00a0\5\'\24\2\u009f"+
		"\u009b\3\2\2\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\36\3\2\2\2\u00a3\u00a4\t\2\2\2\u00a4 \3\2\2\2\u00a5\u00a6\t\3\2\2\u00a6"+
		"\"\3\2\2\2\u00a7\u00a9\t\4\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2"+
		"\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab$\3\2\2\2\u00ac\u00ad\t"+
		"\4\2\2\u00ad&\3\2\2\2\u00ae\u00af\t\5\2\2\u00af(\3\2\2\2\u00b0\u00b1\7"+
		"\"\2\2\u00b1*\3\2\2\2\t\2/\u0097\u0099\u009f\u00a1\u00aa\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
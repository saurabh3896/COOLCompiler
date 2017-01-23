// Generated from CoolParser.g4 by ANTLR 4.5
package cool;

	import cool.AST;
	import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CoolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CoolParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CoolParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#class_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_list(CoolParser.Class_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#class_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_definition(CoolParser.Class_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(CoolParser.FeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#members}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembers(CoolParser.MembersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#declaration_initialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_initialization(CoolParser.Declaration_initializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(CoolParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#argument_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_list(CoolParser.Argument_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal(CoolParser.FormalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#multiple_expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_expressions(CoolParser.Multiple_expressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#brace_expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrace_expressions(CoolParser.Brace_expressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#single_branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_branch(CoolParser.Single_branchContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#case_expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_expressions(CoolParser.Case_expressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#let_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_exp(CoolParser.Let_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#let_expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_expressions(CoolParser.Let_expressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CoolParser.ExpressionContext ctx);
}
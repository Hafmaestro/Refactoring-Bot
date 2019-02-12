package de.refactoringBot.refactoring.supportedRefactorings.ExtractMethod;

import com.github.javaparser.JavaParser;
import com.github.javaparser.Position;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.VoidType;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import com.github.javaparser.ast.visitor.VoidVisitor;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import javassist.expr.MethodCall;
import org.apache.tomcat.jni.Local;

public class MethodExtractor extends VoidVisitorAdapter<Void> {
    private final CompilationUnit compilationUnit;
    private final RefactorCandidate candidate;
    private final String fileName;

    public MethodExtractor(RefactorCandidate candidate, String fileName) throws FileNotFoundException {
        // Read file
        FileInputStream in = new FileInputStream(fileName);
        this.compilationUnit = JavaParser.parse(in);
        this.candidate = candidate;
        this.fileName = fileName;
    }

    public void apply() throws FileNotFoundException {
        for (TypeDeclaration type : compilationUnit.getTypes()) {
            Optional<Position> beginPosition = type.getBegin();
            Optional<Position> endPosition = type.getEnd();
            if (beginPosition.isPresent() && endPosition.isPresent()) {
                int startLine = beginPosition.get().line;
                int endLine = endPosition.get().line;
                if (startLine <= candidate.startLine && endLine >= candidate.endLine) {
                    // create new method
                    EnumSet<Modifier> modifiers = EnumSet.of(Modifier.PRIVATE);
                    Type methodType = new VoidType();
                    if (this.candidate.outVariables.size() > 0) {
                        methodType = new ClassOrInterfaceType(null, this.candidate.outVariables.iterator().next().type);
                    }
                    MethodDeclaration extractedMethod = new MethodDeclaration(modifiers, methodType, "extractedMethod");
                    for (LocalVariable inVar : this.candidate.inVariables) {
                        extractedMethod.addParameter(inVar.type, inVar.name);
                    }
                    type.addMember(extractedMethod);

                    // remove code from original method and add candidate code to new method
                    List<Statement> nodes = compilationUnit.accept(new MethodVisitor(this.candidate, this.compilationUnit), null);
                    BlockStmt block = new BlockStmt();
                    extractedMethod.setBody(block);
                    for (Statement node : nodes) {
                        node.remove();
                        block.addStatement(node);
                    }

                    // call new method in original method
                    Expression methodCall;
                    MethodCallExpr call = new MethodCallExpr("extractedMethod");
                    for (LocalVariable var : this.candidate.inVariables) {
                        call.addArgument(var.name);
                    }
                    if (this.candidate.outVariables.size() > 0) {
                        LocalVariable outVar = this.candidate.outVariables.iterator().next();
                        Expression target = new FieldAccessExpr(null, outVar.name);
                        if (!this.candidate.inVariablesContain(outVar)) {
                            target =  new VariableDeclarationExpr(new ClassOrInterfaceType(outVar.type), outVar.name);
                        }
                        AssignExpr assign = new AssignExpr(target, call, AssignExpr.Operator.ASSIGN);
                        methodCall = assign;
                    } else {
                        methodCall = call;
                    }

                    // Save changes to file
                    PrintWriter out = new PrintWriter(this.fileName);
                    String refactordedCode = compilationUnit.toString();
                    out.println(refactordedCode);
                    out.close();
                }
            }
        }
    }



    private static class MethodVisitor extends GenericVisitorAdapter<List<Statement>, Void> {
        private RefactorCandidate candidate;
        private CompilationUnit compilationUnit;

        public MethodVisitor(RefactorCandidate candidate, CompilationUnit compilationUnit) {
            this.candidate = candidate;
            this.compilationUnit = compilationUnit;
        }

        @Override
        public List<Statement> visit(MethodDeclaration n, Void arg) {
            Optional<Position> beginPosition = n.getBody().get().getBegin();
            Optional<Position> endPosition = n.getBody().get().getEnd();
            List<Statement> removedNodes = new ArrayList<>();
            if (beginPosition.isPresent() && endPosition.isPresent()) {
                int startLine = beginPosition.get().line;
                int endLine = endPosition.get().line;
                if (startLine <= candidate.startLine && endLine >= candidate.endLine) {
                    for (Statement statement : n.getBody().get().getStatements()) {
                        if (this.candidateContainsStatement(statement)) {
                            removedNodes.add(statement);
                        }
                    }
                }
            }
            return removedNodes;
        }

        private boolean candidateContainsStatement(Statement statement) {
            Optional<Position> beginPosition = statement.getBegin();
            Optional<Position> endPosition = statement.getEnd();
            if (beginPosition.isPresent() && endPosition.isPresent()) {
                int startLine = beginPosition.get().line;
                int endLine = endPosition.get().line;
                if (this.candidate.containsLine(startLine) || this.candidate.containsLine(endLine)) {
                    return true;
                }
            }
            return false;
        }
    }
}

package de.refactoringBot.refactoring.supportedRefactorings.prepareCodeForCF;

import java.util.ArrayList;

public class PrepareCodeInnerClass {

    // The name of the inner class
    String className;
    // All variables names that are declared in the compUnit with this inner class
    ArrayList<String> varNames;
    // All methods of the inner class
    ArrayList<PrepareCodeICMethod> methods;
    // All variables of the inner class
    ArrayList<PrepareCodeICVariable> variables;

    public PrepareCodeInnerClass(String className) {
        this.className = className;
        this.varNames = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.variables = new ArrayList<>();
    }

}

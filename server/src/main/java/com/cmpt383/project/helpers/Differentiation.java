package com.cmpt383.project.helpers;

import com.cmpt383.project.parser.ast.Operation;
import com.cmpt383.project.parser.tokenizer.AbstractTreeBuilder;
import com.cmpt383.project.parser.tokenizer.TokenizerException;

public class Differentiation {
    
    AbstractTreeBuilder tree;
    Operation derivative;

    public Differentiation(String equation){
        this.tree = new AbstractTreeBuilder(equation);
    }

    public String getDerivative() throws TokenizerException{
        this.derivative = tree.getTree().getDerivative();
        return derivative.toString();
    }

    public double getNumeric(double number) throws TokenizerException{
        this.derivative = tree.getTree().getDerivative();
        return derivative.getNumericResult(number);
    }
}
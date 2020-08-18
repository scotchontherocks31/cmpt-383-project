package com.cmpt383.project.parser.ast;

public interface Operation {
    Double getNumericResult(Double val);
    Operation getDerivative();
}
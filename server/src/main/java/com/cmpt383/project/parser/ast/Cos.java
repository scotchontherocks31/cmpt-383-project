package com.cmpt383.project.parser.ast;

public class Cos extends UnaryOperation {

    public Cos(Operation op) {
        super(op);
    }
    
    public String toString(){
        return "cos(" + op.toString() + ")";
        }

    @Override
    public Double getNumericResult(Double val) {
        return Math.cos(op.getNumericResult(val));
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Cos)) return false;
        Cos abs = (Cos) o;
        return (op.equals(abs.op));
    }

    @Override
    public Operation getDerivative(){
        return new Negate(new Product(new Sin(op), op.getDerivative()));
    }
    
    public int hashCode(){
        return 29 * op.hashCode();
    }

}

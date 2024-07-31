package src.main.java.calculator;
public record Logarithm(Expression child) implements Expression {
    public double evaluateAt(double d) {
        return Math.log10(child.evaluateAt(d));
    }
}
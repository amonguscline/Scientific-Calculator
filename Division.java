package src.main.java.calculator;
public record Division(Expression left, Expression right) implements Expression {
    public double evaluateAt(double d) {
        return left.evaluateAt(d) / right.evaluateAt(d);
    }
}

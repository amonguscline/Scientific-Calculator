package src.main.java.calculator;
public record NumExpress(double value) implements Expression {
    public double evaluateAt(double d) {
        return value;
    }
}
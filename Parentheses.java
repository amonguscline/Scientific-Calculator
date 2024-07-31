package src.main.java.calculator;
import java.util.*;

public class Parentheses implements Token {
  private final Label label;
  private final String value;
  private final static Map<String, Label> labeller = new HashMap<>(){
    {
      put("(",Label.LPAREN);
      put(")",Label.RPAREN);
    }
  };

  public Parentheses(String value) {
    this.value=value;
    this.label=labeller.get(value);
  }

  public Label getLabel() {
    return label;
  }
  public String toString(){
    return value;
}
}
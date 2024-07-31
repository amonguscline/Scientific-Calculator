package src.main.java.calculator;

import java.util.*;

public class Operator implements Token {

  private final Label label;
  private final String value;
  private final static Map<String, Label> labeller = new HashMap<>(){
    {
      put("+",Label.ADD);
      put("-",Label.SUB);
      put("*",Label.MULT);
      put("/",Label.SUB);
      put("^",Label.EXPO);
      put("√",Label.SQRT);
    }
  };

  public Operator(String value) {
    this.value=value;
    this.label=labeller.get(value);
  }

  public Label getLabel() {
    return this.label;
  }
  public String toString(){
    return value;
  }
}
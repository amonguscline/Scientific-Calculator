package src.main.java.calculator;
import java.util.*;
import java.util.stream.Stream;

class Lexer{
    private static String[] operators = {"+","-","*","/","^","√"};
    private static ArrayList<Token> tokens = new ArrayList<>();
    //Args: an arraylist of string elements of the buttons in the order that the user pressed
    public static ArrayList<Token> lex(List<String> str){
        while(str.size()>0){
            tokenize(str.get(0));
            str.remove(0);
        }
        refactor();
        return tokens;
    }
    //returns a token given a string
    private static void tokenize(String str){
        if(isInt(str)){tokens.add(new Number(Integer.parseInt(str)));}
        else if(isOperator(str)){tokens.add(new Operator(str));}
        else tokens.add(new Parentheses(str));
    }
    private static boolean isInt(String str){
        try {Integer.parseInt(str);} 
        catch (Exception e) {return false;}
        return true;
    }
    private static boolean isOperator(String str){
        return Stream.of(operators).anyMatch(n->n.equals(str));
    }
    //add a multiplication where there is an "implied" multiplication (i.e. between a number and a parentheses)
    private static void refactor(){
        for(int i=0;i<tokens.size()-1;i++){
            Label currentLabel = tokens.get(i).getLabel();
            Label nextLabel = tokens.get(i+1).getLabel();
            if((currentLabel==Label.RPAREN&&nextLabel==Label.LPAREN) ||
                (currentLabel==Label.NUM&&nextLabel==Label.LPAREN) ||
                (currentLabel==Label.RPAREN&&nextLabel==Label.NUM)){
                tokens.add(i+1, new Operator("*"));
                i++;
            }
        }
    }
}
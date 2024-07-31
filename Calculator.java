package src.main.java.calculator;
import javax.swing.JButton;
import javax.swing.JPanel;

import src.main.java.calculator.Token;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Calculator extends JPanel {

    List<String> str = new ArrayList<>();
    Node root;
    public Calculator() {
        addButtons();
    }

    public void addButtons() {
        for(Label label : Label.values()){
            JButton jb = new JButton();
            jb.setText(label.symbol);
            jb.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(label.symbol == "="){
                            parseTokens(Lexer.lex(str));
                            System.out.println(evaluateAt(10));
                        } else{
                            str.add(label.symbol);
                        }
                    }});  
            jb.setSize(300, 300); 
            jb.setVisible(true);
            add(jb);
        }
        for (int i = 0; i < 10; i++) {
            var in = i;
            JButton jb = new JButton();
            jb.setText(i + "");
            jb.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        str.add(in + "");
                    }});  
            jb.setSize(300, 300); 
            jb.setVisible(true);
            add(jb);
        }
    }
    public double evaluateAt(double x) {
        return root.getValue().evaluateAt(x);
    }
    
    public void parseTokens(ArrayList<Token> tokens) {
        root = new Node(tokens);
    }
}

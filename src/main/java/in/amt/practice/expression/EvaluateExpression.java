package in.amt.practice.expression;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by amit.sharma5 on 25/08/17.
 */
public class EvaluateExpression {

    List<String> operators = Arrays.asList("+,-,/,*,(,),{,},[,]".split(","));

    public static void main(String[] args) throws Exception {
        EvaluateExpression t = new EvaluateExpression();
        String expression = "(2+5)*5-9";
        char[] arr = expression.toCharArray();
        System.out.println(t.convertToPostFixAndCalculate(arr));
    }
    private String convertToPostFix(char[] expression) throws Exception {
        StringBuilder builder = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for(int i=0; i<expression.length; i++){
            char ch = expression[i];
            if(ifOperator(ch)){
                if(operators.size()>0){
                    char lastOperator = operators.pop();
                    if(checkPrecedence(lastOperator, ch)){
                        operators.push(lastOperator);
                    }else{
                        builder.append(lastOperator);
                    }
                    operators.push(ch);
                } else{
                    operators.push(ch);
                }
            } else if(ch >= '0' && ch <= '9' ){
                builder.append(ch);
            } else{
                throw new Exception("Invalid Expression");
            }
        }
        while(!operators.empty()){
            builder.append(operators.pop());
        }
        return builder.toString();
    }
    private String convertToPostFixAndCalculate(char[] expression) throws Exception {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for(int i=0; i<expression.length; i++){
            char ch = expression[i];
            if(ifOperator(ch)){
                if(ch == '('){
                    operators.push(ch);
                    continue;
                }else if(ch == ')'){
                    while(operators.peek() != '(')
                        values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                    operators.pop();
                    continue;
                }
                if(operators.size()>0 && !checkPrecedence(operators.peek(), ch)){
                    while(!operators.empty()) {
                        values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                    }
                }
                operators.push(ch);
            } else if(ch >= '0' && ch <= '9' ){
                values.push(Integer.parseInt(Character.toString(ch)));
            } else{
                throw new Exception("Invalid Expression");
            }
        }
        while(!operators.empty()){
            values.push(applyOp(operators.pop(),values.pop(),values.pop()));
        }

        return values.toString();
    }
    private int applyOp(char op, int j, int i) throws Exception {
        switch (op) {
            case '*':
                return (i * j);
            case '+':
                return (i+j);
            case '-':
                return (i-j);
            case '/':
                if(j==0){
                    throw new Exception("Number can't be divided by 0");
                }
                return (i/j);
            default:
                return 0;
        }
    }
    private boolean checkPrecedence(char op1, char op2){
        if(op2 == '(' || op2 == ')'){
            return false;
        }
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        } else{
            return true;
        }
    }
    private boolean ifOperator(char ch){
        if(operators.contains(Character.toString(ch))){
            return true;
        }
        return false;
    }

}


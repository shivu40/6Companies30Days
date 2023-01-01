class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(isOperator(tokens[i])){
                int operand2 = st.pop();
                int operand1 = st.pop();

                int result = applyOperation(operand1, operand2, tokens[i]);
                st.push(result);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.pop();
    }

    public static boolean isOperator(String token){
        if(token.equals("+") || token.equals("-") ||
           token.equals("*") || token.equals("/")){
               return true;
           }

        return false;
    }

    public static int applyOperation(int operand1, int operand2, String operation){
        if(operation.equals("+")){
            return operand1 + operand2;
        }else if(operation.equals("-")){
            return operand1 - operand2;
        }else if(operation.equals("*")){
            return operand1 * operand2;
        }else if(operation.equals("/")){
            return operand1 / operand2;
        }
        return 0;
    }
}
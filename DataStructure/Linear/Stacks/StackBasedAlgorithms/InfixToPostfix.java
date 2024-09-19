package DataStructure.Linear.Stacks.StackBasedAlgorithms;

import java.util.Stack;

public class InfixToPostfix {
   // Function to check the precedence of operators
   static int precedence(char ch) {
      switch (ch) {
         case '+':
         case '-':
            return 1;
         case '*':
         case '/':
            return 2;
         case '^':
            return 3;
      }
      return -1;
   }

   // Function to convert infix expression to postfix expression
   static String infixToPostfix(String expression) {
      StringBuilder result = new StringBuilder();
      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < expression.length(); i++) {
         char c = expression.charAt(i);

         // If the character is an operand, add it to output
         if (Character.isLetterOrDigit(c)) {
            result.append(c);
         }
         // If the character is '(', push it to the stack
         else if (c == '(') {
            stack.push(c);
         }
         // If the character is ')', pop and output from the stack until '(' is found
         else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
               result.append(stack.pop());
            }
            stack.pop();
         } else { // an operator is encountered
            while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
               result.append(stack.pop());
            }
            stack.push(c);
         }
      }

      // Pop all the operators from the stack
      while (!stack.isEmpty()) {
         result.append(stack.pop());
      }

      return result.toString();
   }

   public static void main(String[] args) {
      String expression = "A+B*C-D";
      System.out.println("Infix Expression: " + expression);
      System.out.println("Postfix Expression: " + infixToPostfix(expression));
   }
}


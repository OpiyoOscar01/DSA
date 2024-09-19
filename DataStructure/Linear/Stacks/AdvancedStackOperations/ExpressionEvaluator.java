package DataStructure.Linear.Stacks.AdvancedStackOperations;

import java.util.Stack;

// Class to evaluate infix, postfix, and prefix expressions
public class ExpressionEvaluator {

   // Method to evaluate an infix expression
   public static int evaluateInfix(String expression) {
      // Convert infix expression to postfix expression
      String postfix = infixToPostfix(expression);
      // Evaluate the postfix expression
      return evaluatePostfix(postfix);
   }

   // Convert infix expression to postfix expression
   private static String infixToPostfix(String infix) {
      StringBuilder postfix = new StringBuilder();
      Stack<Character> stack = new Stack<>();

      for (char ch : infix.toCharArray()) {
         if (Character.isDigit(ch)) {
            postfix.append(ch);
         } else if (ch == '(') {
            stack.push(ch);
         } else if (ch == ')') {
            while (stack.peek() != '(') {
               postfix.append(stack.pop());
            }
            stack.pop(); // Remove '(' from the stack
         } else {
            while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
               postfix.append(stack.pop());
            }
            stack.push(ch);
         }
      }

      while (!stack.isEmpty()) {
         postfix.append(stack.pop());
      }

      return postfix.toString();
   }

   // Evaluate a postfix expression
   private static int evaluatePostfix(String postfix) {
      Stack<Integer> stack = new Stack<>();

      for (char ch : postfix.toCharArray()) {
         if (Character.isDigit(ch)) {
            stack.push(ch - '0');
         } else {
            int b = stack.pop();
            int a = stack.pop();
            switch (ch) {
               case '+':
                  stack.push(a + b);
                  break;
               case '-':
                  stack.push(a - b);
                  break;
               case '*':
                  stack.push(a * b);
                  break;
               case '/':
                  stack.push(a / b);
                  break;
            }
         }
      }

      return stack.pop();
   }

   // Evaluate a prefix expression
   public static int evaluatePrefix(String prefix) {
      Stack<Integer> stack = new Stack<>();
      String reversedPrefix = new StringBuilder(prefix).reverse().toString();

      for (char ch : reversedPrefix.toCharArray()) {
         if (Character.isDigit(ch)) {
            stack.push(ch - '0');
         } else {
            int a = stack.pop();
            int b = stack.pop();
            switch (ch) {
               case '+':
                  stack.push(a + b);
                  break;
               case '-':
                  stack.push(a - b);
                  break;
               case '*':
                  stack.push(a * b);
                  break;
               case '/':
                  stack.push(a / b);
                  break;
            }
         }
      }

      return stack.pop();
   }

   // Determine the precedence of operators
   private static int precedence(char operator) {
      switch (operator) {
         case '+':
         case '-':
            return 1;
         case '*':
         case '/':
            return 2;
         default:
            return -1;
      }
   }

   // Main method to test the evaluators
   public static void main(String[] args) {
      String infix = "3+(4*5)";
      String postfix = "345*+";
      String prefix = "*+345";

      System.out.println("Infix Expression: " + infix);
      System.out.println("Postfix Expression: " + postfix);
      System.out.println("Prefix Expression: " + prefix);

      System.out.println("Infix Evaluation: " + evaluateInfix(infix));
      System.out.println("Postfix Evaluation: " + evaluatePostfix(postfix));
      System.out.println("Prefix Evaluation: " + evaluatePrefix(prefix));
   }
}


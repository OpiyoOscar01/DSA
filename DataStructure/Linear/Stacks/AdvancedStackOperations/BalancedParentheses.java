package DataStructure.Linear.Stacks.AdvancedStackOperations;

import java.util.Stack;

public class BalancedParentheses {

   // Method to check if the parentheses in the expression are balanced
   public static boolean areParenthesesBalanced(String expression) {
      Stack<Character> stack = new Stack<>();

      // Iterate through each character in the expression
      for (char ch : expression.toCharArray()) {
         switch (ch) {
            case '(':
            case '{':
            case '[':
               stack.push(ch); // Push opening parentheses onto the stack
               break;
            case ')':
               if (stack.isEmpty() || stack.pop() != '(') {
                  return false; // Unmatched closing parenthesis
               }
               break;
            case '}':
               if (stack.isEmpty() || stack.pop() != '{') {
                  return false; // Unmatched closing parenthesis
               }
               break;
            case ']':
               if (stack.isEmpty() || stack.pop() != '[') {
                  return false; // Unmatched closing parenthesis
               }
               break;
            default:
               // Ignore non-parenthesis characters
               break;
         }
      }

      // If stack is empty, all parentheses are matched
      return stack.isEmpty();
   }

   // Main method to test the areParenthesesBalanced method
   public static void main(String[] args) {
      String[] expressions = {
              "()",
              "((()))",
              "({[]})",
              "(()",
              "())",
              "({[})"
      };

      for (String expression : expressions) {
         System.out.println("Expression: " + expression);
         System.out.println("Balanced: " + areParenthesesBalanced(expression));
      }
   }
}


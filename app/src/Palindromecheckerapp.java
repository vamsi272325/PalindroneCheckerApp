import java.util.Stack;
public class Palindromecheckerapp {
    static void main(String[] args) {

        String input = "level";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        boolean isPalindrome = input.equals(reversed);

        System.out.println("Input : " + input);
        System.out.println("Reversed : " + reversed);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
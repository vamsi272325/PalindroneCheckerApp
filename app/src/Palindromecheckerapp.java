import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Palindromecheckerapp {

    public static void main(String[] args) {
        String input = "level";

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        PalindromeChecker checker = new PalindromeChecker(stackStrategy);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? (Stack)  : " + checker.check(input));

        checker.setStrategy(dequeStrategy);
        System.out.println("Is Palindrome? (Deque)  : " + checker.check(input));
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeChecker {

    private PalindromeStrategy strategy;

    PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    boolean check(String input) {
        return strategy.check(input);
    }
}
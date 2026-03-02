import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Palindromecheckerapp {

    public static void main(String[] args) {
        String input = "level";

        runBenchmark("Two Pointer",   input, new TwoPointerStrategy());
        runBenchmark("Stack",         input, new StackStrategy13());
        runBenchmark("Deque",         input, new DequeStrategy13());
        runBenchmark("Recursive",     input, new RecursiveStrategy());
        runBenchmark("String Reverse",input, new StringReverseStrategy());
    }

    static void runBenchmark(String name, String input, PalindromeStrategy13 strategy) {
        long start = System.nanoTime();
        boolean result = strategy.check(input);
        long end = System.nanoTime();

        System.out.println("------------------------------");
        System.out.println("Strategy        : " + name);
        System.out.println("Input           : " + input);
        System.out.println("Is Palindrome?  : " + result);
        System.out.println("Execution Time  : " + (end - start) + " ns");
    }
}

interface PalindromeStrategy13 {
    boolean check(String input);
}

class TwoPointerStrategy implements PalindromeStrategy13 {
    public boolean check(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

class StackStrategy13 implements PalindromeStrategy13 {
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class DequeStrategy13 implements PalindromeStrategy13 {
    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) return false;
        }
        return true;
    }
}

class RecursiveStrategy implements PalindromeStrategy13 {
    public boolean check(String input) {
        return checkRecursive(input, 0, input.length() - 1);
    }
    private boolean checkRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return checkRecursive(s, start + 1, end - 1);
    }
}

class StringReverseStrategy implements PalindromeStrategy13 {
    public boolean check(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return input.equals(reversed);
    }
}
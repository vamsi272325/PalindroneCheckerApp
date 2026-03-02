import java.util.ArrayDeque;
import java.util.Deque;

public class Palindromecheckerapp {

    public static void main(String[] args) {

        String input = "racecar";

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
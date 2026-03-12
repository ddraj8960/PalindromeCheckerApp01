import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

// Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.checkPalindrome(str);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";

        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // PalindromeStrategy strategy = new DequeStrategy();

        PalindromeChecker checker = new PalindromeChecker(strategy);

        if (checker.check(input)) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is NOT a Palindrome");
        }
    }
}
package problems.problem_0009_palindrome_number;

public class PalindromeNumberSolution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        var num = x + "";
        var left = 0;
        var right = num.length() - 1;

        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

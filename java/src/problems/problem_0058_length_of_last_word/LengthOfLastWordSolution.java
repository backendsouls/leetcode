package problems.problem_0058_length_of_last_word;

public class LengthOfLastWordSolution {

    public int lengthOfLastWord(String s) {
        String words[] = s.split(" ");
        String lastWord = words[words.length - 1];

        return lastWord.length();
    }
}

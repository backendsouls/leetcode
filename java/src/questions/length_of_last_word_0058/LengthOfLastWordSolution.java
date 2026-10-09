package questions.length_of_last_word_0058;

public class LengthOfLastWordSolution {

    public int lengthOfLastWord(String s) {
        String words[] = s.split(" ");
        String lastWord = words[words.length - 1];

        return lastWord.length();
    }
}

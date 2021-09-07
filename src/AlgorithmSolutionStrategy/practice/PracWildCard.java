package AlgorithmSolutionStrategy.practice;

public class PracWildCard {

    boolean match(String w, String s) {

        int pos = 0;
        while ((s.length() > pos && w.length() > pos)
                && (w.charAt(pos) == s.charAt(pos) || w.charAt(pos) == '?')) {
            ++pos;
        }

        if (s.length() == pos && s.length() == w.length())
            return true;

        if (w.charAt(pos) == '*') {
            for (int i = 0; i+pos <= s.length(); i++) {
                if (match( w.substring(pos+1), s.substring(i+pos)))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String w = "hel*o";
        String s = "hell";
        PracWildCard pracWildCard = new PracWildCard();

        System.out.println(pracWildCard.match(w, s));


    }
}

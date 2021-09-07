package AlgorithmSolutionStrategy.dynamicprogramming;

import java.util.Arrays;

public class WildCard {

    boolean match(String w, String s) {
        int pos = 0;

        while(pos < s.length() && pos < w.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
            ++pos;
        }

        if (pos == w.length())
            return pos == s.length();

        if (w.charAt(pos) == '*') {
            for (int skip = 0; (pos+skip) <= s.length(); ++skip) {
                if (match(w.substring(pos+1), s.substring(pos+skip)))
                    return true;
            }
        }
        return false;
    }

    int cache[][] = new int[101][101];
    String W, S;

    boolean matchMemoized(int w, int s) {
        int oW = w;
        int oS = s;
        if (cache[oW][oS] != -1)
            return cache[oW][oS] == 1;

        while (s < S.length() && w < W.length() && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
            ++w;
            ++s;
        }

        if ( w == W.length()) {
            cache[oW][oS] = s == S.length() ? 1 : 0;
            return cache[oW][oS] == 1;
        }

        if (W.charAt(w) == '*') {
            for (int skip = 0; skip+s <= S.length(); ++skip) {
                if (matchMemoized(w+1, s+skip)) {
                    cache[oW][oS] = 1;
                    return true;
                }

            }
        }

        cache[oW][oS] = 0;
        return false;
    }

    boolean matchOpt(int w, int s) {
        int oW = w;
        int oS = s;
        if (cache[oW][oS] != -1)
            return cache[oW][oS] == 1;

        if (s < S.length() && w < W.length() && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
            cache[oW][oS] = matchOpt(w + 1, s + 1) ? 1 : 0;
            return cache[oW][oS] == 1;
        }

        if ( w == W.length()) {
            cache[oW][oS] = s == S.length() ? 1 : 0;
            return cache[oW][oS] == 1;
        }

        if (W.charAt(w) == '*') {

            if (matchOpt(w+1, s) || s < S.length() && matchOpt(w, s+1)) {
                cache[oW][oS] = 1;
                return true;
            }

        }

        cache[oW][oS] = 0;
        return false;
    }


    public static void main(String[] args) {


        WildCard wildCard = new WildCard();

        for (int i = 0; i < wildCard.cache.length; i++) {
            Arrays.fill(wildCard.cache[i], -1);
        }

        wildCard.W = "******a";
        wildCard.S = "aaaaaaaaaaaaab";

        //System.out.println(wildCard.matchMemoized(0,0));
        System.out.println(wildCard.matchOpt(0,0));

        //String s = "hello";
        //String w = "h*l*o";

        //System.out.println(wildCard.match(w,s));
    }
}

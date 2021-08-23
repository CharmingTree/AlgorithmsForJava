package programers;

import java.util.*;

public class LanguagePreference {

    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        Map<String, List<String>> languageMap = new LinkedHashMap<>();
        int score = 0;

        for (int i = 0; i < table.length; i++) {
            String[] currentRow = table[i].split(" ");
            List<String> tmpList = new ArrayList<>();
            for (int j = 1; j < currentRow.length; j++) {
                tmpList.add(currentRow[j]);
            }
            languageMap.put(currentRow[0], tmpList);
        }
        //System.out.println(languageMap);

        for (String k : languageMap.keySet()) {
            int tmpScore = 0;
            for (int i = 0; i < languages.length; i ++) {
                if (languageMap.get(k).contains(languages[i])) {
                    int position = (5-languageMap.get(k).indexOf(languages[i])) * preference[i];
                    tmpScore += position;
                }
            }
            if (tmpScore > score) {
                score = tmpScore;
                answer = k;
            }
            else if (tmpScore == score) {
            if (answer.compareTo(k) > 0) {
                score = tmpScore;
                answer = k;
            }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        LanguagePreference languagePreference = new LanguagePreference();

        String[] table = {
                "SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"
        };

        String[] languages = {"PYTHON", "C++", "SQL"};

        int[] preference = {7,5,5};

        //System.out.println(languagePreference.solution(table, languages, preference));
        System.out.println(languagePreference.solution(table, new String[] {"JAVA", "JAVASCRIPT"}, new int[] {7,5}));
    }
}

package com.bgjo.kakao.newClustering;

import java.util.*;
import java.util.regex.Pattern;

public class NewsClustering implements NewsClusteringInterface {
    public int solution(String str1, String str2) {
        int answer = 0;

        // 소,대문자 차이 무시
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> str1Cut = new ArrayList<>();
        List<String> str2Cut = new ArrayList<>();

        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        for (int i = 1; i < str1.length(); i++) {
            String cutTwo = str1.substring(i-1, i+1);
            // 영소문자가 아니면 skip
            if (!Pattern.matches("^[a-z]*$", cutTwo)) {
                continue;
            }
            if (str1Cut.contains(cutTwo)) {
                str1Map.put(cutTwo, str1Map.get(cutTwo) + 1);
            } else {
                str1Map.put(cutTwo, 1);
            }
            str1Cut.add(cutTwo);
        }

        for (int i = 1; i < str2.length(); i++) {
            String cutTwo = str2.substring(i-1, i+1);

            // 영소문자가 아니면 skip
            if (!Pattern.matches("^[a-z]*$", cutTwo)) {
                continue;
            }
            if (str2Cut.contains(cutTwo)) {
                str2Map.put(cutTwo, str2Map.get(cutTwo) + 1);
            } else {
                str2Map.put(cutTwo, 1);
            }
            str2Cut.add(cutTwo);
        }

        // 합집합 max(x,y)
        Set<String> str1AndStr2 = new HashSet<>();
        str1AndStr2.addAll(str1Cut);
        str1AndStr2.addAll(str2Cut);

        System.out.println(str1AndStr2 + " / " + str1Cut + " / " + str2Cut);
        System.out.println("map : " + str1Map + " / " + str2Map);

        int interCnt = 0;
        int sumCnt = 0;

        if (str1AndStr2.size() > 0) {
            for (String s : str1AndStr2) {
                if (str1Cut.contains(s) && str2Cut.contains(s)) {
                    // 교집합 min(x,y)

                    System.out.println(s + " : " + str1Map.get(s).compareTo(str2Map.get(s)));
                    switch (str1Map.get(s).compareTo(str2Map.get(s))) {
                        case 0:
                            interCnt += str1Map.get(s);
                            sumCnt += str1Map.get(s);
                            break;
                        case -1:
                            interCnt += str1Map.get(s);
                            sumCnt += str2Map.get(s);
                            break;
                        case 1:
                            interCnt += str2Map.get(s);
                            sumCnt += str1Map.get(s);
                            break;
                    }
                } else if (str1Cut.contains(s) && !str2Cut.contains(s)){
                    sumCnt += str1Map.get(s);
                } else {
                    sumCnt += str2Map.get(s);
                }
            }
        } else {
            interCnt = sumCnt = 1;
        }

        System.out.println(interCnt + " / " + sumCnt);
        // 65536 곱 & 소수점 아래 버림.
        answer = (int) Math.floor(((double) interCnt / (double) sumCnt) * 65536);

        return answer;
    }
}

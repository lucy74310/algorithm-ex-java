package com.bgjo.kakao.numberstringToNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NumberStringToNumber implements numstringToNumber {

    @Override
    public int solution(String s) {
        char[] part = s.toCharArray();
        String onlyString = "";
        String answer = "";
        for (int i = 0; i < part.length; i++) {
            try {
                Integer.valueOf(String.valueOf(part[i]));
            } catch (NumberFormatException e) {
                onlyString += part[i];
                if (replaceNumber.containsKey(onlyString)) {
                    answer += replaceNumber.get(onlyString);
                    onlyString = "";
                }
                continue;
            }
            answer += part[i];
        }

        return Integer.parseInt(answer);
    }
}

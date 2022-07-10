package com.bgjo.kakao.numberstringToNumber;

public class OtherSolution implements numstringToNumber {

    @Override
    public int solution(String s) {
        for (String numberString : replaceNumber.keySet()) {
            if (s.contains(numberString)) {
                s = s.replaceAll(numberString, String.valueOf(replaceNumber.get(numberString)));
            }
        }

        return Integer.parseInt(s);
    }
}

package com.bgjo;

import com.bgjo.kakao.keypad.KeyPad;
import com.bgjo.kakao.menuRenewal.MenuRenewal;
import com.bgjo.kakao.menuRenewal.MenuRenewalInterface;
import com.bgjo.kakao.newClustering.NewsClustering;
import com.bgjo.kakao.numberstringToNumber.NumberStringToNumber;
import com.bgjo.kakao.numberstringToNumber.OtherSolution;

public class Main {

    public static void main(String[] args) {
//        numberStringToNumber();
//        keyPad();
//        newsClustering();
        menuRenewal();
    }
    private static void numberStringToNumber() {
        NumberStringToNumber solution = new NumberStringToNumber();
        int result1 = solution.solution("one4seveneight");
        System.out.println(result1);

        OtherSolution otherSolution = new OtherSolution();
        int result2 = otherSolution.solution("one4seveneight");
        System.out.println(result2);
    }
    private static void keyPad() {
        KeyPad solution = new KeyPad();

    }

    private static void newsClustering() {
        NewsClustering solution = new NewsClustering();
//        solution.solution("FRANCE", "french");

//        solution.solution("aa1+aa2", "AAAA12");
        // handshake
//        solution.solution("handshake", "shake hands");
        int answer = solution.solution("abc", "abbb");
        System.out.println(answer);
    }

    private static void menuRenewal() {
        MenuRenewalInterface solution = new MenuRenewal();
        String[] solution1 = solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        //	["AC", "ACDE", "BCFG", "CDE"]

    }
}

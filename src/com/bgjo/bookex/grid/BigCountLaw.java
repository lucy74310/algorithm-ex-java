package com.bgjo.bookex.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BigCountLaw {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrLength = Integer.parseInt(st.nextToken());
        int plusCount = Integer.parseInt(st.nextToken());
        int repeatPossibleCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrLength; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        arr.sort(Comparator.reverseOrder());

        int repeatCount = 0;

        int sum = 0;

        for (int i = 0; i < plusCount; i++) {
            if (repeatCount < repeatPossibleCount) {
                sum += arr.get(0);
                repeatCount++;
            } else {
                sum += arr.get(1);
                repeatCount = 0;
            }
        }

        System.out.println(sum);
    }
}

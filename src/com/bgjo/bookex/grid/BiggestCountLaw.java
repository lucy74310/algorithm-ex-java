package com.bgjo.bookex.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 이것이 (취업을 위한) 코딩테스트다 > 2부 그리디 실전분제 2번 "큰 수의 법칙"
 *
 */
public class BiggestCountLaw {

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

//        int repeatCount = 0;
//
//        int sum = 0;
//
//        for (int i = 0; i < plusCount; i++) {
//            if (repeatCount < repeatPossibleCount) {
//                sum += arr.get(0);
//                repeatCount++;
//            } else {
//                sum += arr.get(1);
//                repeatCount = 0;
//            }
//        }
//
//        System.out.println(sum);
        /**
         * 위 풀이의 한계는 plusCount (문제에서의 M) 의 크기가 100 억 이상처럼 커지면 시간 초과 판정을 받을 것이라는 것이다.
         *
         * 책에서 준 해답은 반복되는 수열을 이용해서 구하는 것이다.
         *
         * (가장 큰수 * repeatPossibleCount) + 두번째 큰수 -> 이 수열이 반복되는데,
         * 이는  { plusCount(M) 을 (repeatPossibleCount(K) + 1 으로 나눈 몫) } + (나머지) ==> 이 결과(H라고 하자) 만큼 가장 큰 수가 곱해짐.
         * { plusCount(M) - (위 결과 (H))} * 두번째 큰수 ==> 이 결과 (J)
         *
         * H + J 가 최종 정답.
         */

        int firstNum = arr.get(0);
        int secondNum = arr.get(1);

        System.out.println(firstNum);
        System.out.println(secondNum);

//        int totalSequenceRepeatCount = plusCount / (repeatPossibleCount + 1);
        int totalSequenceRepeatCount = Math.floorDiv(plusCount, repeatPossibleCount + 1) ;
        int biggestNumRepeatCount = totalSequenceRepeatCount * repeatPossibleCount;
        int mod = Math.floorMod(plusCount, repeatPossibleCount + 1);
        biggestNumRepeatCount += mod;

        int sum = biggestNumRepeatCount * firstNum;
        sum += (plusCount - biggestNumRepeatCount) * secondNum;

        System.out.println(sum);

    }

}

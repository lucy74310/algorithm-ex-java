package com.bgjo.wanted.problem3;

import java.util.Scanner;

/**
 * 문제
 * 길이가 같은 정수 수열 $A = \{A_1, A_2, ..., A_N\}$와 $B = \{B_1, B_2, ..., B_N\}$가 주어진다.
 *
 *  $A_i + A_{i+1} + ... + A_j = B_i + B_{i+1} + ... + B_j$를 만족하는 양의 정수 $i, j ~(i \leq j)$쌍의 개수를 구해보자.
 *
 * 입력
 * 첫 번째 줄에 양의 정수 $N$이 주어진다.
 *
 * 두 번째 줄에 $A$를 나타내는 $N$개의 양의 정수 $A_i$가 $A_1$부터 $A_N$까지 순서대로, 공백으로 구분되어 주어진다.
 *
 * 세 번째 줄에 $B$를 나타내는 $N$개의 양의 정수 $B_i$가 $B_1$부터 $B_N$까지 순서대로, 공백으로 구분되어 주어진다.
 *
 * 출력
 *  $A_i + A_{i+1} + ... + A_j = B_i + B_{i+1} + ... + B_j$를 만족하는 양의 정수 $i, j ~(i \leq j)$쌍의 개수를 출력한다.
 *
 * 제한
 *  $1 \leq N \leq 2\cdot 10^5$ 
 *  $\lvert A \rvert = \lvert B \rvert = N$ 
 *  $1 \leq A_i,B_i \leq 10^4$ 
 * 예제 입력 1
 * 3
 * 1 2 3
 * 1 3 2
 * 예제 출력 1
 * 3
 *  $A = \{1, 2, 3\}$, $B = \{1, 3, 2\}$로, 조건을 만족하는 $i, j$ 쌍은 $(1, 1), (2, 3), (1, 3)$의 세 가지이다.
 *
 *  $A_1$ = $B_1 = 1$ 
 *  $A_2 + A_3 = B_2 + B_3 = 5$ 
 *  $A_1 + A_2 + A_3 = B_1 + B_2 + B_3 = 6$ 
 * 예제 입력 2
 * 5
 * 1 2 3 4 5
 * 4 5 6 7 8
 * 예제 출력 2
 * 0
 * 예제 입력 3
 * 6
 * 23 13 31 17 29 19
 * 23 13 31 17 29 19
 * 예제 출력 3
 * 21
 * 예제 입력 4
 * 3
 * 1 2 1
 * 1 1 1
 * 예제 출력 4
 * 2
 * 노트
 * 정답의 크기가 32비트 정수형 타입의 표현 범위를 초과할 수 있으므로 언어에 따라 적절한 정수형 데이터 타입을 이용해야 한다.
 *
 * Java: long, Long
 * Kotlin: Long
 * Swift: Int64
 * C, C++: long, long long
 *
 */
public class Main {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String firstLine, secondLine, thirdLine;
        firstLine = sc.nextLine();
        secondLine = sc.nextLine();
        thirdLine = sc.nextLine();

        firstLine = "3";
        secondLine = "1 2 3";
        thirdLine = "1 3 2";


        int count = Integer.valueOf(firstLine.trim());

//        for (int i = 1; i < )

    }

}

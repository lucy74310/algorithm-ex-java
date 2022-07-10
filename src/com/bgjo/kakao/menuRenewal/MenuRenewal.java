package com.bgjo.kakao.menuRenewal;

import java.util.*;
import java.util.Map.Entry;

public class MenuRenewal implements MenuRenewalInterface {
    Map<String, Integer> ordersCount = new HashMap<>();

    @Override
    public String[] solution(String[] orders, int[] course) {

        for (int i : course) {
            // i 는 조합 갯수
            // ordersCount 는 해당 조합이 몇번이나 들었는지.
            for (String orderFromOne : orders) {
                char[] onePersonOrders = orderFromOne.toCharArray();
                int length = onePersonOrders.length;
                combination(onePersonOrders, new boolean[length], 0, length, i);
            }
        }

        // 최소 2번 이상 주문된 조합
        // 그리고 거기서 가장 많이 주문된 조합.
        // Map<단품메뉴갯수, Map<코스구성>>
        Map<Integer, List<String>> combinationLengthCourse = new HashMap<>();

        // <단품메뉴갯수, 단품메뉴갯수에 일치하는 조합중 가장 많은 주문수 (갱신)>
        Map<Integer, Integer> courseMaxCount = new HashMap<>();

        Map<String, Integer> overTwo = new HashMap<>();
        for (Entry<String, Integer> comCount : ordersCount.entrySet()) {
            if (comCount.getValue() < 2) continue;
            overTwo.put(comCount.getKey(), comCount.getValue());
            int comLength = comCount.getKey().length();


            if (courseMaxCount.containsKey(comLength)) {
                Integer maxOrderCount = courseMaxCount.get(comLength);
                if (maxOrderCount == comCount.getValue()) { // 추가
                    List<String> courseList = combinationLengthCourse.get(comLength);
                    courseList.add(comCount.getKey());

                } else if (maxOrderCount < comCount.getValue()) { // 갱신
                    List<String> courseCombi = new ArrayList<>();
                    courseCombi.add(comCount.getKey());
                    combinationLengthCourse.put(comLength, courseCombi);
                    courseMaxCount.put(comLength, comCount.getValue());
                }
            } else { // 첫인자.
                courseMaxCount.put(comLength, comCount.getValue());
                List<String> courseCombi = new ArrayList<>();
                courseCombi.add(comCount.getKey());
                combinationLengthCourse.put(comLength, courseCombi);
            }
        }

        List<String> finalCourses = new ArrayList<>();
        for (Entry<Integer, List<String>> integerListEntry : combinationLengthCourse.entrySet()) {
            finalCourses.addAll(integerListEntry.getValue());
        }

        Collections.sort(finalCourses);
        String[] answer = {};
        answer = finalCourses.toArray(answer);

        return answer;
    }

    private void combination(char[] arr, boolean[] visited, int start, int length, int combinationLength) {
        if (combinationLength == 0) {
            putCombination(arr, visited, length);
            return;
        }

        for (int i = start; i < length; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, length, combinationLength - 1);
            visited[i] = false;
        }
    }

    private void putCombination(char[] arr, boolean[] visited, int length) {
        String comb = "";
        for (int c = 0; c < length; c++) {
            if (visited[c]) {
                comb += arr[c];
            }
        }

        // 알파벳순 정렬
        char[] chars = comb.toCharArray();
        Arrays.sort(chars);
        comb = new String(chars);

        if (ordersCount.containsKey(comb)) {
            ordersCount.put(comb, ordersCount.get(comb) + 1);
        } else {
            ordersCount.put(comb, 1);
        }
    }
}

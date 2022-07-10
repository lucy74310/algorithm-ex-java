package com.bgjo.wanted.problem2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * B번 - Drop 7
 * 시간 제한	메모리 제한
 * 1 초	512 MB
 * 문제
 * Drop7은 7×7 크기의 격자에서 진행하는 싱글 플레이어 게임이다. 처음에는 격자가 비어있고, 플레이어는 매 턴마다 1 이상 7 이하의 정수 하나가 적힌 공을 받아 7개의 열 중 한 곳에 떨어뜨려야 한다. 떨어뜨린 공은 이미 배치되어 있는 공 바로 위에 도달하거나 바닥 바로 위에 도달할 때까지 아래로 이동한다.
 *
 * 가로 방향으로 연속해서 놓여있는 공들을 "가로 방향 그룹", 세로 방향으로 연속해서 놓여있는 공들을 "세로 방향 그룹"이라고 하자. 공을 떨어뜨릴 때마다 공들의 그룹이 바뀔 수 있는데, 만약 크기가 $x$인 그룹에 $x$가 적힌 공이 있다면 그 공은 없어진다. 조건을 만족하는 공은 모두 동시에 없어진다. 공이 없어지면 위에 있던 공들이 아래로 내려가며, 공이 없어지는 이벤트는 연쇄적으로 발생한다. 단, 크기가 n인 그룹은 크기가 n-1인 그룹을 포함하지 않는다. 즉 그룹의 가장 끝에 위치한 공은 격자의 테두리 또는 빈 공간과 인접한다.
 *
 * 현재 격자의 상태와 이번에 떨어뜨려야 하는 공의 번호가 주어졌을 때, 공을 한 번 떨어뜨려서 최대한 많이 공을 없애보자.
 *
 * 입력
 * 첫째 줄부터 7개의 줄에 현재 격자의 상태가 주어진다. 공이 있는 칸은 공의 번호가 1부터 7까지의 숫자로 주어지며, 공이 없는 칸은 0으로 주어진다.
 *
 * 다음 줄에 떨어뜨릴 공의 번호가 주어진다.
 *
 * 게임 도중에 나타날 수 있는 상태만 입력으로 주어진다. 즉 격자의 첫 번째 줄은 모두 0이고, 공을 떨어뜨리기 전에 공이 없어지는 이벤트가 발생하지 않는 입력만 주어진다.
 *
 * 출력
 * 공을 떨어뜨렸을 때 격자에 남아있을 수 있는 공의 개수의 최솟값을 출력한다.
 *
 * 예제 입력 1
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 4 0 2 0
 * 0 0 0 5 0 6 0
 * 3 3 0 7 5 6 7
 * 3
 * 예제 출력 1
 * 0
 * 3번째 열에 놓으면 된다.
 *
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 4 0 2 0
 * 0 0 0 5 0 6 0
 * 3 3 3 7 5 6 7
 *
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 2 0
 * 0 0 0 4 0 6 0
 * 3 3 3 5 5 6 0
 *
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 4 0 2 0
 * 3 3 3 5 5 6 0
 *
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 4 0 0 0
 * 3 3 3 5 5 0 0
 *
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 3 3 3 4 0 0 0
 *
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 3 3 3 0 0 0 0
 *
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 *
 *
 *
 */
public class Main {

    private static int nowBallNumInt;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String nowBallNumber;

        List<List<String>> input = new ArrayList<>();
        List<List<Integer>> rowGroup = new ArrayList<>(); // 가로그룹
        List<List<Integer>> columnGroup = new ArrayList<>(); // 세로그룹

//        for (int i = 0; i < 5; i++) {
//            String line = sc.nextLine();
//            input.add(Arrays.asList(line.split("\\s+")));
//        }
//        String nowBallNumber = sc.nextLine();



        input.add(Arrays.asList("0 0 0 0 0 0 0".split("\\s+")));
        input.add(Arrays.asList("0 0 0 0 0 0 0".split("\\s+")));
        input.add(Arrays.asList("0 0 0 0 0 0 0".split("\\s+")));
        input.add(Arrays.asList("0 0 0 0 0 0 0".split("\\s+")));
        input.add(Arrays.asList("0 0 0 4 0 2 0".split("\\s+")));
        input.add(Arrays.asList("0 0 0 5 0 6 0".split("\\s+")));
        input.add(Arrays.asList("3 3 0 7 5 6 7".split("\\s+")));
        nowBallNumber = "3";
        nowBallNumInt = Integer.valueOf(nowBallNumber);
/**
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0
 * 0 0 0 4 0 2 0
 * 0 0 0 5 0 6 0
 * 3 3 0 7 5 6 7
 */

        Map<Integer, Integer> horizonCount = new HashMap<>();
        Map<Integer, Integer> verticalCount = new HashMap<>();

        Map<Integer, Map<Integer, Integer>> row = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> column = new HashMap<>();

        Map<Integer, Integer> verticalBallLocation = new HashMap<>();

        for (int i = 0; i < 7; i++) {


            Map<Integer, Integer> convertColumn = new HashMap<>();
            Map<Integer, Integer> rowAsInteger = new HashMap<>();

            int notZeroCountColumn = 0;
            int notZeroCountRow = 0;
            for (int j = 0; j < 7; j++) {
                int columnBallNum = Integer.valueOf(input.get(j).get(i));
                int rowBallNum = Integer.valueOf(input.get(i).get(j));

                convertColumn.put(j, columnBallNum);
                rowAsInteger.put(j, rowBallNum);

                if (columnBallNum > 0) {
                    if (!verticalBallLocation.containsKey(i))
                        verticalBallLocation.put(i, j);
                    notZeroCountColumn++;
                }
                if (rowBallNum > 0) {
                    notZeroCountColumn++;
                }
            }

            horizonCount.put(i, notZeroCountRow);
            verticalCount.put(i, notZeroCountColumn);

            column.put(i, convertColumn);
            row.put(i, rowAsInteger);
        }

        for (int i = 0; i < 7; i++) {
            System.out.println(row.get(i));
        }

        System.out.println(column);
        System.out.println(horizonCount);
        System.out.println(verticalCount);
        System.out.println(verticalBallLocation);

        // i : 떨어뜨리는 열.
        for (int i = 0; i < 7; i++) {

            // i 열에서 떨어진 row : ballLocation-1
            int ballLocation = verticalBallLocation.get(i);
            Map<Integer, Integer> oneColumn = column.get(i);
            oneColumn.put(ballLocation-1, nowBallNumInt);
            column.put(i, oneColumn);

            // ballLocation-1 row 에서 i 열에 떨어짐.
            Map<Integer, Integer> oneRow = row.get(ballLocation);
            oneRow.put(i, nowBallNumInt);
            row.put(ballLocation, oneRow);

            List<Map<Integer, Map<Integer, Integer>>> changedStatus = new ArrayList<>();
            changedStatus.add(0, column);
            changedStatus.add(1, row);

            List<Integer> checkColum = new ArrayList<>();
            List<Integer> checkRow = new ArrayList<>();
            checkColum.add(i);
            checkRow.add(ballLocation-1);

            deleteBall(changedStatus, checkColum, checkRow);





        }

        // i 열에 떨어뜨릴때 가로그룹 순회
        for (int k = 0; k < 7; k++) {
//            oneRow = row.get(k);
//
//            List<Integer> rr = oneRow.values().stream().collect(Collectors.toList());

//            int rowBallCount = (int) rr.stream().filter(x -> x > 0).count();


        }



    }

    private static List<Map<Integer, Map<Integer, Integer>>> deleteBall(List<Map<Integer, Map<Integer, Integer>>> changedStatus, List<Integer> checkColum, List<Integer> checkRow) {

        Map<Integer, Map<Integer, Integer>> column = changedStatus.get(0);
        Map<Integer, Map<Integer, Integer>> row = changedStatus.get(1);

        for (Integer index : checkColum) {
            doCheckColumn(index, column, row);
        }

        for (Integer index : checkRow) {
            doCheckRow(index, column, row);
        }



        List<Map<Integer, Map<Integer, Integer>>> returnStatus = new ArrayList<>();
        return returnStatus;
    }



    private static void doCheckColumn(Integer index, Map<Integer, Map<Integer, Integer>> column, Map<Integer, Map<Integer, Integer>> row) {
        Map<Integer, Integer> col = column.get(index);


    }

    private static void doCheckRow(Integer index, Map<Integer, Map<Integer, Integer>> column, Map<Integer, Map<Integer, Integer>> row) {
    }


}

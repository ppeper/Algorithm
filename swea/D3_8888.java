package swea;

import java.util.Arrays;
import java.util.Scanner;

class Person {
    int number, score, correct;

    public Person(int number, int score, int correct) {
        this.number = number;
        this.score = score;
        this.correct = correct;
    }
}

class D3_8888 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        sc.nextLine();
        for (int test_case = 1; test_case <= t; test_case++) {
            int N = Integer.parseInt(sc.next());
            int T = Integer.parseInt(sc.next());
            int P = Integer.parseInt(sc.next());
            sc.nextLine();
            int[][] info = new int[N][T];
            // 문제의 점수 배점
            int[] score = new int[T];
            // 결과 init
            initResultAndScore(info, score, sc);
            Person[] person = new Person[N];
            // 참가자 점수
            for (int i = 0; i < person.length; i++) {
                int[] result = info[i];
                person[i] = calculatePersonResult(result, score, i);
            }
            // 정렬
            Arrays.sort(person, (o1, o2) -> {
                if (o1.score == o2.score) {
                    // 맞은 개수 비교
                    if (o1.correct == o2.correct) {
                        return o1.number - o2.number;
                    }
                    return o2.correct - o1.correct;
                }
                return o2.score - o1.score;
            });
            // 출력
            for (int i = 0; i < person.length; i++) {
                if (person[i].number == P) {
                    System.out.println("#" + test_case + " " + person[i].score + " " + (i + 1));
                    break;
                }
            }
        }
    }

    private static Person calculatePersonResult(int[] result, int[] score, int number) {
        int correct = 0;
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                correct++;
                sum += score[i];
            }
        }
        return new Person(number + 1, sum, correct);
    }

    private static void initResultAndScore(int[][] info, int[] score, Scanner sc) {
        for (int i = 0; i < info.length; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < info[i].length; j++) {
                info[i][j] = Integer.parseInt(input[j]);
                if (info[i][j] == 0) {
                    score[j]++;
                }
            }
        }
    }
}

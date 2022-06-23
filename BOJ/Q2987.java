/*
  - 문제 : 블랙잭, 세수의 합이 M과 가까운 것을 출력
  - 등급 : B2
  - 문제 풀이 : Bruteforce
 */

import java.util.Scanner;

public class Q2987 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 숫자의 개수, 블랙잭 숫자
        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        int[] card = new int[n];

        for (int i =0; i < n; i++) {
            card[i] = sc.nextInt();
        }

        int sum = 0;
        int min = 300000;

        // 012, 013... 세 수의 핪을 구해 m과 가장 가까운 수룰 구한다.
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    sum = card[i]+card[j]+card[k];
                    if(sum <= m && m-sum < min) min = m-sum;
                }
            }
        }
        System.out.println(m-min);
    }
}

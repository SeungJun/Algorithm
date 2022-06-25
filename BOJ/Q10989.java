import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
  - 문제 : 오름차순으로 정렬
  - 등급 : B1
  - 문제 풀이 : 계수 정렬
 */
public class Q10989 {
    public static void main(String[] args) throws IOException {

        // 속도를 줄이기 위한 BufferedReader를 통해 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받을 숫자의 개수
        int n;
        n = Integer.parseInt(br.readLine());
        // 입력받은 숫자를 저장할 배열
        int[] arr = new int[n];

        // n만큼의 정수 입력
        for (int i =0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // Arrays 메소드를 이용하여 오름차순으로 정렬
        int[] check = new int[10001];

        for(int i = 0; i < n; i++) {
            check[arr[i]] += 1;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < check.length; i++){
            for(int j = 0; j < check[i]; j++){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}

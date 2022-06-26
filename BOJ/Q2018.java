import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
  - 문제 : 통계학, 산술평균, 정렬, 최빈값, 중앙값
  - 등급 : S3
  - 문제 풀이 : 정렬
 */
public class Q2018 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int am;
        int mid;
        int mod;
        int ran;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int [n];
        int sum = 0;
        // 배열 입력 및 평균을 구하기 위한 배열의 합 구하기
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 오름 차순으로 정렬
        Arrays.sort(arr);
        // 평균을 구하기 위한값
        // 음수일 경우 반올림이 제대로 되지 않을수 있어 경우 나누기
        float temp;
        if(sum < 0) {
            sum = sum *-1;
            temp = (float)sum / n;
            am = -1 * Math.round(temp);
        }
        else {
            temp = (float) sum/n;
            am = Math.round(temp);

        }
        // 중간값 구하기
        mid = arr[n/2];

        // 각 값을 count 하여 최빈 값을 구한다.
        int[] check = new int[8001];

        // -4000 + 4000 의 범위 이므로 0~8000 까지의 배열을 이용
        for(int i = 0; i < n; i++) {
             check[arr[i]+4000] += 1;
        }
        int max = check[0];
        // 최빈값의 개수를 구한다
        for (int i = 0; i < 8001; i++) {
            if(max <= check[i]) {
                max = check[i];
            }
            }
        // 두번째로 작은 최빈값을 찾아야 하기 때문에
        // 첫번째 최빈값을 기점으로 다음 최빈값을 저장해준다.
        boolean flag = false;
        mod = 0;
        for(int i = 0; i < 8001; i++){
           if(max == check[i] && flag == false) {
               flag = true;
               mod = i -4000;
           }
           else if(max == check[i] && flag == true) {
               mod = i-4000;
               break;
           }
        }

        // 범위 최대값 - 최소값
        ran = arr[n-1] - arr[0];

        StringBuilder sb = new StringBuilder();
        sb.append(am).append('\n').append(mid).append('\n').append(mod).append('\n').append(ran);

        System.out.println(sb);

    }

    }


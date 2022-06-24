import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
  - 문제 : 체스판 채우기, 사각형을 입력받아 8*8의 정사각형 체스판을 만든다
  - 등급 : S4
  - 문제 풀이 : Bruteforce
 */
public class Q1018 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 사각형의 가로 세로
        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        char[][] rec;
        rec = new char[n][m];
        String[] temp = new String[n];

        for (int i = 0; i < n; i++) {
                temp[i] = sc.next();
        }
        for(int i = 0; i < n; i++){
            rec[i] = temp[i].toCharArray();
        }
        int min = 25000;
        for(int i = 0; i < n-7; i++){
            for(int j = 0; j <m-7; j++){
                int result = checkNew(rec,i,j);
                if(min > result) min = result;
            }
        }
        System.out.println(min);

    }

    public static int checkNew(char[][] a,int c, int l)
    {
        int count = 0;
        for (int i=c; i < c+8; i++) {
            for (int j = l; j < l+8; j++) {
                if((i+j) %2 == 0 ){
                    if(a[i][j] != 'B')  count++;
                }
                else {
                    if(a[i][j] !='W') count ++;
                }
            }

        }
        return Math.min(count, 64-count);
    }
}


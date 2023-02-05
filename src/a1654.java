import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class a1654 {

    static ArrayList<Long> list = new ArrayList<Long>();

    static long parametric_search(int N) {
        long mid = 0;
        long start = 1; //항상 정수로만 자른다..
        long end = list.get(list.size() - 1);

        //필요한 랜선의 개수가 N개니깐 N개 이상을 만들수 있는 수중 가장 큰 수를 return 해야한다.
        int cnt = 0;
        long maxLength = Long.MIN_VALUE;
        while(start <= end) {
            mid = (start + end) / 2;
            cnt = 0;

            for(int i = 0; i < list.size(); i++) {
                cnt += (list.get(i)/mid);
            }

            if(cnt >= N) {
                if(mid >= maxLength) {
                    maxLength = mid;
                }
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return maxLength;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken()); //이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수

        for(int i = 0; i < K; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(list);

        System.out.println(parametric_search(N));
    }
}

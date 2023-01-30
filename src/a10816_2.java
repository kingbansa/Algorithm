import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class a10816_2 {
    //lower bound와 upper bound 사용
    static ArrayList<Integer> list = new ArrayList<>();

    public static int lower_bound(int k) {
        int mid = 0;
        int start = 0;
        int end = list.size();

        while(start < end) {
           mid = (start + end) / 2;

           if(list.get(mid) >= k) {
               end = mid;
           }
           else {
               start = mid + 1;
           }
        }

        return start;
    }

    public static int upper_bound(int k) {
        int mid = 0;
        int start = 0;
        int end = list.size();

        while(start < end) {
            mid = (start + end ) / 2;

            if(list.get(mid) <= k) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return start;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            int start = lower_bound(n);
            int end = upper_bound(n);

            if(end - start > 0) {
                sb.append(end-start + " ");
            }
            else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }
}

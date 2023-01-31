import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class a18870 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static int BinarySearch(int left, int right, int M) {
        int mid;

        while(left <= right) {
            mid = (left + right) / 2;

            if(list.get(mid) > M) {
                right = mid - 1;
            }
            else if(list.get(mid) < M) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        str = br.readLine();
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()) {
            N = Integer.parseInt(st.nextToken());
            if(!set.contains(N)) {
                set.add(N);
                list.add(N);
            }
        }

        Collections.sort(list);

        st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            N = Integer.parseInt(st.nextToken());
            int M = BinarySearch(0, list.size() - 1, N);
            int cnt = 0;

            for(int i = M - 1; i >= 0; i--) {
                cnt += 1;
            }

            sb.append(cnt + " ");
        }

        System.out.println(sb);
    }
}
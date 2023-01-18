import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a1920 {
    static int[] arr;

    public static int binary_search(int startIdx, int endIdx, int n) {

        int mid = 0;

        while(startIdx <= endIdx) {
            mid = (startIdx + endIdx) / 2;

            if(arr[mid] > n) {
                endIdx = mid - 1;
            }
            else if(arr[mid] < n) {
                startIdx = mid + 1;
            }
            else { //찾았을 때
                return 1;
            }
        }

        //못 찾았을 때
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int N = Integer.parseInt(str);
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i = 0;
        while(st.hasMoreElements()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        str = br.readLine();
        int M = Integer.parseInt(str);

        st = new StringTokenizer(br.readLine(), " ");
        i = 0;
        int result = 0;
        while(st.hasMoreElements()) {
            result = binary_search(0, N-1, Integer.parseInt(st.nextToken()));
            System.out.println(result + " ");
        }
    }
}

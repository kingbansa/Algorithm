import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class a18870_2 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static int lower_bound(int n) {
        int mid = 0;
        int start = 0;
        int end = list.size();

        while(start < end) {
            mid = (start + end) / 2;

            if (n <= list.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> tempList = new ArrayList<>();
        ArrayList<Integer> initList = new ArrayList<>();
        while(st.hasMoreElements()) {
            int n = Integer.parseInt(st.nextToken());
            if(!map.containsKey(n)) {
                list.add(n);
                initList.add(n);
                map.put(n, 0);
            }
            tempList.add(n);
        }

        Collections.sort(list);

        for(int i = 0; i < initList.size(); i++) {
            int n = initList.get(i);
            map.replace(n, lower_bound(n));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tempList.size(); i++) {
            sb.append(map.get(tempList.get(i)) + " ");
        }

        System.out.println(sb);
    }
}

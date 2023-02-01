import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class a2295 {

    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> sumList = new ArrayList<>();

    public static int binary_search(int n) {
        int mid = 0;
        int start = 0;
        int end = sumList.size()-1;

        while(start <= end) {
            mid = (start + end) / 2;

            if(sumList.get(mid) > n) {
                end = mid - 1;
            }
            else if(sumList.get(mid) < n) {
                start = mid + 1;
            }
            else {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            for(int j = i; j < list.size(); j++) {
                sumList.add(list.get(i) + list.get(j));
            }
        }

        Collections.sort(sumList);
        
        //sumList에 값이 있는지 확인해야함
        for(int i = list.size()-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                int result = binary_search(list.get(i) - list.get(j));
                if(result != -1) { //가장 큰 수를 찾은거니깐 찾으면 바로 종료
                    System.out.println(list.get(i));
                    return;
                }
            }
        }
    }
}

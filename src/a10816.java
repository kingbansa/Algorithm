import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a10816 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //중복된 값을 찾으면 list에서 지워졌기때문에 못찾겠지?
        int[] visited = new int[20000004]; // 1~10000000, 0 --> 10000001, -1 ~ -10000000 --> 10000002~20000002
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = 0;
        while(st.hasMoreTokens()) {
            n = Integer.parseInt(st.nextToken());
            //중복된 숫자라면 이미 visited에 값이 있을테니 pass
            if(n == 0 && visited[10000001] != 0) {
                visited[10000001] += 1;
                continue;
            }
            else if(n > 0 && visited[n] != 0) {
                visited[n] += 1;
                continue;
            }
            else if(n < 0 && visited[10000001 + (n*-1)] != 0) {
                visited[10000001 + (n*-1)] += 1;
                continue;
            }
            else {
                if(n == 0) {
                    visited[10000001] += 1;
                }
                else if(n > 0) {
                    visited[n] += 1;
                }
                else if(n < 0) {
                    visited[10000001 + (n*-1)] += 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            n = Integer.parseInt(st.nextToken());
            if(n == 0 && visited[10000001] != 0)
                sb.append(visited[10000001] + " ");
            else if(n > 0 && visited[n] != 0)
                sb.append(visited[n] + " ");
            else if(n < 0 && visited[10000001 + (n*-1)] != 0)
                sb.append(visited[10000001 + (n*-1)] + " ");
            else
                sb.append(0 + " ");
        }

        System.out.println(sb);
    }
}
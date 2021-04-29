package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/2164">카드2</a>
 */
public class P02146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        if(n % 2 == 1) {
            queue.offer(n);
        }

        for(int i = 2; i <= n; i += 2) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                break;
            }

            queue.remove();
            queue.offer(queue.poll());
        }

        System.out.println(queue.peek());
    }
}
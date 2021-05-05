package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a href="boj.kr/18258">큐2</a>
 */
public class P18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<String> queue = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        String temp;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    queue.offer(st.nextToken());
                    break;
                case "pop":
                    temp = queue.poll();
                    sb.append(temp != null ? temp : "-1").append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    sb.append(queue.peek() != null ? queue.peek() : "-1").append("\n");
                    break;
                case "back":
                    sb.append(queue.peekLast() != null ? queue.getLast() : "-1").append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
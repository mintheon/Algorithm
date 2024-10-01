package baekjoon;

import java.util.*;

public class P01966 {
    public void solution() {
        Scanner input = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();
        int repeatCount, n, m;
        int selectedIdx, outSequence = 0;
        repeatCount = input.nextInt();

        for(int i = 0; i < repeatCount; i++) {
            n = input.nextInt();
            m = input.nextInt();
            selectedIdx = m;
            for(int j = 0; j < n; j++) {
                queue.offer(input.nextInt());
            }

            while(true) {
                int maxNum = Collections.max(queue);

                while(!(queue.peek() == maxNum)) {
                    queue.offer(queue.poll());
                    selectedIdx = selectedIdx == 0
                            ? queue.size() - 1
                            : selectedIdx - 1;
                }

                queue.poll();
                outSequence++;

                if(selectedIdx == 0) {
                    System.out.println(outSequence);
                    break;
                } else {
                    selectedIdx--;
                }
            }

            queue.clear();
            outSequence = 0;
        }
    }
}
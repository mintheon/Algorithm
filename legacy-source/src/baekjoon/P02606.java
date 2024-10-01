package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ComputerBfs {
    private int n;
    private int map[][];
    private boolean visitedArr[];
    private Queue<Integer> queue;
    private int virusCount;

    public ComputerBfs(int n) {
        this.n = n;
        map = new int[n + 1][n + 1];
        visitedArr = new boolean[n + 1];
        queue = new LinkedList<>();
        virusCount = 0;
    }

    public void addEdge(int x, int y) {
        map[x][y] = map[y][x] = 1;
    }

    public void search(int idx) {
        int temp;

        queue.add(idx);
        visitedArr[idx] = true;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            virusCount++;

            for (int i = 1; i <= n; i++) {
                if (map[temp][i] == 1 && !visitedArr[i]) {
                    queue.add(i);
                    visitedArr[i] = true;
                }
            }
        }
    }

    public void printVirusCount() {
        System.out.println(virusCount - 1);
    }
}

class ComputerDfs {
    private int n;
    private int map[][];
    private boolean visitedArr[];
    private int virusCount;

    public ComputerDfs(int n) {
        this.n = n;
        this.map = new int[n + 1][n + 1];
        this.visitedArr = new boolean[n + 1];
        this.virusCount = 0;
    }

    public void addEdge(int x, int y) {
        this.map[x][y] = this.map[y][x] = 1;
    }

    public void search(int idx) {
        this.visitedArr[idx] = true;
        virusCount++;

        for(int i = 1; i <= this.n; i++) {
            if(map[idx][i] == 1 && !visitedArr[i]) {
                search(i);
            }
        }
    }

    public void printVirusCount() {
        System.out.println(virusCount - 1);
    }
}

public class P02606 {
    public void solution() {
        int computerCount;
        int connectedEdge;

        Scanner input = new Scanner(System.in);
        computerCount = input.nextInt();
        connectedEdge = input.nextInt();

        ComputerBfs bfs = new ComputerBfs(computerCount);

        for(int i = 0; i < connectedEdge; i++) {
            bfs.addEdge(input.nextInt(), input.nextInt());
        }

        bfs.search(1);
        bfs.printVirusCount();
    }
}
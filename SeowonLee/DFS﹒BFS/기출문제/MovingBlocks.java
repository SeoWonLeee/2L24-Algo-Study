package DFS_BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MovingBlocks {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class State {
        Pair a, b;

        State(Pair a, Pair b) {
            this.a = a;
            this.b = b;
        }
    }

    // 주어진 좌표가 보드 내에 유효한지 확인
    static boolean isValid(Pair p, int[][] board) {
        int n = board.length;
        return p.x >= 0 && p.x < n && p.y >= 0 && p.y < n && board[p.x][p.y] == 0;
    }

    static Set<State> getNextStates(State state, int[][] board) {
        Set<State> nextStates = new HashSet<>();
        Pair a = state.a;
        Pair b = state.b;
        Pair[] directions = {new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1)};

        // 상하좌우 이동
        for (Pair dir : directions) {
            Pair aNext = new Pair(a.x + dir.x, a.y + dir.y);
            Pair bNext = new Pair(b.x + dir.x, b.y + dir.y);
            if (isValid(aNext, board) && isValid(bNext, board)) {
                nextStates.add(new State(aNext, bNext));
            }
        }

        // 두 블록이 같은 행에 있는 경우 회전 가능한 상태 추가
        if (a.x == b.x) {
            for (int i = -1; i <= 1; i += 2) {
                Pair aRotate = new Pair(a.x + i, a.y);
                Pair bRotate = new Pair(b.x + i, b.y);
                if (isValid(aRotate, board) && isValid(bRotate, board)) {
                    nextStates.add(new State(aRotate, a));
                    nextStates.add(new State(bRotate, b));
                }
            }
        }
        // 두 블록이 같은 열에 있는 경우 회전 가능한 상태 추가
        else if (a.y == b.y) {
            for (int i = -1; i <= 1; i += 2) {
                Pair aRotate = new Pair(a.x, a.y + i);
                Pair bRotate = new Pair(b.x, b.y + i);
                if (isValid(aRotate, board) && isValid(bRotate, board)) {
                    nextStates.add(new State(aRotate, a));
                    nextStates.add(new State(bRotate, b));
                }
            }
        }

        return nextStates;
    }

    // 보드에서 블록을 움직여 목적지까지 이동하는 최소 횟수
    public static int solution(int[][] board) {
        int n = board.length;
        boolean[][][][] visited = new boolean[n][n][n][n];
        Queue<State> queue = new ArrayDeque<>();
        Pair startA = new Pair(0, 0);
        Pair startB = new Pair(0, 1);
        State startState = new State(startA, startB);
        queue.offer(startState);
        visited[startA.x][startA.y][startB.x][startB.y] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State currentState = queue.poll();
                Pair a = currentState.a;
                Pair b = currentState.b;
                if ((a.x == n - 1 && a.y == n - 1) || (b.x == n - 1 && b.y == n - 1)) {
                    return level;
                }
                for (State nextState : getNextStates(currentState, board)) {
                    Pair nextA = nextState.a;
                    Pair nextB = nextState.b;
                    if (!visited[nextA.x][nextA.y][nextB.x][nextB.y]) {
                        visited[nextA.x][nextA.y][nextB.x][nextB.y] = true;
                        queue.offer(nextState);
                    }
                }
            }
            level++;
        }

        return -1; // 목적지까지 도달할 수 없는 경우
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] line = scanner.nextLine().split(",");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j].trim());
            }
        }
        System.out.println(solution(board));
    }
}

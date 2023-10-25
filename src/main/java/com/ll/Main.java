package com.ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    static int[] x_move = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[] y_move = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] visit;
    static int l;
    static int x;
    static int y;
    static int xd;
    static int yd;
    static Queue<Integer[]> q = new LinkedList<>();

    static void bfs() {
        visit[x][y] = 1;
        move(x, y, 1);
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            move(poll[0], poll[1], poll[2]);
        }
    }

    static void move(int x_in, int y_in, int cnt) {
        if (visit[xd][yd] != 0) return;
        for (int i = 0; i < 8; i++) {
            int x = x_in + x_move[i];
            int y = y_in + y_move[i];
            if (x >= 0 && x < l && y >= 0 && y < l) {
                if (visit[x][y] == 0) {
                    visit[x][y] = cnt + 1;
                    q.add(new Integer[]{x, y, cnt + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            visit = new int[l][l];
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            xd = Integer.parseInt(st.nextToken());
            yd = Integer.parseInt(st.nextToken());
            bfs();
            sb.append(visit[xd][yd] - 1).append("\n");
        }
        System.out.println(sb);
    }
}



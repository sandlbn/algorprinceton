/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prinston15;

import java.util.Random;

/**
 * @author sand
 */

public class QuickUnionWeighted {
    private int[] id;
    private int[] sz;

    public QuickUnionWeighted(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (j == i) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        int N = 10;
        QuickUnionWeighted qu = new QuickUnionWeighted(N);
        for (int i = 0; i < 6; i++) {
            Random generator = new Random();
            int p = generator.nextInt(10);
            int q = generator.nextInt(10);
            if (qu.connected(p, q)) continue;
            qu.union(p, q);
            StdOut.print("(" + p + "," + q + ")");
            for (int j = 0; j < qu.id.length; j++) {
                StdOut.print(qu.id[j] + ", ");
            }
            StdOut.println();
            for (int j = 0; j < qu.sz.length; j++) {
                StdOut.print(qu.sz[j] + ", ");
            }
            StdOut.println();

        }
        for (int j = 0; j < qu.id.length; j++) {
            StdOut.print(qu.id[j] + ", ");
        }
    }

}

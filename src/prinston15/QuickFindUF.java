/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prinston15;

import java.util.Random;

/**
 *
 * @author sand
 */

public class QuickFindUF {
    private int[] id;
    private int count;
    
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
    }
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
        count--;
            
    }
    
    public int count() {
        return count;
    }
    
    public int find(int p) {
        return id[p];
    }
    
    public static void main(String[] args) {
        int N = 30;
        QuickFindUF uf = new QuickFindUF(N);
        int F = 30;
        for (int i=0; i<F; i++) {
            Random generator = new Random();
            int p = generator.nextInt(9);
            StdOut.println(p);
            int q = generator.nextInt(9);
            StdOut.println(q);

            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count + " components.");
    }
}

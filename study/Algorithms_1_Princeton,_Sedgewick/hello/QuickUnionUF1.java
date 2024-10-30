/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class QuickUnionUF1 {
    private int[] id;

    public QuickUnionUF1(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        if (id[p] == id[q])
            return;
        if (id[p] == p) {
            id[q] = p;
            return;
        }
        if (id[q] == q) {
            id[p] = q;
            return;
        }
        id[p] = root(q);


    }

    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }

    public static void main(String[] args) {
        int length = StdIn.readInt();
        QuickFindUF1 quickF = new QuickFindUF1(length);

        int p = 0;
        int q = 0;
        while (!StdIn.isEmpty()) {
            p = StdIn.readInt();
            q = StdIn.readInt();
            quickF.union(p, q);
        }
        p = 3;
        q = 5;
        System.out.println(" p and q:" + p + " " + q + " are connected:" + quickF.connected(p, q));

        p = 5;
        q = 1;
        System.out.println(" p and q:" + p + " " + q + " are connected:" + quickF.connected(p, q));

        p = 1;
        q = 8;
        System.out.println(" p and q:" + p + " " + q + " are connected:" + quickF.connected(p, q));

    }
}

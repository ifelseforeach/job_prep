import edu.princeton.cs.algs4.StdIn;

public class QuickFindUF1 {
    private int[] id;

    public QuickFindUF1(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        if (id[p] != id[q]) {
            int oldP = id[p];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == oldP)
                    id[i] = id[q];
            }
        }
    }

    public boolean connected(int p, int q) {
        return (id[p] == id[q]);
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

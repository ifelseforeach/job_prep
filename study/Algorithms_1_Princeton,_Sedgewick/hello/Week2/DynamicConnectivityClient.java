package Week2;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.UF;

public class DynamicConnectivityClient {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int p = 0;
        int q = 0;

        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            p = StdIn.readInt();
            q = StdIn.readInt();
            if (!uf.connected(p, q))
                uf.union(p, q);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("0 is connected to " + i + ":" + uf.connected(0, i));
        }
    }
}

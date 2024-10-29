/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {

        int counter = 1;
        String champion = null;
        String word = null;
       /* if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                word = args[i];
                double p = (double) 1 / counter;
                boolean rand = StdRandom.bernoulli(p);
                if (rand)
                    champion = word;
                counter++;
            }
        }
        else {*/
        while (!StdIn.isEmpty()) {
            word = StdIn.readString();
            double p = (double) 1 / counter;
            boolean rand = StdRandom.bernoulli(p);
            if (rand)
                champion = word;
            counter++;
            continue;
        }
        //}
        System.out.println(champion);
    }
}

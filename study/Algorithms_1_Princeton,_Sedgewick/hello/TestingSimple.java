/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TestingSimple {
    public static void main(String[] args) {
        int n = 4;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                int p = row * n + col + 1;
                System.out.print("For [" + row + ", " + col + "] p=" + p + " ");
            }
            System.out.println();
        }
    }
}

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Percolation {
    private int[][] id = null;
    private boolean[][] isOpen = null;
    private int n = 0;
    private int numberOfOpenSites = 0;
    private boolean isPercolated = false;
    private int top = 0;
    private int bottom = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        this.bottom = n * n + 1;
        int counter = 0;
        id = new int[n][n];
        isOpen = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                counter++;
                // top virtual
                if (i == 0) {
                    id[0][j] = top;
                    continue;
                }
                // bottom virtual
                if (i == n - 1) {
                    id[i][j] = bottom;
                    continue;
                }
                // all others
                id[i][j] = counter;

            }
        }
        // test
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen[row][col])
            return;
        numberOfOpenSites++;
        isOpen[row][col] = true;

        // checking neighbours:
        // left
        int parentWithTop = isTopConnected(row, col) ? id[row][col] : 0;
        int parentWithBottom = isBottomConnected(row, col) ? id[row][col] : 0;
        if (row != 0 && isOpen[row - 1][col]) {
            System.out.println("L");
            if (isTopConnected(row - 1, col))
                parentWithTop = id[row - 1][col];
            if (isBottomConnected(row - 1, col))
                parentWithBottom = id[row - 1][col];
            // setNewRoot(row - 1, col, row, col);
        }
        // right
        if (row < this.n - 1 && isOpen[row + 1][col]) {
            System.out.println("R");
            if (isTopConnected(row + 1, col))
                parentWithTop = id[row + 1][col];
            if (isBottomConnected(row + 1, col))
                parentWithBottom = id[row + 1][col];
            // setNewRoot(row, col, row + 1, col);
        }
        if (col != 0 && isOpen[row][col - 1]) {
            System.out.println("T");
            if (isTopConnected(row, col - 1))
                parentWithTop = id[row][col - 1];
            if (isBottomConnected(row, col - 1))
                parentWithBottom = [row][col - 1];
            // setNewRoot(row, col - 1, row, col);
        }
        if (col < this.n - 1 && isOpen[row][col + 1]) {
            System.out.println("B");
            if (isTopConnected(row, col + 1))
                parentWithTop = id[row][col + 1];
            if (isBottomConnected(row, col + 1))
                parentWithBottom = id[row][col + 1];
            // setNewRoot(row, col, row, col + 1);
        }

        if (parentWithTop!=0 && parentWithBottom!=0)
            this.isPercolated = true;
        // if (isTop)


    }

    private void setNewRoot(int row1, int col1, int row2, int col2) {
        int root1 = findRoot(row1, col1);
        int root2 = findRoot(row2, col2);
        if (root1 == root2)
            return;
        if ((root1 == top && root2 == bottom) || (root1 == bottom && root2 == top))
            this.isPercolated = true;
        else if (root1 == top || root1 == bottom)
            this.id[row2][col2] = this.id[row1][col1];
        else
            this.id[row1][col1] = this.id[row2][col2];

    }

    private int findRowById(int p) {
        int i = 0;
        if (p % n == 0)
            i = p / n - 1;
        else
            i = p / n;
        return i;

    }

    private int findColbyId(int p) {
        int j = 0;
        if (p % n == 0)
            j = 3;
        else
            j = p % n - 1;
        return j;
    }

    private int findIdByRowAndCol(int row, int col) {
        int p = 0;
        p = row * this.n + col + 1;
        return p;
    }

    private int findRoot(int row, int col) {

        while (id[row][col] != top || id[row][col] != bottom || id[row][col] == findIdByRowAndCol(
                row, col)) {
            row = findRowById(id[row][col]);
            col = findColbyId(id[row][col]);
        }
        return id[row][col];
    }

    private boolean isTopConnected(int row, int col) {
        return findRoot(row, col) == this.top;
    }

    private boolean isBottomConnected(int row, int col) {
        return findRoot(row, col) == this.bottom;
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return isOpen(row, col);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        // test
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return this.isPercolated;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation perc = new Percolation(3);

        perc.open(0, 0);
        System.out.println("Is percolated: " + perc.isPercolated);
        perc.idToString();
        perc.isOpenToString();

        perc.open(1, 1);
        System.out.println("Is percolated: " + perc.isPercolated);
        perc.idToString();
        perc.isOpenToString();

        perc.open(1, 2);
        System.out.println("Is percolated: " + perc.isPercolated);
        perc.idToString();
        perc.isOpenToString();

        perc.open(2, 2);
        System.out.println("Is percolated: " + perc.isPercolated);
        perc.idToString();
        perc.isOpenToString();

        perc.open(1, 0);
        System.out.println("Is percolated: " + perc.isPercolated);
        perc.idToString();
        perc.isOpenToString();


    }

    private void idToString() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(" " + id[i][j]);
            }
            System.out.println(" ");
        }
    }

    private void isOpenToString() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(" " + isOpen[i][j]);
            }
            System.out.println(" ");
        }
    }

}

import java.util.Arrays;
public class test {
    public static void main(String[] args) {
        int mSide = Integer.parseInt(args[0]);
        int nSide = Integer.parseInt(args[1]);
        int Mines = Integer.parseInt(args[2]);
        int[][] numMines = new int[mSide + 2][nSide + 2];
        boolean[][] isMines = new boolean[mSide + 2][nSide + 2];

        for (int k = 0; k < Mines; k++) {
            int x = (int) (Math.random() * mSide) + 1;
            int y = (int) (Math.random() * nSide) + 1;
            if (isMines[x][y]) {
                Mines = Mines + 1;
            } else {
                isMines[x][y] = true;
            }
        }

        for (int i = 1; i <= mSide; i++) {
            for (int j = 1; j <= nSide; j++) {
                int counter = 0;
                if (!isMines[i][j]) {
                    if (isMines[i][j - 1]) {
                        counter += 1;
                    } else if (isMines[i][j + 1]) {
                        counter += 1;
                    } else if (isMines[i + 1][j]) {
                        counter += 1;
                    } else if (isMines[i - 1][j]) {
                        counter += 1;
                    } else if (isMines[i - 1][j - 1]) {
                        counter += 1;
                    } else if (isMines[i + 1][j + 1]) {
                        counter += 1;
                    } else if (isMines[i - 1][j + 1]) {
                        counter += 1;
                    } else if (isMines[i + 1][j - 1]) {
                        counter += 1;
                    }
                    numMines[i][j] = counter;
                }
            }
        }

            for (int i = 1; i <= mSide; i++) {
                for (int j = 1; j <= nSide; j++) {
                    if (!isMines[i][j]) {
                        System.out.print(numMines[i][j] + "  ");
                    }
                    if (isMines[i][j]) {
                        System.out.print("*  ");
                    }

                }
                System.out.println();
            }
        }

    }


package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
    int countH = 0, countV = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) {
                for (int j = 1; j < board[i].length; j++) {
                    if (board[i][j] == 1) {
                       countH++;
                    }
                }
            }
        }
            for (int i = 0; i < board.length; i++) {
                    if (board[0][i] == 1) {
                        for (int j = 1; j < board.length; j++) {
                            if (board[j][i] == 1) {
                               countV++;
                            }
                        }
                    }
                }
        return ((countH == board.length - 1) || (countV == board.length - 1));
    }
}

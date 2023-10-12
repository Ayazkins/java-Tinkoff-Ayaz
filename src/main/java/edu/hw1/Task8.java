package edu.hw1;

import java.io.Console;

public final class Task8 {


    private final static int BOARD_SIZE = 8;
    private final static int HORSE = 1;
    private final static int[][] HELP = {
            {1, 2},
            {2, 1},
            {-1, 2},
            {2, -1},
            {1, -2},
            {-2, 1},
            {-2, -1},
            {-1, -2}
    };

    private Task8() {
    }

    public static boolean check(int pos1, int pos2) {
        return pos1 >= 0 && pos1 < BOARD_SIZE && pos2 >= 0 && pos2 < BOARD_SIZE;
    }

    public static boolean knightBoardCapture(int[][] board) {
        if (board.length != BOARD_SIZE) {
            return false;
        }
        for (int i = 0; i < BOARD_SIZE; ++i) {
            if (board[i].length != BOARD_SIZE) {
                return false;
            }
            for (int j = 0; j < BOARD_SIZE; ++j) {
                if (board[i][j] == HORSE) {
                    for (var t : HELP) {
                        int pos1 = i + t[0];
                        int pos2 = j + t[1];
                        if (check(pos1, pos2) && board[pos1][pos2] == HORSE) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

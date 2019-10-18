package com.carlosmanias.challenges.queens;

import com.carlosmanias.challenges.queens.domain.ChessBoard;

public class Application {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(4);
        String message = chessBoard.solve() ? "Board solved!!" : "No solutions found";
        System.out.println(message);
    }
}

package com.carlosmanias.challenges.queens;

import com.carlosmanias.challenges.queens.domain.ChessBoard;

public class Application {

    public static void main(final String[] args) {
        final ChessBoard chessBoard = new ChessBoard(8);
        final String message = chessBoard.solve() ? "Board solved!!" : "No solutions found";
        System.out.println(message);
        System.out.println(chessBoard.drawBoard());
    }
}

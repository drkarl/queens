package com.carlosmanias.challenges.queens.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ChessBoardTest {

    @Test
    public void shouldNotSolveBoardForNLessThan4(){
        int n = 3;
        ChessBoard chessBoard = new ChessBoard(n);
        assertFalse(chessBoard.solve());
    }

    @Test
    public void shouldSolveBoardForNEqualsOrGreaterThan4(){
        int n = 4;
        ChessBoard chessBoard = new ChessBoard(n);
        List<Queen> placedQueens = chessBoard.getPlacedQueens();
        assertTrue(chessBoard.solve());
        assertEquals(n, placedQueens.size());
        for (Queen queen: placedQueens){
            for (Queen anotherQueen : placedQueens) {
                if (!queen.equals(anotherQueen)) {
                    assertFalse(queen.canAttack(anotherQueen));
                    for (Queen thirdQueen : placedQueens) {
                        if (!queen.equals(thirdQueen) && !anotherQueen.equals(thirdQueen)) {
                            assertFalse(thirdQueen.formsLine(queen, anotherQueen));
                        }
                    }
                }
            }
        }
    }
}

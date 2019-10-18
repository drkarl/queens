/*
MIT License

Copyright (c) 2019 Carlos Manias

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
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

package com.carlosmanias.challenges.queens.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the Chess Board.
 * It contains the placed queens and can solve the n-queens problem recursively.
 */
@Data
public class ChessBoard {
    private int gridSize;
    private List<Queen> placedQueens;
    private Map<Double, Pair<Queen, Queen>> memoizedSlopes;
    private static final int MIN_BOARD_SIZE = 4;

    public ChessBoard(final int gridSize){
        this.gridSize = gridSize;
        this.placedQueens = new ArrayList<>();
        this.memoizedSlopes = new HashMap<>();
    }

    /**
     * This method places n Queens on a n x n Chess board.
     * If there is no solution it returns false.
     * For boards smaller than 4 x 4 there is no solution possible
     * because the Queens can attack all positions.
     * @return
     */
    public boolean solve(){
        return gridSize >= MIN_BOARD_SIZE && placeQueen(0);
    }

    /**
     * Generates a String representation of the Chess board
     * with the n queens placed in it.
     * @return
     */
    public String drawBoard(){
        int[][] board = new int[gridSize][gridSize];
        placedQueens.forEach(queen -> board[queen.getCol()][queen.getRow()] = 1);
        final StringBuilder sb = new StringBuilder();
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                if (board[i][j] == 1) {
                    sb.append("[Q] ");
                } else {
                    sb.append("[ ] ");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private boolean placeQueen(final int col) {
        if (placedQueens.size() == gridSize) {
            return true;
        }
        for (int row = 0; row < gridSize; row++) {
            final Queen newQueen = new Queen(col, row);
            if (isSafe(newQueen) && !formsLine(newQueen)) {
                placedQueens.add(newQueen);
                if (placeQueen(col + 1)) {
                    return true;
                }
                final Queen removedQueen = placedQueens.remove(placedQueens.size() - 1);
                memoizedSlopes.entrySet().removeIf(doublePairEntry -> findRemovedQueenMemoization(doublePairEntry, removedQueen));
            }
        }
        return false;
    }

    private boolean findRemovedQueenMemoization(final Map.Entry<Double, Pair<Queen, Queen>> entry, final Queen removedQueen) {
        final Pair<Queen, Queen> pairOfQueens = entry.getValue();
        return removedQueen.equals(pairOfQueens.getLeft()) || removedQueen.equals(pairOfQueens.getRight());
    }

    private boolean isSafe(final Queen newQueen) {
        return placedQueens.isEmpty() || placedQueens.stream().noneMatch(placedQueen -> placedQueen.canAttack(newQueen));
    }

    private boolean formsLine(final Queen newQueen) {
        for (final Queen queen : placedQueens) {
            final Double slope = queen.slope(newQueen);
            if (memoizedSlopes.containsKey(slope)) {
                final Pair<Queen, Queen> pairOfQueens = memoizedSlopes.get(slope);
                final boolean formsLine = newQueen.formsLine(pairOfQueens.getLeft(), pairOfQueens.getRight());
                if (!formsLine) {
                    memoizedSlopes.put(slope, Pair.of(queen, newQueen));
                }
                return formsLine;
            } else {
                memoizedSlopes.put(slope, Pair.of(queen, newQueen));
                return false;
            }
        }
        return false;
    }

}

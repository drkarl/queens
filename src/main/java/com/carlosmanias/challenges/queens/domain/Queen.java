package com.carlosmanias.challenges.queens.domain;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents a Queen.
 * It only contains the position coordinates as data
 * but it can perform checks in relation to other queens.
 */
@Builder
@Data
public class Queen {
    private int col;
    private int row;

    /**
     * Checks if these coordinates are diagonal to other coordinates
     * @param other
     * @return
     */
    public boolean isDiagonal(final Queen other){
        final int diffX = this.getCol() - other.getCol();
        final int diffY = this.getRow() - other.getRow();
        return Math.abs(diffX) == Math.abs(diffY);
    }

    /**
     * Checks if these coordinates are on the same column as other coordinates
     * @param other
     * @return
     */
    public boolean sameColumn(final Queen other){
        return other.getCol() == this.getCol();
    }

    /**
     * Checks if these coordinates are on the same row as other coordinates
     * @param other
     * @return
     */
    public boolean sameRow(final Queen other){
        return other.getRow() == this.getRow();
    }

    /**
     * Calculates the slope between two coordinates
     * @param other
     * @return
     */
    public double slope(final Queen other){
        return ((double)this.getRow() - (double)other.getRow()) / ((double)this.getCol() - (double)other.getCol());
    }

    /**
     * Check if these coordinates and other two coordinates
     * are on the same straight line
     * @param second
     * @param third
     * @return
     */
    public boolean formsLine(final Queen second, final Queen third){
        return this.slope(second) == second.slope(third);
    }

    /**
     * Checks whether this queen and another queen can attack each other
     * @param other
     * @return
     */
    public boolean canAttack(final Queen other){
        return this.sameColumn(other) ||
                this.sameRow(other) ||
                this.isDiagonal(other);
    }

}

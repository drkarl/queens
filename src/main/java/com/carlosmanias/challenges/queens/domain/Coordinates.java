package com.carlosmanias.challenges.queens.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Coordinates {
    private int x;
    private int y;

    /**
     * Checks if these coordinates are diagonal to other coordinates
     * @param other
     * @return
     */
    public boolean isDiagonal(final Coordinates other){
        final int diffX = this.getX() - other.getX();
        final int diffY = this.getY() - other.getY();
        return Math.abs(diffX) == Math.abs(diffY);
    }

    /**
     * Checks if these coordinates are on the same column as other coordinates
     * @param other
     * @return
     */
    public boolean sameColumn(final Coordinates other){
        return other.getX() == this.getX();
    }

    /**
     * Checks if these coordinates are on the same row as other coordinates
     * @param other
     * @return
     */
    public boolean sameRow(final Coordinates other){
        return other.getY() == this.getY();
    }

    /**
     * Calculates the slope between two coordinates
     * @param other
     * @return
     */
    public double slope(final Coordinates other){
        return ((double)this.getY() - (double)other.getY()) / ((double)this.getX() - (double)other.getX());
    }

    /**
     * Check if these coordinates and other two coordinates
     * are on the same straight line
     * @param second
     * @param third
     * @return
     */
    public boolean formsLine(final Coordinates second, final Coordinates third){
        return this.slope(second) == second.slope(third);
    }
}

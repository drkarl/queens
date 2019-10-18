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

import lombok.Builder;
import lombok.Value;

/**
 * This class represents a Queen.
 * It only contains the position coordinates as data
 * but it can perform checks in relation to other queens.
 */
@Builder
@Value
public class Queen {
    int col;
    int row;

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

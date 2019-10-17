package com.carlosmanias.challenges.queens.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Queen {

    private Coordinates coordinates;

    /**
     * Checks whether this queen and another queen can attack each other
     * @param other
     * @return
     */
    public boolean canAttack(final Queen other){
        final Coordinates otherCoordinates = other.getCoordinates();
        return this.coordinates.sameColumn(otherCoordinates) ||
                this.coordinates.sameRow(otherCoordinates) ||
                this.coordinates.isDiagonal(otherCoordinates);
    }

}

package com.carlosmanias.challenges.queens.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CoordinatesTest {

    @Test
    public void isColumnShouldFindTwoCoordinatesOnTheSameColumn() {
        final Coordinates one = Coordinates.builder()
                            .x(1)
                            .y(2)
                            .build();
        final Coordinates another = Coordinates.builder()
                            .x(1)
                            .y(5)
                            .build();

        assertTrue(one.sameColumn(another));
    }

    @Test
    public void isRowShouldFindTwoCoordinatesOnTheSameRow() {
        final Coordinates one = Coordinates.builder()
                .x(1)
                .y(2)
                .build();
        final Coordinates another = Coordinates.builder()
                .x(5)
                .y(2)
                .build();

        assertTrue(one.sameRow(another));
    }

    @Test
    public void isDiagonalShouldFindTwoCoordinatesOnTheSameDiagonal() {
        final Coordinates one = Coordinates.builder()
                .x(1)
                .y(2)
                .build();
        final Coordinates another = Coordinates.builder()
                .x(4)
                .y(5)
                .build();

        assertTrue(one.isDiagonal(another));
    }

    @Test
    public void formsLineShouldFindALineBetweenThreePoints() {
        final Coordinates first = Coordinates.builder()
                .x(1)
                .y(1)
                .build();
        final Coordinates second = Coordinates.builder()
                .x(3)
                .y(5)
                .build();
        final Coordinates third = Coordinates.builder()
                .x(5)
                .y(9)
                .build();

        assertTrue(first.formsLine(second, third));
    }

    @Test
    public void formsLineShouldFindThereIsNoLineBetweenThreePoints() {
        final Coordinates first = Coordinates.builder()
                .x(0)
                .y(1)
                .build();
        final Coordinates second = Coordinates.builder()
                .x(3)
                .y(5)
                .build();
        final Coordinates third = Coordinates.builder()
                .x(5)
                .y(9)
                .build();

        assertFalse(first.formsLine(second, third));
    }
}

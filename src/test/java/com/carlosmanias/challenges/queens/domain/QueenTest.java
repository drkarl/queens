package com.carlosmanias.challenges.queens.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class QueenTest {

    @Test
    public void isColumnShouldFindTwoCoordinatesOnTheSameColumn() {
        final Queen one = Queen.builder()
                .col(1)
                .row(2)
                .build();
        final Queen another = Queen.builder()
                .col(1)
                .row(5)
                .build();

        assertTrue(one.sameColumn(another));
    }

    @Test
    public void isRowShouldFindTwoCoordinatesOnTheSameRow() {
        final Queen one = Queen.builder()
                .col(1)
                .row(2)
                .build();
        final Queen another = Queen.builder()
                .col(5)
                .row(2)
                .build();

        assertTrue(one.sameRow(another));
    }

    @Test
    public void isDiagonalShouldFindTwoCoordinatesOnTheSameDiagonal() {
        final Queen one = Queen.builder()
                .col(1)
                .row(2)
                .build();
        final Queen another = Queen.builder()
                .col(4)
                .row(5)
                .build();

        assertTrue(one.isDiagonal(another));
    }

    @Test
    public void formsLineShouldFindALineBetweenThreePoints() {
        final Queen first = Queen.builder()
                .col(1)
                .row(1)
                .build();
        final Queen second = Queen.builder()
                .col(3)
                .row(5)
                .build();
        final Queen third = Queen.builder()
                .col(5)
                .row(9)
                .build();

        assertTrue(first.formsLine(second, third));
    }

    @Test
    public void formsLineShouldFindThereIsNoLineBetweenThreePoints() {
        final Queen first = Queen.builder()
                .col(0)
                .row(1)
                .build();
        final Queen second = Queen.builder()
                .col(3)
                .row(5)
                .build();
        final Queen third = Queen.builder()
                .col(5)
                .row(9)
                .build();

        assertFalse(first.formsLine(second, third));
    }

    @Test
    public void queenCanAttackIfOnSameRow(){
        final Queen one = Queen.builder()
                .col(1)
                .row(2)
                .build();
        final Queen another = Queen.builder()
                .col(5)
                .row(2)
                .build();

        assertTrue(one.canAttack(another));
    }

    @Test
    public void queenCanAttackIfOnSameColumn(){
        final Queen one = Queen.builder()
                .col(1)
                .row(2)
                .build();
        final Queen another = Queen.builder()
                .col(1)
                .row(5)
                .build();

        assertTrue(one.canAttack(another));
    }

    @Test
    public void queenCanAttackIfOnSameDiagonal(){
        final Queen one = Queen.builder()
                .col(1)
                .row(2)
                .build();
        final Queen another = Queen.builder()
                .col(4)
                .row(5)
                .build();

        assertTrue(one.canAttack(another));
    }

    @Test
    public void queenIsSafe(){
        final Queen one = Queen.builder()
                .col(0)
                .row(2)
                .build();
        final Queen another = Queen.builder()
                .col(4)
                .row(5)
                .build();

        assertFalse(one.canAttack(another));
    }

}

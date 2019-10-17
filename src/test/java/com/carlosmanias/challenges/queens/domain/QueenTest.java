package com.carlosmanias.challenges.queens.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class QueenTest {

    @Test
    public void queenCanAttackIfOnSameRow(){
        final Coordinates one = Coordinates.builder()
                .x(1)
                .y(2)
                .build();
        final Coordinates another = Coordinates.builder()
                .x(5)
                .y(2)
                .build();

        final Queen first = Queen.builder().coordinates(one).build();
        final Queen second = Queen.builder().coordinates(another).build();
        assertTrue(first.canAttack(second));
    }

    @Test
    public void queenCanAttackIfOnSameColumn(){
        final Coordinates one = Coordinates.builder()
                .x(1)
                .y(2)
                .build();
        final Coordinates another = Coordinates.builder()
                .x(1)
                .y(5)
                .build();

        final Queen first = Queen.builder().coordinates(one).build();
        final Queen second = Queen.builder().coordinates(another).build();
        assertTrue(first.canAttack(second));
    }

    @Test
    public void queenCanAttackIfOnSameDiagonal(){
        final Coordinates one = Coordinates.builder()
                .x(1)
                .y(2)
                .build();
        final Coordinates another = Coordinates.builder()
                .x(4)
                .y(5)
                .build();

        final Queen first = Queen.builder().coordinates(one).build();
        final Queen second = Queen.builder().coordinates(another).build();
        assertTrue(first.canAttack(second));
    }

    @Test
    public void queenIsSafe(){
        final Coordinates one = Coordinates.builder()
                .x(0)
                .y(2)
                .build();
        final Coordinates another = Coordinates.builder()
                .x(4)
                .y(5)
                .build();

        final Queen first = Queen.builder().coordinates(one).build();
        final Queen second = Queen.builder().coordinates(another).build();
        assertFalse(first.canAttack(second));
    }

}

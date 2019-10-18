package com.carlosmanias.challenges.queens.domain;

import lombok.Value;

/**
 * Generic Immutable 2-tuple
 * @param <L>
 * @param <R>
 */
@Value(staticConstructor = "of")
public class Pair<L, R> {
    L left;
    R right;
}

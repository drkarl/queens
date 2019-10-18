package com.carlosmanias.challenges.queens.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Pair<L, R> {
    L left;
    R right;
}

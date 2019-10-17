package com.carlosmanias.challenges.queens.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ChessBoard {
    private int n;
    private List<Queen> placedQueens;
}

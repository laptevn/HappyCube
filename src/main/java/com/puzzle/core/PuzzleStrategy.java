package com.puzzle.core;

/**
 * Defines puzzle solving strategy
 */
public interface PuzzleStrategy {
    boolean match(Piece piece);
    boolean isFinished();
    void rollback();
    String getResult();
}
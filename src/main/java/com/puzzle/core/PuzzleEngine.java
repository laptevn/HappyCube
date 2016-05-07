package com.puzzle.core;

import com.puzzle.utils.CollectionUtils;

import java.util.List;

/**
 * Solves a puzzle.
 */
public class PuzzleEngine {
    private final PuzzleStrategy strategy;

    public PuzzleEngine(PuzzleStrategy strategy) {
        this.strategy = strategy;
    }

    public String solvePuzzle(List<Piece> pieces) {
        if (pieces.size() != Constants.PIECES_COUNT) {
            throw new IllegalArgumentException(Constants.PIECES_COUNT + " pieces should be passed");
        }

        solveRecursive(pieces);
        return strategy.getResult();
    }

    private boolean solveRecursive(List<Piece> pieces) {
        if (strategy.isFinished()) {
            return true;
        }

        for (Piece piece : pieces) {
            for (int flipIndex = 0; flipIndex < Constants.FLIP_COUNT; ++flipIndex) {
                piece.flip();

                for (int turnIndex = 0; turnIndex < Constants.SIDES_COUNT; ++turnIndex) {
                    piece.turn();

                    if (!strategy.match(piece)) {
                        continue;
                    }

                    if (solveRecursive(CollectionUtils.copyWithoutElement(pieces, piece))) {
                        return true;
                    }
                }
            }
        }

        strategy.rollback();
        return false;
    }
}
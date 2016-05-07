package com.puzzle.cube;

import com.puzzle.core.Piece;
import com.puzzle.core.PuzzleStrategy;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CubeStrategyTest {
    private final static Piece PIECE1 = new Piece(new byte[][]{
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0}
    });

    private final static Piece PIECE2 = new Piece(new byte[][]{
            {0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 1, 1}
    });

    private final static Piece PIECE3 = new Piece(new byte[][]{
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0}
    });

    private final static Piece PIECE4 = new Piece(new byte[][]{
            {1, 0, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 1, 0}
    });

    private final static Piece PIECE5 = new Piece(new byte[][]{
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1}
    });

    private final static Piece PIECE6 = new Piece(new byte[][]{
            {0, 1, 0, 1, 0},
            {1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0}
    });

    @Test
    public void duplicateMatching() {
        PuzzleStrategy strategy = new CubePuzzleFactory().createStrategy();
        assertTrue("Piece #1 doesn't match", strategy.match(PIECE1));
        assertFalse("Duplicated piece #1 matches", strategy.match(PIECE1));
        assertTrue("Piece #2 doesn't match", strategy.match(PIECE2));
    }

    @Test
    public void matchingSequence() {
        PuzzleStrategy strategy = new CubePuzzleFactory().createStrategy();
        assertTrue("Piece #1 doesn't match", strategy.match(PIECE1));
        assertTrue("Piece #2 doesn't match", strategy.match(PIECE2));
        assertTrue("Piece #3 doesn't match", strategy.match(PIECE3));
        assertTrue("Piece #4 doesn't match", strategy.match(PIECE4));
        assertTrue("Piece #5 doesn't match", strategy.match(PIECE5));
        assertTrue("Piece #6 doesn't match", strategy.match(PIECE6));

        assertFalse("Puzzle is already completed and no piece should match after that", strategy.match(PIECE6));
    }

    @Test
    public void matchAfterRollback() {
        PuzzleStrategy strategy = new CubePuzzleFactory().createStrategy();
        strategy.rollback();

        assertTrue("Piece #1 doesn't match", strategy.match(PIECE1));
        assertTrue("Piece #2 doesn't match", strategy.match(PIECE2));

        strategy.rollback();

        assertFalse("Piece #3 should not match after rollback", strategy.match(PIECE3));
        assertTrue("Piece #2 doesn't match", strategy.match(PIECE2));

        assertFalse("Invalid piece wasn't detected", strategy.match(new Piece(new byte[][]{
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}
        })));

        assertTrue("Piece #3 doesn't match", strategy.match(PIECE3));
        assertTrue("Piece #4 doesn't match", strategy.match(PIECE4));

        strategy.rollback();
        strategy.rollback();
        assertFalse("Piece #5 should not match after rollback", strategy.match(PIECE5));
        assertFalse("Piece #4 should not match after rollback", strategy.match(PIECE4));

        assertTrue("Piece #3 doesn't match", strategy.match(PIECE3));
        assertTrue("Piece #4 doesn't match", strategy.match(PIECE4));
        assertTrue("Piece #5 doesn't match", strategy.match(PIECE5));

        strategy.rollback();
        strategy.rollback();
        strategy.rollback();
        strategy.rollback();
        strategy.rollback();

        assertTrue("Piece #1 doesn't match", strategy.match(PIECE1));
        assertTrue("Piece #2 doesn't match", strategy.match(PIECE2));
        assertTrue("Piece #3 doesn't match", strategy.match(PIECE3));
        assertTrue("Piece #4 doesn't match", strategy.match(PIECE4));
        assertTrue("Piece #5 doesn't match", strategy.match(PIECE5));
        assertTrue("Piece #6 doesn't match", strategy.match(PIECE6));

        strategy.rollback();

        assertTrue("Piece #6 doesn't match", strategy.match(PIECE6));
    }

    @Test
    public void missingVertex() {
        PuzzleStrategy strategy = new CubePuzzleFactory().createStrategy();
        assertTrue("Piece #1 doesn't match", strategy.match(PIECE1));
        assertTrue("Piece #2 doesn't match", strategy.match(PIECE2));
        assertTrue("Piece #3 doesn't match", strategy.match(PIECE3));
        assertTrue("Piece #4 doesn't match", strategy.match(PIECE4));
        assertTrue("Piece #5 doesn't match", strategy.match(PIECE5));

        assertFalse("Missing vertex wasn't detected", strategy.match(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}
        })));
    }

    @Test
    public void invalidVertex() {
        PuzzleStrategy strategy = new CubePuzzleFactory().createStrategy();
        assertTrue("Piece #1 doesn't match", strategy.match(PIECE1));
        assertTrue("Piece #2 doesn't match", strategy.match(PIECE2));
        assertTrue("Piece #3 doesn't match", strategy.match(PIECE3));
        assertTrue("Piece #4 doesn't match", strategy.match(PIECE4));
        assertTrue("Piece #5 doesn't match", strategy.match(PIECE5));

        assertFalse("Invalid vertex wasn't detected", strategy.match(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1}
        })));
    }
}
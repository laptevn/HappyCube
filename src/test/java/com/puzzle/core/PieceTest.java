package com.puzzle.core;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PieceTest {
    private static final byte[][] DATA = new byte[][]{
            {0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0}
    };

    @Test(expected = IllegalArgumentException.class)
    public void illegalSize() {
        new Piece(new byte[][]{
                {0, 1, 0, 0, 1}
        });
    }

    @Test
    public void sidesAfterTurn() {
        Piece piece = new Piece(DATA);
        checkSides(piece,
                new byte[]{0, 1, 0, 0, 1},
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{0, 1, 0, 1, 1},
                new byte[]{1, 1, 1, 1, 0});
        assertArrayEquals(piece.getData(), DATA);

        piece.turn();
        checkSides(piece,
                new byte[]{1, 1, 0, 1, 0},
                new byte[]{0, 1, 1, 1, 1},
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{0, 1, 0, 0, 1});
        assertArrayEquals(piece.getData(), new byte[][]{
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1}
        });

        piece.turn();
        checkSides(piece,
                new byte[]{0, 0, 0, 0, 1},
                new byte[]{1, 0, 0, 1, 0},
                new byte[]{0, 1, 1, 1, 1},
                new byte[]{1, 1, 0, 1, 0});
        assertArrayEquals(piece.getData(), new byte[][]{
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        });

        piece.turn();
        checkSides(piece,
                new byte[]{1, 1, 1, 1, 0},
                new byte[]{0, 1, 0, 1, 1},
                new byte[]{1, 0, 0, 1, 0},
                new byte[]{0, 0, 0, 0, 1});
        assertArrayEquals(piece.getData(), new byte[][]{
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 0, 1, 1}
        });

        piece.turn();
        checkSides(piece,
                new byte[]{0, 1, 0, 0, 1},
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{0, 1, 0, 1, 1},
                new byte[]{1, 1, 1, 1, 0});
        assertArrayEquals(piece.getData(), DATA);
    }

    @Test
    public void sidesAfterFlip() {
        Piece piece = new Piece(DATA);
        checkSides(piece,
                new byte[]{0, 1, 0, 0, 1},
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{0, 1, 0, 1, 1},
                new byte[]{1, 1, 1, 1, 0});
        assertArrayEquals(piece.getData(), DATA);

        piece.flip();
        checkSides(piece,
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{0, 1, 0, 0, 1},
                new byte[]{1, 1, 0, 1, 0},
                new byte[]{0, 1, 1, 1, 1});
        assertArrayEquals(piece.getData(), new byte[][]{
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}
        });

        piece.flip();
        checkSides(piece,
                new byte[]{0, 1, 0, 0, 1},
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{0, 1, 0, 1, 1},
                new byte[]{1, 1, 1, 1, 0});
        assertArrayEquals(piece.getData(), DATA);

        piece.turn();
        checkSides(piece,
                new byte[]{1, 1, 0, 1, 0},
                new byte[]{0, 1, 1, 1, 1},
                new byte[]{1, 0, 0, 0, 0},
                new byte[]{0, 1, 0, 0, 1});
        assertArrayEquals(piece.getData(), new byte[][]{
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1}
        });

        piece.flip();
        checkSides(piece,
                new byte[]{0, 1, 1, 1, 1},
                new byte[]{1, 1, 0, 1, 0},
                new byte[]{0, 0, 0, 0, 1},
                new byte[]{1, 0, 0, 1, 0});
        assertArrayEquals(piece.getData(), new byte[][]{
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0}
        });
    }

    private static void checkSides(Piece piece, byte[] top, byte[] bottom, byte[] left, byte[] right) {
        assertArrayEquals(piece.getTop().getPoints(), top);
        assertArrayEquals(piece.getBottom().getPoints(), bottom);
        assertArrayEquals(piece.getLeft().getPoints(), left);
        assertArrayEquals(piece.getRight().getPoints(), right);
    }
}
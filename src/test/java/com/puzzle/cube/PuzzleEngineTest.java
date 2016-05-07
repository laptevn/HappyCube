package com.puzzle.cube;

import com.puzzle.core.Piece;
import com.puzzle.core.PuzzleEngine;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PuzzleEngineTest {
    @Test
    public void unsolvable() {
        PuzzleEngine engine = new CubePuzzleFactory().createEngine();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {1, 0, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1}
        }));

        String result = engine.solvePuzzle(pieces);
        assertThat(result, is(equalTo("")));
    }

    @Test
    public void solveBlue() {
        PuzzleEngine engine = new CubePuzzleFactory().createEngine();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1}
        }));

        String result = engine.solvePuzzle(pieces);
        String expectedResult =
                "  o  o o o  o  " + System.lineSeparator() +
                " ooo ooooo ooo " + System.lineSeparator() +
                "ooooo ooo ooooo" + System.lineSeparator() +
                " ooo ooooo ooo " + System.lineSeparator() +
                "  o  o o o o o " + System.lineSeparator() +
                "      o o " + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "      oooo" + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "     oo o " + System.lineSeparator() +
                "       o o" + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      o oo" + System.lineSeparator() +
                "     o o  " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      o o ";

        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void solveRed() {
        PuzzleEngine engine = new CubePuzzleFactory().createEngine();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(new byte[][]{
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 0, 1, 1}
        }));

        String result = engine.solvePuzzle(pieces);
        String expectedResult =
                "  o   o o oo  o" + System.lineSeparator() +
                " oooo ooo ooooo" + System.lineSeparator() +
                " ooo ooooo ooo " + System.lineSeparator() +
                "ooooo ooo ooooo" + System.lineSeparator() +
                "o o o  o  o oo " + System.lineSeparator() +
                "      o o " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "       o  " + System.lineSeparator() +
                "      o oo" + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "      o o " + System.lineSeparator() +
                "     o o  " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      oooo" + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "     o o  ";

        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void solvePurple() {
        PuzzleEngine engine = new CubePuzzleFactory().createEngine();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(new byte[][]{
                {1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0}
        }));

        String result = engine.solvePuzzle(pieces);
        String expectedResult =
                "ooo  o o  oo oo" + System.lineSeparator() +
                "oooo ooooo oooo" + System.lineSeparator() +
                " oooo ooo oooo " + System.lineSeparator() +
                "oooo ooooo ooo " + System.lineSeparator() +
                "   o    oo o o " + System.lineSeparator() +
                "     ooo  " + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "       ooo" + System.lineSeparator() +
                "     oo   " + System.lineSeparator() +
                "      oooo" + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "      o o " + System.lineSeparator() +
                "       o  " + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "      oooo" + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "      o o ";

        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void solveYellow() {
        PuzzleEngine engine = new CubePuzzleFactory().createEngine();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0}
        }));

        pieces.add(new Piece(new byte[][]{
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1}
        }));

        String result = engine.solvePuzzle(pieces);
        String expectedResult =
                " o o oo    o oo" + System.lineSeparator() +
                " oooo oooo ooo " + System.lineSeparator() +
                "oooo oooo ooooo" + System.lineSeparator() +
                " oooo oooo ooo " + System.lineSeparator() +
                "  o   o o oo oo" + System.lineSeparator() +
                "     o o  " + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "      oooo" + System.lineSeparator() +
                "     oooo " + System.lineSeparator() +
                "      o o " + System.lineSeparator() +
                "     o o  " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "       o  " + System.lineSeparator() +
                "     oo o " + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "     ooooo" + System.lineSeparator() +
                "      ooo " + System.lineSeparator() +
                "       ooo";

        assertThat(result, is(equalTo(expectedResult)));
    }
}
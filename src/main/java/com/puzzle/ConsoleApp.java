package com.puzzle;

import com.puzzle.core.Piece;
import com.puzzle.core.PuzzleEngine;
import com.puzzle.cube.CubePuzzleFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Test console app that prints puzzle solution to a file.
 */
public class ConsoleApp {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("ERROR: Pass output file path as an argument");
            return;
        }

        PuzzleEngine engine = new CubePuzzleFactory().createEngine();
        String result = engine.solvePuzzle(createPieces());
        printToFile(args[0], result);

        System.out.println("Success!");
    }

    private static void printToFile(String filePath, String data) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath))) {
            writer.write(data);
        }
    }

    private static List<Piece> createPieces() {
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
        return pieces;
    }
}
package com.puzzle.cube;

import com.puzzle.core.PuzzleEngine;
import com.puzzle.core.PuzzleStrategy;

/**
 * Creates puzzle instances.
 */
public class CubePuzzleFactory {
    PuzzleStrategy createStrategy() {
        return new CubeStrategy(new CubeStructureFactory(), new CubePiecesDesigner());
    }

    public PuzzleEngine createEngine() {
        return new PuzzleEngine(createStrategy());
    }
}
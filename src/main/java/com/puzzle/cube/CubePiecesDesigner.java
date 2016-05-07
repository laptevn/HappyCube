package com.puzzle.cube;

import com.puzzle.core.Constants;
import com.puzzle.core.Piece;
import com.puzzle.core.PiecesDesigner;

import java.util.List;

class CubePiecesDesigner implements PiecesDesigner {
    private final static int HORIZONTAL_PIECES_COUNT = 3;
    private final static char INDENT_SYMBOL = ' ';
    private final static char EMPTY_SYMBOL = ' ';
    private final static byte EMPTY_VALUE = 0;
    private final static char NONEMPTY_SYMBOL = 'o';
    private final static byte NONEMPTY_VALUE = 1;

    @Override
    public String design(List<Piece> pieces) {
        StringBuilder result = new StringBuilder();
        for (int lineIndex = 0; lineIndex < Constants.PIECE_SIZE; ++lineIndex) {
            for (int pieceIndex = 0; pieceIndex < HORIZONTAL_PIECES_COUNT; ++pieceIndex) {
                printLine(lineIndex, pieces.get(pieceIndex).getData(), result);
            }

            result.append(System.lineSeparator());
        }

        for (int pieceIndex = HORIZONTAL_PIECES_COUNT; pieceIndex < Constants.PIECES_COUNT; ++pieceIndex) {
            for (int lineIndex = 0; lineIndex < Constants.PIECE_SIZE; ++lineIndex) {
                boolean needNewLine = pieceIndex != HORIZONTAL_PIECES_COUNT || lineIndex != 0;
                if (needNewLine) {
                    result.append(System.lineSeparator());
                }

                indent(result, Constants.PIECE_SIZE);
                printLine(lineIndex, pieces.get(pieceIndex).getData(), result);
            }
        }

        return result.toString();
    }

    private static void indent(StringBuilder builder, int indentSize) {
        for (int i = 0; i < indentSize; ++i) {
            builder.append(INDENT_SYMBOL);
        }
    }

    private void printLine(int lineIndex, byte[][] data, StringBuilder result) {
        if (lineIndex < 0 || lineIndex >= data.length) {
            throw new IllegalArgumentException("Illegal line index");
        }

        for (byte value : data[lineIndex]) {
            printValue(value, result);
        }
    }

    private static void printValue(byte value, StringBuilder result) {
        switch (value) {
            case EMPTY_VALUE:
                result.append(EMPTY_SYMBOL);
                break;

            case NONEMPTY_VALUE:
                result.append(NONEMPTY_SYMBOL);
                break;

            default:
                throw new UnsupportedOperationException("Unsupported piece content is used");
        }
    }
}
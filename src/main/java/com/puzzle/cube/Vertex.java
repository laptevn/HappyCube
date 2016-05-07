package com.puzzle.cube;

class Vertex {
    private final static byte NOT_INITIALIZED_VALUE = -1;

    private byte value = NOT_INITIALIZED_VALUE;
    private int initializingPiece = NOT_INITIALIZED_VALUE;

    public void reset(int currentPieceIndex) {
        if (initializingPiece == currentPieceIndex) {
            value = NOT_INITIALIZED_VALUE;
            initializingPiece = NOT_INITIALIZED_VALUE;
        }
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value, int initializingPiece) {
        this.value = value;
        this.initializingPiece = initializingPiece;
    }

    public boolean isInitializingPieceUsed(int checkingPiece) {
        return initializingPiece == checkingPiece;
    }

    public boolean isInitialized() {
        return value != NOT_INITIALIZED_VALUE;
    }
}
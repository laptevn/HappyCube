package com.puzzle.cube;

import com.puzzle.core.SideType;

class JointInfo {
    private int pieceIndex;
    private SideType sideType;
    private boolean isReversed;
    private Vertex vertex1;
    private Vertex vertex2;

    public int getPieceIndex() {
        return pieceIndex;
    }

    public SideType getSideType() {
        return sideType;
    }

    public boolean isReversed() {
        return isReversed;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public JointInfo withPieceIndex(int pieceIndex) {
        this.pieceIndex = pieceIndex;
        return this;
    }

    public JointInfo withSideType(SideType sideType) {
        this.sideType = sideType;
        return this;
    }

    public JointInfo withIsReserved(boolean isReversed) {
        this.isReversed = isReversed;
        return this;
    }

    public JointInfo withVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
        return this;
    }

    public JointInfo withVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
        return this;
    }
}
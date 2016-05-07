package com.puzzle.cube;

import com.puzzle.core.*;
import com.puzzle.utils.JoinUtils;
import com.puzzle.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CubeStrategy implements PuzzleStrategy {
    private final List<PieceJoints> piecesJoints;
    private final List<Piece> pieces = new ArrayList<>(Constants.PIECES_COUNT);
    private final PiecesDesigner designer;

    public CubeStrategy(CubeStructureFactory cubeStructureFactory, PiecesDesigner designer) {
        piecesJoints = cubeStructureFactory.create();
        this.designer = designer;
    }

    @Override
    public boolean match(Piece piece) {
        if (isFinished()) {
            return false;
        }

        int pieceIndex = pieces.size();
        PieceJoints pieceJoints = piecesJoints.get(pieceIndex);
        boolean isMatched = match(pieceIndex, piece, pieceJoints);
        if (isMatched) {
            pieces.add(piece);
        } else {
            resetVertexes(pieceIndex);
        }

        return isMatched;
    }

    @Override
    public boolean isFinished() {
        return pieces.size() == Constants.PIECES_COUNT;
    }

    private void resetVertexes(int pieceIndex) {
        PieceJoints pieceJoints = piecesJoints.get(pieceIndex);
        resetVertexes(SideType.TOP, pieceJoints, pieceIndex);
        resetVertexes(SideType.BOTTOM, pieceJoints, pieceIndex);
        resetVertexes(SideType.LEFT, pieceJoints, pieceIndex);
        resetVertexes(SideType.RIGHT, pieceJoints, pieceIndex);
    }

    private static void resetVertexes(SideType sideType, PieceJoints pieceJoints, int pieceIndex) {
        pieceJoints.getJointInfo(sideType).getVertex1().reset(pieceIndex);
        pieceJoints.getJointInfo(sideType).getVertex2().reset(pieceIndex);
    }

    private boolean match(int pieceIndex, Piece piece, PieceJoints pieceJoints) {
        return matchSide(pieceIndex, piece, pieceJoints, SideType.TOP) &&
                matchSide(pieceIndex, piece, pieceJoints, SideType.BOTTOM) &&
                matchSide(pieceIndex, piece, pieceJoints, SideType.LEFT) &&
                matchSide(pieceIndex, piece, pieceJoints, SideType.RIGHT);
    }

    private boolean matchSide(int pieceIndex, Piece piece, PieceJoints pieceJoints, SideType sideType) {
        return matchSide(pieceIndex, piece.getSide(sideType), pieceJoints.getJointInfo(sideType));
    }

    private boolean matchSide(int pieceIndex, Side side, JointInfo jointInfo) {
        boolean jointTargetExist = jointInfo.getPieceIndex() < pieces.size();
        if (!jointTargetExist) {
            return true;
        }

        Side jointSide = pieces.get(jointInfo.getPieceIndex()).getSide(jointInfo.getSideType());
        if (jointInfo.isReversed()) {
            jointSide = new Side(CollectionUtils.reverse(jointSide.getPoints()));
        }


        if (!side.canBeJoinedTo(jointSide)) {
            return false;
        }

        return matchVertex(jointInfo.getVertex1(), pieceIndex, side.getVertex1Value(), jointSide.getVertex1Value()) &&
                matchVertex(jointInfo.getVertex2(), pieceIndex, side.getVertex2Value(), jointSide.getVertex2Value());
    }

    private boolean matchVertex(Vertex vertex, int currentPiece, byte value1, byte value2) {
        if (vertex.isInitializingPieceUsed(currentPiece)) {
            return true;
        }

        if (vertex.isInitialized()) {
            return JoinUtils.canBeJoint(vertex.getValue(), value1);
        }

        if (JoinUtils.hasJoinConflict(value1, value2)) {
            return false;
        }

        vertex.setValue(JoinUtils.join(value1, value2), currentPiece);
        return true;
    }

    @Override
    public void rollback() {
        if (!pieces.isEmpty()) {
            int pieceIndex = pieces.size() - 1;
            resetVertexes(pieceIndex);
            pieces.remove(pieceIndex);
        }
    }

    @Override
    public String getResult() {
        return isFinished() ? designer.design(pieces) : "";
    }
}
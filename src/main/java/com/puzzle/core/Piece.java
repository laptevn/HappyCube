package com.puzzle.core;

import com.puzzle.utils.CollectionUtils;

/**
 * Represents a single piece of a puzzle.
 */
public class Piece {
    private Side top;
    private Side bottom;
    private Side left;
    private Side right;
    private final byte[][] data;

    public Piece(byte[][] data) {
        if (data.length != Constants.PIECE_SIZE || data[0].length != Constants.PIECE_SIZE) {
            throw new IllegalArgumentException(String.format("A piece should have %1$dx%1$d points size", Constants.PIECE_SIZE));
        }

        this.data = CollectionUtils.deepCopy(data);
        this.top = createTopSide(this.data);
        this.bottom = createBottomSide(this.data);
        this.left = createLeftSide(this.data);
        this.right = createRightSide(this.data);
    }

    private static Side createTopSide(byte[][] data) {
        return new Side(data[0]);
    }

    private void updateTopSide() {
        data[0] = top.getPoints();
    }

    private static Side createBottomSide(byte[][] data) {
        return new Side(data[data.length - 1]);
    }

    private void updateBottomSide() {
        data[data.length - 1] = bottom.getPoints();
    }

    private static Side createLeftSide(byte[][] data) {
        byte[] sideData = new byte[data.length];
        for (int i = 0; i < data.length; ++i) {
            sideData[i] = data[i][0];
        }
        return new Side(sideData);
    }

    private void updateLeftSide() {
        for (int i = 0; i < data.length; ++i) {
            data[i][0] = left.getPoints()[i];
        }
    }

    private static Side createRightSide(byte[][] data) {
        byte[] sideData = new byte[data.length];
        for (int i = 0; i < data.length; ++i) {
            sideData[i] = data[i][data[i].length - 1];
        }
        return new Side(sideData);
    }

    private void updateRightSide() {
        for (int i = 0; i < data.length; ++i) {
            data[i][data[i].length - 1] = right.getPoints()[i];
        }
    }

    public Side getTop() {
        return top;
    }

    public Side getBottom() {
        return bottom;
    }

    public Side getLeft() {
        return left;
    }

    public Side getRight() {
        return right;
    }

    public Side getSide(SideType sideType) {
        switch (sideType){
            case TOP:
                return getTop();

            case BOTTOM:
                return getBottom();

            case LEFT:
                return getLeft();

            case RIGHT:
                return getRight();

            default:
                throw new UnsupportedOperationException("Unknown side type");
        }
    }

    public byte[][] getData() {
        updateTopSide();
        updateBottomSide();
        updateLeftSide();
        updateRightSide();

        return data;
    }

    public void turn() {
        Side previousTop = top;
        top = new Side(CollectionUtils.reverse(left.getPoints()));
        left = new Side(bottom.getPoints());
        bottom = new Side(CollectionUtils.reverse(right.getPoints()));
        right = new Side(previousTop.getPoints());
    }

    public void flip() {
        Side previousTop = top;
        top = new Side(bottom.getPoints());
        bottom = new Side(previousTop.getPoints());
        left = new Side(CollectionUtils.reverse(left.getPoints()));
        right = new Side(CollectionUtils.reverse(right.getPoints()));
    }
}
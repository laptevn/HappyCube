package com.puzzle.core;

import com.puzzle.utils.JoinUtils;

public class Side {
    private final byte[] points;

    public Side(byte[] points) {
        this.points = points;
    }

    public boolean canBeJoinedTo(Side otherSide) {
        if (getPoints().length != otherSide.getPoints().length) {
            throw new IllegalArgumentException("Sides should have the same size");
        }

        for (int i = 1; i < getPoints().length - 1; i++) {
            if (!JoinUtils.canBeJoint(getPoints()[i], otherSide.getPoints()[i])) {
                return false;
            }
        }

        return true;
    }

    public byte[] getPoints() {
        return points;
    }

    public byte getVertex1Value() {
        return points[0];
    }

    public byte getVertex2Value() {
        return points[points.length - 1];
    }
}
package com.puzzle.utils;

/**
 * Contains util methods used in join.
 */
public final class JoinUtils {
    public static boolean canBeJoint(byte point1, byte point2) {
        return point1 + point2 == 1;
    }

    public static boolean hasJoinConflict(byte point1, byte point2) {
        return point1 + point2 > 1;
    }

    public static byte join(byte point1, byte point2) {
        return (byte)(point1 + point2);
    }
}
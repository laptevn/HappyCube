package com.puzzle.core;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SideTest {
    @Test
    public void matchingSides() {
        Side side1 = new Side(new byte[] {1, 0, 1, 0});
        Side side2 = new Side(new byte[] {1, 1, 0, 0});

        assertTrue(side1.canBeJoinedTo(side2));
    }

    @Test
    public void notMatchingSides() {
        Side side1 = new Side(new byte[] {0, 0, 1, 0});
        Side side2 = new Side(new byte[] {1, 0, 0, 1});

        assertFalse(side1.canBeJoinedTo(side2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalSize() {
        Side side1 = new Side(new byte[] {0, 0, 1, 0});
        Side side2 = new Side(new byte[] {1, 0});

        side1.canBeJoinedTo(side2);
    }
}
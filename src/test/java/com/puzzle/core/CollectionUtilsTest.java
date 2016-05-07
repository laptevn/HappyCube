package com.puzzle.core;

import com.puzzle.utils.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionUtilsTest {
    @Test
    public void reverseEmptyArray() {
        assertTrue("Result array should be empty", CollectionUtils.reverse(new byte[0]).length == 0);
    }

    @Test
    public void reverseNonEmptyArray() {
        byte[] source = new byte[] {1, 2, 3};
        assertArrayEquals(CollectionUtils.reverse(source), new byte[]{3, 2, 1});
        assertArrayEquals(source, new byte[]{1, 2, 3});
    }

    @Test
    public void copyEmptyArray() {
        assertTrue("Result array should be empty", CollectionUtils.deepCopy(new byte[0][]).length == 0);
    }

    @Test
    public void copy() {
        byte[][] source = new byte[][] {
                new byte[] {0, 1},
                new byte[] {1, 1},
        };

        byte[][] result = CollectionUtils.deepCopy(source);
        assertArrayEquals(source, result);
        assertNotSame(source, result);

        result[0][0] = 10;
        assertNotEquals("Deep copy wasn't performed", source[0][0], result[0][0]);
    }

    @Test
    public void copyWithoutElement() {
        String element = new String();
        ArrayList<String> elements = new ArrayList<>();
        elements.add(element);

        List<String> result = CollectionUtils.copyWithoutElement(elements, element);
        assertTrue(result.isEmpty());
        assertNotSame(elements, result);
    }
}
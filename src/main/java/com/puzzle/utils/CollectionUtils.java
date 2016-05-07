package com.puzzle.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains util methods used in collections and arrays manipulations.
 */
public final class CollectionUtils {
    public static byte[] reverse(byte[] data) {
        byte[] result = new byte[data.length];
        for (int i = data.length - 1, j = 0; i >= 0; i--, j++) {
            result[j] = data[i];
        }
        return result;
    }

    public static byte[][] deepCopy(byte[][] data) {
        byte[][] result = new byte[data.length][];
        for(int i = 0; i < data.length; ++i) {
            result[i] = Arrays.copyOf(data[i], data[i].length);
        }
        return result;
    }

    public static <T> List<T> copyWithoutElement(List<T> listToCopy, T excludingElement) {
        List<T> result = new ArrayList<>(listToCopy);
        result.remove(excludingElement);
        return result;
    }
}
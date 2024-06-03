package org.example.bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Bag01Test {

    @Test
    void case1() {
        Bag01 bag01 = new Bag01();
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagCapacity = 4;
        int maxValue = bag01.maxValueInBag(weights, values, bagCapacity);

        Assertions.assertEquals(35, maxValue);
    }

    @Test
    void case2() {
        Bag01 bag01 = new Bag01();
        int[] weights = {3, 4, 5};
        int[] values = {4, 5, 6};
        int bagCapacity = 10;
        int maxValue = bag01.maxValueInBag(weights, values, bagCapacity);

        Assertions.assertEquals(11, maxValue);
    }
}
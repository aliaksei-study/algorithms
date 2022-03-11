package com.closestpoint;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Point> testArray = Arrays.asList(new Point(1, 4), new Point(5, 1), new Point(10, 10),
                new Point(7, 4), new Point(4, 4), new Point(3, 2));
        PointsUtils pointsUtils = new PointsUtils();
        testArray.sort(Comparator.comparingInt(Point::getX));
        System.out.println(pointsUtils.findClosestPoints(testArray));
    }
}

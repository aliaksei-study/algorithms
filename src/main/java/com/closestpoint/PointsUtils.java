package com.closestpoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PointsUtils {

    public double findClosestPoints(List<Point> pointsSortedByX) {
        int size = pointsSortedByX.size();
        final int maximumBruteForceSize = 3;
        if (size <= maximumBruteForceSize) {
            return findClosestPointsUsingBruteForce(pointsSortedByX);
        }
        double leftHalveDistance = findClosestPoints(pointsSortedByX.subList(0, size / 2));
        double rightHalveDistance = findClosestPoints(pointsSortedByX.subList(size / 2, size));
        double smallestHalvesDistance = Math.min(leftHalveDistance, rightHalveDistance);
        List<Point> strip = getPointsCloserThanMinDistanceToLinePassingThroughArrayMiddlePoint(pointsSortedByX,
                smallestHalvesDistance);
        return Math.min(smallestHalvesDistance, findStripClosestPoints(strip, smallestHalvesDistance));
    }

    public double findClosestPointsUsingBruteForce(List<Point> points) {
        double min = Double.MAX_VALUE;
        double distanceBetweenTwoPoints;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                distanceBetweenTwoPoints = distance(points.get(i), points.get(j));
                if (distanceBetweenTwoPoints < min) {
                    min = distanceBetweenTwoPoints;
                }
            }
        }
        return min;
    }

    public double distance(Point firstPoint, Point secondPoint) {
        return Math.sqrt((firstPoint.getX() - secondPoint.getX()) * (firstPoint.getX() - secondPoint.getX()) +
                (firstPoint.getY() - secondPoint.getY()) * (firstPoint.getY() - secondPoint.getY())
        );
    }

    public List<Point> getPointsCloserThanMinDistanceToLinePassingThroughArrayMiddlePoint(List<Point> points,
                                                                                          double minDistance) {
        Point midPoint = points.get(points.size() / 2);
        List<Point> strip = new ArrayList<>();
        for (Point point : points) {
            if (Math.abs(point.getX() - midPoint.getX()) < minDistance) {
                strip.add(point);
            }
        }
        return strip;
    }

    public double findStripClosestPoints(List<Point> strip, double minDistance) {
        strip.sort(Comparator.comparingInt(Point::getY));
        double minStripPointsDistance;
        for(int i = 0; i < strip.size(); i++) {
            for(int j = i + 1; j < strip.size() && (strip.get(j).getY() - strip.get(i).getY()) < minDistance; j++) {
                minStripPointsDistance = distance(strip.get(i), strip.get(j));
                if(minStripPointsDistance < minDistance) {
                    minDistance = minStripPointsDistance;
                }
            }
        }
        return minDistance;
    }
}

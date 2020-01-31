package zrx.com.DesignAndAnalysisOfComputerAlgorithms.recursion;

import zrx.com.DesignAndAnalysisOfComputerAlgorithms.TestForDesignAndAnalysisOfComputerAlgorithms;
import zrx.com.MultiThread.MyTools;

import java.util.*;

/**
 * Description
 * 最接近点对问题
 * <p>
 * Data
 * 21:03
 *
 * @author zrx
 * @version 1.0
 */

public class NearestPointsProblem {
    @TestForDesignAndAnalysisOfComputerAlgorithms(value = "最接近点对问题", detailInfo = {
            "平面上n个点，找出最近的一对",
            "使用分治法，关键是处理分别属于不同边界上的点"
    },repeat = 5, page = 42)
    public void solve() {
        Point[] points = Point.randomPoint(1000);
        System.out.println("蛮力解法答案：" + nearestDistanceForce(points));
        System.out.println("递归解法答案：" + nearestDistanceRecursion(points));
    }

    private double nearestDistanceRecursion(Point[] points){
        if(points.length==0||points.length==1)
            return 1e8;
        else if(points.length==2)
            return Point.distance(points[0],points[1]);

        //对x排序
        Arrays.sort(points, Comparator.comparingDouble(Point::getX));

        //中间的点
        int midIndex = points.length/2;
        double minX = points[midIndex].getX();

        //中间的点放到右边
        double leftMin = nearestDistanceRecursion(Arrays.copyOfRange(points,0,midIndex));
        double rightMin = nearestDistanceRecursion(Arrays.copyOfRange(points,midIndex,points.length));

        double partMin = Math.min(leftMin,rightMin);

        final List<Point> rightPoints = new ArrayList<>();
        final List<Point> leftPoints = new ArrayList<>();

        for (int i = 0; i < midIndex; i++) {
            if(Math.abs(points[i].getX()-minX)<partMin)
                leftPoints.add(points[i]);
        }

        for (int i = midIndex; i < points.length; i++) {
            if(Math.abs(points[i].getX()-minX)<partMin)
                rightPoints.add(points[i]);
        }

        for (Point rightPoint : rightPoints) {
            for (Point leftPoint : leftPoints) {
                partMin = Math.min(partMin,Point.distance(rightPoint,leftPoint));
            }
        }

        return partMin;
    }

    //暴力解法
    private double nearestDistanceForce(Point[] points){
        double minDistance = Point.distance(points[0],points[1]);

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                minDistance = Math.min(minDistance,Point.distance(points[i],points[j]));
            }
        }

        return minDistance;
    }

    private static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static double distance(Point p1, Point p2) {
            return Math.sqrt(
                    (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)
            );
        }

        private static Random random = new Random();

        public static Point randomPoint() {
            return new Point(random.nextDouble() * 1000, random.nextDouble() * 1000);
        }

        public static Point[] randomPoint(int number) {
            Point[] points = new Point[number];
            for (int i = 0; i < points.length; i++) {
                points[i] = randomPoint();
            }

            return points;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
}

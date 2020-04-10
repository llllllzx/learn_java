package page_001_020;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int dup_points = 0;
            int vertical_points = 0;
            int cur_max = 1;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) break;
                double delta_x = points[j].x - points[i].x;
                double delta_y = points[j].y - points[i].y;
                //有重复的点
                if (delta_x == 0 && delta_y == 0) {
                    dup_points++;
                } else if (delta_x == 0) {//斜率不存在
                    vertical_points = vertical_points == 0 ? vertical_points + 2 : vertical_points + 1;
                    cur_max = Math.max(cur_max, vertical_points);
                } else {//斜率存在
                    double d = delta_y / delta_x;
                    int value = map.getOrDefault(d, -1);
                    if (value == -1) {
                        map.put(d, 2);
                    } else {
                        map.put(d, value + 1);
                    }
                    cur_max = Math.max(map.get(d), cur_max);
                }
            }
            res = Math.max(cur_max + dup_points, res);
        }
        return res;
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}



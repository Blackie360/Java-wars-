package student;

public class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof Point point) {
            return point.x == x && point.y == y;
        }
        return false;
    }

    @Override
    public int compareTo(Point point) {
        if (point == null) {
            return 1;  // Assume non-null is greater than null
        }

        int xComparison = Integer.compare(this.x, point.x);
        if (xComparison != 0) {
            return xComparison;
        }

        return Integer.compare(this.y, point.y);
    }
}

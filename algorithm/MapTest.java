public class MapTest {

    public static void main(String[] args) {
        Map<String, String> hogwarts = new Map<>(5);

        System.out.println(hogwarts.size());  // 0

        hogwarts.put("Harry", "Ginny");
        hogwarts.put("Ron", "Lavender");
        hogwarts.put("Voldemort", null);
        hogwarts.put(null, "Wormtail");
        System.out.println(hogwarts.size());  // 4

        System.out.println(hogwarts.containsKey("Harry"));  // true
        System.out.println(hogwarts.containsKey("Ginny"));  // false
        System.out.println(hogwarts.containsKey("Ron"));  // true
        System.out.println(hogwarts.containsKey("Voldemort"));  // true
        System.out.println(hogwarts.containsKey(null));  // true
        System.out.println(hogwarts.containsKey("Joanne"));  // false

        System.out.println(hogwarts.get("Harry"));  // Ginny
        System.out.println(hogwarts.get("Ron"));  // Lavender
        System.out.println(hogwarts.get("Voldemort"));  // null
        System.out.println(hogwarts.get(null));  // Wormtail
        System.out.println(hogwarts.get("Joanne"));  // null

        hogwarts.put("Ron", "Hermione");
        hogwarts.put("Albus", "Gellert");
        hogwarts.put(null, null);
        System.out.println(hogwarts.size());  // 5

        System.out.println(hogwarts.containsKey(null));  // true
        System.out.println(hogwarts.containsKey("Albus"));  // true
        System.out.println(hogwarts.containsKey("Hermione"));  // false

        System.out.println(hogwarts.get("Albus"));  // Gellert
        System.out.println(hogwarts.get("Harry"));  // Ginny
        System.out.println(hogwarts.get("Ron"));  // Hermione
        System.out.println(hogwarts.get("Voldemort"));  // null
        System.out.println(hogwarts.get(null));  // null

        // Additional tests with Point class
        Map<Point, Integer> pointMap = new Map<>(1);
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p2_dup = new Point(2, 1);
        Point p3 = new Point(4, 5);

        pointMap.put(p1, 2);
        pointMap.put(p2, 7);
        pointMap.put(p2_dup, 10);
        System.out.println(pointMap.get(p1));  // 2
        System.out.println(pointMap.get(p2));  // 10
        System.out.println(pointMap.containsKey(p1));  // true
        System.out.println(pointMap.containsKey(p3));  // false
        System.out.println(pointMap.size());  // 2
        pointMap.put(p3, 9);
        pointMap.put(null, 11);
        System.out.println(pointMap.get(null));  // 11
    }
}

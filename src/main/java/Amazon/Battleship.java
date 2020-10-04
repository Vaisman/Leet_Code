package Amazon;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Battleship {

    public static String battleShip(int N, String S, String T) {
        int hit = 0;
        int sunk = 0;
        Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));
        String[] ships = S.split(",");

        for (String ship : ships) {
            Set<String> coordinates = getShipCoordinates(ship);
            if (hits.containsAll(coordinates)) {
                sunk++;
            } else {
                for (String coordinate : coordinates) {
                    if (hits.contains(coordinate)) {
                        hit++;
                        break;
                    }
                }
            }
        }
        return sunk + "," + hit;
    }

    public static Set<String> getShipCoordinates(String ship) {
        Set<String> set = new HashSet<>();
        String[] coordinates = ship.split(" ");
        int index = 0;
        if (coordinates[0].equals("")) {
            index = 1;
        }
        int rowStart = coordinates[index].charAt(0) - '0';
        char colStart = coordinates[index].charAt(1);

        int rowEnd = coordinates[index+1].charAt(0) - '0';
        char colEnd = coordinates[index+1].charAt(1);

        for (int i = rowStart; i <= rowEnd; i++) {
            for (char j = colStart; j <= colEnd; j++) {
                set.add(i + "" + j);
            }
        }
        return set;
    }

    private static final int MAX_RANGE = 26;

    public String solution(int n, String s, String t) {
        if (n > MAX_RANGE) {
            return "0,0";
        }

        List<Ship> ships = parseShips(s, n * n);
        List<Point> hits = parseHits(t, n * n);

        int touched = 0;
        int sunken = 0;

        Iterator<Ship> shipIt = ships.iterator();

        while (shipIt.hasNext()) {
            Ship current = shipIt.next();
            int touching = current.getHits(hits);
            if (touching > 0) {
                if (touching == current.getSize()) {
                    sunken++;
                } else {
                    touched++;
                }
            }
        }

        return "" + sunken + "," + touched;
    }

    public List<Point> parseHits(String hits, int maxHits) {
        List<Point> hitsList = new ArrayList<>(maxHits);
        String[] coords = hits.split(" ");
        for (String coord : coords) {
            hitsList.add(new Point(coord));
        }
        return hitsList;
    }

    public List<Ship> parseShips(String ships, int maxShips) {
        List<Ship> shipsList = new ArrayList<>(maxShips);
        String[] shipsCoords = ships.split(", ");
        for (String shipCoord : shipsCoords) {
            String[] coords = shipCoord.split(" ");
            shipsList.add(new Ship(new Point(coords[0]), new Point(coords[1])));
        }
        return shipsList;
    }

    static public class Point {
        int x;
        int y;

        public Point(String coord) {
            x = (coord.toUpperCase().charAt(1)) - ('A');
            y = (coord.charAt(0)) - ('1');
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean greaterOrEqual(Point other) {
            return x >= other.x && y >= other.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static public class Ship {
        private Point topLeft;
        private Point bottomRight;

        public Ship(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public Point getTopLeft() {
            return topLeft;
        }

        public Point getBottomRight() {
            return bottomRight;
        }

        public int getSize() {
            return (Math.abs(topLeft.getX() - bottomRight.getX()) + 1)
                    * (Math.abs(topLeft.getY() - bottomRight.getY()) + 1);
        }

        @Override
        public String toString() {
            return "(" + topLeft + ", " + bottomRight + ")";
        }

        public int getHits(List<Point> shots) {
            Iterator<Point> shotIt = shots.iterator();
            int hits = 0;
            while (shotIt.hasNext()) {
                Point shot = shotIt.next();
                if (shot.greaterOrEqual(topLeft) && bottomRight.greaterOrEqual(shot)) {
                    hits++;
                }
            }
            return hits;
        }
    }

    public  String solution1(int N, String S, String T) {
        int sink = 0;
        int hit = 0;
        Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));
        String[] ships = S.split(",");
        for (String ship : ships) {
            Set<String> shipComponents = new HashSet<>();
            String[] splitTopAndBottom = ship.split(" ");
            // rows can be from 1 to 26 , logic added to read both the digits if row is double digit
            int top = (splitTopAndBottom[0].charAt(1) > 57)
                    ? Integer.parseInt(splitTopAndBottom[0].charAt(0)+"")
                    : Integer.parseInt(splitTopAndBottom[0].charAt(0)+""+splitTopAndBottom[0].charAt(1)+"");

            int left = (top > 9 ) ? splitTopAndBottom[0].charAt(2) :  splitTopAndBottom[0].charAt(1);

            int bottom = (splitTopAndBottom[1].charAt(1) > 57)
                    ? Integer.parseInt(splitTopAndBottom[1].charAt(0)+"")
                    : Integer.parseInt(splitTopAndBottom[1].charAt(0)+""+splitTopAndBottom[1].charAt(1)+"");

            int right = (bottom > 9 ) ? splitTopAndBottom[1].charAt(2) :  splitTopAndBottom[1].charAt(1);

            for (int i = top; i <= bottom; i++) {
                for (int j = left; j <= right; j++) {
                    shipComponents.add("" + i + (char) j);
                }
            }
            if (hits.containsAll(shipComponents)) {
                sink++;
            } else {
                for (String com : shipComponents) {
                    if (hits.contains(com)) {
                        hit++;
                        break;
                    }
                }
            }

        }

        return "" + sink + "," + hit;
    }

    @Test
    public void amazonTest1() {
        assertEquals("1,1",  solution(4, "1B 2C, 2D 4D", "2B 2D 3D 4D 4A"));
        assertEquals("0,1", solution(3, "1A 1B, 2C 2C", "1B"));
        assertEquals("1,0", solution(12, "1A 2A, 12A 12A", "12A"));
    }
}

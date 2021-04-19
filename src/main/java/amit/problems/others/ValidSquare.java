package amit.problems.others;

/**
 * Given four points in a 2d plane determine if they form a valid square
 * https://leetcode.com/problems/valid-square
 *
 * Status works
 */
public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double side = Math.min(dist(p1, p2), dist(p1, p3));//If this is a square then points at least one must be side and the smaller distance.
        double diagonal = Math.sqrt(2) * side; //formula for diagonal based on pythagoras theorem.
        return side > 0 && valid(p1, p2, p3, p4, side, diagonal) && valid(p2, p1, p3, p4, side, diagonal) && valid(p3, p2, p1, p4, side, diagonal) && valid(p4, p2, p3, p1, side, diagonal);
    }

    //Checks if any given 4 points are part of valid square from one point perspective.
    boolean valid(int[] p1, int[] p2, int[] p3, int[] p4, double side, double diagonal) {
        double epsilon = 0.0000006; //To manage floating point errors.
        double dist2 = dist(p1, p2);
        double dist3 = dist(p1, p3);
        double dist4 = dist(p1, p4);

        //if one distance was diagonal then other two must be sides.
        if (Math.abs(dist2 - diagonal) < epsilon) {
            return Math.abs(dist3 - side) < epsilon && Math.abs(dist4 - side) < epsilon;
        } else if (Math.abs(dist3 - diagonal) < epsilon) {
            return Math.abs(dist2 - side) < epsilon && Math.abs(dist4 - side) < epsilon;
        } else if (Math.abs(dist4 - diagonal) < epsilon) {
            return Math.abs(dist2 - side) < epsilon && Math.abs(dist3 - side) < epsilon;
        }
        return false;
    }

    //distance formula sqrt ((x2 - x1)^2/(y2 - y1)^2
    private double dist(int[] p1, int[] p11) {
        return Math.sqrt((p1[0] - p11[0]) * (p1[0] - p11[0]) + (1.0 * (p1[1] - p11[1]) * (p1[1] - p11[1])));
    }

    public static void main(String[] args) {
        ValidSquare vs = new ValidSquare();
        System.out.println(vs.validSquare(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, 1}));//true
        System.out.println(vs.validSquare(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, 12}));//false
        System.out.println(vs.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}));//true
    }
}

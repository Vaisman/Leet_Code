package Amazon;

import java.math.BigInteger;

public class PointOfLattice {
    public String findLattice(int AX, int AY, int BX, int BY){
        int distX = BX-AX;
        int distY = BY-AY;
        // now go clockwise (90 deg right) res (y,-x)
        int resX = distY;
        int resY = -distX;

        int gcd = BigInteger.valueOf(resX).gcd(BigInteger.valueOf(resY)).intValue();
        resX /= gcd;
        resY /= gcd;

        resX += BX;
        resY += BY;
        return resX +","+ resY;
    }
}

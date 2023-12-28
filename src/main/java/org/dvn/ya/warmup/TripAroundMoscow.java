package org.dvn.ya.warmup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

public class TripAroundMoscow {


    public static void main(String[] args) {
        int xa, ya, xb, yb;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String firstInputLine = reader.readLine();
            String[] dataFirstLine = firstInputLine.split(" ");
            xa = Integer.parseInt(dataFirstLine[0]);
            ya = Integer.parseInt(dataFirstLine[1]);
            xb = Integer.parseInt(dataFirstLine[2]);
            yb = Integer.parseInt(dataFirstLine[3]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getShortestWay(xa, ya, xb, yb));
    }

    private static double getShortestWay(int xa, int ya, int xb, int yb) {

        if ((xa == ya) && (ya == xb) && (xb == yb)) {
            return 0;
        }
        BigDecimal bigIntegerA = new BigDecimal(Math.pow(xa, 2) + Math.pow(ya, 2));
        BigDecimal bigIntegerB = new BigDecimal(Math.pow(xb, 2) + Math.pow(yb, 2));

        double diamPath, arcPath;
        double aDiameter = bigIntegerA.sqrt(new MathContext(100)).doubleValue();
        double bDiameter = bigIntegerB.sqrt(new MathContext(100)).doubleValue();

        if (aDiameter == 0) {
            return bDiameter;
        } else if (bDiameter == 0) {
            return aDiameter;
        }

        var d0 = new BigDecimal(xa * xb + ya * yb);
        var d1 = new BigDecimal(Math.pow(xa, 2) + Math.pow(ya, 2)).sqrt(new MathContext(100));
        var d2 = new BigDecimal(Math.pow(xb, 2) + Math.pow(yb, 2)).sqrt(new MathContext(100));

        double cosAngle = d0.divide(d1, new MathContext(100)).divide(d2, new MathContext(100))
                .doubleValue();
        double segmentLength;
        if (aDiameter > bDiameter) {
            segmentLength = bDiameter * Math.acos(cosAngle);
            arcPath = segmentLength + aDiameter - bDiameter;
        } else if (bDiameter > aDiameter) {
            segmentLength = aDiameter * Math.acos(cosAngle);
            arcPath = segmentLength + bDiameter - aDiameter;
        } else {
            segmentLength = aDiameter * Math.acos(cosAngle);
            arcPath = segmentLength;
        }

        diamPath = aDiameter + bDiameter;

        return arcPath > diamPath ? diamPath : arcPath;
    }
}

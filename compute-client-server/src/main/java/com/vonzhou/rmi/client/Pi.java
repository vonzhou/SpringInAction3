package com.vonzhou.rmi.client;

import com.vonzhou.rmi.common.Task;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by vonzhou on 16/4/23.
 */
public class Pi implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    /**
     * constants used in pi computation
     */
    private static final BigDecimal FOUR =
            BigDecimal.valueOf(4);

    /**
     * rounding mode to use during pi computation
     */
    private static final int roundingMode =
            BigDecimal.ROUND_HALF_EVEN;

    /**
     * digits of precision after the decimal point
     */
    private final int digits;

    /**
     * Construct a task to calculate pi to the specified
     * precision.
     */
    public Pi(int digits) {
        this.digits = digits;
    }

    /**
     * Calculate pi.
     */
    public BigDecimal execute() {
        return computePi(digits);
    }

    /**
     * Compute the value of pi to the specified number of
     * digits after the decimal point.  The value is
     * computed using Machin's formula:
     * <p>
     * pi/4 = 4*arctan(1/5) - arctan(1/239)
     * <p>
     * and a power series expansion of arctan(x) to
     * sufficient precision.
     */
    public static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(
                arctan1_239).multiply(FOUR);
        return pi.setScale(digits,
                BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Compute the value, in radians, of the arctangent of
     * the inverse of the supplied integer to the specified
     * number of digits after the decimal point.  The value
     * is computed using the power series expansion for the
     * arc tangent:
     * <p>
     * arctan(x) = x - (x^3)/3 + (x^5)/5 - (x^7)/7 +
     * (x^9)/9 ...
     */
    public static BigDecimal arctan(int inverseX,
                                    int scale) {
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 =
                BigDecimal.valueOf(inverseX * inverseX);

        numer = BigDecimal.ONE.divide(invX,
                scale, roundingMode);

        result = numer;
        int i = 1;
        do {
            numer =
                    numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term =
                    numer.divide(BigDecimal.valueOf(denom),
                            scale, roundingMode);
            if ((i % 2) != 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}
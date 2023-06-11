package hw01.utils;

import java.util.*;
/**
 * The class which performs conversions of lengths from available list of units
 * of measurement.
 * The result is an array of strings containing input number, output number, input unit of
 * measurement and output unit of measurement.
 */
public class Converter {
    /**
     * The conversion method
     *
     * @param a - the input number
     * @param from - the unit of measurement to convert from
     * @param to - the unit of measurement to convert to
     * @return - the result in the form of an array of strings containing input number cast to
     * string, output number cast to string, input unit of measurement and
     * output unit of measurement.
     */
    public static String[] convert(int a, String from, String to) {
        Map<String, Double> coefficients = new HashMap<>();
        coefficients.put("mm", 1.0);
        coefficients.put("cm", 10.0);
        coefficients.put("dm", 100.0);
        coefficients.put("m", 1000.0);
        coefficients.put("km", 1000000.0);
        coefficients.put("in", 25.4);
        coefficients.put("ft", 304.8);
        coefficients.put("mi", 1609344.0);

        double b = coefficients.get(from);
        double c = coefficients.get(to);
        double conversion = b / c * a;

        String[] output = new String[4];
        output[0] = Integer.toString(a);
        output[1] = Double.toString(conversion);
        output[2] = from;
        output[3] = to;

        return output;
    }
}

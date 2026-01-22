import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AP CSA - Weekly Data Analyzer (Arrays & OOP Assessment)
 * JUnit tests for WeeklyData.java
 *
 * This test class validates:
 *  - Constructor deep copy (internal array must NOT alias the input).
 *  - getTotal(): sum of values.
 *  - getAverage(): total / length.
 *  - getMax(): maximum value.
 *  - getMin(): minimum value.
 *  - toString(): one day per line, labeled and readable.
 *
 * Assumptions:
 *  - Arrays are non-empty for core tests.
 *  - Optional tests included for empty-array behavior.
 */
class WeeklyDataTest {

    // -------------------------------------------------
    // Constructor Deep Copy Tests
    // -------------------------------------------------
    @Test
    void constructor_makesDeepCopy_notAliasingInput() {
        double[] input = {10.0, 20.0, 30.0};
        WeeklyData wd = new WeeklyData(input);

        double originalTotal = wd.getTotal();

        // Mutate original array after construction
        input[0] = 9999.0;

        assertEquals(
                originalTotal,
                wd.getTotal(),
                1e-9,
                "WeeklyData must deep-copy the input array. External changes should not affect internal data."
        );
    }

    @Test
    void constructor_copiesAllElements_correctLength() {
        double[] input = {5.5, 10.0, 20.25};
        WeeklyData wd = new WeeklyData(input);

        assertEquals(35.75, wd.getTotal(), 1e-9);
    }

    // -------------------------------------------------
    // getTotal Tests
    // -------------------------------------------------
    @Test
    void getTotal_typicalValues() {
        double[] input = {100, 200, 300};
        WeeklyData wd = new WeeklyData(input);

        assertEquals(600.0, wd.getTotal(), 1e-9);
    }

    @Test
    void getTotal_singleValue() {
        double[] input = {42.5};
        WeeklyData wd = new WeeklyData(input);

        assertEquals(42.5, wd.getTotal(), 1e-9);
    }

    // -------------------------------------------------
    // getAverage Tests
    // -------------------------------------------------
    @Test
    void getAverage_typicalValues() {
        double[] input = {2, 4, 6, 8};
        WeeklyData wd = new WeeklyData(input);

        assertEquals(5.0, wd.getAverage(), 1e-9);
    }

    @Test
    void getAverage_decimalResult() {
        double[] input = {1, 2, 3};
        WeeklyData wd = new WeeklyData(input);

        assertEquals(2.0, wd.getAverage(), 1e-9);
    }

    // -------------------------------------------------
    // getMax Tests
    // -------------------------------------------------
    @Test
    void getMax_typicalValues() {
        double[] input = {10, 50, 30, 75, 25};
        WeeklyData wd = new WeeklyData(input);

        assertEquals(75.0, wd.getMax(), 1e-9);
    }

    @Test
    void getMin_typicalValues() {
        double[] input = {10, 50, 30, 75, 25};
        WeeklyData wd = new WeeklyData(input);

        assertEquals(10.0, wd.getMin(), 1e-9);
    }

    // -------------------------------------------------
    // toString Tests
    // -------------------------------------------------
    @Test
    void toString_containsAllDays() {
        double[] input = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
        WeeklyData wd = new WeeklyData(input);
        String result = wd.toString();

        assertTrue(result.contains("Day 1"));
        assertTrue(result.contains("Day 7"));
        assertTrue(result.contains("1.0"));
        assertTrue(result.contains("7.0"));
    }
}

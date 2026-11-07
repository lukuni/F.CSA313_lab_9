package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test
    void letterGradeA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void gpaTwoScores() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 0.001);
    }

    @Test
    void scholarshipFull() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarshipSeventy() {
        assertEquals(70, calc.scholarship(3.5, 13, false));
    }

    @Test
    void scholarshipFifty() {
        assertEquals(50, calc.scholarship(3.1, 10, false));
    }

    // ---- letterGrade ----
    @Test void letterGradeB() { assertEquals("B", calc.letterGrade(85)); }
    @Test void letterGradeC() { assertEquals("C", calc.letterGrade(75)); }
    @Test void letterGradeD() { assertEquals("D", calc.letterGrade(65)); }
    @Test void letterGradeF() { assertEquals("F", calc.letterGrade(30)); }
    @Test void letterGradeNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }
    @Test void letterGradeAbove100Throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    // ---- gpa ----
    @Test void gpaNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }
    @Test void gpaEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }
    @Test void gpaAllGradeTypes() {   // A,B,C,D,F -> switch-ийн бүх салаа
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 30}), 0.001);
    }

    // ---- scholarship ----
    @Test void scholarshipGpaNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 10, false));
    }
    @Test void scholarshipGpaAboveFourThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 10, false));
    }
    @Test void scholarshipCreditsNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.0, -1, false));
    }
    @Test void scholarshipViolationZero() {
        assertEquals(0, calc.scholarship(3.9, 16, true));
    }
    @Test void scholarshipHighGpaLowCredits() {   // gpa >= 3.8 үнэн, credits >= 15 худал
        assertEquals(70, calc.scholarship(3.9, 14, false));
    }
    @Test void scholarshipMidGpaLowCredits() {    // gpa >= 3.4 үнэн, credits >= 12 худал
        assertEquals(50, calc.scholarship(3.5, 11, false));
    }
    @Test void scholarshipLowGpaHighCredits() {   // gpa < 3.4
        assertEquals(50, calc.scholarship(3.2, 20, false));
    }
    @Test void scholarshipBelowThreeZero() {
        assertEquals(0, calc.scholarship(2.9, 20, false));
    }
}

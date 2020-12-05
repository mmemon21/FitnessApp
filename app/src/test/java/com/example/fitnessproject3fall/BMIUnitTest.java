package com.example.fitnessproject3fall;

import static org.junit.Assert.*;
import org.junit.Test;

public class BMIUnitTest {
    float delta = 0.01f;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void BMITest1() {
        assertTrue(Math.abs(20.0f - BmiActivity.calculateBMI(2,80) ) <= delta);
    }

    @Test
    public void BMITest2() {
        assertTrue(Math.abs(35.555f - BmiActivity.calculateBMI(1.5f,80) ) <= delta);
    }

    @Test
    public void BMITest3() {
        assertTrue(Math.abs(38.4f - BmiActivity.calculateBMI(1.25f,60) ) <= delta);
    }
}

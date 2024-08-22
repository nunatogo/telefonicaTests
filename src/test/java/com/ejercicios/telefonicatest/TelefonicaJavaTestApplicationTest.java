package com.ejercicios.telefonicatest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TelefonicaJavaTestApplicationTest {

    @Test
    void calculateAreaOfTriangle() {
        // GIVEN
        double base = 3.0;
        double height = 5.0;
        double areaOfTriangle = 7.5;
        // WHEN
        double result = TelefonicaJavaTestApplication.calculateAreaOfTriangle(base, height);
        // THEN
        assertThat(result).isEqualTo(areaOfTriangle);
    }

    @Test
    void calculateAreaOfCircle() {
        // GIVEN
        double radio = 3.0;
        double areaOfCircle = 28.26;
        // WHEN
        double result = TelefonicaJavaTestApplication.calculateAreaOfCircle(radio);
        // THEN
        assertThat(result).isEqualTo(areaOfCircle);
    }
}
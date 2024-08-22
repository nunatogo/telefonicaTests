package com.ejercicios.telefonicatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelefonicaJavaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelefonicaJavaTestApplication.class, args);
    }

    /**
     * Calculating the area of triangle with its base and height
     *
     * @param base,   double
     * @param height, double
     * @return double
     */
    public static double calculateAreaOfTriangle(double base, double height) {
        return (base * height) / 2;
    }

    /**
     * Calculating the area of a circle based on its radius
     *
     * @param radio, double
     * @return double
     */
    public static double calculateAreaOfCircle(double radio) {
        return 3.14 * Math.pow(radio, 2);
    }
}

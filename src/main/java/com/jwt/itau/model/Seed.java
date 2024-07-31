package com.jwt.itau.model;

public class Seed {
    private int value;

    public Seed(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Seed must be a valid number: " + value);
        }

        if (!isPrime(this.value)) {
            throw new IllegalArgumentException("Seed must be a prime number: " + value);
        }
    }

    public int getValue() {
        return value;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


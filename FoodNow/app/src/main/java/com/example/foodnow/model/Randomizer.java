package com.example.foodnow.model;

/**
 * Created by rwitting on 11/8/15.
 */
public class Randomizer {
    public static int getRandomIntegerInclusive(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}

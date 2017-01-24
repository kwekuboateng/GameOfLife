package com.zianos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(12);
        game.print();
        System.out.println("----------------");
        game.step();
        game.print();
        System.out.println("----------------");
        game.step();
        game.print();

        final boolean[][] preset = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };
        Game presetGame = new Game(preset);
        System.out.println("preset board");
        presetGame.print();
        System.out.println("----------------");
        presetGame.step();
        presetGame.print();
        System.out.println("----------------");
        presetGame.step();
        presetGame.print();


    }
}
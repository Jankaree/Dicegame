package com.martin.dicegame;
import java.util.Random;
public class Dice {

    public int sides;


    public Dice(int sides){
        this.sides = sides;

    }

    public static int rollDice(Dice dice){

        Random diceScore = new Random();

        return diceScore.nextInt(dice.sides) + 1;
    }
}

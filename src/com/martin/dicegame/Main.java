package com.martin.dicegame;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {



        Playfield playfield = setup();
        run(playfield);
        sortWinner(playfield.playerlist);
        decideWinner(playfield);
        declareWinner(playfield);


    }



    public static Playfield run(Playfield playfield){

        String throwDice = "";

        for (int i = 0; i < playfield.turns; i++) {

            for (int j = 0; j < Playfield.returnPlayers(playfield).length; j++) {

                int points = 0;
                int temp = 0;
                for (int k = 0; k < Playfield.returnDice(playfield).length; k++) {

                    System.out.println("Type 1 to throw dice " + (k+1) + " " + playfield.playerlist[j].name + "!");
                    do{

                        throwDice = Scannerdice.scannerText();
                        switch (throwDice) {
                            case "1":
                                System.out.println("Throwing dice!");
                                for (int l = 0; l < 3; l++) {
                                    try {
                                        Thread.sleep(500);
                                        System.out.print(". ");
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }

                                }

                                break;
                            default:
                                System.out.println("Wrong input");

                        }
                    }while(!Objects.equals(throwDice, "1"));

                    if(playfield.dicelist.length > 1){
                        for (int l = 0; l < playfield.dicelist.length; l++) {
                            points += Dice.rollDice(playfield.dicelist[l]);

                            System.out.println(playfield.playerlist[j].name + " rolls a: " + (points - temp));
                            temp = points;

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }


                        }
                        k = Playfield.returnDice(playfield).length;
                    }else {

                        points += Dice.rollDice(playfield.dicelist[k]);

                        System.out.println(playfield.playerlist[j].name + " rolls a: " + (points - temp));
                        temp = points;


                    }
                }


                Player.awardPoints(points, playfield.playerlist[j]);
                System.out.println(playfield.playerlist[j].name + "'s current points: " + Player.getScore(playfield.playerlist[j]));
                System.out.println();


            }

        }

        return playfield;
    }

    public static Player[] sortWinner(Player[] players){

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length; j++) {

                if(Player.comparePlayers(players[i],players[j]) == 1){
                    Player winner = players[i];
                    players[i] = players[j];
                    players[j] = winner;
                }
            }
        }

        return players;
    }

    public static Playfield setup(){

        int players = 0;
        int dices = 0;
        int turns = 0;



        System.out.println("Write number of players");
        players = Scannerdice.scanInteger();
        System.out.println("How many dice would you like to use?");
        dices = Scannerdice.scanInteger();


        Player[] playerList = new Player[players];
        Dice[] dicelist = new Dice[dices];

        for (int i = 0; i < players; i++) {
            System.out.println("Player " + (i +1) + " write your id");
            String temp = Scannerdice.scannerText();
            Player playtest = new Player(temp);
            playerList[i] = playtest;
        }

        for (int i = 0; i < dices; i++) {
            System.out.println("How many sides do you want dice " + (i+1) + " to be?");
            int temp = Scannerdice.scanInteger();
            Dice dicetest = new Dice(temp);
            dicelist[i] = dicetest;
        }

        System.out.println("how many turns would you like to play?");
        turns = Scannerdice.scanInteger();

        Playfield playfield= new Playfield(playerList, dicelist, turns);


        return playfield;
    }

    public static Playfield decideWinner(Playfield playfield){
        int nrOfWinners = 0;

        while(Player.comparePlayers(playfield.playerlist[0], playfield.playerlist[nrOfWinners]) == 0){
            nrOfWinners++;
            if(nrOfWinners == playfield.playerlist.length){
                break;
            }
        }

        Player[] winnerList = new Player[nrOfWinners];


        for (int i = 0; i < winnerList.length; i++) {

            winnerList[i] = playfield.playerlist[i];
        }

        playfield.playerlist = winnerList;

        if(playfield.playerlist.length > 1){
            suddenDeath(playfield);
        }


        return playfield;
    }

    public static Playfield suddenDeath(Playfield playfield){
        playfield.turns = 1;

        while(playfield.playerlist.length > 1) {
            System.out.println();
            System.out.println("SUDDEN DEATH!!!");
            System.out.println("CURRENT PLAYERS ARE: ");
            for (int i = 0; i < playfield.playerlist.length; i++) {
                System.out.print(playfield.playerlist[i].name + "! ");
            }
            System.out.println();
            run(playfield);
            sortWinner(playfield.playerlist);
            decideWinner(playfield);
        }

        return playfield;
    }

    public static void declareWinner(Playfield playfield){
        System.out.println("AND THE WINNER IS: ");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println();
        System.out.println(playfield.playerlist[0].name + " With " + playfield.playerlist[0].score + " points " + " \uD83C\uDF89");
    }




}

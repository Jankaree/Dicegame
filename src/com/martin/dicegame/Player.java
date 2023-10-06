package com.martin.dicegame;

public class Player {

    public String name;
    public int score;

    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public static void awardPoints(int points, Player player){
        player.score += points;

    }

    public static String infoplayer(Player player){
        String info = "";
        info = "name: " + player.name + " score: " + player.score;
        return info;
    }

    public static int getScore(Player player){

        return player.score;
    }

    public static String getName(Player player){

        return player.name;
    }

    public static int comparePlayers(Player player1, Player player2){
        if (player1.score > player2.score){
            return 1;
        }
        if (player1.score < player2.score) {
            return -1;
        }
        return 0;

    }
}





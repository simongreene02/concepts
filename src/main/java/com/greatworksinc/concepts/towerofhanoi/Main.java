package com.greatworksinc.concepts.towerofhanoi;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(new Board(args.length == 1 ? Integer.parseInt(args[0]) : 3));
        player.play();
    }
}

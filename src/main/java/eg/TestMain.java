package eg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TestMain {

    private static void println(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        println("enter player count");
        var playerCount = Integer.parseInt(reader.readLine());
        var players = new Player[playerCount];

        for (var i = 0; i < playerCount; i++) {
            players[i] = new Player();
        }

        var rnd = new Random();
        var continuePlay = true;
        while (continuePlay) {
            for (var i = 0;i < players.length; i++) {
                players[i].hit((int)(rnd.nextDouble() * 10));
                println("player["+i+"]: "+ players[i].getHealth());
                if (players[i].health <= 0) {
                    println("game end");
                    continuePlay = false;
                    break;
                }
                Thread.sleep(200);
            }
        }

    }
}
